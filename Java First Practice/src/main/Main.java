package main;

	//IMPORTS

		import java.util.InputMismatchException;
		import java.util.Scanner;
		
public class Main {
	static final int INI_INT = 0;
	static final String DIVIDER ="\n--------------------";
	
	//METHODS
	
		public static int readInt(Scanner input) {
			int output = INI_INT;
			try {
				output = input.nextInt();
			} catch (InputMismatchException ex) {
				output = INI_INT;
				input.next();
				System.out.println("ERROR! only numbers are allowed here, program will end now");
			}
			return output;
		}
		
		public static int numGen(int min, int max) {
			
			//This method generates a number between a range that is given via parameters
			
			int output;
			output = (int) (Math.random() * (max-min+1)+min);
			return output;
		}
		
		public static boolean checkEven(int num) {
			
			/**This method checks that every number given to the method is even or not
			 * and returns true if so, false if not
			 */
			
			return num % 2 == 0;
		}
		
		public static void fillOdds(int[] odds) {
			
			/**This method fills an array with numbers randomly generated 
			 * those numbers are being checked to be odd before being
			 * introduced into the Array
			 */
			
			int temp = INI_INT;
			for (int i = 0; i < odds.length; i++) {
				do {
					temp = numGen(5, 50);
				} while (checkEven(temp));
				odds[i] = temp;
			}
			
		}
		
		public static void fillEvens( int[] evens){
			
			/**This method fills an array with numbers randomly generated 
			 * those numbers are being checked to be even before being
			 * introduced into the Array
			 */
			
			int temp = INI_INT;
			for (int i = 0; i < evens.length; i++) {
				do {
					temp = numGen(5, evens.length);
				} while (!checkEven(temp));
				evens[i] = temp;
			}
			
		}
		
		
		public static void showArray(int[] array) {
			
			//This method shows all the values stored in the array
			
			for (int i = 0; i < array.length; i++) {
				System.out.print("[" + i  + "]="+ array[i]+ " | ");
			}
		}
		
		public static int smallerNumber(int[] array) {
			
			/**This method takes all the numbers in the array and 
			 * compares each one to the one right after in order 
			 * to find the smaller one, that number is being returned 
			 * only after all the values have been checked
			 */
			
			int output = array[0];
			for (int i = 1; i < array.length; i++) {
			    if (array[i] < output) {
			        output = array[i];
			    }
			}
			return output;
		}
		
		public static int greaterNumber(int[] array) {
			
			/**This method takes all the numbers in the array and 
			 * compares each one to the one right after in order 
			 * to find the greater one, that number is being returned 
			 * only after all the values have been checked
			 */
			
		int output = array[0];
		for (int i = 1; i < array.length; i++) {
		    if (array[i] > output) {
		        output = array[i];
		    }
		}
		return output;
		}
		
		
		public static int gcd(int a, int b) {
			
			/**This method uses the Euclide´s algorithm to get the
			 * Greatest common divisor
			 */
			
			
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
			
		//Declaration of variables
			
			Scanner input = new Scanner (System.in);
			int odds_size,evens_size, evensSmall, evensGreat;
			odds_size =  evens_size = evensSmall = evensGreat = INI_INT;
			
			
		//Creation of the Odd numbers Array
			
			System.out.println("Please, type the size of the Array you want to create");
			odds_size = readInt(input);
			
			if(odds_size > INI_INT) {
				int[] odds = new int[odds_size];
				fillOdds(odds);
				
		//Creation of the even numbers Array
				
				evens_size = smallerNumber(odds);
				int[] evens = new int[evens_size];
				fillEvens(evens);
			
		//Showing both Arrays and the greatest and smaller numbers of each and the gcd between both
				
				System.out.println(DIVIDER);
				
				System.out.println("Array containing odd numbers");
				showArray(odds);
				
				System.out.println(DIVIDER);
				
				System.out.println("Array containing even numbers") ;
				showArray(evens);
				
				System.out.println(DIVIDER);
				
				System.out.println("The greatest number of the Array containing odds is: " + greaterNumber(odds));
				System.out.println("The smallest number of the Array containing odds is: " + (smallerNumber(odds)));
				
				System.out.println(DIVIDER);
				
			
				System.out.println("The greatest number of the Array containing evens is: " + (evensGreat =greaterNumber(evens)));
				System.out.println("The smallest number of the Array containing evens is: " +(evensSmall = smallerNumber(evens)));
				
				System.out.println(DIVIDER);
				
				System.out.println("The greatest common divisor of " + smallerNumber(evens)+ " and " + greaterNumber(evens)+ " is:  "+  gcd(evensSmall,evensGreat));
				
				
			}else if(odds_size != INI_INT){
				
				System.out.println("Invalid size, program will end now");
				
			}
			
			input.close();
		}
}