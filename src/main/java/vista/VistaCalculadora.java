package vista;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCalculadora;
import lombok.Getter;
import lombok.Setter;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaCalculadoraSwing.
 */
@Getter
@Setter
public class VistaCalculadora extends JFrame {
	
	//private JFrame jframe;
    
    /** The txt resultado. */
    private JTextField txtResultado;
    
    /** btn numeros. */
    private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    
    /** btn formula y acciones */
    private JButton btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnLimpiar, btnGuardar, btnRecuperar, btnPunto;
    
    //array donde tendremos todos los componentes (botones). para no tener q ir recuperando uno por uno. Ejem... dame el btn1, dame ahora el btn2... Asi recorre todos y con un gestor de eventos “ControladorCalculadoraSwing.java”
    private AbstractButton botones[];
    
    /** The panel operadores. un panel para los numeros y otro panel para las operaciones */
    private JPanel panelNumeros, panelOperadores, panelFunciones;
    
    /**
     * Instantiates a new vista calculadora.
     */
    public VistaCalculadora() {
        //super("Calculadora Tokio");
    	setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculadora Tokio");

		//añadir un ICONO a nuestra ventana
		Image imageIcon = Toolkit.getDefaultToolkit().getImage(vista.VistaCalculadora.class.getResource("icono.png"));	//recuperamos la imagen
		setIconImage(imageIcon);
		
        //Evitamos un nuevo BorderLayout para la ventana principal
		setLayout(new BorderLayout(20, 20));

        txtResultado = new JTextField();
        txtResultado.setLayout(new GridLayout(50,20,50,50));
        txtResultado.setColumns(25);	//tamaño recuadro de texto
        txtResultado.setEditable(false);
        txtResultado.setHorizontalAlignment(JTextField.RIGHT);
        txtResultado.setBackground(Color.WHITE); //recuatro texto con fondo blanco
        txtResultado.setBorder(new EmptyBorder(10, 10, 5, 10));	//indicamos unos margenes alrededor del "txtResultado"
        //txtResultado.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
       
		
        // Panel para agregar margen alrededor del JTextField "txtResultado"
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.setBorder(new EmptyBorder(10, 20, 5, 20)); //indicamos unos margenes alrededor del "panelResultado"
        panelResultado.add(txtResultado, BorderLayout.CENTER);	//añadimos "txtResultado"

        add(panelResultado, BorderLayout.NORTH);
        //add(txtResultado, "North");
       
   
        //Creamos un Panel principal y alojamos los panles: panelNumeros, panelOperadores, panelFunciones
        JPanel contenedorPrincipal = new JPanel(new BorderLayout(20, 20));

        //PanelNumeros
        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3, 15, 15));
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");
        btn0 = new JButton("0");
        btnPunto = new JButton(".");
        btnIgual = new JButton("=");

        
        panelNumeros.add(btn1);
        panelNumeros.add(btn2);
        panelNumeros.add(btn3);
        panelNumeros.add(btn4);
        panelNumeros.add(btn5);
        panelNumeros.add(btn6);
        panelNumeros.add(btn7);
        panelNumeros.add(btn8);
        panelNumeros.add(btn9);
        panelNumeros.add(btn0);
        panelNumeros.add(btnPunto);
        panelNumeros.add(btnIgual);

        contenedorPrincipal.add(panelNumeros, BorderLayout.WEST);
        //add(panelNumeros, "West");
        
        //panelOperadores
        panelOperadores = new JPanel();
        panelOperadores.setLayout(new GridLayout(4, 1, 15, 15));
        btnSuma = new JButton("+");
        btnResta = new JButton("-");
        btnMultiplicacion = new JButton("*");
        btnDivision = new JButton("/");
        
        panelOperadores.add(btnSuma);
        panelOperadores.add(btnResta);
        panelOperadores.add(btnMultiplicacion);
        panelOperadores.add(btnDivision);
        
        contenedorPrincipal.add(panelOperadores, BorderLayout.CENTER);
        //add(panelOperadores, "Center");
        
        //panleFunciones
        panelFunciones = new JPanel();
        panelFunciones.setLayout(new GridLayout(4, 1, 15, 15));
        btnLimpiar = new JButton("Limpiar");
        btnGuardar = new JButton("Guardar");	//guardar, creamos con un texto el boton 
        btnRecuperar = new JButton("Recuperar");	//recuperar, creanos con un texto el boton
        
        panelFunciones.add(btnLimpiar);
        panelFunciones.add(btnGuardar);	//añadimos boton guardar
        panelFunciones.add(btnRecuperar);	//añadimos boton recuperar
        
        contenedorPrincipal.add(panelFunciones, BorderLayout.EAST);
        //add(panelFunciones, "East");
        
        add(contenedorPrincipal, BorderLayout.CENTER);

        pack();
        
        //añadimos todos los botones al array "botones"
        botones=new AbstractButton[] {btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSuma, btnResta, btnMultiplicacion, btnDivision, btnIgual, btnLimpiar, btnGuardar, btnRecuperar, btnPunto};
        setLocationRelativeTo(null);
    }
    
    /**
     * Sets the controlador.
     *
     * @param controlador the new controlador
     */
    public void setControlador(ControladorCalculadora controlador) {
        btn0.addActionListener(controlador);
        btn1.addActionListener(controlador);
        btn2.addActionListener(controlador);
        btn3.addActionListener(controlador);
        btn4.addActionListener(controlador);
        btn5.addActionListener(controlador);
        btn6.addActionListener(controlador);
        btn7.addActionListener(controlador);
        btn8.addActionListener(controlador);
        btn9.addActionListener(controlador);
        btnSuma.addActionListener(controlador);
        btnResta.addActionListener(controlador);
        btnMultiplicacion.addActionListener(controlador);
        btnDivision.addActionListener(controlador);
        btnIgual.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnPunto.addActionListener(controlador);
        
        btnGuardar.addActionListener(controlador);	//guardar envia por parametro
        btnRecuperar.addActionListener(controlador);	//recueperar envia por parametro
    }
    
    /**
     * Actualizar resultado.
     *
     * @param resultado the resultado
     */
    public void actualizarResultado(String resultado) {
        txtResultado.setText(resultado);
    }
}


