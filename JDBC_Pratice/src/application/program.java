package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;
import db.DbMetodos;

public class program {

	public static void main(String[] args) {
    Connection conn = null;
   PreparedStatement st = null;
   
   /*
   
   try {
	   conn = DB.getConnection();
	   st = conn.prepareStatement(
                            "DELETE FROM department "  
	                       + "WHERE "
	                       +"Id = ?");
	   st.setInt(1, 2);
	   
	   int rowsAffected = st.executeUpdate();
	   System.out.println("Done! Lines affected  : "+rowsAffected);
   } catch (SQLException e) {
	   throw new DbIntegrityException(e.getMessage());
   }
   finally {
	   DB.closeST(st);
	   DB.closeConnection();
   }
   
*/
   
   DbMetodos qr = new DbMetodos();
   String a = qr.retorno();
   conn = DB.getConnection();
   DbMetodos insert = new DbMetodos();
   insert.Insert();
   
   DbMetodos deleter = new DbMetodos();
   deleter.Deletar();
   
   DbMetodos atualizar = new DbMetodos();
   atualizar.Atualizar();
   
}

}
