
package modelo;

import controlador.ControladorAlumno;
import datos.Alumno_Dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Alumno {
    
    private long dni;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private int sexo;
    private Alumno_Dao aludato1;
   
    public Alumno() {
    }

    public Alumno(long dni, String nombre, String apellido, String direccion, String telefono, int sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

   
    //busca por dni      return this.aludato1.dameSqlalumno(double dni);
    public ArrayList<Alumno> buscarAlumno(int dni) {
         
        System.out.println("2° - Clase Alumno, se entro al metodo buscarAlumno()    ");
       
        int dni_alu=dni;
        Alumno_Dao alumno_dao=new  Alumno_Dao();
        ArrayList<Alumno> alum_array_dni=alumno_dao.dameSqlalumno(dni);
        
       
        
        System.out.println("4°-  - Clase Alumno,, ultima parte del codigo   " );
      
       
         return alum_array_dni;
    }
    
    
    public  void  guardarAlumno(int dni_alu,String nom_alu,String ape_alu,String dir_alu,String tel_alu,int sex_alu) throws SQLException {
         
        System.out.println("     ");
       
         
        Alumno_Dao alumno_dao=new  Alumno_Dao();
         
        ArrayList<Alumno> alum_array_dni=alumno_dao.guardaSqlalumno(dni_alu, nom_alu, ape_alu, dir_alu, tel_alu, sex_alu);
       
        
        System.out.println("4°-  - Clase Alumno,, ultima parte del codigo   " );
      
       
        
    }
    
    
     public boolean buscarID_Duplicado(int dni) throws SQLException {
         boolean existe_dni=false;
        System.out.println("2° - Clase Alumno, se entro al metodo      ");
       
        int dni_alu=dni;
        Alumno_Dao alumno_dao=new  Alumno_Dao();
        System.out.println(" - llamo al metodo    recorreAlumno(dni_alu)   ");
         ArrayList<Alumno> alum_array_dni= alumno_dao.recorreAlumno(dni_alu);
        
        for (int i = 0; i < alum_array_dni.size(); i++) {                  //MOSTRAMOS LOS DATOS 
          System.out.println("dni:" + alum_array_dni.get(i).getDni());
              if((dni_alu)== (alum_array_dni.get(i).getDni())){
               System.out.println(" Ese DNI ya existe   ");
                 existe_dni=true;
               }
                  
	   }
        
        
      
       return existe_dni;
         
    }
     
     
     public  void  actualizaAlumno(int dni_alu,String nom_alu,String ape_alu,String dir_alu,String tel_alu) throws SQLException {
         
        System.out.println("     ");
     
         
        Alumno_Dao alumno_dao=new  Alumno_Dao();
         
        ArrayList<Alumno> alum_array_dni=alumno_dao.actualizaSqlalumno(dni_alu, nom_alu, ape_alu, dir_alu, tel_alu);
       
        
        System.out.println("4°-  -Mostrando Alumno  actualizados  " );
        
         for (int i = 0; i < alum_array_dni.size(); i++) {                  //MOSTRAMOS LOS DATOS 
         
             System.out.println("dni:" + alum_array_dni.get(i).getDni());
             System.out.println("nombre:" + alum_array_dni.get(i).getNombre());
             System.out.println("apellidop:" + alum_array_dni.get(i).getApellido());
             System.out.println("direccion:" + alum_array_dni.get(i).getDireccion());
             System.out.println("telefono:" + alum_array_dni.get(i).getTelefono());
               
                
                  
	  }
      
        
        
    }
     
     public  void  eliminaAlumno(int dni_alu) throws SQLException {
         
        System.out.println(" se entro a    eliminaAlumno  ");
     
         
        Alumno_Dao alumno_dao=new  Alumno_Dao();
         
       boolean esEliminado= alumno_dao.eliminaSqlalumno(dni_alu);
       
        if(esEliminado){
             JOptionPane.showConfirmDialog(null, "Alumno Eliminado");
        }else{
            JOptionPane.showConfirmDialog(null, "No se pudo eliminar");
        }
        System.out.println("4°-  -Mostrando Alumno  actualizados  " );
        
          
      
        
        
    }
     
     
    
    
}
