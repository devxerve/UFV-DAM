package academy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Academy {
	/** Main class that manages different types of classrooms (It and Education)
	 *  @author DevXervE &lt;aviercerverarodriguez@gmail.com&gt;
	 *  @version 1.0
	 *  @param INI_INT Constant made in order to initialize all integer variables in the code
	 *  @param DIVIDER Constant made to separate prints visually during the code
	 */
static final int INI_INT = 0; 
static final String DIVIDER = "-----------------"; 

	/** 
	 * Reads an input from standard input using a Scanner Object
	 * if the input is not an integer or its a negative one 
	 * the input gets asked until it matches a positive integer
	 * @param input Scanner made for user input
	 * @return Positive integer
	 */
	public static int readInt(Scanner input) {
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
	
	/**
	 * Main method that runs the program.
	 * Allows the user to create dynamic arrays for different types of classrooms (IT and Education).
	 * The user enters a number to choose an option:
	 * - 1: Create an IT classroom (specify computers and students).
	 * - 2: Create an Education classroom (specify students).
	 * - 3: Show a summary of all classrooms created.
	 * - 4: Exit the program and show the total number of students to relocate.
	 * The program uses a do-while loop to repeat the menu until the user chooses to exit.
	 * 
	 * @param args Command-line arguments (not used).
	 */

	
	public static void main(String[] args) {
		
			Scanner input = new Scanner(System.in);
			ArrayList<It> list_It = new ArrayList<It>();
			ArrayList<Education> list_Education = new ArrayList<Education>();
		
			int option, relocatedStudents, computers, students;
			option = relocatedStudents = computers = students = INI_INT;
		
			
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
					System.out.println(DIVIDER);
					break;
				case 2:
					System.out.println("You chose to create an Education classroom");
					System.out.println("You may now enter the number of students you want to put into the class");
					students = readInt(input);
					list_Education.add(new Education(students));
					list_Education.getLast().getInfo();
					System.out.println(DIVIDER);
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
						System.out.println(DIVIDER);
						for (Education education : list_Education) {
							education.getInfo();
						}
						System.out.println("**** End of Class Summary ****");
						System.out.println(DIVIDER);
					}
					break;
				case 4:
					
					// Sums relocatedStudents from both classes to show the total number of relocated students when exiting.
					
					relocatedStudents = It.relocatedStudents + Education.relocatedStudents; 
					System.out.println("Students to relocate = " + relocatedStudents);
					System.out.println(DIVIDER);
					break;
					
				default:
					System.out.println("A number between 1-4 was expected, you may try again");
					System.out.println(DIVIDER);
					break;
				}
			} while (option !=4);
				System.out.println("Bye!!!!!!!");
		input.close();
	}

}
