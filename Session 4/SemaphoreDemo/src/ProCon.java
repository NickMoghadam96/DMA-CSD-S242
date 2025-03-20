// Karsten Jeppesen, UCN
// 
// java application to demonstrate 
// use of semaphores (Locks)
//
// Semaphore methods:
// acquire()
//   will wait for semaphore to be in released state. Will set semaphore to acquired state
// release()
//   will release an acquired semaphore


import java.util.concurrent.*; 

//A shared resource/class. 
class Shared 
{ 
	static int count = 0; 
} 

class MyThread extends Thread 
{
	// We need 2 semaphores.
	// This one will prevent the Producer writing twice
	Semaphore semPro;
	// This one will prevent the consumer reading twice
	Semaphore semCon;
	String threadName;
	
	public MyThread(Semaphore mySemPro, Semaphore mySemCon, String threadName) 
	{
		// The Thread class constructor that takes a String argument creates 
		// a Thread with a specific name 
		// (as opposed to automatically generated names such as Thread-1).
		super(threadName);
		// We set the semaphores from the main method
		this.semPro = mySemPro; 
		this.semCon = mySemCon;
		this.threadName = threadName;
	}
	
	@Override
	public void run()
	{ 
		
		// run by thread "Producer" 
		if(this.getName().equals("Producer")) 
		{
			System.out.println("Starting " + threadName);
			for ( int i=0; i<5; i++)
			{
				try
				{
					Shared.count++; 
					System.out.println(threadName + " Writes: " + Shared.count); 
					// Now, allowing a context switch -- if possible. 
					// for thread Consumer to execute 
					Thread.sleep(10); 

				}
				catch (InterruptedException exc)
				{
					// Should anything fail - then  we end up here
					System.out.println(exc); 
				} 
			}
			// And we are done 
			System.out.println("Ending " + threadName); 
		} 
		
		// run by thread Consumer 
		else
		{ 
			System.out.println("Starting " + threadName); 
			for (int i=0; i< 5; i++)
			{
					System.out.println(threadName + " Reads: " + Shared.count);
			}
			// And we are done 
			System.out.println("Ending " + threadName);
		} 
	} 
} 

