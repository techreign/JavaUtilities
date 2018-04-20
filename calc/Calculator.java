package materials;

import java.util.ArrayList;

public class Calculator {
	
	private int value;
	private int value2;
	private Boolean added = false;
	private Boolean subbed = false;
	private Boolean multi = false;
	private Boolean divided = false;

	public Calculator(){
		
		value = Start.getNumber();
		value2 = 0;
		
	}
	
	public void plus(){
		refresh();
		Start.reset();
		added = true;
		
	}
	
	public void minus(){
		refresh();
		Start.reset();
		subbed = true;
		
	}
	
	public void multiply(){
		refresh();
		Start.reset();
		multi = true;
		
	}
	
	public void divide(){
		refresh();
		Start.reset();
		divided = true;
		
	}
	public int equal(){
		
		refresh2();	
		int ans = 0;
		// addition
		if (added) {
			ans = value + value2;
			added = false;
			return ans;
		}		
		
		// subtraction
		else if (subbed) {
			ans = value - value2;
			subbed = false;
			return ans;
		}
		
		// multiplication
		else if (multi) {
			ans = value * value2;
			multi = false;
			return ans;
		}	
				
		// division
		else if (divided) {
			ans = (value / value2);
			divided = false;
			return ans;
		}	
				
		return 0;
	} 
	
	public void refresh(){
		value = Start.getNumber();
	}
	
	public void refresh2(){
		value2 = Start.getNumber();
	}
	

}
