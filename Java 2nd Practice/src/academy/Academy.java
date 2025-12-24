package academy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Academy {
static final int INI_INT = 0; // Constant made in order to initialize all integer variables
static final String SEPARATOR = "-----------------"; // Visual separator between console sections.
	public static int readInt(Scanner input) {
		
		/* Reads an integer from input.
		 * If the user enters a non‑integer or a negative value,
		 * the method shows an error message and asks again.
		 * It only returns once a positive integer has been provided.
		 */


		int output = INI_INT;
		do {
			try {
				output = input.nextInt();
				if (output < INI_INT) {
	                System.out.println("A positive integer was expected here, you may try again");
	                output = -1;
	            }
			} catch (InputMismatchException ex) {
				input.next();
				System.out.println("An integer was expected here, you may try again");
				output = -1;
			}
			
		} while (output == -1);	
		return output;	
	}

	public static void main(String[] args) {
		
		//Objects declaration
			Scanner input = new Scanner(System.in);
			ArrayList<It> list_It = new ArrayList<It>();
			ArrayList<Education> list_Education = new ArrayList<Education>();
		
		//Variables declaration
			int option, relocatedStudents, computers, students;
			option = relocatedStudents = computers = students = INI_INT;
		
		// Instructions
			
			do {
				System.out.println("Enter a number between 1-4 to choose an option \n1) Create an IT classroom \n2) Create an Education classroom \n3) Show classes summary \n4) Exit");
				option = readInt(input);
				switch (option) {

				case 1:
					System.out.println("You chose to create an IT classroom \n Enter the number of computers you want to install in the class (0 is default (12 pcs)");
					computers = readInt(input);
					System.out.println("You may now enter the number of students you want to put into the class");
					students = readInt(input);
					list_It.add(new It(students, computers));
					list_It.getLast().getInfo();
					System.out.println(SEPARATOR);
					break;
				case 2:
					System.out.println("You chose to create an Education classroom");
					System.out.println("You may now enter the number of students you want to put into the class");
					students = readInt(input);
					list_Education.add(new Education(students));
					list_Education.getLast().getInfo();
					System.out.println(SEPARATOR);
					break;
				case 3:
					
					// Before showing the summary, check that at least one list is not empty.

					
					if ((list_Education.size() == 0) && (list_It.size() == 0)) { 
						System.out.println("There are no classes to show in the summary");
					}else {
						System.out.println("**** Class Summary ****");
						for (It it : list_It) {
							it.getInfo();
						}
						System.out.println(SEPARATOR);
						for (Education education : list_Education) {
							education.getInfo();
						}
						System.out.println("**** End of Class Summary ****");
						System.out.println(SEPARATOR);
					}
					break;
				case 4:
					
					/* Sums relocatedStudents from both classes
					 * to show the total number of relocated students when exiting.
					 */

					
					relocatedStudents = It.relocatedStudents + Education.relocatedStudents; 
					System.out.println("Students to relocate = " + relocatedStudents);
					System.out.println(SEPARATOR);
					break;
					
				default:
					System.out.println("A number between 1-4 was expected, you may try again");
					System.out.println(SEPARATOR);
					break;
				}
			} while (option !=4);
				System.out.println("Bye!!!!!!!");
		input.close();
	}

}
