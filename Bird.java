
package com.sarthak.fb.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import com.sarthak.fb.BirdPanel;
import com.sarthak.fb.Driver;

public class Bird {

	private int x;
	private int y;
	private int width, height; 
	private String imagePath = "src/com/sarthak/fb/image/sbird.png"; // 
	
	public Bird(int x, int y,int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}

	public void draw(Graphics g){
		ImageIcon birdImage = new ImageIcon(imagePath);
		g.drawImage(birdImage.getImage(),x,y,null);  // drawing the bird
		
        
		
	}
		
	
	
	//Setters of Birds
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
	
	public void moveUp() {
        this.setY(this.getY()-30 );
    }
}