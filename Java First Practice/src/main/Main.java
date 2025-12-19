package main;

//IMPORTACIONES
	import java.util.InputMismatchException;
	import java.util.Scanner;
	
//Principal
	
public class Main {
	static final int INI_INT = 0;
	static final String SEPARADOR ="\n--------------------";
	
	//METODOS
	
		public static int leerInt(Scanner entrada) {
			int output = INI_INT;
			try {
				output = entrada.nextInt();
			} catch (InputMismatchException ex) {
				output = INI_INT;
				entrada.next();
				System.out.println("Error, introduce solo números, el programa terminara");
			}
			return output;
		}
		public static int generarNum(int min, int max) {
			int output;
			output = (int) (Math.random() * (max-min+1)+min);
			return output;
		}
		
		public static boolean comprobarPar(int num) {
			boolean output= false;
			if(num %2 == INI_INT) {
				output = true; // True es PAR
			}else {
				output = false; //False es IMPAR
			}
			return output;
		}
		
		public static void rellenarArrayimpar(int[] impares) {
			boolean valid = false;
			int temp = INI_INT;
			for (int i = 0; i < impares.length; i++) {
		        do {
		            valid = false;
		            temp = generarNum(5,50); 
		            if (!comprobarPar(temp)) {
		                impares[i] = temp;
		                valid = true;
		            }
		        } while (!valid);
		    }
		}
		public static void rellenarArraypar( int[] pares, int tam){
			boolean valid = false;
			int temp = INI_INT;
			for (int i = INI_INT; i < pares.length; i++) {
		        do {
		            valid = false;
		            temp = generarNum(1,tam); 
		            if (comprobarPar(temp)) {                    
		                pares[i] = temp;
		                valid = true;
		            }
		        } while (!valid);
		    }
		}
		public static void mostrarArraypar(int[] pares) {
			for (int i = 0; i < pares.length; i++) {
				System.out.print("[" + i  + "]="+ pares[i]+ " | ");
			}
		}
		public static void mostrarArrayImpar(int[] impares) {
			for (int i = 0; i < impares.length; i++) {
				System.out.print("[" + i  + "]="+ impares[i]+ " | ");
			}
		}
		
		public static int numeroMenor(int[] array) {
			int output = array[0];
			for (int i = 1; i < array.length; i++) {
			    if (array[i] < output) {
			        output = array[i];
			    }
			}
			return output;
		}
		public static int numeroMayor(int[] array) {
		int output = array[0];
		for (int i = 1; i < array.length; i++) {
		    if (array[i] > output) {
		        output = array[i];
		    }
		}
		return output;
		}
		public static int mcd(int a, int b) {
		   int temp = INI_INT;
		    while (b != INI_INT) {
		        temp = b;
		        b = a % b;
		        a = temp;
		    }
		    return a;
		}
		

	//MAIN
		
		public static void main(String[] args) {
			
		//Declaracion de entrada y variables
			
			Scanner entrada = new Scanner (System.in);
			int tam_impares,tam_pares;
			tam_impares =  tam_pares = INI_INT;
			
			
		//Creacion y relleno Array Impar
			
			System.out.println("Introduce el tamaño del Array que quieres crear");
			tam_impares = leerInt(entrada);
			if(tam_impares > INI_INT) {
				int[] impares = new int[tam_impares];
				rellenarArrayimpar(impares);
				
			//Creacion y relleno Array par
				
				tam_pares = numeroMenor(impares);
				int[] pares = new int[tam_pares];
				rellenarArraypar(pares,tam_pares);
			
			//Mostramos array y numeros mayores y menores
				
				System.out.println(SEPARADOR);
				
				System.out.println("Array Impares");
				mostrarArrayImpar(impares);
				
				System.out.println(SEPARADOR);
				
				System.out.println("Array pares");
				mostrarArraypar(pares);
				
				System.out.println(SEPARADOR);
				
				System.out.println("El número menor del array impar es " + numeroMenor(impares));
				System.out.println("El número mayor del array impar es " + numeroMayor(impares));
				
				System.out.println(SEPARADOR);
				
				System.out.println("El número menor del array par es " + numeroMenor(pares));
				System.out.println("El número mayor del array par es " + numeroMayor(pares));
				
				System.out.println(SEPARADOR);
				
				System.out.println("El Máximo Común Divisor de " + numeroMenor(pares)+ " y " + numeroMayor(pares)+ " es:  "+  mcd(numeroMenor(pares),numeroMayor(pares)));
				
				
			}else if(tam_impares != INI_INT){
				System.out.println("Tamaño invalido, el programa termina");
			}
			
			entrada.close();
		}
}