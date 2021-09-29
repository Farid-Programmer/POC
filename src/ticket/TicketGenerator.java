package ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicketGenerator {
	int TicketTable[][];
	static int row;
	static int column;
	static int randomNumberGenerator;
	static int randomNumberGeneratorForRowIndex;
	static int randomNumberGeneratorForColIndex;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter row size");
		row = sc.nextInt();
		System.out.println("Enter column size");
		column = sc.nextInt();
		TicketGenerator tg = new TicketGenerator();
		tg.TicketGeneratorform(row, column);
		
		
		
		  for(int i=0;i<row;i++)
		  { 
			  List<Integer> rowlist=new ArrayList();
			  
			int j=0;
		   while (j<=10) 
		  {
		  
		  int randomNumberGeneratorForColIndex2 = tg.randomNumberGeneratorForColIndex(column);
		 
		  if(!rowlist.contains(randomNumberGeneratorForColIndex2)) {
		  tg.TicketTable[i][randomNumberGeneratorForColIndex2-1] =tg.randomNumberRangeGenerator(randomNumberGeneratorForColIndex2);
		  rowlist.add(randomNumberGeneratorForColIndex2);
		  
		  }
		  j++;
		 
		  if(rowlist.size()==5)
		  {
			  //System.out.println(rowlist);
			  break;
		  }
		
		  } 
		  
			  
		  }
		
		tg.printArray();

	}

	
	public int randomNumberRangeGenerator(int number) {
		// number=0;

		switch (number) {
		// Case statements
		case 1:
			int rang1 = randomNumberGenerator(1, 10);
			return rang1;
		case 2:
			int rang2 = randomNumberGenerator(11, 20);
			return rang2;
		case 3:
			int rang3 = randomNumberGenerator(21, 30);
			return rang3;
		case 4:
			int rang4 = randomNumberGenerator(31, 40);
			return rang4;
		case 5:
			int rang5 = randomNumberGenerator(41, 50);
			return rang5;
		case 6:
			int rang6 = randomNumberGenerator(51, 60);
			return rang6;
		case 7:

			int rang7 = randomNumberGenerator(61, 70);
			return rang7;
		case 8:
			int rang8 = randomNumberGenerator(71, 80);
			return rang8;
		case 9:
			int rang9 = randomNumberGenerator(81, 90);
			return rang9;
		// Default case statement
		default:
			System.out.println("Not valid Case");
		}

		return number;
	}

	public void TicketGeneratorform(int row, int column) {
		TicketTable = new int[row][column];
		// System.out.println(TicketTable.length);

	}

	
	// generate random number w.r.t given range

	public static int randomNumberGenerator(int startRange, int endRange) {
		Random r = new Random();
		int low = startRange;
		int high = endRange;
		int result = r.nextInt(high - low) + low;
		// System.out.println(result);
		return result;

	}

	// generate random index Number for placing random number on it.
	public int randomNumberGeneratorForRowIndex() {
		Random r = new Random();
		int low = 1;
		int high = 4;
		int result = r.nextInt(high - low) + low;
		// System.out.println(result);
		return result;

	}

	// generate random index Number for placing random number on it.
	public int randomNumberGeneratorForColIndex(int endRange) {
		Random r = new Random();
		int low = 1;
		int high = endRange;
		int result = r.nextInt(high - low) + low;
		// System.out.println(result);
		return result;

	}

	// print Array
	public void printArray() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(TicketTable[i][j] + " ");
			}
			System.out.println();
		}
	}

}
