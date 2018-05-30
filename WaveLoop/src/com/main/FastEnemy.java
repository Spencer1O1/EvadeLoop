package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class FastEnemy extends GameObject{
	
	private Handler handler;
	
	private BufferedImage enemy_image;
	
	Random r = new Random();
	
	int dir = 0;

	public FastEnemy(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		this.handler = handler;
		
		dir = r.nextInt(2);
		if(dir == 0) {
			velX = 4;
			velY = 17;
		}else if(dir ==1) {
			velX = 17;
			velY = 4;
		}
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(1, 3, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= -1 || y >= Game.HEIGHT-48) velY *= -1;
		if(x <= -1 || x >= Game.WIDTH-20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, new Color(0, 255, 255), 16, 16, 0.05f, handler));
	}

	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect((int) x, (int) y, 16, 16);
		
		g.drawImage(enemy_image, (int)x, (int)y, null);
	}

}
