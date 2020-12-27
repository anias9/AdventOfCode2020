/* PART 1
You start on the open square (.) in the top-left corner and need to reach the bottom (below the bottom-most row on your map).

The toboggan can only follow a few specific slopes (you opted for a cheaper model that prefers rational numbers); start by counting all the trees you would encounter for the slope right 3, down 1:

From your starting position at the top-left, check the position that is right 3 and down 1. Then, check the position that is right 3 and down 1 from there, and so on until you go past the bottom of the map.

The locations you'd check in the above example are marked here with O where there was an open square and X where there was a tree:

..##.........##.........##.........##.........##.........##.......  --->
#..O#...#..#...#...#..#...#...#..#...#...#..#...#...#..#...#...#..
.#....X..#..#....#..#..#....#..#..#....#..#..#....#..#..#....#..#.
..#.#...#O#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#..#.#...#.#
.#...##..#..X...##..#..#...##..#..#...##..#..#...##..#..#...##..#.
..#.##.......#.X#.......#.##.......#.##.......#.##.......#.##.....  --->
.#.#.#....#.#.#.#.O..#.#.#.#....#.#.#.#....#.#.#.#....#.#.#.#....#
.#........#.#........X.#........#.#........#.#........#.#........#
#.##...#...#.##...#...#.X#...#...#.##...#...#.##...#...#.##...#...
#...##....##...##....##...#X....##...##....##...##....##...##....#
.#..#...#.#.#..#...#.#.#..#...X.#.#..#...#.#.#..#...#.#.#..#...#.#  --->
In this example, traversing the map using this slope would cause you to encounter 7 trees.*/

/*PART 2
Time to check the rest of the slopes - you need to minimize the probability of a sudden arboreal stop, after all.

Determine the number of trees you would encounter if, for each of the following slopes, 
you start at the top-left corner and traverse the map all the way to the bottom:

Right 1, down 1.
Right 3, down 1. (This is the slope you already checked.)
Right 5, down 1.
Right 7, down 1.
Right 1, down 2.
In the above example, these slopes would find 2, 7, 3, 4, and 2 tree(s) respectively; multiplied together, these produce the answer 336.*/

package adventOfCode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day3{
	
	public static List<String> fileReading() throws IOException {
		Scanner s = new Scanner(new File("src/data/day3.txt"));
		
		List<String> list = new ArrayList<>();
		
		while(s.hasNextLine()) {
			list.add(s.nextLine());
		}
		s.close();
		
		return list;
	}
	
	public static void forestWalk() throws IOException{		
		List<String> list = fileReading();
		int iter = 0; 
		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;
	
		//slope 5
		for (int i = 2 ; i < list.size();  i += 2) {
			iter += 1;
			
			if (iter >= list.get(i).length())
				iter = iter % list.get(i).length();
					
			if (list.get(i).charAt(iter) == '#')
				counter5++;
		}
		
		//starting from second line
		list.remove(0);
		iter = 0 ;
		//slope 1 
		for (String s : list) {
			iter += 1;
			
			if (iter >= s.length())
				iter = iter % s.length();
			
			if (s.charAt(iter) == '#')
				counter++;
			
		}
		iter = 0; 
		
		//slope 2 
		for (String s : list) {
			iter += 3;
			
			if (iter >= s.length())
				iter = iter % s.length();
			
			if (s.charAt(iter) == '#')
				counter2++;
			
		}
		iter = 0 ;
		
		//slope 3
		for (String s : list) {
			iter += 5;
			
			if (iter >= s.length())
				iter = iter % s.length();
			
			if (s.charAt(iter) == '#')
				counter3++;
			
		}
		iter = 0 ;	
		
		//slope 4
		for (String s : list) {
			iter += 7;
			
			if (iter >= s.length())
				iter = iter % s.length();
			
			if (s.charAt(iter) == '#')
				counter4++;
		}
		
		System.out.println("answer slope 1 " + counter);
		System.out.println("answer slope 2 PART 1 " + counter2);
		System.out.println("answer slope 3 " + counter3);
		System.out.println("answer slope 4 " + counter4);
		System.out.println("answer slope 5 " + counter5);
		long total = counter * counter2 * counter3 * counter4 ; 
		
		// right answer: 3 517 401 300
		
		System.out.println("Total: PART 2 " + (total * counter5)); 
	}
	
	public static void main(String[] args) throws IOException {
		forestWalk();
	}
}