# SudokuSolver9000

The purpose of this program is to solve a Sudoku puzzle.

---The class SudokuCell represents a single cell in the Sudoku board.

The cell has a "number" variable from 1 to 9, if the number is 0, that means the cell is empty.
If it is empty then is has a possibility to be a number from 1 to 9 which is represented in
the array of booleans "possibilityOf1to9".

All the setters are checked for correct input.

--- The class SudokuRealization creates a LinkedList of 81 SudokuCell objects

The class manages their creation (sudokuInitializer()), 
input (sudokuPreloaderExample1()), 
printing (sudokuPrinter()), 
sets the right values for possibilityOf1to9 for each cell and each number (cellPossibilityOfNumberRegulator()),
attempts to solve the Sudoku Puzzle(sudokuSolver()) and
validates the puzzle after the attempted solution (System.out.println(sudokuValidatorAfterSolved())).

--- The class  SudokuIndexFinders is a helper used by SudokuRealization
and more specifically by cellPossibilityOfNumberRegulator() for identifying
the correct line, column and 3x3 block.


--- note to self - make a map for possibilityOf1to9 values for an incorrectly solved number
