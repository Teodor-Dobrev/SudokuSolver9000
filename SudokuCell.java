
public class SudokuCell {
	private int number = 0;
	private boolean[] possibilityOf1to9 = new boolean[10];
	// index of possibilityOf1to9 = real number possibility to be in this cell
	// possibilityOf1to9[1] means possibility of number 1 to be in this cell

	SudokuCell() {
		this.number = 0;
		for (int i = 1; i < 10; i++) {
			possibilityOf1to9[i] = true;
		}
	}

	SudokuCell(int number) {
		this.number = number;
		if (this.number > 0 && this.number < 10) {
			for (int i = 1; i < 10; i++) {
				this.possibilityOf1to9[i] = false;
			}
		} else if (this.number == 0) {
			for (int i = 1; i < 10; i++) {
				this.possibilityOf1to9[i] = true;
			}
		} else {
			System.out.println("Wrong input data!");
		}
	}

	public int getNumber() {
		return number;
	}

	public boolean getPossibilityOf1to9(int i) {
		if (i > 0 && i < 10) {
			return this.possibilityOf1to9[i];
		} else {
			return false;
		}
	}

	public void setNumber(int number) {
		if (number > 0 && number < 10) {
			this.number = number;
		} else {
			System.out.println("Wrong input data!");
		}
	}

	public void setPossibilityOf1to9(int num, boolean possibility) {
		if (num > 0 && num < 10) {
			this.possibilityOf1to9[num] = possibility;
		} else {
			System.out.println("Wrong input data!");
		}
	}
}
