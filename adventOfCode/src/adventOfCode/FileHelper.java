package adventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {

	public static List<String> fileReading(String fileName) throws IOException {
		Scanner s = new Scanner(new File(fileName));
		
		List<String> list = new ArrayList<>();
				
		while(s.hasNextLine()) {
			
			list.add(s.nextLine());
		}
		s.close();
		
		return list;
	}
	
	public static List<Integer> fileReadingToInt(String fileName) throws IOException {
		Scanner s = new Scanner(new File(fileName));
		
		List<Integer> list = new ArrayList<>();
		
		while(s.hasNext()) {
			list.add(Integer.parseInt(s.next()));
		}
		s.close();
		
		return list;
	}
}
