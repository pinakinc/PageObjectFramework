package hrdemoapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Utilities {
	// Method to get timeStamp
	public static String getTimeStamp() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMMddHHmmss");
		String timestamp = new SimpleDateFormat("yyyyMMMddHHmmss")
				.format(new Timestamp(System.currentTimeMillis()));
		return timestamp;
	}

	// Method to write to a file
	public static void write(String s, File f) {
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(s);
			fw.write(System.lineSeparator());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String[] readFile(File fileName) {
		String[] userName = null;
		try {
			int count = 0;

			Scanner s1 = new Scanner(fileName);
			while (s1.hasNext()) {
				count = count + 1;
				s1.next();
			}
			userName = new String[count];
			Scanner s2 = new Scanner(fileName);
			for (int i = 0; i < count; i++) {
				userName[i] = s2.next();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userName;

	}
}
