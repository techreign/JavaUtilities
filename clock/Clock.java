package clock;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Clock {
	
	private JFrame frame = new JFrame("Clock");
	private JLabel label1 = new JLabel("", SwingConstants.CENTER);
	private Font labelFont = label1.getFont();


	public Clock() {
		frame.setName("Clock");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		
		label1.setFont(new Font(labelFont.getName(), Font.PLAIN, 50));
		currentTime();
		frame.add(label1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	// consistently get the current time and update the Jlabel
	public void currentTime(){
		Calendar cal = new GregorianCalendar();
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		label1.setText(" " + hour + " : " + minute + " : " + second);
	}
	
	// run the clock
	public void run(){
		while (true) {
			currentTime();
		}
	}

	public static void main(String[] args) {
		Clock clock = new Clock();
		clock.run();
	}

}
