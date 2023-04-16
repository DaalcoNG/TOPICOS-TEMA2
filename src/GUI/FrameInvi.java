/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Graficas.Graficas;
import IO.Jopi;
import IO.Totales;
import TDA.Asistentes;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class FrameInvi extends JFrame implements ActionListener{
    private Totales lista;
    private Container contenedor;
    private JRadioButton radio3,radio4,radio5,radio6;
    private JCheckBox radio1, radio2;
   private ButtonGroup btsex,btcivil;
    private JList listasis,listaest;
    private DefaultListModel modelo,modelo2;
    private JScrollPane scrollLista,scrollLista2;
    private JLabel nombre,edad,sexo,civil,estad,asist;
    private JButton añadir, mostrar, eliminar,graficag;
    private JTextField campoNombre, campoEdad;
    public FrameInvi() {
        lista = new Totales(); //Objeto de la clase totales para llamada de metodos de esa clase
        inicio();
        setTitle("Captura datos ");
        setSize(500, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        //getContentPane().setBackground(Color.orange);

    }
    
    private void inicio(){
        contenedor = getContentPane();
        contenedor.setLayout(null);
        //******NOMBRE******
        nombre = new JLabel();
        nombre.setText("Nombre:");
        nombre.setBounds(20, 5, 100, 30);
        campoNombre = new JTextField();
        campoNombre.setBounds(110,12,150,20);
        //******EDAD******
        edad = new JLabel();
        edad.setText("Edad:");
        edad.setBounds(20, 35, 100, 30);
        campoEdad = new JTextField();
        campoEdad.setBounds(110,42,150,20);
        //******SEXO******
        sexo = new JLabel();
        sexo.setText("Sexo:");
        sexo.setBounds(270, 5, 100, 30);
        
        btsex= new ButtonGroup();
        radio1 = new JCheckBox("Femenino");
        radio1.setBounds(310, 5, 85, 30);
        contenedor.add(radio1);
        btsex.add(radio1);

        radio2 = new JCheckBox("Masculino");
        radio2.setBounds(400, 5, 85, 30);
        contenedor.add(radio2);
        btsex.add(radio2);
        //******ESTADO CIVIL******
        btcivil= new ButtonGroup();
        civil = new JLabel();
        civil.setText("Estado civil:");
        civil.setBounds(20, 72, 100, 30);
        
        radio3 = new JRadioButton("soltero");
        radio3.setBounds(30, 102, 70, 25);
        contenedor.add(radio3);
        btcivil.add(radio3);
        
        radio4 = new JRadioButton("casado");
        radio4.setBounds(140, 102, 70, 25);
        contenedor.add(radio4);
        btcivil.add(radio4);
        
        radio5 = new JRadioButton("viudo");
        radio5.setBounds(250, 102, 70, 25);
        contenedor.add(radio5);
        btcivil.add(radio5);
        
        radio6 = new JRadioButton("divorciado");
        radio6.setBounds(360, 102, 90, 25);
        contenedor.add(radio6);
        btcivil.add(radio6);
        //******CAMPO PARA ASISTENTES******
        asist = new JLabel();
        asist.setText("Asistentes");
        asist.setBounds(115, 132, 100, 30);
        listasis = new JList();
        listasis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();
        // Establece una barra de desplazamiento vertical
        scrollLista = new JScrollPane();
        scrollLista.setBounds(45, 172, 200, 150);
        // Asocia la barra de desplazamiento vertical a la lista de personas
        scrollLista.setViewportView(listasis);
        
         //******CAMPO PARA ESTADISTICAS******
        estad = new JLabel();
        estad.setText("Estadisticas");
        estad.setBounds(310, 132, 100, 30);
        listaest = new JList();
        listaest.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo2 = new DefaultListModel();
        // Establece una barra de desplazamiento vertical
        scrollLista2 = new JScrollPane();
        scrollLista2.setBounds(250, 172, 200, 150);
        // Asocia la barra de desplazamiento vertical a la lista de personas
        scrollLista2.setViewportView(listaest);

        //BOTONESSS
        añadir = new JButton();
        añadir.setText("Añade asistente");
        añadir.setBounds(20, 338, 130, 23);
        añadir.addActionListener(this);
        mostrar = new JButton();
        mostrar.setText("<html><center>Mostrar<p>estadisticas</p></center><html>");
        mostrar.setBounds(265, 330, 75, 40);
        mostrar.addActionListener(this);
        eliminar= new JButton();
        eliminar.setText("Eliminar");
        eliminar.setBounds(170, 335, 80, 23);
        eliminar.addActionListener(this);
        graficag=new JButton("Genera grafico");
        graficag.setBounds(400, 335, 80, 23);
        graficag.addActionListener(this);
        
        //Añade componentes
        contenedor.add(nombre);
        contenedor.add(campoNombre);
        contenedor.add(edad);
        contenedor.add(campoEdad);
        contenedor.add(sexo);
        contenedor.add(civil);
        contenedor.add(scrollLista);
         contenedor.add(scrollLista2);
        contenedor.add(estad);
        contenedor.add(asist);
        contenedor.add(añadir);
        contenedor.add(mostrar);
        contenedor.add(eliminar);
        contenedor.add(graficag);
        
    }
    private void añadeAsis(){     
        Asistentes p= new Asistentes();
        /* Se obtienen los campos de texto ingresados y se crea una Alumno */
         String cad = campoNombre.getText() +" "+ campoEdad.getText();
        p.setNombre(campoNombre.getText());
        p.setEdad((Byte.parseByte(campoEdad.getText())));
        if(radio2.isSelected()){
            p.setSexo("Masculino");cad+=" Masculino";
        }
        if(radio1.isSelected()){
            p.setSexo("Femenino");cad+=" Femenino";
        }
        
        if(radio3.isSelected()){
            p.setEstadoCivil("Soltero");cad+=" Soltero";
        }else{
            if(radio4.isSelected()){
                p.setEstadoCivil("Casado");cad+=" Casado";
            }else{
                if (radio5.isSelected()) {
                    p.setEstadoCivil("Viudo");cad+=" Viudo";
                }else{
                    if(radio6.isSelected()){
                        p.setEstadoCivil("Divorciado");cad+=" Divorciado";
                    }
                }
            }
        }
        lista.añadeAs(p);
        /* Se añade una persona al vector de personas */
       
        modelo.addElement(cad);
        /* Se agrega el texto con los  datos del Alumni al JList */
        listasis.setModel(modelo);
        int x = modelo.getSize();
        // Se colocan todos los campos de texto nulos, para limpiar el area
        campoNombre.setText("");
        campoEdad.setText("");
        btsex.clearSelection();
        btcivil.clearSelection();
    }
        private void eliminarAsis(int indice) {
        if (indice >= 0) { // Si la posición existe
            modelo.removeElementAt(indice);
            /* Se elimina un alumno seleccionada de la lista gráfica */
            lista.eliminarAsis(indice);
            int x = modelo.getSize();
            modelo2.clear();
            mostrarEst();
        } else {
            /* Si no se seleccionó ninguna persona, se genera un  mensaje de error */
            JOptionPane.showMessageDialog(null, "Debe seleccionar un elemento");
        }
    }
    private void mostrarEst() {
        modelo2.addElement("Total: " + lista.totalAsistentes() );
        modelo2.addElement("Mayores de Edad: " + lista.totalMayorEdad() );
        modelo2.addElement("Hombres: " + lista.totalHombres() );
        modelo2.addElement("Mujeres: " + lista.totalMujeres() );
        modelo2.addElement("Solteros: " + lista.totalSolteros());
        modelo2.addElement("Casados: " + lista.totalCasados() );
        modelo2.addElement("Viudos: " + lista.totalViudos() );
        modelo2.addElement("Divorciados: " + lista.totalDivorciados()  );
        modelo2.addElement("Porcentaje Hombres: " + lista.porcentajeHombres() );
        modelo2.addElement("Porcentaje Mujeres: " + lista.porcentajeMujeres() );    
        listaest.setModel(modelo2);
        int x = modelo2.getSize();
    }

    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == añadir) { // Si se pulsa el botón añadir
                añadeAsis();
        }
        if(evento.getSource()==mostrar){
            mostrarEst();
        }
        if(evento.getSource()==eliminar){
            eliminarAsis(listasis.getSelectedIndex());
        }
        if(evento.getSource()==graficag){
            Graficas.crearGraficas(Graficas.edad(lista),
             Graficas.sexo(lista),Graficas.civil(lista),
             Graficas.porcentaje(lista), lista);
        }
    }
    
}
