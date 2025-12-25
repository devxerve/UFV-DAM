package academy;

/** 
  * Class that manages the creation of Education classrooms
  * @author [DevXervE &lt;aviercerverarodriguez@gmail.com&gt;]
  * @version 1.0
 */

	public class Education {
		
			/**
			 * Constant made in order to initialize all integer variables in the code.
			 */
		
				static final int INI_INT = 0; 
			
			/**
			 * Made private so it does not suffer any alterations during program execution, and static because all classes have the same surface.
			 */
			
				private static int surface = 36; 	
			
			/**
			 * Made private so it does not suffer any alteration during the program execution each instance <b>(clasroom)</b> can have a diferent number of students.
			 */
			
				private int students = INI_INT;		
			
			/**
			 * This String is initialized for the id string that will be modified later made private for no alterations during the program.
			 */
			
				private String id = "-";	
			
			/**
			 * Made static so it does not belong for an instance of the class, but for the class itself, made for counting how many clasrooms of this class exists 
			 */
			
				public static int counter = INI_INT;  
			
			/**
			 * <b>Constant</b> for the <b>id</b> string (Will be used on the String.format method inside the <b>setId</b> method)
			 */
			
				final static String FORMAT = "%s%04d"; 
			
			/**
			  * This static variable will store all the relocated students for all the instances of the class
			 */
			
				public static int relocatedStudents = INI_INT; // 
		
			/** 
			  * Constructor for the Education class the counter is altered before the id to use it into the id
			  * @param students each classroom has its own number of students
			  */
			
				Education(int students) {
					Education.counter++;
					setId();
					setUsers(students);
				}
			
			/**
			  * Simple method to check capacity (applying comparison formula given by the instructions of the practice)
			  * @param students This parameter is the number of students for each classroom
			  * @param surface This parameter is the total surface of each classroom
			  * @return True if the comparison is correct, false if not
			 */
			
				public static boolean checkCapacity(int students, int surface) { 
					return (surface / students <= 1); 
				}
		
			/**
			  * Returns a warning message when capacity is exceeded.
			  * @param students This parameter is the number of students for each classroom, used in the invocation of <b>checkCapacity</b>
			  * @param surface This parameter is the total surface of each classroom, used in the invocation of <b>checkCapacity</b>
			  * @param id This parameter is made in order to format the output of the method
			  * @return Warning message if the capacity is surpassed
			 */
				
				public static String invalidCapacity(int students, int surface, String id) {
					String output = "";
					if (checkCapacity(students, surface)) {
						output = "***Careful, you have surpassed the maximum capacity of the Education class " + id + " ***";
						}
					return output;
				}
		
			/**
			 * Prints the information of an instance of the class
			 */
			
				public void getInfo() {
					System.out.println("The education class " + id + " has " + students + " students and its surface is " + surface + "m\u00B2" );
				}
		
				public String getId() {
					return id;
				}
		
			/**
			 * Sets an unique id to each instance of the object, using the format given as a constant, the letter E (Education) and the instance creation number
			 */
			
				private void setId() {			
					id = String.format(FORMAT, "E", Education.getCounter());
				}
		
				public static int getCounter() {
					return Education.counter;
				}
			
				public int getUsers() {
					return students;
				}
	
			/**
			 * Sets students for this class. If capacity is exceeded, removes students and updates relocatedStudents.
			 * @param students This parameter is the number of students for each classroom, used in the invocation of <b>invalidCapacity</b>
			 */
			
				private void setUsers(int students) {			
					if(checkCapacity(students,surface)) {
						System.out.println(invalidCapacity(students,surface,id));
						System.out.println("Hold On We are eliminating users from the Education class " + id);
						System.out.println("Current users = " + students);
						while(checkCapacity(students,surface)) {
							students--;
							relocatedStudents++;
						}
						System.out.println("-------------\nElimination done \nFinal users = " + students);
					}
					this.students = students;
				}
		}
