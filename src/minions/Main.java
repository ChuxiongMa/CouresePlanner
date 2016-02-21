/***
 * To implement the main game logic by utilizing the Fortress, Tank, and Board classes.
 */

package minions;

import java.util.Arrays;
public class Main{
	static int rowInt ;
	static int columnInt ;
	static Fortress player;

	 static Tank tank1;
	 static Tank tank2;
	 static Tank tank3;
	 static Tank tank4;
	 static Tank tank5;
	 static Board board;

		static String[] firstTankLocation;
		static String[] secondTankLocation;
		static String[] thirdTankLocation;
		static String[] fourthTankLocation;
		static String[] fifthTankLocation;


	public static void main(String[] args) {

		player = new Fortress();
		tank1 = new Tank();
		tank2 = new Tank();
		tank3 = new Tank();
		tank4 = new Tank();
		tank5 = new Tank();
		board = new Board();


		String[] tanksLocationArray = Tank.tanksLocation
				.toArray(new String[Tank.tanksLocation.size()]);

		firstTankLocation = Arrays.copyOfRange(tanksLocationArray, 0, 4);
		secondTankLocation = Arrays.copyOfRange(tanksLocationArray, 4, 8);
		thirdTankLocation = Arrays.copyOfRange(tanksLocationArray, 8, 12);
		fourthTankLocation = Arrays.copyOfRange(tanksLocationArray, 12, 16);
		fifthTankLocation = Arrays.copyOfRange(tanksLocationArray, 16, 20);
		

		for (int i = 0; i < Tank.tanksLocation.size(); i++) {
			if (Tank.tanksLocation.get(i).length() == 2) {
				int rowTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(0, 1));
				int columnTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(1, 2));
				board.updateCellLogic(rowTank, columnTank);
			} else if (Tank.tanksLocation.get(i).length() == 3) {
				if (Tank.tanksLocation.get(i).startsWith("10")) {
					int rowTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(0, 2));
					int columnTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(2, 3));
					board.updateCellLogic(rowTank, columnTank);
				} else {
					int rowTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(0, 1));
					int columnTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(1, 3));
					board.updateCellLogic(rowTank, columnTank);
				}
			} else {
				int rowTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(0, 2));
				int columnTank = Integer.parseInt(Tank.tanksLocation.get(i).substring(2, 4));
				board.updateCellLogic(rowTank, columnTank);
			}
		}


			}

		}
	
	
	

