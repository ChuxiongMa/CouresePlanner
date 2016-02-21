/***
 * To create a Board object with all fog
 */

package minions;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/***
 * To create a board object in which 5 tank objects reside
 */


public class Board {
	
	private int rows = 11;
	private int columns = 11;
	JPanel GameBoard = new JPanel();
	ImageIcon miss=new ImageIcon("miss.png");
	ImageIcon hit=new ImageIcon("hit.png");
	ImageIcon fog=new ImageIcon("fog.png");
	ImageIcon tank=new ImageIcon("tank.png");
	ImageIcon field=new ImageIcon("field.jpg");
	
	private ImageIcon[][] boardView = new ImageIcon[rows][columns];
	private boolean[][] boardLogic = new boolean[rows][columns];
	private boolean[][] clickLogic = new boolean[rows][columns];
	JLabel shot1 = new JLabel("You were shot for: "+ Main.tank1.calculateDamageOutput(Main.tank1.getUndamagedCells()));
	JLabel shot2 = new JLabel("You were shot for: "+ Main.tank2.calculateDamageOutput(Main.tank2.getUndamagedCells()));
	JLabel shot3 = new JLabel("You were shot for: "+ Main.tank3.calculateDamageOutput(Main.tank3.getUndamagedCells()));
	JLabel shot4 = new JLabel("You were shot for: "+ Main.tank4.calculateDamageOutput(Main.tank4.getUndamagedCells()));
	JLabel shot5 = new JLabel("You were shot for: "+ Main.tank5.calculateDamageOutput(Main.tank5.getUndamagedCells()));
	
	JLabel health = new JLabel("Fortress Health: "+(Main.player).getHealth());
	JFrame frame = new JFrame("Tank Battlefield");


