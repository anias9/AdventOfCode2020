package adventOfCode;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Day10 {
	
	public static void adapter() throws IOException {
		List<Integer> input = FileHelper.fileReadingToInt("src/data/day10.txt");

		int jolt1 = 0;
		int jolt3 = 0;
	
		Collections.sort(input);
		input.add(0, 0);
		input.add(input.get(input.size() - 1) + 3);

		for (int i = 0; i< input.size(); i++) {
			if (i == input.size()-1)
				break;
			if (input.get(i+1) - input.get(i) == 1)
				jolt1++;
			else if (input.get(i+1) - input.get(i) == 3)
				jolt3++;
				
		}
		System.out.println("Answer: " + jolt1*jolt3);
	}

	public static void main(String[] args) throws IOException {
		adapter();
	}
}
