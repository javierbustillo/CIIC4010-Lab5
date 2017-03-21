import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter {
	private int flag=0;
	public int mineCount=0;
	int initialMineFlag=0;
	int gameEndedFlag=0;
	int CELLS_WITHOUT_MINE=72;
	public void mousePressed(MouseEvent e) {
		if(gameEndedFlag!=0){
			//doNothing
		}
		else{
			switch (e.getButton()) {
			case 1:		//Left mouse button
				Component c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}
				}
				JFrame myFrame = (JFrame) c;
				MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
				Insets myInsets = myFrame.getInsets();
				int x1 = myInsets.left;
				int y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				int x = e.getX();
				int y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				myPanel.mouseDownGridX = myPanel.getGridX(x, y);
				myPanel.mouseDownGridY = myPanel.getGridY(x, y);
				
				
				
				if(MyPanel.cells[myPanel.mouseDownGridX][myPanel.mouseDownGridY].getMineValue()){
					for(int x2=0;x2<10;x2++){
						for(int y2=0;y2<10;y2++){
							if(MyPanel.cells[x2][y2].getMineValue()){
								myPanel.colorArray[x2][y2] = Color.BLACK;
							}
						}
					}
					gameEndedFlag++;
				}
				
				if(initialMineFlag==0){
					for(int mine=1; mine<=9; mine++)
					{ //Declaring 9 random cells as mines after first click so the initial click will never be a mine
						Random randomGenerator = new Random();
						int RandXComp=randomGenerator.nextInt(8) + 1;
						int RandYComp=randomGenerator.nextInt(8) + 1;
						
						if (MyPanel.cells[RandXComp][RandYComp].getMineValue()==false&&myPanel.mouseDownGridX!=RandXComp&&myPanel.mouseDownGridY!=RandYComp){ //if cell isnt already set as a mine
							MyPanel.cells[RandXComp][RandYComp].setMineValue(true);
						}
						else{
							mine--;
						}
					
					}
					initialMineFlag++;
				}
				
				
				
				myPanel.repaint();
				
				break;
			case 3:		//Right mouse button
				c = e.getComponent();
				while (!(c instanceof JFrame)) {
					c = c.getParent();
					if (c == null) {
						return;
					}
				}
				myFrame = (JFrame) c;
				myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
				myInsets = myFrame.getInsets();
				x1 = myInsets.left;
				y1 = myInsets.top;
				e.translatePoint(-x1, -y1);
				x = e.getX();
				y = e.getY();
				myPanel.x = x;
				myPanel.y = y;
				myPanel.mouseDownGridX = myPanel.getGridX(x, y);
				myPanel.mouseDownGridY = myPanel.getGridY(x, y);
				
				
				myPanel.repaint();
				break;
			default:    //Some other button (2 = Middle mouse button, etc.)
				//Do nothing
				break;
			}
		}
	}
	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:
							Color newColor = Color.WHITE;
							if (MyPanel.cells[gridX][gridY].getMineValue()){ // if you click on a cell with a mine
								newColor = Color.BLACK;
								mineCount=0;
								JOptionPane.showMessageDialog(null, "Loser");
							}
							else {// click on cell without a mine
								newColor = Color.GRAY;
								mineCount = MyPanel.cells[gridX][gridY].mineCouter();
								if(mineCount>0){
									//Print number on cell
								}
								else{
									MyPanel.cells[gridX][gridY].painter();
									for(int i=0;i<9;i++){
										for(int j=0;j<9;j++){
											myPanel.colorArray[i][j] = MyPanel.cells[i][j].getCellColor();
											
										}
									}
									myPanel.repaint();
								}
							}

							//System.out.println(MyPanel.cells[gridX][gridY].getMineValue());
							
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							MyPanel.cells[gridX][gridY].setCellColor(newColor);
							int openedCells=0;
							myPanel.repaint();
							for(int x2=0;x2<10;x2++){
								for(int y2=0;y2<10;y2++){
									if(MyPanel.cells[x2][y2].getMineValue() == false && MyPanel.cells[x2][y2].getCellColor() == Color.WHITE){
										break;
									}
									else if(MyPanel.cells[x2][y2].getMineValue() == false && MyPanel.cells[x2][y2].getCellColor() == Color.GRAY && x2>=1 && y2>=1 ){
										openedCells++;
										if(openedCells==CELLS_WITHOUT_MINE){
											gameEndedFlag++;
											for(int i=0;i<10;i++){
												for(int j=0;j<10;j++){
													if(MyPanel.cells[i][j].getMineValue() && MyPanel.cells[i][j].getCellColor()==Color.WHITE){
														myPanel.colorArray[i][j]= Color.RED ;
														myPanel.repaint();
														break;
													}
												}
											}
											JOptionPane.showMessageDialog(null, "Winner");
										}
									}
								}
							}
						}
					}
				}
			}
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame)c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			gridX = myPanel.getGridX(x, y);
			gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:
							if(flag<10){ //verifying there aren't more flags than mines
								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.WHITE){
									Color newColor = Color.RED;
									Boolean flagValue = MyPanel.cells[gridX][gridY].getFlagValue();
									MyPanel.cells[gridX][gridY].setFlagValue(!flagValue);
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();
									flag++;
									MyPanel.cells[gridX][gridY].setCellColor(newColor);
									//System.out.println(MyPanel.cells[gridX][gridY].getFlagValue());
								}else if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED){
									Color newColor = Color.WHITE;
									Boolean flagValue = MyPanel.cells[gridX][gridY].getFlagValue();
									MyPanel.cells[gridX][gridY].setFlagValue(!flagValue);
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
									myPanel.repaint();
									flag--;
									MyPanel.cells[gridX][gridY].setCellColor(newColor);
									//System.out.println(MyPanel.cells[gridX][gridY].getFlagValue());
								}
							}
							else if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == Color.RED){
								Color newColor = Color.WHITE;
								Boolean flagValue = MyPanel.cells[gridX][gridY].getFlagValue();
								MyPanel.cells[gridX][gridY].setFlagValue(!flagValue);
								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
								myPanel.repaint();
								flag--;
								MyPanel.cells[gridX][gridY].setCellColor(newColor);
								//System.out.println(MyPanel.cells[gridX][gridY].getFlagValue());
							}
						}
					}
				}
			}
			myPanel.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}

}