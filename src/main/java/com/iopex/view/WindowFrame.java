package com.iopex.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * A basic window frame without borders & buttons
 * @author Sridhar
 */
public class WindowFrame {
	
	static Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	private static final int SQUARE_FRAME_SIZE = dim.height / 15;

	public static void showFrame() throws IOException {
		JFrame frame = new JFrame();
		frame.setSize(SQUARE_FRAME_SIZE, SQUARE_FRAME_SIZE);
		frame.setLocation(dim.width - SQUARE_FRAME_SIZE, dim.height - SQUARE_FRAME_SIZE);
		frame.setUndecorated(true);
		frame.setTitle("My Awesome App");
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		try {
			WindowFrame.showFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
