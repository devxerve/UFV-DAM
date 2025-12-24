package academy;

public class It {
	
	static final int INI_INT = 0; //Constant made in order to initialize all integer variables
	
	private static int surface = 24; /* Made private so it does not suffer any alterations during the program execution, 
	  									and static cause all the classes have the same surface */
	
	private int users = INI_INT; // Made private so it does not suffer any alteration during the program execution
	
	private int pcs = surface/2; /* Made private so it does not suffer any unwanted alteration during the program execution 
									initial value given by formula in the instructions of the practice*/
	
	private String id = "-"; /* This String is initialized for the id string that will be modified later
		made private for no alterations during the program */
	
	
	public static int counter = INI_INT; // Made static so it does not belong for an instance of the class, but for the class itself
	
	final static String FORMAT = "%s%04d"; // Format for the id string (Will be used on the String.format method inside the setId method)
	
	public static int relocatedStudents = INI_INT; // This variable will store all the relocated students for all the instances of the class

	It(int users, int pcs){
		
		// Constructor made for the It class, the counter is altered before the id to use it into the id
		
		It.counter++;
		setId();
		setPcs(pcs);
		setUsers(users);
		
	}
	
	public static boolean checkCapacity(int users ,int pcs) { //Simple method to check capacity (applying formula given by the instructions of the practice)
		return (users > pcs);
	}
	
public static String invalidCapacity(int users, int pcs, String id) {
		
		// Returns a warning message when capacity is exceeded.

		
		String output = "";
		if (checkCapacity(users, pcs)) {
			output = "***Careful, you have surpassed the maximum capacity of the It class " + id + " ***";
			}
		return output;
		}
	
	public void getInfo() {
		// Prints the information of an instance of the class 
		System.out.println("The It class " + id + " has " + users + " students, " + pcs + " computers" + " and its surface is " + surface + "m\u00B2" );
	}
	public  String getId() {
		return id;
	}
	private void setId() {
		/* Sets an unique id to each instance of the object, 
		 * using the format given as a constant, the letter I (It) and the instance creation number
		 */
		id = String.format(FORMAT, "I", It.getCounter());
	}
	
	public int getPcs() {
		return pcs;
	}

	public void setPcs(int pcs) {
		
		/* Sets the number of PCs for each instance.
		 * If the input is 0, the default value (12) is used.
		 */

		if(pcs == 0) {
			this.pcs = 12;
		}else {
			this.pcs = pcs;
		}
	}

	public static int getCounter() {
		return It.counter;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		
		/* Sets students for this class.
		 * If capacity is exceeded, removes students and updates relocatedStudents.
		 */
		
		if(checkCapacity(users,pcs)) {
			
			System.out.println(invalidCapacity(users,pcs,id));
			System.out.println("Hold On We are eliminating users from the It class " + id);
			System.out.println("Current users = " + users);
			while(checkCapacity(users,pcs)) {			
				users--;
				relocatedStudents++;
			}
			System.out.println("-------------\nElimination done \nFinal users = " + users);
		}
		this.users = users;
		
	}
	}
