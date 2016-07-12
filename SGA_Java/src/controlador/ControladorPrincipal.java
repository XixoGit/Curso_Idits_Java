package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.Form_alumno;
import vista.Form_principal;

/**
 *
 * @author Diego Vargas
 */
public class ControladorPrincipal implements ActionListener {

   public Form_principal escritorio;
   //public  Form_alumno for_alumno;
    private ControladorAlumno ca1;
    
   
    public ControladorPrincipal(Form_principal escritorio) {
         this.escritorio=escritorio;
         this.escritorio.aluMenuItem.addActionListener(this); 
          
         
         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource().equals(this.escritorio.aluMenuItem)){
             System.out.println("se hizo click menuitem alumno");
             this.ca1=new ControladorAlumno(escritorio);
             
         }
    }
    
}
