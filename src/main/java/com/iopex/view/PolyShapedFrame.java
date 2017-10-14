package com.iopex.view;

import java.awt.Color;
import java.awt.Polygon;

import javax.swing.JFrame;

/**
 * A polygon shaped frame
 * @author Sridhar
 */
public class PolyShapedFrame {

	public static void main(String[] args) {
		int xPoly[] = {0, 50, 300, 300, 50, 50, 0};
        int yPoly[] = {0, 0, 0, 100, 100, 50, 50};
		
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setUndecorated(true);
		frame.setBackground(Color.GRAY);
		
		Polygon s = new Polygon(xPoly, yPoly, yPoly.length);
		frame.setShape(s);
		frame.setVisible(true);
	}
	
}
