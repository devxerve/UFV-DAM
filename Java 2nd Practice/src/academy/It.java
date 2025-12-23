package academy;

public class It {
	
	static final int INI_INT = 0;
	private int surface = 24;
	private int users = INI_INT;
	private int pcs = surface/2;
	private  String id = "-";
	public static int counter = INI_INT;
	final static String FORMAT = "%s%04d";
	public static int relocatedStudents = INI_INT;

	It(int users, int pcs){
		It.counter++;
		setId();
		setPcs(pcs);
		setUsers(users);
		
	}
	
	public static boolean checkCapacity(int users ,int pcs) {
		return (users > pcs);
	}
	
	public static boolean unvalidCapacity(int users ,int pcs) {
		boolean output = false;
		if(checkCapacity(users, pcs)) {
			output = true;
		}
		return output;
		
	}
	
	public void getInfo() {
		System.out.println("The It class " + id + " has " + users + " students, " + pcs + " computers" + " and its surface is " + surface + "m\u00B2" );
	}
	public  String getId() {
		return id;
	}
	private void setId() {
		id = String.format(FORMAT, "I", It.getCounter());
	}
	
	public int getPcs() {
		return pcs;
	}

	public void setPcs(int pcs) {
		
		if(pcs == 0) {
			pcs = 12;
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
		if(unvalidCapacity(users,pcs)) {
			System.out.println("***Careful, you have surpassed the maximum capacity of the Technology class " + id + " ***");
			System.out.println("Hold On We are eliminating users from the It class");
			System.out.println("Current users = " + users);
			while(unvalidCapacity(users, pcs)) {			
				users--;
				relocatedStudents++;
			}
			System.out.println("-------------\nElimination done \nFinal users = " + users);
		}
		this.users = users;
		
	}
	}
