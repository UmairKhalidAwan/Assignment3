import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Filehandling 
{
	public void writeFile(String filename, String data, boolean existCheck) 
	{
		try 
		{
			File myObj = new File(filename);
			FileWriter writer = new FileWriter(filename);
			writer.write(String.format(data));
			writer.close();
			System.out.println("Writing to file successful!");
		}
		catch (IOException e) 
		{
			System.out.println("Some error occured during writing to file" + filename);
			e.printStackTrace();
		}
	}

	private int countLines(File file, char delimiter) throws IOException 
	{
		int lines = 0;

		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[8 * 1024]; // 8kb buffer is most efficient
		int read;

		while ((read = fis.read(buffer)) != -1) 
		{
			for (int i = 0; i < read; i++)
			{
				if (buffer[i] == delimiter)
					lines++;
			}
		}
	 fis.close();
     return lines;
	}

	public String[] readFileArr(String filename,char delimiter) throws IOException 
	{
		int size;
		try 
		{
			File myObj = new File(filename);
			size = countLines(myObj, delimiter);
			String[] data = new String[size + 1];
			int index = 0;
			Scanner reader = new Scanner(myObj);
			while (reader.hasNextLine()) 
			{
				String str = reader.nextLine();
				data[index] = str;
				index++;
				System.out.println(data[index]);
			}
			reader.close();
			System.out.println("Successfully read from file -> " + filename + " - words(" + String.valueOf(size) + ")");
			return data;
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("Error occured during reading of file " + filename);
			e.printStackTrace();
		}
		System.out.println("Something weird happend during read of file -> " + filename);
		return null;
	}
	
	public String readFile(String filename,char delimiter) throws IOException {
		int size;
		try {
			File myObj = new File(filename);
			size = countLines(myObj, delimiter);
			String data = new String();
			int index = 0;
			Scanner reader = new Scanner(myObj);
			while (reader.hasNextLine()) {
				data = reader.nextLine();
				index++;
			}
			reader.close();
			System.out.println("Successfully read from file -> " + filename + " - words(" + String.valueOf(size) + ")");
			return data;
		} catch (FileNotFoundException e) {
			System.out.println("Error occured during reading of file " + filename);
			e.printStackTrace();
		}
		System.out.println("Something weird happend during read of file -> " + filename);
		return null;
	}
}
