import java.io.IOException;

public class ProcessDemo {
	// You will have to find your own application path for this

	public static void main(String[] args) {
		ProcessBuilder builder = new ProcessBuilder("C:\\Program Files\\HeidiSQL\\heidisql.exe");
		try {
			// Start the process
			Process process = builder.start();
			
            // Wait for the process to terminate
            int exitCode = process.waitFor();
			
            // Check if the process terminated successfully
            if (exitCode == 0) {
                System.out.println("Process executed successfully!");
            } else {
                System.out.println("Process failed with error code: " + exitCode);
            }
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done...");
	}

}
