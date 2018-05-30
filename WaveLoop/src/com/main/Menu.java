package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.main.Game.STATE;

public class Menu extends MouseAdapter{
	
	private HUD hud;
	public Menu(Game game, Handler handler, HUD hud, Shop shop){
		this.hud = hud;
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(Game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt3 = new Font("arial", 1, 25);
			
			g.setFont(fnt);
			g.setColor(Color.red);
			g.drawString("You Died!", 340, 185);
			
			g.setFont(fnt3);
			g.setColor(Color.orange);
			g.drawString("You lost on level " + hud.getLevel() + ", with a score of " + hud.getScore() + ".", 220, 285);
			
			g.setColor(Color.green);
			g.drawString("Press \'F\' to play again!", 315, 380);
			
		}
		
	}

}
