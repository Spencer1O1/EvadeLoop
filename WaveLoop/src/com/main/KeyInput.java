package com.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import com.main.Game.STATE;

public class KeyInput extends KeyAdapter{

	private Handler handler;
	private HUD hud;
	private Shop shop;
	private Random r;
	
	private boolean[] keyDown = new boolean[4];
	
	Game game;
	
	public KeyInput(Handler handler, Game game, HUD hud, Shop shop) {
		this.handler = handler;
		
		this.game = game;
		this.hud = hud;
		this.shop = shop;
		
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
		r = new Random();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-handler.spd); keyDown[0]=true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(handler.spd); keyDown[1]=true;}
				if(key == KeyEvent.VK_D) {tempObject.setVelX(handler.spd); keyDown[2]=true;}
				if(key == KeyEvent.VK_A) {tempObject.setVelX(-handler.spd); keyDown[3]=true;}
				
			}
		}
		
		if(key == KeyEvent.VK_P) {
			
			if(Game.gameState == STATE.Game) {
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
			
		}
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
		if(key == KeyEvent.VK_SPACE) {
			if(Game.gameState == STATE.Game && !Game.paused) Game.gameState = STATE.Shop;
			else if(Game.gameState == STATE.Shop)Game.gameState = STATE.Game;
			else return;
			
			}
		
		if(key == KeyEvent.VK_F) {
			if(Game.gameState == STATE.End) {
				game.setBackred(0);
				game.setBackgreen(40);
				game.setBackblue(91);
				hud.setLevel(1);
				hud.setScore(0);
				handler.clearEnemies();
				hud.setCoins(0);
				hud.setCoinsFromCoins(0);
				handler.spd = 5;
				hud.bounds = 0;
				HUD.HEALTH = 150;
				shop.setB1(7);
				shop.setB2(6);
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/2-16, Game.HEIGHT/2-16, ID.Player, handler));
				handler.clearEnemies();
				handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH- 75), r.nextInt(Game.HEIGHT- 75), ID.HardEnemy, handler, hud, game));
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH- 75), r.nextInt(Game.HEIGHT- 75), ID.SmartEnemy, handler));
	
				game.diff = 1;
				AudioPlayer.getSound("menu_sound").play();	
			}
		}
	}
		
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i< handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player){
				
				if(key == KeyEvent.VK_W) keyDown[0]=false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1]=false;//tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2]=false;//tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3]=false;//tempObject.setVelX(0);
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
		
	}
	
}
