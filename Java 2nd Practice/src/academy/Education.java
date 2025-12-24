package academy;

public class Education {

		static final int INI_INT = 0; //Constant made in order to initialize all integer variables
		
		private static int surface = 36; 	/* Made private so it does not suffer any alterations during the program execution, 
											  and static cause all the classes have the same surface */
		
		private int users = INI_INT;		// Made private so it does not suffer any alteration during the program execution
		
		private String id = "-";			/* This String is initialized for the id string that will be modified later
		 									made private for no alterations during the program */
		
		public static int counter = INI_INT; // Made static so it does not belong for an instance of the class, but for the class itself
		
		final static String FORMAT = "%s%04d"; // Format for the id string (Will be used on the String.format method inside the setId method)
		
		public static int relocatedStudents = INI_INT; // This variable will store all the relocated students for all the instances of the class
	
		Education(int users) {
			
			// Constructor made for the Education class, the counter is altered before the id to use it into the id
			
			Education.counter++;
			setId();
			setUsers(users);
			
		}
	
		public static boolean checkCapacity(int users, int surface) { //Simple method to check capacity (applying formula given by the instructions of the practice)
			return (surface / users <= 1); 
		}
	
		public static String invalidCapacity(int users, int surface, String id) {
			
			// Returns a warning message when capacity is exceeded.
			
			String output = "";
			if (checkCapacity(users, surface)) {
				output = "***Careful, you have surpassed the maximum capacity of the Education class " + id + " ***";
				}
			return output;
		}
	
		
		public void getInfo() {
			// Prints the information of an instance of the class
			
			System.out.println("The education class " + id + " has " + users + " students and its surface is " + surface + "m\u00B2" );
		}

	// GETTERS AND SETTERS
	
		public String getId() {
			return id;
		}
	
		private void setId() {
			
			/* Sets an unique id to each instance of the object, 
			 * using the format given as a constant, the letter E (Education) and the instance creation number
			 */
			
			id = String.format(FORMAT, "E", Education.getCounter());
		}
	
	
		public static int getCounter() {
			return Education.counter;
		}
	
		public int getUsers() {
			return users;
		}

		private void setUsers(int users) {
			
			/* Sets students for this class.
			 * If capacity is exceeded, removes students and updates relocatedStudents.
			 */
			
			if(checkCapacity(users,surface)) {
				System.out.println(invalidCapacity(users,surface,id));
				System.out.println("Hold On We are eliminating users from the Education class " + id);
				System.out.println("Current users = " + users);
				while(checkCapacity(users,surface)) {
					users--;
					relocatedStudents++;
				}
				System.out.println("-------------\nElimination done \nFinal users = " + users);
			}
			this.users = users;
		}
	}
