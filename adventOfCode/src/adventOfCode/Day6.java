package adventOfCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6{
	
	public static void questions1() throws IOException {
		List<String> list = FileHelper.fileReading("src/data/day6.txt");
		
		int counter = 0; 
		List<Character> letters = new ArrayList<>();
		
		for (String question : list) {
			if (question.isEmpty()) {
				counter += letters.size();
				letters.clear();
			}
			else {
				for (int i = 0; i< question.length(); i++) {
					if(!letters.contains(question.charAt(i)))
						letters.add(question.charAt(i));
				}
			}
		}
		
		counter+=letters.size();
		System.out.print(counter);
	}
	
	public static void main(String[] args) throws IOException  {
		
		questions1();
	}
}