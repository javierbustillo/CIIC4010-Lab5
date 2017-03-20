import java.awt.Color;

public class Cell {
	
	private Boolean mineValue;
	private Boolean flag = false;
	private Boolean clicked = false;
	private int gridX;
	private int gridY;
	private Color color;
	
	public Boolean getClicked() {
		return clicked;
	}
	public void setClicked(Boolean clicked) {
		this.clicked = clicked;
	}
	public void setMineValue(Boolean mineValue) {
		this.mineValue = mineValue;
	}
	public Cell(Boolean mine, int gridX, int gridY, Color c) {
		// TODO Auto-generated constructor stub
		mineValue = mine;
		this.gridX = gridX;
		this.gridY = gridY;
		this.color = c;
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
	public void setCellColor(Color c){
		this.color = c;
	}
	public Color getCellColor(){
		return color;
	}
	public void painter(){
		Color newColor = Color.GRAY;
		if(gridX-1<1||gridY-1<1||gridX < 0 ||gridX==0||gridY==0 || gridX > 9 || gridY < 0 || gridY > 9 || MyPanel.cells[gridX][gridY].getMineValue() == true|| MyPanel.cells[gridX][gridY].getFlagValue() ==true || MyPanel.cells[gridX][gridY].getCellColor()!=Color.WHITE  ){
			//Do Nothing
		}
		else{
			if(gridX+1<9&&gridY+1<9&&gridX-1>1&&gridY-1>1){
				if(MyPanel.cells[gridX-1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY-1].painter();
				}
				if(MyPanel.cells[gridX][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY-1].painter();
				}
				if(MyPanel.cells[gridX+1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX+1][gridY-1].setCellColor(newColor);
					
				}
				else{
					MyPanel.cells[gridX+1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX+1][gridY-1].painter();
				}
				if(MyPanel.cells[gridX+1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX+1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX+1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX+1][gridY].painter();
				}
				if(MyPanel.cells[gridX+1][gridY+1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX+1][gridY+1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX+1][gridY+1].setCellColor(newColor);
					MyPanel.cells[gridX+1][gridY+1].painter();
				}
				if(MyPanel.cells[gridX][gridY+1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY+1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY+1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY+1].painter();
				}
				if(MyPanel.cells[gridX-1][gridY+1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY+1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY+1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY+1].painter();
					
				}
				if(MyPanel.cells[gridX-1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY].painter();
				}
			}
			else if(gridX+1>9&&gridY+1<9){
				if(MyPanel.cells[gridX-1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY-1].painter();
					System.out.println("k");
				}
				if(MyPanel.cells[gridX][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY-1].painter();
				}
				if(MyPanel.cells[gridX][gridY+1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY+1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY+1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY+1].painter();
				}
				if(MyPanel.cells[gridX-1][gridY+1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY+1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY+1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY+1].painter();
					
				}
				if(MyPanel.cells[gridX-1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY].painter();
				}
			}
			else if(gridX+1>9&&gridY+1>9&&gridX>0&&gridY>0&&gridX<10&&gridY<10){
				if(MyPanel.cells[gridX-1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY-1].painter();
					System.out.println("k");
				}
				if(MyPanel.cells[gridX][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY-1].painter();
				}
				if(MyPanel.cells[gridX-1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY].painter();
				}
	
			}
			else if(gridY+1>9 && gridX+1<9){
				if(MyPanel.cells[gridX-1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY-1].painter();
					System.out.println("k");
				}
				if(MyPanel.cells[gridX][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX][gridY-1].painter();
				}
				if(MyPanel.cells[gridX+1][gridY-1].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX+1][gridY-1].setCellColor(newColor);
					
				}
				else{
					MyPanel.cells[gridX+1][gridY-1].setCellColor(newColor);
					MyPanel.cells[gridX+1][gridY-1].painter();
				}
				if(MyPanel.cells[gridX+1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX+1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX+1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX+1][gridY].painter();
				}
				if(MyPanel.cells[gridX-1][gridY].mineCouter()>0){
					//Print number
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
				}
				else{
					MyPanel.cells[gridX-1][gridY].setCellColor(newColor);
					MyPanel.cells[gridX-1][gridY].painter();
				}
			}
			
		}
	}

}