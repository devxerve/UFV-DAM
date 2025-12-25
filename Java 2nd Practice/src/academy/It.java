package academy;

 /** 
  * Class that manages the creation of IT classes
  * @author [DevXervE &lt;aviercerverarodriguez@gmail.com&gt;]
  * @version 1.0
  */ 

	public class It {
	
		/**
		 * Constant made in order to initialize all integer variables in the code.
		 */
	
			static final int INI_INT = 0;
			
		/**
		 * surface made private so it does not suffer any alterations during program execution, and static because all classes have the same surface.
		 */
			
			private static int surface = 24; 
		
		/**
		 * students made private so it does not suffer any alteration during the program execution each instance <b>(clasroom)</b> can have a different number of students. 
		 */
		
			private int students = INI_INT; 
		
		/**
		 * pcs made private so it does not suffer any alteration during the program execution, each instance <b>(clasroom)</b> can have a different number of pcs
		 */
			
			private int pcs = surface/2;
			
		/**
		 * This String is initialized for the id string that will be modified later made private for no alterations during the program
		 */
			
			private String id = "-"; 
			
		/**
		 * counter made static so it does not belong for an instance of the class, but for the class itself, made for counting how many clasrooms of this class exists 
		 */
			
			public static int counter = INI_INT;
			
		/**
		 * <b>Constant</b> for the <b>id</b> string (Will be used on the String.format method inside the <b>setId</b> method)
		 */
			
			final static String FORMAT = "%s%04d";
			
		/**
		 * This static variable will store all the relocated students for all the instances of the class
		 */
			
			public static int relocatedStudents = INI_INT;
	
		/**
		 * Constructor made for the It class, the counter is altered before the id to use it into the id
		 * @param students each classroom has its own number of students (setted via input)
		 * @param pcs each classroom has its own number of students (setted via input)
		 */
		
			It(int students, int pcs){	
				It.counter++;
				setId();
				setPcs(pcs);
				setUsers(students);
				
			}
			
		/**
		 * Simple method to check capacity (applying formula given by the instructions of the practice)
		 * @param students This parameter is the number of students for each classroom
		 * @param pcs This parameter is the number of pcs for each classroom
		 * @return True if the comparison is correct, false if not
		 */
			public static boolean checkCapacity(int students ,int pcs) { 
				return (students > pcs);
			}
		
		/**
		 * Returns a warning message when capacity is exceeded.
		 * @param students This parameter is the number of students for each classroom, used in the invocation of <b>checkCapacity</b>
		 * @param pcs This parameter is the number of pcs for each classroom, used in the invocation of <b>checkCapacity</b>
		 * @param id This parameter is made in order to format the output of the method
		 * @return Warning message when capacity is surpassed
		 */
		
			public static String invalidCapacity(int students, int pcs, String id) {
					String output = "";
					if (checkCapacity(students, pcs)) {
						output = "***Careful, you have surpassed the maximum capacity of the It class " + id + " ***";
						}
					return output;
					}
	
		/**
		 * Prints the information of an instance of the class
		 */
	
			public void getInfo() { 
				System.out.println("The It class " + id + " has " + students + " students, " + pcs + " computers" + " and its surface is " + surface + "m\u00B2" );
			}
			
			public  String getId() {
				return id;
			}
		
		/**
		 * Sets an unique id to each instance of the object,  using the format given as a constant, the letter I (It) and the instance creation number
		 */
		
			private void setId() {
				id = String.format(FORMAT, "I", It.getCounter());
			}
			
			public int getPcs() {
				return pcs;
			}
		
		/**
		 * Sets the number of PCs for each instance. If the input is 0, the default value (12) is used. 
		 * @param pcs number of pcs opf each instance
		 */
		
			public void setPcs(int pcs) {
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
				return students;
			}
			
		/**
		 * Sets students for this class. If capacity is exceeded, removes students and updates relocatedStudents.
		 * @param students students for each classroom
		 */
		
			public void setUsers(int students) {		
				if(checkCapacity(students,pcs)) {
					System.out.println(invalidCapacity(students,pcs,id));
					System.out.println("Hold On We are eliminating users from the It class " + id);
					System.out.println("Current users = " + students);
					while(checkCapacity(students,pcs)) {			
						students--;
						relocatedStudents++;
					}
					System.out.println("-------------\nElimination done \nFinal users = " + students);
				}
				this.students = students;
				
			}
	}
