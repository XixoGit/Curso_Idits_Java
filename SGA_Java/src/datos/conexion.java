
package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conexion {
    
    public String db="sga_java";
    public String url="jdbc:mysql://127.0.0.1/" +db;
    public String user="root";
    public String pass="5363";
    
      public conexion() {
      }
      
     public Connection conectar(){
            Connection link=null;
        
         try {
             Class.forName("org.gjt.mm.mysql.Driver");   //cargamos el driver de la conexion
          link=DriverManager.getConnection(this.url, this.user, this.pass);  //creamos un enlace hacia la base de datos
         } catch (ClassNotFoundException | SQLException e) {
              JOptionPane.showConfirmDialog(null,e);
         }
            
        return link;
     }
     
}
