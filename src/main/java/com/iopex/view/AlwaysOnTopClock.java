package com.iopex.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 * A clock to be shown always on top and not closeable from task bar
 * @author Sridhar
 * @version 1.0, Oct 14, 2017
 */
public class AlwaysOnTopClock {

	private static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	private static final int FRAME_WIDTH = dim.width / 10;
	private static final int FRAME_HEIGHT = dim.height / 10;

	private ClockLabel dateLable = new ClockLabel("date");
	private ClockLabel timeLable = new ClockLabel("time");
	private ClockLabel dayLable = new ClockLabel("day");

	public static void main(String[] args) {
		new AlwaysOnTopClock().showFrame();
	}

	/**
	 * Show the frame
	 */
	public void showFrame() {
		final JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setLocation(dim.width - FRAME_WIDTH, dim.height - (FRAME_HEIGHT * 2));
		frame.setAlwaysOnTop(true); // Always on foreground
		frame.setUndecorated(true); // No frame & Min, Max, Close Buttons

		frame.setLayout(new GridLayout(3, 1));

		frame.add(dateLable);
		frame.add(timeLable);
		frame.add(dayLable);

		frame.getContentPane().setBackground(Color.black);

		frame.setVisible(true);
		
		// Override window options
		frame.addWindowListener(new WindowAdapter() {
			
			// Overriding close button functionality
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(frame, "You ain't a wizard to do so!");
			}
		});
	}

}

/**
 * Label implementation for clock
 * @author Sridhar
 * @version 1.0, Oct 14, 2017
 */
class ClockLabel extends JLabel implements ActionListener {

	private static final long serialVersionUID = 8966816618184258639L;

	String type;
	SimpleDateFormat sdf;

	public ClockLabel(String type) {
		this.type = type;
		setForeground(Color.green);

		switch (type) {
		case "date" : sdf = new SimpleDateFormat("  MMMM dd yyyy");
		setFont(new Font("sans-serif", Font.PLAIN, 12));
		setHorizontalAlignment(SwingConstants.LEFT);
		break;
		case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
		setFont(new Font("sans-serif", Font.PLAIN, 20));
		setHorizontalAlignment(SwingConstants.CENTER);
		break;
		case "day"  : sdf = new SimpleDateFormat("EEEE  ");
		setFont(new Font("sans-serif", Font.PLAIN, 12));
		setHorizontalAlignment(SwingConstants.RIGHT);
		break;
		default     : sdf = new SimpleDateFormat();
		break;
		}

		Timer t = new Timer(1000, this);
		t.start();
	}

	/* Will be called by timer every second to get date time values
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent ae) {
		sdf.setTimeZone(TimeZone.getTimeZone("PST"));
		setText(sdf.format(new Date()));
	}

}
