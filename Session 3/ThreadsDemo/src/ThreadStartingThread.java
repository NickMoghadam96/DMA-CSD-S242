
public class ThreadStartingThread implements Runnable{

	private String myString="";
	
	public ThreadStartingThread( String initString ) {
		myString = initString;
	}
	
	@Override
	public void run() {
		System.out.println( "ThreadStartingThread (" + myString + ") Start" );
		ExtendingThreads myThreadA = new ExtendingThreads( "ThreadStartingThread " + myString );
		myThreadA.start();
		try {
			myThreadA.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "ThreadStartingThread (" + myString + ") End" );
	}
}
