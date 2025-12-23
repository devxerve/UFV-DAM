package academy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Academy {
static final int INI_INT = 0;
static final String SEPARATOR = "-----------------";
	public static int readInt(Scanner input) {
		
		/* This method asks for an integer input, and if the input is not an integer it catches the exception
		 * and sets the variable output to -1 (that will be the control), also if the input is negative it will
		 * ask for the input again. The method wont finish until a positive integer value is inserted
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
			Scanner input = new Scanner (System.in);
			ArrayList<It> list_It = new ArrayList<It>();
			ArrayList<Education> list_Education = new ArrayList<Education>();
		
		//Variables declaration
			int option, relocatedStudents, computers, students;
			option = relocatedStudents = computers = students = INI_INT;
		
		// Instructions
			
			do {
				System.out.println("Type a number between 1-4 to choose an option \n1) Create an It Class \n2) Create an education class \n3) Show classes summary \n4) Exit");
				option = readInt(input);
				switch (option) {

				case 1:
					System.out.println("You chose to create an It Class \n Introduce the number of computers you want to install in the class (0 is default (12 pcs)");
					computers = readInt(input);
					System.out.println("You may now introduce the number of students you want to put into the class");
					students = readInt(input);
					list_It.add(new It(students, computers));
					list_It.getLast().getInfo();
					System.out.println(SEPARATOR);
					break;
				case 2:
					System.out.println("You chose to create an Education Class");
					System.out.println("You may now introduce the number of students you want to put into the class");
					students = readInt(input);
					list_Education.add(new Education(students));
					list_Education.getLast().getInfo();
					System.out.println(SEPARATOR);
					break;
				case 3:
					if ((list_Education.size() == 0) && (list_It.size() == 0)) {
						System.out.println("There is no classes to show in the summary");
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
					
					/* Both the static variables relocatedStudents are being summed 
					 * in order to being outputed to give more information when ending the program
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
