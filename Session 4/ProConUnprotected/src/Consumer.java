
public class Consumer extends Thread {
	private Buffer sharedLocation;

	public Consumer( Buffer shared ) {
		super("Consumer");
		sharedLocation = shared;
	}
	
	public void run() {
		int sum = 0;
		for (int count = 1; count <= 4; count++) {
			try {
				Thread.sleep((int)(Math.random() * 3001));
				sum += sharedLocation.get();
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		System.err.println( getName() + " read values totalling: " + sum + "  ...DONE");
	}

}
