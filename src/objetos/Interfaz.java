package objetos;
import java.util.Random;

import javax.swing.JOptionPane;


public class Interfaz {

	static int numeroGenerado; 
	static int intentos = 0;
	
	//Genera un numero aleatorio entre 1 i 500 ambos incluidos
	public static void generarNumero() {
		Random random = new Random();
		numeroGenerado = random.nextInt(501);		
	}
	
	//Pide por pantalla un numero al usuario
	public static void pedirNumero() {
		boolean seguir = true;		
		String numeroTxt;
		int numeroIntroducido;		
		
		do {
			numeroTxt = JOptionPane.showInputDialog("Introduce un numero del 1 al 500");
			numeroIntroducido = Integer.parseInt(numeroTxt);
			intentos ++;
			
			if(numeroIntroducido == numeroGenerado) {
				seguir = false;
				JOptionPane.showMessageDialog(null, "Muy bine has acertado!!");
				JOptionPane.showMessageDialog(null, "Has hecho " + intentos + " intentos");
				intentos = 0;
			} 
			else if (numeroIntroducido < numeroGenerado) {
				JOptionPane.showMessageDialog(null, "Es un numero mas grande");
			} 
			else if (numeroIntroducido > numeroGenerado) {
				JOptionPane.showMessageDialog(null, "Es un numero mas pequeño");
			}
			
			} while (seguir);
	}
	
	//Pedirem un numero i controlaremos la excepcion en caso de que no se introduzca un numero entero
	public static void pedirNumeroExcepcion() {		
			try {
				pedirNumero();
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "No has introducido un numero");
				intentos++; // si no introduce un numero entero, lo contaremos como un intento
				pedirNumeroExcepcion(); // en caso de excepcion pediremos el numero otra vez controlando la excepcion
			}			
	}	
}
