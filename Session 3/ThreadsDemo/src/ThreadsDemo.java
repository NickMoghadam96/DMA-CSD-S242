// Karsten Jeppesen, UCN
// There are 3 ways to start threads.
// This demo will show two of the options
// - by extending the Thread class and overriding its run() method
// - by implementing the Runnable interface
//

public class ThreadsDemo {

	public static void main(String[] args) {
		System.out.println("Main");
		
		// Extending the Thread class will oc result in a thread
		ExtendingThreads myThreadA = new ExtendingThreads("A");
		ExtendingThreads myThreadB = new ExtendingThreads("B");
		ExtendingThreads myThreadC = new ExtendingThreads("C");
		
		// implementing the runnable interface will require an additional call to threads
		Runnable myRunnableD = new ImplementingRunnable("D");
		Runnable myRunnableE = new ImplementingRunnable("E");
		Runnable myRunnableF = new ImplementingRunnable("F");
		Runnable myRunnableL = new ThreadStartingThread("L");
		
		// Here we inject the runnable into the thread class
		Thread myThreadD = new Thread( myRunnableD );
		Thread myThreadE = new Thread( myRunnableE );
		Thread myThreadF = new Thread( myRunnableF );
		Thread myThreadL = new Thread( myRunnableL );
		
		// Starting all threads. Note that sequence can not be guaranteed.
		myThreadA.start();
		myThreadB.start();
		myThreadC.start();
		myThreadD.start();
		myThreadE.start();
		myThreadF.start();
		myThreadL.start();
				
		System.out.println("Main... Done");
	}

}
