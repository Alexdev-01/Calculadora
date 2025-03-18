
import controlador.ControladorCalculadora;
import modelo.ModeloCalculadora;
import vista.VistaCalculadora;


public class Aplicacion {
    public static void main(String[] args) {
        ModeloCalculadora modelo = new ModeloCalculadora();
        VistaCalculadora vista = new VistaCalculadora();
        ControladorCalculadora controlador = new ControladorCalculadora(modelo, vista);
        
     //   vista.setControlador(controlador);
        vista.setVisible(true);
    }
}

