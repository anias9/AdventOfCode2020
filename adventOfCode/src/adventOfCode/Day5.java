package adventOfCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day5{
	
	public static void findSeat() throws IOException{
		List<String> boardingPasses = FileHelper.fileReading("src/data/day5.txt");
	
		int seatID = 0; 
		
		List<Integer> allIDs = new ArrayList<Integer>();
		
		for (String boardingPass : boardingPasses) {
			int[] row = new int[] {0,127};
			int[] column = new int[] {0,7};
			
			for (int i = 0; i < 7 ; i++) {
				if (boardingPass.charAt(i) == 'F') {
					row[1]= ((row[1] - row[0]) / 2) + row[0];
				}
				else {
					row[0]= (((row[1] - row[0]) / 2) + row[0]) + 1;
				}
			}
			
			for (int i = 7 ; i < 10 ; i++) {
				if (boardingPass.charAt(i) == 'L') {
					column[1]= ((column[1] - column[0]) / 2) + column[0];
				}
				else {
					column[0]= (((column[1] - column[0]) / 2) + column[0]) + 1;
				}
			}
			 
			seatID = row[0] * 8 + column[0]; 
			allIDs.add(seatID);
		}
				
		System.out.println(Collections.max(allIDs));
		
		int mySeat = 0; 
		
		for (int i = 0 ; i < allIDs.size(); i++) {
			for (int j = 1 ; j < allIDs.size(); j++) {
				if (allIDs.get(i) > allIDs.get(j) ) {
					if (allIDs.get(i) - allIDs.get(j) == 2) {
						if (!allIDs.contains(allIDs.get(j)+1))
							mySeat = allIDs.get(j) + 1;
					}
				}
				else if ((allIDs.get(i) < allIDs.get(j) )) {
					if (allIDs.get(j) - allIDs.get(i) == 2) {
						if (!allIDs.contains(allIDs.get(i)+1))
							mySeat = allIDs.get(i) + 1;
					}
				}
			}
		}
		System.out.println("\nMy seat ID: " + mySeat);
	}
	
	public static void main(String[] args) throws IOException  {
		
		findSeat();
	}
}