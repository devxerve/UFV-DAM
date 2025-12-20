package academy;

public class It {
	
	static final int INI_INT = 0;
	private int surface = 24;
	private int users = INI_INT;
	private int pcs = surface/2;
	public static int counter = INI_INT;

	It(int users, int pcs){
		setUsers(users);
		setPcs(pcs);
		Education.counter++;
	}
	
	public static boolean checkCapacity(int surface ,int users) {
		return ((surface/users) <=1); 
	}
	
	public static void unvalidCapacity(int surface ,int users) {
		if(checkCapacity(surface, users)) {
			System.out.println("***Careful, you have surpassed the maximum capacity of the Technology class " + It.counter + "***");
		}
		
	}
	
	public int getPcs() {
		return pcs;
	}

	public void setPcs(int pcs) {
		this.pcs = pcs;
	}

	public static int getCounter() {
		return Education.counter;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}


	}
