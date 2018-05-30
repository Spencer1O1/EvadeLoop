package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{
	
	private Handler handler;
	
	Random r = new Random();

	private Color col;
	private int timer = 7;
	
	private int WW = (int) Math.floor(r.nextInt(2));
	private int WW2 = (int) Math.floor(r.nextInt(2));
	
	public MenuParticle(int x, int y, ID id, Handler handler) {
		
		super(x, y, id);
		this.handler = handler;
		
		if(WW == 0) {
			velY = 0;
			if(WW2 == 0) {
				velX = 2;
			} else {
				velX = -2;
			}
		}
		if(WW == 1) {
			velX = 0;
			if(WW2 == 0) {
				velY = 2;
			}else {
				velY = -2;
			}
		}
		else if(WW == 2) {
			velX = 0;
			if(WW2 == 0) {
				velY = 2;
			}else {
				velY = -2;
			}
		}
		
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 25, 25);
	}

	public void tick() {
		timer--;
		x += velX;
		y += velY;
		
		if(y <= -1 || y >= Game.HEIGHT-48) velY *= -1;
		if(x <= -1 || x >= Game.WIDTH-20) velX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, col, 25, 25, 0.02f, handler));
		if(timer <= 0) {
			col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			timer = 7;
		}
		
	}

	public void render(Graphics g) {
		g.setColor(col);
		g.fillRect((int) x, (int) y, 25, 25);
	}

}
