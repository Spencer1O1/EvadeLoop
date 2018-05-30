package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class HardEnemy extends GameObject{
	
	private Handler handler;
	private HUD hud;
	private Game game;
	
	private int timer3 = 10;
	
	private BufferedImage enemy_image;

	public HardEnemy(int x, int y, ID id, Handler handler, HUD hud, Game game) {
		
		super(x, y, id);
		this.handler = handler;
		this.hud = hud;
		this.game = game;
		
		velX = 7;
		velY = 7;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		enemy_image = ss.grabImage(2, 1, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= -1 || y >= Game.HEIGHT-48) velY*=-1;
		if(x <= -1 || x >= Game.WIDTH-20) velX*=-1;
		
		if(hud.getLevel() == 10 || hud.getLevel() == 20){
			
			if(timer3 <= 0) {
				if (game.getBackred() == 0){
			game.setBackred(255);
			} else {
				game.setBackred(0);
			}
			if (game.getBackgreen() == 40){
				game.setBackgreen(165);
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
		timer3--;
		handler.addObject(new Trail(x, y, ID.Trail, new Color(216, 126, 0), 16, 16, 0.02f, handler));
	}

	public void render(Graphics g) {
		//g.setColor(Color.orange);
		//g.fillRect((int) x, (int) y, 16, 16);
		g.drawImage(enemy_image, (int)x, (int)y, null);
	}

}
