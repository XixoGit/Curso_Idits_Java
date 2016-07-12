/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import datos.Alumno_Dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Alumno;
import util.Util;
import vista.Form_alumno;
import vista.Form_principal;
/**
 *
 * @author Diego Vargas
 */
public class ControladorAlumno  implements ActionListener{
   private Form_principal form_princ;
   private Form_alumno form_alu;
   private Alumno obj_alum1;
   private Alumno_Dao alu_dao;
    
    public ControladorAlumno(Form_principal form_princ) { //inicializo la ventana Alumno
        this.form_alu=new Form_alumno();                    
        this.obj_alum1=new Alumno();
        this.form_princ = form_princ;
        this.form_princ.escritorio.add(form_alu);
        this.form_alu.show();                             //muestro la ventana
        this.form_alu.btn_buscar.addActionListener(this);
        this.form_alu.btn_nuevo.addActionListener(this);
        this.form_alu.btn_guardar.addActionListener(this);
        this.form_alu.btn_actualizar.addActionListener(this);
         this.form_alu.btn_eliminar.addActionListener(this);
          this.form_alu.btn_salir.addActionListener(this);
         this.form_alu.btn_cancelar.addActionListener(this);
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource().equals(this.form_alu.btn_buscar)){
     
              if (this.form_alu.txt_buscar.getText().length() == 0) {
                 JOptionPane.showConfirmDialog(null, "Debes ingresar un num de documento valido!");
                 this.form_alu.txt_alu_dni.requestFocus();
              return;
             }
             habilitar();
             System.out.println("1 ° MenuItem Buscar Alumno ");
             ArrayList<Alumno> ar1 = new ArrayList();
             ar1 = this.obj_alum1.buscarAlumno(Integer.parseInt(this.form_alu.txt_buscar.getText()));
               this.form_alu.cbo_alu_sexo.setEnabled(false);
             System.out.println("°5 Muestro por consola el alumno con dni encontrado");
              if (ar1.size() == 0) {
                 JOptionPane.showConfirmDialog(null, "Arrray Alumno VAcio!");
                   System.out.println("°Array vacio, dni no existe");
              return;
             }
            
              
             for (int i = 0; i < ar1.size(); i++) {                  //MOSTRAMOS LOS DATOS 
		 System.out.println("dni:" + ar1.get(i).getDni());
                 System.out.println("nombre:" + ar1.get(i).getNombre());
                 System.out.println("apellido:" + ar1.get(i).getApellido());
                 System.out.println("direccion:" + ar1.get(i).getDireccion());
                 System.out.println("telefono:" + ar1.get(i).getTelefono());
	    }  
             for (int i = 0; i < ar1.size(); i++) {                  //MOSTRAMOS LOS DATOS 
		 this.form_alu.txt_alu_dni.setText(String.valueOf(ar1.get(i).getDni()));	 
                 this.form_alu.txt_alu_nombre.setText(ar1.get(i).getNombre());	 
		 this.form_alu.txt_alu_apellido.setText(ar1.get(i).getApellido());
	         this.form_alu.txt_alu_direccion.setText(ar1.get(i).getDireccion());
                 this.form_alu.txt_alu_telefono.setText(ar1.get(i).getTelefono());
                  
	     }
            // this.form_alu.txt_alu_dni.setEnabled(false);
              JOptionPane.showConfirmDialog(null, "Alumno Encontrado");
         }
     
