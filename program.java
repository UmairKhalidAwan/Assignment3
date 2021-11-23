import java.io.IOException;

public class program {

	public static void main(String args[]) throws IOException {
		System.out.println("Program run successful! ");
		int totalFiles = args.length;
		for (int i = 0; i < totalFiles; i++) {
			System.out.println("File-" + String.valueOf(i + 1) + ": " + args[i]);
		}
		System.out.println("Total Files: " + String.valueOf(totalFiles));

		for (int i = 0; i < totalFiles; i++) {
			threadr r = new threadr(args[i]);
			Thread t = (new Thread(r));
			t.start();
			t.setName(args[i].replace(".txt", ""));
			System.out.println("Thread: " + t.getName());
		}

	}
}
