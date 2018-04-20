package paint;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


/*
 * 	Creating a paint like editing program which should include
 *  most features commonly found in Microsoft paint. Such as
 *  drawing, loading pictures, saving, etc.
 */

public class MyPaint extends JPanel implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private int len, hei;	// had to rename these variables since length and height exist
	private Font labelFont = new Font("TimesRoman", Font.BOLD, 20);
	private int tool;	// what tool is selected corresponds to the follow ints:
	private int BRUSH = 0,
				ERASER = 1,
				LINE = 2,
				STRING = 3;
	private Button brush, eraser, line, string, clear;		// will change the current selected tool when clicked
	private JPanel drawBoard;
	private Cpoint[] linePointArray;
	private Point p1, p2;			// previous and current mouse positions
	private Cpoint cp1, cp2;
	private ArrayList<Cpoint[]> linePoints; 	// the lines will be created from an arraylist of points
	private ArrayList<Cpoint[]> brushPoints;	// the brush strokes will be created from an arraylist of points
	private ArrayList<Cpoint[]> stringPoints;	// the strings will be stored in an arraylist
	private Color currColour = Color.BLACK;	// the current colour of the paint tool
	private int brushWidth, brushHeight;
	private String input;	// the text that the user will create
	
	public MyPaint(){
		
		len = 600; hei = 600;
		setSize(len, hei);
		setBackground(Color.white);
		setLayout(null);
		
		int colHeight = getHeight()/2;
		int colWidth = getWidth()/12;
		int colDistance = getHeight()/10;
		brushWidth = 5;	brushHeight = 5;
		
		drawBoard = new JPanel();
		drawBoard.setSize(500,600);
		drawBoard.setLocation(100, 0);
		drawBoard.setBackground(Color.blue);
		
		// initializing the buttons
		brush = new Button("BRUSH");
		eraser = new Button("ERASER");
		line = new Button("LINE");
		string = new Button("STRING");
		clear = new Button("CLEAR");
		
		// positioning the buttons
		brush.setSize(colWidth*2, colDistance);
		brush.setLocation(0, colHeight - (colHeight/16) );
		
		eraser.setSize(colWidth*2, colDistance);
		eraser.setLocation(0, colHeight + 60 - (colHeight/16) );
		
		line.setSize(colWidth*2, colDistance);
		line.setLocation(0, colHeight + 120 - (colHeight/16) );
		
		string.setSize(colWidth*2, colDistance);
		string.setLocation(0, colHeight + 180 - (colHeight/16) );
		
		clear.setSize(colWidth*2, colDistance);
		clear.setLocation(0, colHeight + 240 - (colHeight/16) );
		
		// adding action listeners to the buttons
		brush.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTool(BRUSH);
			}
		});
		
		eraser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTool(ERASER);
			}
		});
		
		line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTool(LINE);
			}
		});
		
		string.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTool(STRING);
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		
		// initializing the array list of list of points
		linePointArray = new Cpoint[2];
		linePoints = new ArrayList<Cpoint[]>();
		brushPoints = new ArrayList<Cpoint[]>();
		stringPoints = new ArrayList<Cpoint[]>();

		
		add(brush);	add(eraser); add(line); add(string); add(clear);
		//add(drawBoard);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setTool(BRUSH);
		  
	}
	
	public void setTool(int num) {
		tool = num;		
	}
	
	public void clear() {
		linePoints = new ArrayList<Cpoint[]>();
		brushPoints = new ArrayList<Cpoint[]>();
		stringPoints = new ArrayList<Cpoint[]>();
		setBackground(Color.white);
		repaint();
	}
	
	public void popUp(Cpoint cp1) {
		input = JOptionPane.showInputDialog("Enter your text.");
		if (input.length() > 0) {
			cp1.setText(input);
			stringPoints.add(linePointArray);
		} else {
			input = "";
		}
		repaint();
	}
	
	public void changeColour(int num) {
		
		switch (num) {
			case 0: currColour = Color.WHITE; break;
			case 1: currColour = Color.BLACK; break;
			case 2: currColour = Color.RED; break;
			case 3: currColour = Color.BLUE; break;
			case 4: currColour = Color.ORANGE; break;
			case 5: currColour = Color.GREEN; break;
			case 6: currColour = Color.YELLOW; break;
			case 7: currColour = Color.GRAY; break;
			case 8: currColour = Color.PINK; break;
			case 9: currColour = new Color(156, 93, 82); break;
		}
		
	}
	
	public Color getCurrColour() {
		return currColour;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
				
		int colHeight = getHeight()/2;
		int colWidth = getWidth()/12;
		int colDistance = getHeight()/10;
		
		// the colours 
		g.drawRect(0, 0, colWidth, colHeight/5);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(colWidth, 0, colWidth, colHeight/5);
		g.fillRect(colWidth, 0, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, colDistance, colWidth, colHeight/5);
		g.setColor(Color.RED);
		g.fillRect(0, colDistance, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(colWidth, 0, colWidth + 2, colHeight/5);
		g.setColor(Color.BLUE);
		g.fillRect(colWidth, colDistance, colWidth + 2, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, colDistance*2, colWidth, colHeight/5);
		g.setColor(Color.ORANGE);
		g.fillRect(0, colDistance*2, colWidth, colHeight/5 + 1);

		g.setColor(Color.BLACK);
		g.drawRect(colWidth, colDistance*2, colWidth, colHeight/5);
		g.setColor(Color.GREEN);
		g.fillRect(colWidth, colDistance*2, colWidth, colHeight/5);

		g.setColor(Color.BLACK);
		g.drawRect(0, colDistance*3, colWidth, colHeight/5);
		g.setColor(Color.YELLOW);
		g.fillRect(0, colDistance*3, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(colWidth, colDistance*3, colWidth, colHeight/5);
		g.setColor(Color.GRAY);
		g.fillRect(colWidth, colDistance*3, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(0, colDistance*4, colWidth, colHeight/5);
		g.setColor(Color.PINK);
		g.fillRect(0, colDistance*4, colWidth, colHeight/5);
		
		g.setColor(Color.BLACK);
		g.drawRect(colWidth, colDistance*4, colWidth, colHeight/5);
		Color brown = new Color(156, 93, 82);
		g.setColor(brown);
		g.fillRect(colWidth, colDistance*4, colWidth, colHeight/5);
		
		//	item boxes
		g.setColor(Color.BLACK);
		for (int i = 0; i < 5; i++){
			g.drawRect(0, colDistance*(5+i), colWidth*2, colHeight/5);
		}
				
		// tool bars
		g.setColor(Color.BLACK);
		g.drawRect(0,0,getWidth()/6, colHeight);
		g.drawRect(0, 0, getWidth()/6, getHeight()-1);
		
		// setting the colour to what was clicked
		g.setColor(getCurrColour());
	
		// drawing all the line objects 
		if (!linePoints.isEmpty()) {
			for (Cpoint[] items : linePoints) {
				if (items[0] != null && items[1] != null) {
					g.setColor(items[0].getColour());
					g.drawLine(items[0].x, items[0].y, items[1].x, items[1].y);
				}
			}
		}
		
		// drawing all the brush objects
		if (!brushPoints.isEmpty()) {
			for (Cpoint[] items : brushPoints) {
				if (items[0] != null) {
					g.setColor(items[0].getColour());
					g.fillOval(items[0].x, items[0].y, brushWidth, brushHeight);
				}
			}
		}
		
		// drawing all the text objects
		if (!stringPoints.isEmpty()) {
			for (Cpoint[] items : stringPoints) {
				if (items[0] != null) {
					g.setColor(items[0].getColour());
					g.drawString(items[0].getText(), items[0].x, items[0].y);
				}
			}
		}
	
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		
		p2 = e.getPoint();

		if (tool == LINE){
			
			cp2 = new Cpoint();
			cp2.setLocation(p2);
			linePointArray[1] = cp2;
			
		}

		if (tool == BRUSH){
			
			cp1 = new Cpoint();
			cp1.setLocation(p2);
			cp1.setColour(currColour);
			linePointArray = new Cpoint[2];
			linePointArray[0] = cp1;
			brushPoints.add(linePointArray);
			repaint();
		}
		
		if (tool == ERASER){
			
			cp1 = new Cpoint();
			cp1.setLocation(p2);
			cp1.setColour(Color.WHITE);
			linePointArray = new Cpoint[2];
			linePointArray[0] = cp1;
			brushPoints.add(linePointArray);
			repaint();
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (tool == LINE){
			
			p2 = e.getPoint();
			cp2 = new Cpoint();
			cp2.setLocation(p2);
			linePointArray[1] = cp2;
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();

		// selecting the colours
		// checking if the mouse is within the colour boxes
		if (mouseX >= 0 && mouseX <= getWidth()/6 && mouseY >= 0 && mouseY <= getHeight()/2) {
			
			if (mouseX < getWidth()/12 && mouseY <= getHeight()/10) {
				changeColour(0);
			} else if (mouseX > getWidth()/12 && mouseY <= getHeight()/10) {
				changeColour(1);
			} else if (mouseX < getWidth()/12 && mouseY <= getHeight()/10 + getHeight()/10) {
				changeColour(2);
			} else if (mouseX > getWidth()/12 && mouseY <= getHeight()/10 + getHeight()/10) {
				changeColour(3);
			} else if (mouseX < getWidth()/12 && mouseY <= getHeight()/10 + (2 * getHeight()/10) ) {
				changeColour(4);
			} else if (mouseX > getWidth()/12 && mouseY <= getHeight()/10 + (2 * getHeight()/10)) {
				changeColour(5);
			} else if (mouseX < getWidth()/12 && mouseY <= getHeight()/10 + (3 * getHeight()/10) ) {
				changeColour(6);
			} else if (mouseX > getWidth()/12 && mouseY <= getHeight()/10 + (3 * getHeight()/10) ) {
				changeColour(7);
			} else if (mouseX < getWidth()/12 && mouseY <= getHeight()/10 + (4 * getHeight()/10) ) {
				changeColour(8);
			} else if (mouseX > getWidth()/12 && mouseY <= getHeight()/10 + (4 * getHeight()/10) ) {
				changeColour(9);
			}		
			
		}
		
		
		if (tool == STRING) {
			p1 = e.getPoint();
			cp1 = new Cpoint();
			cp1.setLocation(p1);
			cp1.setColour(currColour);
			linePointArray = new Cpoint[2];
			linePointArray[0] = cp1;
			popUp(cp1);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		p1 = e.getPoint();

		if (tool == LINE){
			cp1 = new Cpoint();
			cp1.setLocation(p1);
			cp1.setColour(currColour);
			linePointArray[0] = cp1;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		if (tool == LINE) {
			linePoints.add(linePointArray);
			linePointArray = new Cpoint[2];
			p1 = new Point();
			p2 = new Point();
			repaint();
		}
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
