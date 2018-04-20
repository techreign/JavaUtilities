package paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MyPaintLauncher extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private MyPaint myPaint;
	
	public MyPaintLauncher() {
		super("My Paint");
		myPaint = new MyPaint();
		
		setLayout(new BorderLayout());
		setSize(600, 600);
		setResizable(false);
		add(myPaint, BorderLayout.CENTER);
		addMouseListener(myPaint);
		addMouseMotionListener(myPaint);
		setLocationRelativeTo(null);
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);		
	}
	
	public static void main(String args[]) {
		MyPaintLauncher launcher = new MyPaintLauncher();
	}
	
	
}
 