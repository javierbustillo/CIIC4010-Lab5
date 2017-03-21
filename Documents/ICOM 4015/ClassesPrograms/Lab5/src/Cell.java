
public class Cell {
	
	private Boolean mineValue;
	private Boolean flag = false;
	
	
	public Cell(Boolean mine) {
		// TODO Auto-generated constructor stub
		mineValue = mine;
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

}