	Board() {
	
		
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
		frame.add(makeHealth());
		frame.add(makeGameField());
		frame.add(makeShot(shot1));
		frame.add(makeShot(shot2));
		frame.add(makeShot(shot3));
		frame.add(makeShot(shot4));
		frame.add(makeShot(shot5));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	ImageIcon getCell(int row, int column) {
		return boardView[row][column];
	}
	
	void BoardLogic() {
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				boardLogic[i][j] = false;
			}
		}
	}
	
	void clickLogic() {
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				clickLogic[i][j] = false;
			}
		}
	}

	void updateCellLogic(int row, int column) {
		boardLogic[row][column] = true;
	}

	void setCell(int row, int column, ImageIcon icon) {
		boardView[row][column] = icon;
		//mylabel.setIcon(getScaleImageIcon(icon,60,60));
	}

	boolean isTankPresent(int row, int column) {
		return boardLogic[row][column];
	}
	
	int getCol(int col){
		return col;
	}
	
	int getRow(int row){
		return row;
	}

	public JPanel makeGameField(){
		final int row = 10;
		final int column = 10;
		
		GameBoard.setLayout(new GridLayout(row,column));
		//int i;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				final JLabel mylabel = new JLabel();
			    mylabel.setIcon(getScaleImageIcon(fog,60,60));
			    final int a = i+1;
			    final int b= j+1;
			    mylabel.addMouseListener(new MouseAdapter()  
			    {  
			        public void mouseClicked(MouseEvent e)  
			        {  
			        	Main.board.clickLogic[a][b] = true;
			        	if(Main.board.isTankPresent(a, b)){
			        		mylabel.setIcon(getScaleImageIcon(hit,60,60));
			        		String rowColumnAsString = "" + a + b;
			        		if (Arrays.asList(Main.firstTankLocation).indexOf(rowColumnAsString) != -1) {
								if (Main.tank1.getCellHasBeenHit(Arrays.asList(Main.firstTankLocation).indexOf(rowColumnAsString))) {
									// do nothing, tank has been hit there before.
								} else {
									Main.tank1.decreaseUndamagedCells();
									Main.tank1.setWhichCellHasBeenHit(Arrays.asList(Main.firstTankLocation).indexOf(rowColumnAsString));
								}
								shot1.setText("You were shot for: "+Main.tank1.calculateDamageOutput(Main.tank1.getUndamagedCells()));
							}

							if (Arrays.asList(Main.secondTankLocation)
									.indexOf(rowColumnAsString) != -1) {
								if (Main.tank2.getCellHasBeenHit(Arrays.asList(
										Main.secondTankLocation).indexOf(rowColumnAsString))) {
									// do nothing, tank has been hit there before.
								} else {
									Main.tank2.decreaseUndamagedCells();
									Main.tank2.setWhichCellHasBeenHit(Arrays.asList(Main.secondTankLocation).indexOf(rowColumnAsString));
								}
								shot2.setText("You were shot for: "+Main.tank2.calculateDamageOutput(Main.tank2.getUndamagedCells()));
							}

							if (Arrays.asList(Main.thirdTankLocation).indexOf(rowColumnAsString) != -1) {
								if (Main.tank3.getCellHasBeenHit(Arrays
										.asList(Main.thirdTankLocation).indexOf(rowColumnAsString))) {
									// do nothing, tank has been hit there before.
								} else {
									Main.tank3.decreaseUndamagedCells();
									Main.tank3.setWhichCellHasBeenHit(Arrays.asList(Main.thirdTankLocation).indexOf(rowColumnAsString));
								}
								shot3.setText("You were shot for: "+Main.tank3.calculateDamageOutput(Main.tank3.getUndamagedCells()));
							}

							if (Arrays.asList(Main.fourthTankLocation)
									.indexOf(rowColumnAsString) != -1) {
								if (Main.tank4.getCellHasBeenHit(Arrays.asList(
										Main.fourthTankLocation).indexOf(rowColumnAsString))) {
									// do nothing, tank has been hit there before.
								} else {
									Main.tank4.decreaseUndamagedCells();
									Main.tank4.setWhichCellHasBeenHit(Arrays.asList(Main.fourthTankLocation).indexOf(rowColumnAsString));
								}
								shot4.setText("You were shot for: "+Main.tank4.calculateDamageOutput(Main.tank4.getUndamagedCells()));
							}

							if (Arrays.asList(Main.fifthTankLocation).indexOf(rowColumnAsString) != -1) {
								if (Main.tank5.getCellHasBeenHit(Arrays.asList(Main.fifthTankLocation).indexOf(rowColumnAsString))) {
									// do nothing, tank has been hit there before.
								} else {
									Main.tank5.decreaseUndamagedCells();
									Main.tank5.setWhichCellHasBeenHit(Arrays.asList(Main.fifthTankLocation).indexOf(rowColumnAsString));
								}
								shot5.setText("You were shot for: "+Main.tank5.calculateDamageOutput(Main.tank5.getUndamagedCells()));
							}
							
			        		
			        	}
			        	else{
			        		
			        		mylabel.setIcon(getScaleImageIcon(miss,60,60));
			        	}
			        	
						int totalDamage = Main.tank1.calculateDamageOutput(Main.tank1
								.getUndamagedCells())
								+ Main.tank2.calculateDamageOutput(Main.tank2.getUndamagedCells())
								+ Main.tank3.calculateDamageOutput(Main.tank3.getUndamagedCells())
								+ Main.tank4.calculateDamageOutput(Main.tank4.getUndamagedCells())
								+ Main.tank5.calculateDamageOutput(Main.tank5.getUndamagedCells());
						Main.player.decreaseHealthBy(totalDamage);
						health.setText("Fortress Health: "+(Main.player).getHealth());
						

							
							
			    	if (Main.tank1.isDead() && Main.tank2.isDead() && Main.tank3.isDead()
							&& Main.tank4.isDead() && Main.tank5.isDead()&&Main.player.isAlive()) {
			    		Win(Main.board);
						JOptionPane.showMessageDialog(frame, "Congratulations! You won!");
						System.exit(0);
						
					} 
					else if (!Main.player.isAlive()) {
						Lost(Main.board);
						JOptionPane.showMessageDialog(frame, "I am sorry, You lost!");
					    
						System.exit(0);
			        }
			        
			       
			    }
			        }); 

			   
			    
			    GameBoard.add(mylabel);
			    }
			}
			    
		
		return GameBoard;
	}
	static public ImageIcon getScaleImageIcon(ImageIcon icon, int width, int height) {
		return new ImageIcon(getScaledImage(icon.getImage(), width, height));
		}
	static private Image getScaledImage(Image srcImg, int width, int height){
		 BufferedImage resizedImg =
		new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		 Graphics2D g2 = resizedImg.createGraphics();
		 g2.setRenderingHint(
		RenderingHints.KEY_INTERPOLATION,
		RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		 g2.drawImage(srcImg, 0, 0, width, height, null);
		 g2.dispose();
		 return resizedImg;
		}
	
	public JPanel makeHealth() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(health, BorderLayout.WEST);
		
		return panel;
	}
	
	public JPanel makeShot(JLabel shot) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(shot, BorderLayout.WEST);
		
		return panel;
	}
	
	
	public void Win(Board board){
		GameBoard.removeAll();
		final int row = 10;
		final int column = 10;

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				final int c = x+1;
			    final int d= y+1;
			    JLabel winlabel = new JLabel();
	    	if(board.isTankPresent(c, d)){
	    		if(board.clickLogic[c][d]){
	    			winlabel.setIcon(getScaleImageIcon(hit,60,60));
	    		}
			  
			   }
	    	
	    	else if(!board.isTankPresent(c, d)){
	    		if(board.clickLogic[c][d]){
	    			winlabel.setIcon(getScaleImageIcon(miss,60,60));	}
	    		else{
		    		winlabel.setIcon(getScaleImageIcon(field,60,60));	
		    	}
	    	}
	    	
	    	GameBoard.add(winlabel);
	    }
	    
			
		}

        
	}
	public void Lost(Board board){
		
		GameBoard.removeAll();
		final int row = 10;
		final int column = 10;

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				final int c = x+1;
			    final int d= y+1;
			    JLabel winlabel = new JLabel();
	    	if(board.isTankPresent(c, d)){
	    		if(!board.clickLogic[c][d]){
	    			winlabel.setIcon(getScaleImageIcon(tank,60,60));
	    		}
	    		else{
	    			winlabel.setIcon(getScaleImageIcon(hit,60,60));
	    		}
			  
			   }
	    	
	    	else if(!board.isTankPresent(c, d)){
	    		if(board.clickLogic[c][d]){
	    			winlabel.setIcon(getScaleImageIcon(miss,60,60));	}
	    		else{
		    		winlabel.setIcon(getScaleImageIcon(field,60,60));	
		    	}
	    	}
	    	
	    	GameBoard.add(winlabel);
	    }
	    
			
		}


	}

}