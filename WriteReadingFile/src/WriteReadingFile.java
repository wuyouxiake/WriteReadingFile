import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.HashMap;

public class WriteReadingFile {
	public static void main(String[] args) throws FileNotFoundException {
		String filename = (System.getProperty("user.dir") + File.separatorChar + "myNumbers.txt");
		System.out.println(filename);
		PrintWriter writer = null;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		Scanner in = new Scanner(System.in);
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		System.out.println("map = " + map);
		int tempKey = 0;
		String tempValue;
		

		String choice = "y";
		try {
			writer = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File does not exist!");
		}finally{
			while (choice.equalsIgnoreCase("y")) {
				System.out.println("Please enter a number: ");
				tempKey = in.nextInt();
				if (map.containsKey(tempKey)) {
					System.out.println("You entered " + map.get(tempKey));
				} else {
					System.out.println("The number you entered does not exist. ");
					System.out.println("The value? ");
					tempValue = in.next();
					map.put(tempKey, tempValue);
					writer.println(tempKey + "\t" + map.get(tempKey));
				}
				System.out.println("Want to continue?(y/n)");
				choice = in.next();
			}
		}
		writer.close();
		
		// read from a file
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(filename));
		System.out.println("Read from the file " + filename);

		try {
			System.out.println("Read the file:");
			String line = reader.readLine();
			while (line != null) {
				System.out.println(line);

				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("File does not exist!");
		} finally {

		}
	}
}
