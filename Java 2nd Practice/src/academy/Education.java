package academy;

public class Education {
	
	static final int INI_INT = 0;
	private int surface = 36;
	private int users = INI_INT;
	public static int counter = INI_INT;

	Education(int users){
		setUsers(users);
		Education.counter++;
	}
	
	public static int getCounter() {
		return Education.counter; 
	}
	
	public static boolean checkCapacity(int surface ,int users) {
		return ((surface/users) <=1);
	}
	
	public static void unvalidCapacity(int surface ,int users) {
		if(checkCapacity(surface, users)) {
			System.out.println("***Careful, you have surpassed the maximum capacity of the Education class " + Education.counter + "***");
		}
		
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
