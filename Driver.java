/**
 * 
 */
package com.sarthak.fb;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		BirdPanel panel = new BirdPanel();

		JFrame frame = new JFrame();

		frame.setResizable(false);
		frame.add(panel);
		frame.setSize(500, 450);
		frame.setTitle("Flappy Bird");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		// creates the pipes
		panel.makepipes();

		// starts the game

		while (true) {
			
			if (panel.isGameOver()) {
				
				panel.restart();
			}
			
			panel.Gravity();
			panel.movePipes();
			panel.checkCollision();
			panel.scrollBackground();
			               
		}
	}
}
