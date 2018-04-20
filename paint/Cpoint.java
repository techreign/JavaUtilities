package paint;

import java.awt.Color;
import java.awt.Point;

public class Cpoint extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colour = Color.BLACK;
	private String text = "";
	
	public void setColour(Color colour) {
		this.colour = colour;
	}
	
	public Color getColour() {
		return colour;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	
}
