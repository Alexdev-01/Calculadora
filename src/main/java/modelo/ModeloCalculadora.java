package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeloCalculadora {
	private double operando1;
	private double operando2;
	private char operador;

	//contructor
	public ModeloCalculadora() {
		operando1 = 0;
		operando2 = 0;
		operador = ' ';
	}
	
	//metodo segun la operacion hace una u otra
	public double calcular() {
		double resultado = 0;

		switch (operador) {
		case '+':
			resultado = operando1 + operando2;
			break;
		case '-':
			resultado = operando1 - operando2;
			break;
		case '*':
			resultado = operando1 * operando2;
			break;
		case '/':
			resultado = operando1 / operando2;
			break;
		default:
		}

		return resultado;
	}
	
	
    //metodo que guarda el parametro que recibe como resultado y crea un BufferWriter creando un archivo para guardar el resultado
    public void guardarResultado(double resultado) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultado.txt"))) {	 //introducimos dentro del TRY() para que se autocierre
            writer.write(Double.toString(resultado));
        }
    }

    //metodo recupera el resultado del archivo creado anteriormente con el resultado
    public double recuperarResultado() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("resultado.txt"))) {	 //introducimos dentro del TRY() para que se autocierre
            return Double.parseDouble(reader.readLine());	//es necesario parsear
        }
    }

	
	
}
