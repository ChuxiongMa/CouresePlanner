/***
 * To create a tank object with health and corresponding damage output
 */

package minions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tank {

	private static int row;
	private static int column;
	private static int oldRow;
	private static int oldColumn;
	private static int nextCell;
	private static String rowCol;
	private static String rowString;
	private static String columnString;
	private static String location;
	private static int cells;
	Random random = new Random();

	public static List<String> tanksLocation = new ArrayList<String>();
	private boolean[] cellHasBeenHit = new boolean[4];

	private int undamagedCells;
	private int damageOutput;

	public Tank() {
		generateLocation();
		undamagedCells = 4;

		for (int i = 0; i < cellHasBeenHit.length; i++) {
			cellHasBeenHit[i] = false;
		}
	}

	void setWhichCellHasBeenHit(int index) {
		cellHasBeenHit[index] = true;
	}

	boolean getCellHasBeenHit(int index) {
		return cellHasBeenHit[index];
	}

	void decreaseUndamagedCells() {
		undamagedCells = undamagedCells - 1;
		assert (undamagedCells > -1);
	}

	int getUndamagedCells() {
		return undamagedCells;
	}

	boolean isDead() {
		if (undamagedCells == 0) {
			return true;
		}
		return false;
	}

	int calculateDamageOutput(int life) {
		switch (life) {
		case 4:
			damageOutput = 20;
			break;
		case 3:
			damageOutput = 5;
			break;
		case 2:
			damageOutput = 2;
			break;
		case 1:
			damageOutput = 1;
			break;
		case 0:
			damageOutput = 0;
			break;
		default:
			assert false;
		}
		return damageOutput;
	}

	public void generateLocation() {
		row = random.nextInt(10) + 1;
		column = random.nextInt(10) + 1;
		rowString = "" + row;
		columnString = "" + column;
		location = rowString + columnString;

		if (tanksLocation.size() == 0) {
			tanksLocation.add(location);
			cells = 3;
		} else {
			cells = 4;
		}

		for (int i = 0; i < cells; i++) {
			nextCell = random.nextInt(3) + -1;

			while (nextCell == 0) { // -1 or 1
				nextCell = random.nextInt(3) + -1;
			}

			oldRow = row;
			oldColumn = column;
			String rowCol = random.nextBoolean() ? "row" : "col";

			if (rowCol.equals("row")) {
				row = row + nextCell;
			} else if (rowCol.equals("col")) {
				column = column + nextCell;
			}

			checkRange();
			rowString = "" + row;
			columnString = "" + column;
			location = rowString + columnString;
			sameCell();
		}
	}

	public void checkRange() {
		while ((row < 1 || row > 10) || (column < 1 || column > 10)) {
			newCell();
		}
	}

	public void newCell() {
		column = oldColumn;
		row = oldRow;
		nextCell = random.nextInt(3) + -1;

		while (nextCell == 0) { // -1 or 1
			nextCell = random.nextInt(3) + -1;
		}

		rowCol = random.nextBoolean() ? "row" : "col";
		if (rowCol.equals("row")) {
			row = row + nextCell;
		} else if (rowCol.equals("col")) {
			column = column + nextCell;
		}
	}

	public void sameCell() {
		boolean check = true;
		while (check) {
			int j = 0;
			while (j < tanksLocation.size()) {
				if (location.equals(tanksLocation.get(j))) {
					newCell();
					checkRange();
					rowString = "" + row;
					columnString = "" + column;
					location = rowString + columnString;
					j = 0;
					continue;
				}
				j++;
			}
			if (j == tanksLocation.size()) {
				break;
			}
		}
		tanksLocation.add(location);
	}
}