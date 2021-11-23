import java.io.IOException;

public class threadr implements Runnable {
	String file;
	public threadr(String filename) {
		file = filename;
	}
	
	public void run(){
		System.out.println("A thread is running ...");
		Filehandling fHandler = new Filehandling();
		try 
		{
			fHandler.readFile(file, ' ');
		} 
		catch (IOException e) 
		{
			System.out.println("Error in reading file using threading! ");
			e.printStackTrace();
		}
	}
}
