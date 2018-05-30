package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemyBoss extends GameObject{
	
	private Handler handler;
	private Game game;
	private HUD hud;
	
	Random r = new Random();
	
	private BufferedImage boss_image;
	
	//private int timer = 100;
	//private int timer2 = 60;
	private int timer3 = 10;
	public EnemyBoss(int x, int y, ID id, Handler handler, Game game, HUD hud) {
		
		super(x, y, id);
		this.handler = handler;
		this.game = game;
		this.hud = hud;
		
		velX = 15;
		velY = 15;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		boss_image = ss.grabImage(2, 3, 32, 32);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= -1 || y >= Game.HEIGHT-16) velY *= -1;
		if(x <= -1 || x >= Game.WIDTH-16) velX *= -1;
		
		if(hud.getLevel() == 10 || hud.getLevel() == 20){
		
		if(timer3 <= 0) {
			if (game.getBackred() == 0){
		game.setBackred(0);
		} else {
			game.setBackred(0);
		}
		if (game.getBackgreen() == 40){
			game.setBackgreen(0);
		} else {
			game.setBackgreen(40);
		}
		if (game.getBackblue() == 91){
			game.setBackblue(0);
		} else {
			game.setBackblue(91);
		}
		timer3 = 10;
		}
		
		}
		
		timer3 --;
		handler.addObject(new Trail(x, y, ID.Trail, Color.black, 32, 32, 0.02f, handler));
	}

	public void render(Graphics g) {
		//g.setColor(Color.black);
		//g.fillRect((int) x, (int) y, 32, 32);
		
		g.drawImage(boss_image, (int)x, (int)y, null);
	}

}
