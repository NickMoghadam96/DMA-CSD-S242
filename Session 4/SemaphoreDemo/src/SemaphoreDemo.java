// Karsten Jeppesen, UCN
// 
// java application to demonstrate 
// use of semaphores (Locks)
//
// The Semaphore constructor takes one argument: The number of permits!
// Every acquire granted will decrease the number of available permits by 1.
// Every release of an acquired semaphore will increase the number of permits.

import java.util.concurrent.*; 


// Driver class 
public class SemaphoreDemo 
{ 
	public static void main(String args[]) throws InterruptedException 
	{ 
		// creating a Semaphore object 
		// Granting 1 permit: You may write one object to the buffer
		Semaphore semPro = new Semaphore(1);
		// Granting 0 permits: Thou shallt not read what hasn't yet been written! (as nobody has yet written to the buffer)
		Semaphore semCon = new Semaphore(0);
		
		// creating two threads named "Producer" and "Consumer" 
		MyThread mt1 = new MyThread(semPro, semCon, "Producer"); 
		MyThread mt2 = new MyThread(semPro, semCon, "Consumer"); 
		
		// stating threads A and B 
		mt1.start(); 
		mt2.start(); 
		
		// waiting for threads A and B 
		mt1.join(); 
		mt2.join(); 
		
		// count will always remain 0 after 
		// both threads will complete their execution 
		System.out.println("count: " + Shared.count); 
	} 
} 
