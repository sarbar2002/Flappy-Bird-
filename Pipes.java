
package com.sarthak.fb.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import com.sarthak.fb.BirdPanel;
import com.sarthak.fb.Driver;

public class Pipes {

	private int x;
	private int y;
	private int width, height; 
	private String imagePath; // 
	private Pipes[] pipes = new Pipes[8];
	
	


	public Pipes(int x, int y,int width, int height, String imagePath ){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.imagePath = imagePath;
	}

	public Pipes() {
		
	}
	//Draw Method
	public void draw(Graphics g){
		ImageIcon birdImage = new ImageIcon(imagePath);
		g.drawImage(birdImage.getImage(),x,y,null);  // drawing the bird
		
	}
	public void createpipes(){
		int i = 0;
		int x = 600; // First walls distance from very right side
		
		//walls width and height, width is static and height changes constantly
		int width = 60, height = 280; 
		
		
		//1st & 2nd wall
		pipes[i] = new Pipes(x, 280, width, height, "src/com/sarthak/fb/image/wallUP.png");
		i++;
		pipes[i] = new Pipes(x, -90, width, height, "src/com/sarthak/fb/image/wallDOWN.png");
		x = pipes[i].getX()+220; // 160 is the difference between wall
		i++;
		
		//3rd & 4th wall
		pipes[i] = new Pipes(x, 360, width, height, "src/com/sarthak/fb/image/wallUP.png");
		i++;
		pipes[i] = new Pipes(x, -10, width, height, "src/com/sarthak/fb/image/wallDOWN.png");
		x = pipes[i].getX()+220;
		i++;
		
		
		//5rd & 6th wall
		pipes[i] = new Pipes(x, 280, width, height, "src/com/sarthak/fb/image/wallUP.png");
		i++;
			pipes[i] = new Pipes(x, -90, width, height, "src/com/sarthak/fb/image/wallDOWN.png");
			x = pipes[i].getX()+220;
			i++;
		
		
		//7rd & 8th wall
		pipes[i] = new Pipes(x, 220, width, height, "src/com/sarthak/fb/image/wallUP.png");
		i++;
		pipes[i] = new Pipes(x, -170, width, height, "src/com/sarthak/fb/image/wallDOWN.png");
		x = pipes[i].getX()+220;
		
		
	}
	
	
	//Setters of Birds Component
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	

	public void setPipes(Pipes[] pipes) {
		this.pipes = pipes;
	}

	//Getters of Component
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public String getImagePath() {
		return imagePath;
	}
	public Pipes[] getPipes() {
		this.createpipes();
		return pipes;
	}

}