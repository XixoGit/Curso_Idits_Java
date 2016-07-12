
package controlador;

import vista.Form_alumno;
import vista.Form_materia;
import vista.Form_principal;
import vista.Form_profesor;
import vista.Menu;


public class SGA_Java {

    
    public static void main(String[] args) {
       Form_principal f=new Form_principal();
       ControladorPrincipal c=new ControladorPrincipal(f);
       f.setVisible(true);
    }
    
}
