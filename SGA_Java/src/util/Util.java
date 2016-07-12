/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import vista.Form_alumno;

/**
 *
 * @author Diego
 */
public class Util {
     private Form_alumno form_alu;
    
    
  public  void inhabilitar() {
       this.form_alu.txt_alu_apellido.setEnabled(false);
        
        /*
        txtidpersona.setVisible(false);
        
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        
        txtnum_documento.setEnabled(false);
        txtdireccion.setEnabled(false);
        txttelefono.setEnabled(false);
        txtemail.setEnabled(false);
        txtcodigo_cliente.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
     //   txtamaterno.setText("");
        txtnum_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtcodigo_cliente.setText("");*/
    }
    
  
  
  
  public void habilitar() {
        this.form_alu.txt_alu_apellido.setEnabled(true);
      
       /*
       
       txtidpersona.setVisible(false);
        
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
      //  txtamaterno.setEnabled(true);
      //  cbotipo_documento.setEnabled(true);
        txtnum_documento.setEnabled(true);
        txtdireccion.setEnabled(true);
        txttelefono.setEnabled(true);
        txtemail.setEnabled(true);
        txtcodigo_cliente.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);
        txtidpersona.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
     //   txtamaterno.setText("");
        txtnum_documento.setText("");
        txtdireccion.setText("");
        txttelefono.setText("");
        txtemail.setText("");
        txtcodigo_cliente.setText("");
        
         */
    }
}
