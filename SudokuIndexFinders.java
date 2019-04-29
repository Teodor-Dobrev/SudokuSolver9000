
public class SudokuIndexFinders {
	// This whole class is dedicated to finding the right 
	// indexes in the sudoku "game" LinkedList
	// for each line, column, and 3x3 block
	/*
			  0  1  2  3  4  5  6  7  8
			  9 10 11 12 13 14 15 16 17
			 18 19 20 21 22 23 24 25 26
			 27 28 29 30 31 32 33 34 35
			 36 37 38 39 40 41 42 43 44
			 45 46 47 48 49 50 51 52 53
			 54 55 56 57 58 59 60 61 62
			 63 64 65 66 67 68 69 70 71
			 72 73 74 75 76 77 78 79 80
	 */
	
	public static int leftOfLineFinder(int j) {
		int leftOfLine = 0;
		
		if (j >= 0 && j <= 8) {
			leftOfLine = 0;
		} else if (j >= 9 && j <= 17) {
			leftOfLine = 9;
		} else if (j >= 18 && j <= 26) {
			leftOfLine = 18;
		} else if (j >= 27 && j <= 35) {
			leftOfLine = 27;
		} else if (j >= 36 && j <= 44) {
			leftOfLine = 36;
		} else if (j >= 45 && j <= 53) {
			leftOfLine = 45;
		} else if (j >= 54 && j <= 62) {
			leftOfLine = 54;
		} else if (j >= 63 && j <= 71) {
			leftOfLine = 63;
		} else if (j >= 72 && j <= 80) {
			leftOfLine = 72;
		}
		
		return leftOfLine;
	}
	
	public static int topOfColumnFinder(int topOfCol) {
		if (topOfCol > 8) {
			while (topOfCol - 9 >= 0) {
				topOfCol -= 9;
			}
		}
		return topOfCol;
	}
	
	public static int topLeftOfBlockFinder(int j) {
		int topLeftOfBlock = j;
		
		if (j % 3 == 2) { // getting the right column
			topLeftOfBlock -= 2;
		} else if (j % 3 == 1) {
			topLeftOfBlock -= 1;
		}
		
		if (j >= 9 && j <= 17) { //getting the right line
			topLeftOfBlock -= 9;
		} else if (j >= 18 && j <= 26) {
			topLeftOfBlock -= 18;
		} else if (j >= 36 && j <= 44) {
			topLeftOfBlock -= 9;
		} else if (j >= 45 && j <= 53) {
			topLeftOfBlock -= 18;
		} else if (j >= 63 && j <= 71) {
			topLeftOfBlock -= 9;
		} else if (j >= 72 && j <= 80) {
			topLeftOfBlock -= 18;
		}
		
		return topLeftOfBlock;
	}
}
