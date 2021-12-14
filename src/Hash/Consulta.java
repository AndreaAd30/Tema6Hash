
package Hash;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Consulta extends JDialog{
    
    private JScrollPane scrollArea;
    private JTextArea textArea;
    
    public Consulta(Principal ventanaPrincipal, boolean modal, Hashtable<String, EstudianteVo> tablaPersonas){
        super(ventanaPrincipal,modal);
        initialize();
        setLocationRelativeTo(null);
        
        mostrarListaPersonas(tablaPersonas);
        
    }
    
    public void initialize(){
        setSize(300,208);
        getContentPane().setLayout(null);
        
        textArea=new JTextArea();
        textArea.setBounds(10,33,264,102);
        
        scrollArea=new JScrollPane();
        scrollArea.setBounds(10,50,264,102);
        scrollArea.setViewportView(textArea);
        getContentPane().add(scrollArea);
        
        JLabel lblConsultaDePersona=new JLabel("CONSULTA DE ESTUDIANTE");
        lblConsultaDePersona.setBounds(10,11,153,23);
        getContentPane().add(lblConsultaDePersona);   
    }

    private void mostrarListaPersonas(Hashtable<String, EstudianteVo> tablaPersonas) {
        String mensaje="";
        
        Enumeration<EstudianteVo> elemento=tablaPersonas.elements();
        while(elemento.hasMoreElements()){
            EstudianteVo personaVo=elemento.nextElement();
            mensaje+="Numero de Control: "+personaVo.getnControl()+"    Nombre: "+personaVo.getNombre()+"\n";
            mensaje+="Promedio: "+personaVo.getPromedio()+"\n\n";
            textArea.setText(mensaje);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

