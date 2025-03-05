
public class ImplementingRunnable implements Runnable{

	private String myString="";
	
	public ImplementingRunnable( String initString ) {
		myString = initString;
	}
	
	public void run() {
		System.out.println( "ImplementingRunnable (" + myString + ") Start" );
		// The next section of dead code shows how a thread may be set sleeping
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "ImplementingRunnable (" + myString + ") End" );
	}

}
