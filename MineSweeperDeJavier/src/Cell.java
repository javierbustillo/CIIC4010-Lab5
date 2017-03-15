
public class Cell {
	
	private Boolean mineValue;
	private Boolean flag = false;
	private int gridX;
	private int gridY;
	
	
	public void setMineValue(Boolean mineValue) {
		this.mineValue = mineValue;
	}
	public Cell(Boolean mine, int gridX, int gridY) {
		// TODO Auto-generated constructor stub
		mineValue = mine;
		this.gridX = gridX;
		this.gridY = gridY;
	}
	public Boolean getMineValue(){
		return mineValue;
	}
	
	public void setFlagValue(Boolean flag){
		this.flag = flag;
	}
	
	public Boolean getFlagValue(){
		return flag;
	}
	public int mineCouter(){
		int mineCount=0;
		if(gridX+1<=9&&gridY+1<=9&&MyPanel.cells[gridX][gridY].getMineValue()==false){
			if(MyPanel.cells[gridX-1][gridY-1].getMineValue()){
				mineCount++;
				}
			
			if(MyPanel.cells[gridX][gridY-1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX+1][gridY-1].getMineValue()){
				mineCount++;
				
			}if(MyPanel.cells[gridX+1][gridY].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX+1][gridY+1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX][gridY+1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX-1][gridY+1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX-1][gridY].getMineValue()){
				mineCount++;
			}
		} 
		else if(gridX+1>9&&gridY+1<=9&&MyPanel.cells[gridX][gridY].getMineValue()==false){//Right side of panel
			if(MyPanel.cells[gridX-1][gridY-1].getMineValue()){
				mineCount++;
				}
			
			if(MyPanel.cells[gridX][gridY-1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX][gridY+1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX-1][gridY+1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX-1][gridY].getMineValue()){
				mineCount++;
			}
		}
		else if(gridX+1>9&&gridY+1>9&&MyPanel.cells[gridX][gridY].getMineValue()==false){
			if(MyPanel.cells[gridX-1][gridY-1].getMineValue()){
				mineCount++;
				}
			
			if(MyPanel.cells[gridX][gridY-1].getMineValue()){
				mineCount++;
			}

			if(MyPanel.cells[gridX-1][gridY].getMineValue()){
				mineCount++;
			}
		}
		else if(gridY+1>9 && gridX+1<=9 && MyPanel.cells[gridX][gridY].getMineValue()==false){
			if(MyPanel.cells[gridX-1][gridY-1].getMineValue()){
				mineCount++;
				}
			
			if(MyPanel.cells[gridX][gridY-1].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX+1][gridY-1].getMineValue()){
				mineCount++;
				
			}if(MyPanel.cells[gridX+1][gridY].getMineValue()){
				mineCount++;
			}
			
			if(MyPanel.cells[gridX-1][gridY].getMineValue()){
				mineCount++;
			}
		}
	
	return mineCount;
	}

}
