import java.util.LinkedList;

public class SudokuRealization {

	static LinkedList<SudokuCell> game = new LinkedList<SudokuCell>();

	public static void main(String[] args) {
		sudokuInitializer();
		// sudokuIndexRevealer();
		sudokuPreloaderExample1();
		sudokuPrinter();
		cellPossibilityOfNumberRegulator();
		sudokuSolver();
		sudokuPrinter();
		System.out.println(sudokuValidatorAfterSolved());
		// int test = SudokuIndexFinders.topLeftOfBlockFinder(23);
		// System.out.println(test);
	}

	// Creates a Sudoku board with indexes from 0 to 80
	// All are set to 0 (it means empty)
	public static void sudokuInitializer() {
		for (int i = 0; i < 81; i++) {
			SudokuCell cell = new SudokuCell(0);
			game.add(cell);
		}
	}

	// Shows all of the board indexes (useful for the preloader)
	public static void sudokuIndexRevealer() {
		for (int i = 0; i < 81; i++) {
			if (i < 10) {
				System.out.print("  " + i);
			} else {
				System.out.print(" " + i);
			}

			if (i == 8 || i == 17 || i == 26 || i == 35 || i == 44 || i == 53 || i == 62 || i == 71) {
				System.out.println();
			}
		}
	}

	// Prints the current sudoku list
	public static void sudokuPrinter() {
		System.out.println();
		System.out.println(" ―――――――――――――――――――――――――――");
		System.out.print(" | ");
		for (int i = 0; i < 81; i++) {
			if (game.get(i).getNumber() == 0) {
				System.out.print("  ");
			} else {
				System.out.print(" " + game.get(i).getNumber());
			}

			if (i == 8 || i == 17 || i == 26 || i == 35 || i == 44 || i == 53 || i == 62 || i == 71) {
				System.out.println();
				if (i == 26 || i == 53) {
					System.out.println(" ―――――――――――――――――――――――――――");
				}
			}
			if (i % 3 == 2 && i != 80) {
				System.out.print(" | ");
			}
		}
		System.out.println();
		System.out.println(" ―――――――――――――――――――――――――――");
	}

	// Loads a custom sudoku (difficulty:easy)
	public static void sudokuPreloaderExample1() {

		game.get(1).setNumber(6);
		game.get(4).setNumber(4);
		game.get(5).setNumber(1);
		game.get(7).setNumber(3);
		game.get(8).setNumber(7);
		game.get(9).setNumber(7);
		game.get(12).setNumber(3);
		game.get(14).setNumber(9);
		game.get(15).setNumber(1);
		game.get(17).setNumber(6);
		game.get(18).setNumber(3);
		game.get(21).setNumber(8);
		game.get(25).setNumber(2);
		game.get(29).setNumber(6);
		game.get(32).setNumber(4);
		game.get(34).setNumber(1);
		game.get(36).setNumber(4);
		game.get(37).setNumber(3);
		game.get(43).setNumber(6);
		game.get(44).setNumber(5);
		game.get(46).setNumber(2);
		game.get(48).setNumber(6);
		game.get(51).setNumber(7);
		game.get(55).setNumber(7);
		game.get(59).setNumber(2);
		game.get(62).setNumber(3);
		game.get(63).setNumber(5);
		game.get(65).setNumber(3);
		game.get(66).setNumber(1);
		game.get(68).setNumber(7);
		game.get(71).setNumber(4);
		game.get(72).setNumber(6);
		game.get(73).setNumber(4);
		game.get(75).setNumber(9);
		game.get(76).setNumber(8);
		game.get(79).setNumber(7);
	}

	// Sets all possibility values for all numbers by the rules of sudoku
	public static void cellPossibilityOfNumberRegulator() {
		for (int i = 1; i < 10; i++) {// FOR EACH NUMBER (1 - 9)
			for (int j = 0; j < 81; j++) {// FOR EACH INDEX (0 - 80)
				if (game.get(j).getNumber() == i) {

					// LINE --------------
					int leftOfLine = SudokuIndexFinders.leftOfLineFinder(j);

					for (int nuller = leftOfLine; nuller <= leftOfLine + 8; nuller++) {

						game.get(nuller).setPossibilityOf1to9(i, false);
					}

					// COLUMN ---------------
					int topOfCol = SudokuIndexFinders.topOfColumnFinder(j);

					// sets the whole column to false for the matched number
					while (topOfCol <= 80) {
						game.get(topOfCol).setPossibilityOf1to9(i, false);
						topOfCol += 9;
					}

					// BLOCK 3X3 ----------------
					int topLeftOfBlock = SudokuIndexFinders.topLeftOfBlockFinder(j);
					game.get(topLeftOfBlock).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 1).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 2).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 9).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 10).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 11).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 18).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 19).setPossibilityOf1to9(i, false);
					game.get(topLeftOfBlock + 20).setPossibilityOf1to9(i, false);

				}
			}
		}
	}

	// Solves the sudoku puzzle
	public static void sudokuSolver() {
		int isThereOnlyOneNumberPossibleForACell = 0;
		int possibleNumberMemory = 0;
		int numberOfIterations = 0;
		while (sudokuNumberOfZeros() > 1 && numberOfIterations < 10000) {
			numberOfIterations++;
			for (int i = 0; i < 81; i++) {// for each index
				for (int j = 1; j < 10; j++) {// for each number possibility in a cell
					if (game.get(i).getPossibilityOf1to9(j) == true) {
						isThereOnlyOneNumberPossibleForACell++;
						if (isThereOnlyOneNumberPossibleForACell > 1) {
							break;
						}
						possibleNumberMemory = j;
					}
				}
				if (isThereOnlyOneNumberPossibleForACell == 1) {
					game.get(i).setNumber(possibleNumberMemory);
					cellPossibilityOfNumberRegulator();
				}
				isThereOnlyOneNumberPossibleForACell = 0;
			}
		}

	}

	// Finds the number of empty cells
	public static int sudokuNumberOfZeros() {
		int number = 0;
		for (int i = 0; i < 81; i++) {
			if (game.get(i).getNumber() == 0) {
				number++;
			}
		}
		return number;
	}

	// Validates the sudoku game after being solved
	public static String sudokuValidatorAfterSolved() {
		for (int i = 0; i < 81; i++) {
			if (game.get(i).getNumber() == 0) {
				return "The sudoku puzzle is NOT completed yet or it doesn't have a solution!";
			}
		}
		int sum = 0;
		for (int i = 0; i < 81; i++) {
			if (i % 9 == 0 && i != 0) {
				if (sum != 45) {
					return "There is a mistake in the solving proccess!";
				}
				sum = 0;
			}
			sum += game.get(i).getNumber();
		}
		return "The sudoku puzzle is solved correctly!";
	}
}
