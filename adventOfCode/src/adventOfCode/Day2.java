/*For example, suppose you have the following list:

1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc
Each line gives the password policy and then the password. The password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means that the password must contain a at least 1 time and at most 3 times.

In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b, but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the limits of their respective policies.
*/

package adventOfCode;

import java.io.IOException;
import java.util.List;

public class Day2{
	
	public static void checkPasswords() throws IOException {
		List<String> list = FileHelper.fileReading("src/data/day2.txt");
		Integer correct = 0; 
		Integer correct2 = 0; 
		
		for (String s : list) {
			String[] parts = s.split(" ");
			String[] minMax = parts[0].split("-");
			int min = Integer.parseInt(minMax[0]);
			int max = Integer.parseInt(minMax[1]);
			char letter = parts[1].charAt(0);
			char[] password = parts[2].toCharArray();
			int total = 0;
			
			//for part 1 
			for (char p : password) {
				if (letter == p ) 
					total++; 
			}
			if (total <= max && total >= min ) 
				correct++; 
			
			total = 0; 
			
			//for part 2 
			if (password[min-1]== letter ^ password[max-1] == letter)
				correct2++;
		}
		System.out.println("Part 1\n Correct passwords: " + correct);
		System.out.println("Part 2\n Correct passwords: " + correct2);

	}
	
	public static void main(String[] args) throws IOException {
		checkPasswords();
	}
}