/**
 * 
 */
package com.sarthak.fb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.sarthak.fb.models.Background;
import com.sarthak.fb.models.Bird;
import com.sarthak.fb.models.Pipes;

/**
 * @author sarthaksingh
 *
 */
public class BirdPanel extends JPanel implements KeyListener {

	
	
	public int WIDTH = 700, HEIGHT = 500;
	private int score = 0; 
	
	//background
	private Background background1 = new Background(0, 0, 500, 550);
	private Background background2 = new Background(400, 0, 750, 550);
	
	
	//Bird
	private Bird bird = new Bird((WIDTH/ 2 - 150), (HEIGHT /2) - 40, 50 , 36);
	//Wall array
	private Pipes[] walls = new Pipes[8];

	//pipe n speed
	private int speed = 2;
	
	private boolean started = false, gameOver =false; 
	
	
	
	//BirdPanel Constructor
	public BirdPanel(){
		super.addKeyListener(this);
		super.setFocusable(true);
	}
	
	
	
	
	
	// Gravity
	public void Gravity(){	
		
		
		bird.setY(bird.getY() + 1);						
		// bird falls by 1 pixel
		
		
	// checks the sky and ground collisions
		if(bird.getY() > 450 || bird.getY() <= 0){ 
			
			if(!gameOver)  
			gameOver = true;
			bird.setX(0);
		}
		try{ Thread.sleep(3); }  catch(Exception e) {} // This is for the delay basically just stops running the program so the bird can fall I orignally used a for loop to delay but my dad told me this is easier. 
		super.repaint();
	}
	
	
	//Helps wall move 
	public void movePipes(){ 
		
		for(int i = 0; i < walls.length; i+=2){
			if(walls[i].getX() > - 150){
				walls[i].setX(walls[i].getX() - speed);
				walls[i+1].setX(walls[i+1].getX() - speed);
			}
			else{
				walls[i].setX(700);
				walls[i+1].setX(700);
					
			}
		}
		
		try{ Thread.sleep(3); }  catch(Exception e) {}
		
		
		super.repaint();
	}
	
	
	

	public void scrollBackground(){ 
			
		
		if(background1.getX() > -400){
			background1.setX(background1.getX() - speed/2);
		} else { background1.setX(400);	}
		
		
		if(background2.getX() > -400){
			background2.setX(background2.getX() -speed/2);
		} else { background2.setX(400);	}
		
		
		
		try{ Thread.sleep(5); }  catch(Exception e) {}
		super.repaint();
	}
	
	
	

	
	//Draws panel
	public void paint(Graphics g){
		
		//Draws backgrounds
		background1.draw(g);
		background2.draw(g);
		
		//Draws Bird
		bird.draw(g);
		
		//Draws Walls
		for(int i = 0; i < walls.length; i++){
			walls[i].draw(g);
		}
	
		//Draws Texts
		if (gameOver) {	
			g.setFont(new Font("Arial", 1, 40));
			g.setColor(Color.red.brighter().brighter().brighter());
			g.drawString("Game Over!", 235, HEIGHT / 2 - 50);
			
		}
		else if (!gameOver){	
			g.setColor(Color.red);
			g.setFont(new Font("Arial", 1, 35));
			g.drawString(String.valueOf(score/2), 220 , 110);
		}
		

	
		
	}
	
	
	// Checks for birds collisions 
	public void checkCollision(){
		
		// Draws a rectangle around the bird so it can check for collisions 
		Rectangle birdrect = new Rectangle( bird.getX(), bird.getY(),25,25);
		
		// reectangle for the walls for collision checks 
		for(int i = 0; i < walls.length; i++){
			Rectangle WallRect=new Rectangle(walls[i].getX(),walls[i].getY(),walls[i].getWidth(),walls[i].getHeight());
			if(WallRect.intersects(birdrect)==true){
				bird.setX(-500);
				if(!gameOver)
				gameOver = true;
				break;
			} else if(bird.getX() == walls[i].getX()+speed){
				//if bird passes one wall then counts a point
				addpoints();
			}	
		}
		
	}
	
	
	//When any key press this code executes 
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE){
			
			
			
			if(gameOver){
				bird.setY((HEIGHT/2));
				bird.setX(WIDTH/2 - 150);
				score = 0;
				gameOver = false;
			}

				bird.moveUp();
				super.repaint();

			
		}
	}
	
	public void restart() {
		bird.setY((HEIGHT /2));
		bird.setX(WIDTH/2 - 150);
		
		this.makepipes();
		score = 0;
		super.repaint();
	}
	
	//Increments the score
	
	public void addpoints(){
		score+= 1;
	
		
	}
	
	public void makepipes(){
		Pipes p = new Pipes();
		walls = p.getPipes();
	}
	
	//Setters and Getters
	
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	//Key Events

	public void keyReleased(KeyEvent e) {
	}

	
	public void keyTyped(KeyEvent e) {
	}

}