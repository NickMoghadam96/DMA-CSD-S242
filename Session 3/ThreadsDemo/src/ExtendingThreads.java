
public class ExtendingThreads extends Thread {

	private String myString="";
	
	public ExtendingThreads( String initString ) {
		myString = initString;
	}
	
	public void run() {
		System.out.println( "ExtendingThreads (" + myString + ") Start");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "ExtendingThreads (" + myString + ") End");
	}

}
