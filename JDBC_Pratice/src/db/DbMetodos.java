package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DbMetodos {
Connection conn = null;
Statement st = null;
ResultSet rs = null;
PreparedStatement stp = null;
SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
	public DbMetodos() {}
		
	public String retorno() {
		if(DB.getConnection() != null) {
			conn = DB.getConnection();
			try {
				st = conn.createStatement();
				rs = st.executeQuery("select * from department");
				while(rs.next()) {
					System.out.println(rs.getInt("id") + "," + rs.getString("Name"));
				}
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			} 
			
			finally {
				DB.closeST(stp);
				DB.closeConnection();
			}
			
		}
		else {
			DB.getConnection();
			retorno();
		}
		
		return conn.toString();
	}
	
	public void Insert() {
		conn = DB.getConnection();
		if(DB.getConnection() != null) {
			try {
				stp = conn.prepareStatement(
						"INSERT into seller"
						+ "(Name,Email,BirthDate,BaseSalary,DepartmentId) " 
						+ "VALUES"
						+ "(?,?,?,?,?)",
						+ 		   Statement.RETURN_GENERATED_KEYS);
				
				 stp.setString(1, "Jose");
				 stp.setString(2, "JoseJonas@gmail.com");
				 stp.setDate(3,new java.sql.Date(stf.parse("10/08/2014").getTime()));
				 stp.setDouble(4,7000);
				 stp.setInt(5, 4);
				 
				 int rowsAffected = stp.executeUpdate();
	} catch (SQLException e) {
		System.out.println("Erro de SQL");
		throw new DbException(e.getMessage());
	}
			
			catch (ParseException e) {
				System.out.println("Erro de parse");
				throw new DbException(e.getMessage());
			}
			
			finally {
				DB.closeST(stp);
				DB.closeConnection();
			}
				
} 
		else {
        
}
		
	}
	
	
	public void Deletar() {
		try {
			conn = DB.getConnection();
			stp = conn.prepareStatement("DELETE from department "
					+ "WHERE "
					+"Id = ?");
			stp.setInt(1,6);
			
			int rowsAffected = stp.executeUpdate();
			System.out.println("Delete feito!");
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeST(stp);
			DB.closeConnection();
		}
		
		
	}
	
	public void Atualizar() {
		try {
			conn = DB.getConnection();
			stp = conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+("DepartmentId =  ?"));
			
			stp.setDouble(1, 100000);
			stp.setInt(2, 2);
			
			int rowsAffected = stp.executeUpdate();
			System.out.println("Atualização Realizada!");
					
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeST(stp);
			DB.closeConnection();
		}
	}
	
	
	
		
	}
	

