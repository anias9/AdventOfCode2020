/*PART I : Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456

In this list, the two entries that sum to 2020 are 1721 and 299. 
Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

PART II: 
The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?
*/

package adventOfCode;

import java.io.IOException;
import java.util.List;

public class Day1{
	
	public static void part1() throws IOException {
		List<Integer> list = FileHelper.fileReadingToInt("src/data/day1.txt");
		Integer year = 2020;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if (list.get(i) + list.get(j) == year) {
					System.out.println("Part 1 answer: " + list.get(i) * list.get(j));
					return; 
				}
			}		
		}

	}
	
	public static void part2() throws IOException {
		List<Integer> list = FileHelper.fileReadingToInt("src/data/day1.txt");
		Integer year = 2020;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = i + 1; j < list.size(); j++) {
				for (int k = j+1 ; k < list.size(); k++) {
					if (list.get(i) + list.get(j) + list.get(k) == year) {
						System.out.println("Part 2 answer: " + list.get(i) * list.get(j) * list.get(k));
						return; 
					}
				}
			}		
		}
	}
	
	public static void main (String[] args) throws IOException {

		part1();
		part2();
	}
}