
// All non primary objects (int, char etc) have wait, notify, notifyAll
// Methods "synchronized" to provide intrinsic locks
// If a thread calling wait() method does not own the inherent lock,
//   an error will be thrown.
public class Buffer {
	private int BufferSize = 4;
	private int[] Container = new int[BufferSize];
	private int PosR=0, PosW=0;
	
	public synchronized int Read() {
		while (true) {
			if ( PosR == PosW ) { //puffer tom, hvis den er det så venter vi
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else { // hvis den ike er tom så prøver vi at læse læseposistionen
				int v=Container[ PosR ];
				PosR = (PosR+1) % BufferSize; // vi flytter den en frem modulu buffer size
				System.out.println("Read pos " + PosR);
				notifyAll(); //alle der står at venter må godt undersøge om det kan bruges til noget eller ej
				return v;
			}
		}
	}
	
	public synchronized void Write( int Val ) { //lig mærke til syncrhonized, noget med monitor. 
		while (true) {
			if (((PosW + 1) % BufferSize) == PosR) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Container[PosW] = Val;
				PosW = (PosW+1) % BufferSize;
				System.out.println("Write pos " + PosW);
				notifyAll();
				return;
			}
		}
	}
}