        //BOTON actualizar
         if(e.getSource().equals(this.form_alu.btn_actualizar)){
             try {
                  
                 
                 System.out.println("se hizo click en boton actualizar" );
                  
                 int dni_alu=Integer.parseInt(this.form_alu.txt_alu_dni.getText());
                 System.out.println("dnialu" + dni_alu);
                 String nom_alu=this.form_alu.txt_alu_nombre.getText();
                 String ape_alu=this.form_alu.txt_alu_apellido.getText();
                 String dir_alu=this.form_alu.txt_alu_direccion.getText();
                 String tel_alu=this.form_alu.txt_alu_telefono.getText();
                 System.out.println("llamo al metodo actualizaAlumno" );
                 this.obj_alum1.actualizaAlumno(dni_alu,nom_alu,ape_alu,dir_alu,tel_alu);
                  JOptionPane.showConfirmDialog(null, "Alumno Actualizado");
                 System.out.println("datos actualizados" );
             } catch (SQLException ex) {
                 Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            
          }
         
          //BOTON ELIMINAR
         if(e.getSource().equals(this.form_alu.btn_eliminar)){
             try {
                 System.out.println("se entro a ELIMINAR");
                 this.obj_alum1.eliminaAlumno(Integer.parseInt(this.form_alu.txt_buscar.getText()));
                 limpiar();
             } catch (SQLException ex) {
                 Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
             }
            
          }
 
          //BOTON NUEVO
         if(e.getSource().equals(this.form_alu.btn_nuevo)){
           limpiar();
           habilitar();
           System.out.println("se entro a limpiar");
         }
        
       
         //BOTON GUARDAR
       if(e.getSource().equals(this.form_alu.btn_guardar)){
            
             try {
                 System.out.println("se entro a guardar");
                 
                 
                 
                 if ((this.form_alu.txt_alu_dni.getText().length() <7) || (this.form_alu.txt_alu_dni.getText().length()>8)) {
                     JOptionPane.showConfirmDialog(null, "Debes ingresar un num de documento para el alumno");
                     this.form_alu.txt_alu_dni.requestFocus();
                     return;
                 }
                 
                 if (this.form_alu.txt_alu_nombre.getText().length() == 0) {
                     JOptionPane.showConfirmDialog(null, "Debes ingresar un nombre para el alumno");
                     this.form_alu.txt_alu_nombre.requestFocus();
                     return;
                 }
                 
                 if (this.form_alu.txt_alu_apellido.getText().length() == 0) {
                     JOptionPane.showConfirmDialog(null, "Debes ingresar un apellido para el alumno");
                     this.form_alu.txt_alu_apellido.requestFocus();
                     return;
                 }
                 
                 if (this.form_alu.txt_alu_direccion.getText().length() == 0) {
                 JOptionPane.showConfirmDialog(null, "Debes ingresar una direccion para el alumno");
                 this.form_alu.txt_alu_telefono.requestFocus();
                 return;
                 }
               
                 if (this.form_alu.txt_alu_telefono.getText().length() == 0) {
                 JOptionPane.showConfirmDialog(null, "Debes ingresar un telefono para el alumno");
                 this.form_alu.txt_alu_telefono.requestFocus();
                 return;
                 }
                 
                 int dni_alu=Integer.parseInt(this.form_alu.txt_alu_dni.getText());
                 System.out.println("dnialu" + dni_alu);
                 String nom_alu=this.form_alu.txt_alu_nombre.getText();
                 String ape_alu=this.form_alu.txt_alu_apellido.getText();
                 String dir_alu=this.form_alu.txt_alu_direccion.getText();
                 String tel_alu=this.form_alu.txt_alu_telefono.getText();
                 int sex_alu=this.form_alu.cbo_alu_sexo.getSelectedIndex();
                 System.out.println("llamo al metodo buscarID_Duplicado " + dni_alu);
                
                 boolean esDuplicado=this.obj_alum1.buscarID_Duplicado(dni_alu);
                  System.out.println("boolean esDuplicado: " + esDuplicado);
                 
                  
                 if(!esDuplicado){
                     
                 System.out.println("Si no es duplicado, se llamo al metodo guardarAlumno");
                 this.obj_alum1.guardarAlumno(dni_alu,nom_alu,ape_alu,dir_alu,tel_alu,sex_alu);
                 JOptionPane.showMessageDialog(null,"Alumno Guardado con Exito!!");
             
                 }else{
                        JOptionPane.showConfirmDialog(null, "DNI duplicado !!");
                     System.out.println("ES DUPLICado!!");
                  this.form_alu.txt_alu_dni.requestFocus();
                     return;
                 }
             
             } catch (SQLException ex) {
                 Logger.getLogger(ControladorAlumno.class.getName()).log(Level.SEVERE, null, ex);
             }
          }
         
       
        //BOTON SALIR
         if(e.getSource().equals(this.form_alu.btn_salir)){
           this.form_alu.dispose();
           System.out.println("se entro a salir");
         }
        //BOTON CANCELAR
         if(e.getSource().equals(this.form_alu.btn_cancelar)){
             this.form_alu.dispose();
           System.out.println("se entro a cancelar");
         }
    
    }
    
    
      
    
    

    private void habilitar() {
          System.out.println("se entro a habilitar");
        this.form_alu.txt_alu_apellido.setEnabled(true);
        this.form_alu.txt_alu_nombre.setEnabled(true);
         this.form_alu.txt_alu_telefono.setEnabled(true);
        this.form_alu.txt_alu_direccion.setEnabled(true);
       this.form_alu.cbo_alu_sexo.setEnabled(true); 
         this.form_alu.txt_alu_dni.setEnabled(true);
          
    }
    
      private void limpiar() {
          this.form_alu.txt_alu_dni.setText("");
          this.form_alu.txt_alu_apellido.setText("");
          this.form_alu.txt_alu_nombre.setText("");
          this.form_alu.txt_alu_telefono.setText("");
          this.form_alu.txt_alu_direccion.setText("");
          this.form_alu.txt_alu_dni.setText("");
          this.form_alu.txt_buscar.setText("");
       
    }     
     
    
   
   
    
}
