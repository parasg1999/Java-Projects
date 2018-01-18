import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Clock implements Runnable {

	JFrame frame;
	GregorianCalendar gc;
	JLabel label;
	Thread thread;
	
	public Clock() {
		frame = new JFrame("");
		label = new JLabel("");
		label.setFont(new Font("Ariel", Font.BOLD , 20));
		label.setForeground(Color.WHITE);
		thread = new Thread(this);
		thread.start();
		frame.setUndecorated(true);
		frame.setLayout(new GridBagLayout());
		frame.add(label);
		frame.setSize(200,100);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Clock();
	}

	@Override
	public void run() {
		try {
			while(true)
			{
				gc = new GregorianCalendar();
				label.setText(gc.getTime().getHours() + " : " + gc.getTime().getMinutes() + " : " + gc.getTime().getSeconds());
				thread.sleep(1000);
			}
		} catch(Exception e) {}
		
	}

}
