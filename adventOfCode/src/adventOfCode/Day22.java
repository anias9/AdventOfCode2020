package adventOfCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day22 {

	public static void playGame() throws IOException {
        List<String> list = FileHelper.fileReadingWithoutLines("src/data/day22.txt");
        
        Integer len = list.size();
        List<Integer> p1cards = new ArrayList<Integer>();
        List<Integer> p2cards = new ArrayList<Integer>();
        List<String> player1 = list.subList(2, len/2);
        List<String> player2 = list.subList((len/2)+2,len);

        for(String cards: player1) {
        	p1cards.add(Integer.parseInt(cards));
        }
               
        for(String cards: player2) {
        	p2cards.add(Integer.parseInt(cards));
        }

      while ( (p1cards.size() > 0 && p2cards.size() > 0) ) {
        	Integer card1 = p1cards.remove(0);
        	Integer card2 = p2cards.remove(0);
        	
        	if(card1 > card2) {
        		p1cards.add(card1);
        		p1cards.add(card2);
        	}
        	else {
        		p2cards.add(card2);
        		p2cards.add(card1);
        	}
    	}
    	
        List<Integer> winnerCards = new ArrayList<>();
        
        if (p2cards.size() > p1cards.size()) {
        	winnerCards.addAll(p2cards);
        	System.out.print("Winner - Player2\n");
        }
        else {
        	System.out.print("Winner - Player1\n");
        	winnerCards.addAll(p1cards);
        }

        int result = 0;
    	for(int i = 0; i<winnerCards.size(); i++) {
    		result += winnerCards.get(i) *(winnerCards.size()-i);
    	}

    	System.out.println("Score: " + result);
	 }
	
	 public static void main(String[] args) throws IOException{
	        	playGame();
	    }
}