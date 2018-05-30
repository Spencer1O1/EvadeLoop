package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player extends GameObject{

	Random r = new Random();
	Handler handler;
	
	private BufferedImage player_image;
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		player_image = ss.grabImage(1, 1, 32, 32);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
		x = Game.clamp((int) x, 0, Game.WIDTH - 36);
		y = Game.clamp((int) y, 0, Game.HEIGHT - 65);
		
		handler.addObject(new Trail(x, y, ID.Trail, new Color(124, 255, 150), 32, 32, 0.04f, handler));
		
		collision();
	}
	
	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.BasicEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 2;
				}
			}else if(tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy || tempObject.getId() == ID.HardEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 6;
				}
			}else if(tempObject.getId() == ID.HardEnemy) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 10;
				}
			}else if(tempObject.getId() == ID.EnemyBoss) {
				if(getBounds().intersects(tempObject.getBounds())) {
					HUD.HEALTH -= 25;
				}else return;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(player_image, (int)x, (int)y, null);
	}
	
}
