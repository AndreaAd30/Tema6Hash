
package Hash;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Principal extends JFrame implements ActionListener {
    
    private JTextField campoNumeroControl;
    private JTextField campoPromedio;
    private JTextField campoNombre;
    //private JTextField campoDireccion;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnRegistrar;
    private JButton btnConsultarLista;
    
    Hashtable<String, EstudianteVo> tablaPersonas;
    
    public Principal(){
        initialize();
        setSize(350,245);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        tablaPersonas=new Hashtable<String, EstudianteVo>();
    }
    
    private void initialize(){
        
        getContentPane().setLayout(null);
        
        JLabel lblRegistroDePersona=new JLabel("REGISTRO DE ESTUDIANTE");
        lblRegistroDePersona.setBounds(10,11,153,23);
        getContentPane().add(lblRegistroDePersona);
        
        JLabel lblControl = new JLabel("Numero de control");
        lblControl.setBounds(10,45,79,14);
        getContentPane().add(lblControl);
        
        campoNumeroControl=new JTextField();
        campoNumeroControl.setBounds(86, 42, 86, 20);
        getContentPane().add(campoNumeroControl);
        campoNumeroControl.setColumns(10);
        
        campoPromedio=new JTextField();
        campoPromedio.setBounds(232, 42, 86, 20);
        getContentPane().add(campoPromedio);
        campoPromedio.setColumns(10);
        
        JLabel lblPromedio=new JLabel("Promedio");
        lblPromedio.setBounds(198, 45, 50, 14);
        getContentPane().add(lblPromedio);
        
        campoNombre=new JTextField();
        campoNombre.setColumns(10);
        campoNombre.setBounds(85,71,233,20);
        getContentPane().add(campoNombre);
        
        JLabel lblNombre=new JLabel("Nombre");
        lblNombre.setBounds(10, 74, 86, 14);
        getContentPane().add(lblNombre);
        
        //JLabel lblDireccion=new JLabel("Direccion");
        //lblDireccion.setBounds(10, 105, 86, 14);
        //getContentPane().add(lblDireccion);
        
        //campoDireccion=new JTextField();
        //campoDireccion.setColumns(10);
        //campoDireccion.setBounds(85,102,233,20);
        //getContentPane().add(campoDireccion);
        
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(219,145,99,23);
        btnEliminar.addActionListener(this);
        getContentPane().add(btnEliminar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(119,145,89,23);
        btnBuscar.addActionListener(this);
        getContentPane().add(btnBuscar);
        
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(10,145,99,23);
        btnRegistrar.addActionListener(this);
        getContentPane().add(btnRegistrar);
        
        btnConsultarLista = new JButton("Consultar Lista");
        btnConsultarLista.setBounds(71,173,188,23);
        btnConsultarLista.addActionListener(this);
        getContentPane().add(btnConsultarLista);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnRegistrar){
            registrarPersona(tablaPersonas);
            
        }
        if(e.getSource()==btnBuscar){
            consultarPersona(tablaPersonas);
            
        }
        if(e.getSource()==btnConsultarLista){
            Consulta ventanaConsulta=new Consulta(this,true,tablaPersonas);
            ventanaConsulta.setVisible(true);
        }
        if(e.getSource()==btnEliminar){
            eliminarPersona(tablaPersonas);
   
        }
    }  

    private void registrarPersona(Hashtable<String, EstudianteVo> tablaPersonas) {
        EstudianteVo miPersona= new EstudianteVo();
        miPersona.setnControl(campoNumeroControl.getText());
        miPersona.setNombre(campoNombre.getText());
        miPersona.setPromedio(Integer.parseInt(campoPromedio.getText()));
        //miPersona.setDireccion(campoDireccion.getText());
        
        if(tablaPersonas.containsKey(miPersona.getnControl())==false){
            tablaPersonas.put(miPersona.getnControl(),miPersona);
            System.out.println("Almacena");
            limpiarCampos();
        }else{
            JOptionPane.showMessageDialog(null, "El numero de control ya existe!!", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void consultarPersona(Hashtable<String, EstudianteVo> tablaPersonas) {
        String mensaje="DATOS DEL ESTUDIANTE\n";
        String documento=JOptionPane.showInputDialog("Ingrese el numero de control de la persona");
        if(tablaPersonas.containsKey(documento)==true){
            EstudianteVo alumno=tablaPersonas.get(documento);
            mensaje+="Numero de control: "+alumno.getnControl()+"\n";
            mensaje+="Nombre: "+alumno.getNombre()+"\n";
            mensaje+="Promedio: "+alumno.getPromedio()+"\n";
            
            JOptionPane.showMessageDialog(null, mensaje);
            
        }else{
            JOptionPane.showMessageDialog(null, "El numero de control NO existe!!", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void eliminarPersona(Hashtable<String, EstudianteVo> tablaPersonas) {
        String control=JOptionPane.showInputDialog("Ingrese el numero de control de la persona a eliminar");
        if(tablaPersonas.containsKey(control)){
            tablaPersonas.remove(control);
        }else{
            JOptionPane.showMessageDialog(null, "El numero de control NO existe!!", "Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

    private void limpiarCampos() {
        //campoDireccion.setText("");
        campoNumeroControl.setText("");
        campoNombre.setText("");
        campoPromedio.setText("");
    }
    
}
