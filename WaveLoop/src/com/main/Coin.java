package com.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Coin extends GameObject{
	
	private Handler handler;
	private HUD hud;
	
	private BufferedImage coin_image;

	public Coin(int x, int y, ID id, Handler handler, HUD hud) {
		
		super(x, y, id);
		
		this.handler = handler;
		this.hud = hud;
		
		SpriteSheet ss = new SpriteSheet(Game.sprite_sheet);
		
		coin_image = ss.grabImage(2, 2, 16, 16);
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, 16, 16);
	}

	public void tick() {

		collision();
	}

	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hud.setCoinsFromCoins(hud.getCoinsFromCoins()+ 1);
					handler.removeObject(this);
				}
				
			}
			
		}
		
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect((int) x, (int) y, 16, 16);
		g.drawImage(coin_image, (int)x, (int)y, null);
	}

}