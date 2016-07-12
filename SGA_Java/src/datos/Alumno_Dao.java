
package datos;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Alumno;


public class Alumno_Dao {
      
    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
  //  private String sSQL = "SELECT * FROM alumno  ";        
       //select descripcion,precio from articulos where codigo="+tf3.getText()
   
    Alumno obj_alum;
        
  
        public ArrayList<Alumno> dameSqlalumno(int dni){
            //unas vez conectado tenes que hacer la sql, de tipo select con el where del dni = alu_dni
            //trae ese dato y almacenalo en un arraylist qye tiene que ser retornado
           //return arraylistalumno;
           
           int dni2=dni;
            String sSQL = "SELECT alu_dni,alu_nom,alu_ape,alu_dir,alu_tel,alu_sex FROM alumno WHERE alu_dni="+dni2;   
          
           ArrayList<Alumno> array_alumno=new ArrayList<Alumno>();    //creamos el objeto usuario de tipo <Usuario>               
	   
            try {
            PreparedStatement pst=cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            while( rs.next()){
            obj_alum=new Alumno();              //instanciamos la clase Usuario para acceder a los getter and setters
	    obj_alum.setDni(rs.getInt("alu_dni"));
	    obj_alum.setNombre(rs.getString("alu_nom"));
	    obj_alum.setApellido(rs.getString("alu_ape"));
            obj_alum.setDireccion(rs.getString("alu_dir"));
            obj_alum.setTelefono(rs.getString("alu_tel"));             //trabajamos con los setters and getters
	    obj_alum.setSexo(rs.getInt("alu_sex"));
	    array_alumno.add(obj_alum);    
            }
            rs.close();
            int n= pst.executeUpdate();
            if(n>0){
               JOptionPane.showMessageDialog(null, "REgistro guardado");
            }
           
            } catch (SQLException | HeadlessException e) {
			System.out.println("error2" + e);
            }   
           
          return array_alumno;       
       }
        
        
        
       public ArrayList<Alumno> guardaSqlalumno(int dni_alu,String nom_alu,String ape_alu,String dir_alu,String tel_alu,int sex_alu) throws SQLException{
             System.out.println("Se entro al metodo  guardaSqlalumno");
          int dnialumno=dni_alu;
          String nombre=nom_alu;
          String apellido=ape_alu;
          String direccion=dir_alu;
          String telefono=tel_alu;
          int sexo=sex_alu;
          
           ArrayList<Alumno> array_alumno=new ArrayList<Alumno>();    //creamos el objeto usuario de tipo <Usuario>               
	   obj_alum=new Alumno(); 
           
           String sSQL = "INSERT INTO alumno (alu_dni,alu_nom,alu_ape,alu_dir,alu_tel,alu_sex) VALUES (?,?,?,?,?,?);";  
            
                
            PreparedStatement pst=cn.prepareStatement(sSQL);
          
              
                
                  pst.setLong(1,dnialumno );
                  pst.setString(2,nombre);
                  pst.setString(3, apellido);
                  pst.setString(4,direccion);
                  pst.setString(5, telefono);
                  pst.setInt(6, sexo);
                
		 pst.executeUpdate();
               
          return array_alumno;       
       }
        
       
        public ArrayList<Alumno> actualizaSqlalumno(int dni_alu,String nom_alu,String ape_alu,String dir_alu,String tel_alu) throws SQLException{
          System.out.println("Se entro al metodo  guardaSqlalumno");
          int dnialumno=dni_alu;
          String nombre=nom_alu;
          String apellido=ape_alu;
          String direccion=dir_alu;
          String telefono=tel_alu;
          
          
           ArrayList<Alumno> array_alumno=new ArrayList<Alumno>();    //creamos el objeto usuario de tipo <Usuario>               
	   obj_alum=new Alumno(); 
           
           String sSQL = "UPDATE `alumno` SET `alu_nom` = ?,alu_ape=?,alu_dir=? , `alu_tel` = ? WHERE `alumno`.`alu_dni` =" +dnialumno;  
            
            try {    
            PreparedStatement pst=cn.prepareStatement(sSQL);
          
              
                
                        pst.setString(1, nombre);           //modificando los datos a la tabla carrera
			pst.setString(2, apellido);
			pst.setString(3,direccion);
                        pst.setString(4,telefono);
			                     //AL modificar la tabla usuario el id va al final como ACA!!
			pst.executeUpdate();       
               } catch (Exception e) {
			System.out.println("error2"+ e);
		}
          return array_alumno;       
       }
        
       
        
         public  boolean eliminaSqlalumno(int dni_alu) throws SQLException{
          System.out.println("Se entro al metodo  guardaSqlalumno");
          int dnialumno=dni_alu;
           
          
           boolean esEliminado=false;
            
           
           String sSQL = " DELETE FROM `alumno` WHERE `alu_dni` = ?";  
            
            try {    
            PreparedStatement pst=cn.prepareStatement(sSQL);
          
              pst.setInt(1, dnialumno);           // 1 no es el id 1 , sino que corresponde al primer campo 
	      pst.executeUpdate();
                
                              
		esEliminado=true;	 
			      
               } catch (Exception e) {
			System.out.println("error2"+ e);
		}
                 return esEliminado;
       }
        
        
       public    ArrayList<Alumno> recorreAlumno(int dni) throws SQLException{
           System.out.println("Se entro al metodo recorreAlumno");
           int dni2=dni;
            String sSQL = "SELECT alu_dni FROM alumno ;";   
          
           ArrayList<Alumno> array_alumno=new ArrayList<Alumno>();    //creamos el objeto usuario de tipo <Usuario>               
	   
             
            PreparedStatement pst=cn.prepareStatement(sSQL);
            ResultSet rs = pst.executeQuery();
            
            while( rs.next()){
            obj_alum=new Alumno();              //instanciamos la clase Usuario para acceder a los getter and setters
	    obj_alum.setDni(rs.getInt("alu_dni"));
	   
	    array_alumno.add(obj_alum);    
            }
            rs.close();
           
             
                 
	
           return array_alumno;
       }
        
        
        
        
        
}
