
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

public class Background {

	private int x;
	private int y;
	private int width, height; 
	private String imagePath = "src/com/sarthak/fb/image/flappybackground.png"; // 
	
	public Background(int x1, int y1,int width1, int height1){
		this.x = x1;
		this.y = y1;
		this.width = width1;
		this.height = height1;
		
	}

	
	//Draw Method
	public void draw(Graphics g){
		ImageIcon birdImage = new ImageIcon(imagePath);
		g.drawImage(birdImage.getImage(),x,y,null);  // drawing the bird
		
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
	
}