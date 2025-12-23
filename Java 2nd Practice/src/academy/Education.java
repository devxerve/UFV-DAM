package academy;

public class Education {

	static final int INI_INT = 0;
	private int surface = 36;
	private int users = INI_INT;
	private String id = "-";
	public static int counter = INI_INT;
	final static String FORMAT = "%s%04d";
	public static int relocatedStudents = INI_INT;

	Education(int users) {
		Education.counter++;
		setId();
		setUsers(users);
		
	}

	public static boolean checkCapacity(int users, int surface) {
		return (surface / users <= 1);
	}

	public static boolean unvalidCapacity(int users, int surface) {
		boolean output = false;
		if (checkCapacity(users, surface)) {
			output = true;
			}
		return output;
		}

	
	public void getInfo() {
		System.out.println("The education class " + id + " has " + users + " students and its surface is " + surface + "m\u00B2" );
	}


	public String getId() {
		return id;
	}

	private void setId() {
		id = String.format(FORMAT, "E", Education.getCounter());
	}


	public static int getCounter() {
		return Education.counter;
	}

	

	public int getUsers() {
		return users;
	}

	private void setUsers(int users) {
		if(unvalidCapacity(users,surface)) {
			System.out.println("***Careful, you have surpassed the maximum capacity of the Education class " + id + "***");
			System.out.println("Hold On We are eliminating users from the Education class");
			System.out.println("Current users = " + users);
			while(unvalidCapacity(users, surface)) {
				users--;
				relocatedStudents++;
			}
			System.out.println("-------------\nElimination done \nFinal users = " + users);
		}
		this.users = users;
	}
}
