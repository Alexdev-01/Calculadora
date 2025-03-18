package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import modelo.ModeloCalculadora;
import vista.VistaCalculadora;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class ControladorCalculadora implements ActionListener {
	
    private ModeloCalculadora modelo;
    private VistaCalculadora vista;
    private double resultado = 0;
    
    //constructor
    public ControladorCalculadora(ModeloCalculadora modelo, VistaCalculadora vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        AbstractButton botones[]= vista.getBotones();	//dame todos los botones del Array "botones"
        System.out.println(botones.length);
		for (int i = 0; i < botones.length; i++) {
			System.out.println(i+"-"+botones[i]);
			((JButton)(botones[i])).addActionListener(this);	//addActionListener es el q va gestionar los eventos, xq implement "ActionListener"
		}
    }
    
    public void actionPerformed(ActionEvent e) {
    	
    try {
    	//una forma mas obtima
    	//siempre q sea un boton de numero recupera el texto ((JButton)e.getSource()).getText()), q pone en el boton seleccionado como VALOR
    	if(e.getSource() == vista.getBtn0() || e.getSource() == vista.getBtn1() || e.getSource() == vista.getBtn2() || e.getSource() == vista.getBtn3() || e.getSource() == vista.getBtn4() || e.getSource() == vista.getBtn5() || e.getSource() == vista.getBtn6() || e.getSource() == vista.getBtn7() || e.getSource() == vista.getBtn8() || e.getSource() == vista.getBtn9() ) {
    		vista.actualizarResultado(vista.getTxtResultado().getText() + ((JButton)e.getSource()).getText());
    	}
    
    	//una forma menos obtima, solo botones de numeros
        /*if(e.getSource() == vista.getBtn0()) {	//estoy presionando el Btn0
            vista.actualizarResultado(vista.getTxtResultado().getText() + "0"); //dame el "0"
        } else if(e.getSource() == vista.getBtn1()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "1");
        } else if(e.getSource() == vista.getBtn2()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "2");
        } else if(e.getSource() == vista.getBtn3()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "3");
        } else if(e.getSource() == vista.getBtn4()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "4");
        } else if(e.getSource() == vista.getBtn5()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "5");
        } else if(e.getSource() == vista.getBtn6()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "6");
        } else if(e.getSource() == vista.getBtn7()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "7");
        } else if(e.getSource() == vista.getBtn8()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "8");
        } else if(e.getSource() == vista.getBtn9()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + "9");
        } else*/
    	
    	//formulas
    	if(e.getSource() == vista.getBtnSuma()) {
            modelo.setOperando1(Double.parseDouble(vista.getTxtResultado().getText()));
            modelo.setOperador('+');
            vista.actualizarResultado("");
            
        } else if(e.getSource() == vista.getBtnResta()) {
            modelo.setOperando1(Double.parseDouble(vista.getTxtResultado().getText()));
            modelo.setOperador('-');
            vista.actualizarResultado("");
            
        } else if(e.getSource() == vista.getBtnMultiplicacion()) {
            modelo.setOperando1(Double.parseDouble(vista.getTxtResultado().getText()));
            modelo.setOperador('*');
            vista.actualizarResultado("");
            
        } else if(e.getSource() == vista.getBtnDivision()) {
            modelo.setOperando1(Double.parseDouble(vista.getTxtResultado().getText()));
            modelo.setOperador('/');
            vista.actualizarResultado("");
            
        } else if(e.getSource() == vista.getBtnIgual()) {
        	modelo.setOperando2(Double.parseDouble(vista.getTxtResultado().getText()));
            double resultado = modelo.calcular();
            vista.actualizarResultado(Double.toString(resultado));
            
        } else if(e.getSource() == vista.getBtnLimpiar()) {
            modelo.setOperando1(0);
            modelo.setOperando2(0);
            modelo.setOperador(' ');
            vista.actualizarResultado("");
        
        //Punto
        } else if (e.getSource() == vista.getBtnPunto()) {
            vista.actualizarResultado(vista.getTxtResultado().getText() + ".");

        //Guardar, usamos el metodo "guardarResultado" el parametro que recibe tenemos que parsearlo, siendo el resultado de la "vista"
        } else if (e.getSource() == vista.getBtnGuardar()) {
            modelo.guardarResultado(Double.parseDouble(vista.getTxtResultado().getText()));
            vista.actualizarResultado("Guardado");

        //Recuperar, usamos el metodo "recuperarResultado" para recuperar el resultado guardado y sacarlo por la "vista"
        } else if (e.getSource() == vista.getBtnRecuperar()) {
            vista.actualizarResultado(Double.toString(modelo.recuperarResultado()));

        }
    	
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (NumberFormatException ex) {
        ex.printStackTrace();
        vista.actualizarResultado("Error");
    }
    

    }
}


