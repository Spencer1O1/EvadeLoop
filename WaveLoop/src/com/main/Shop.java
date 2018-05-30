package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{

	Handler handler;
	HUD hud;
	
	private int B1 = 7;
	private int B2 = 6;
	private int B3 = 5;
	
	
	public Shop(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("arial", 1, 50));
		
		g.setColor(Color.cyan);
		g.drawString("Shop", 600, 85);
		
		//UHealth
		g.setColor(new Color(0, 16, 145));
		g.fillRect(585, 120, 155, 80);
		g.setColor(new Color(99, 116, 255));
		g.setFont(new Font("arial", 1, 20));
		g.drawString("Upgrade Health", 590, 150);
		g.drawString("Cost: " + B1, 590, 185);
		g.drawRect(585, 120, 155, 80);
		
		//USpeed
		g.setColor(new Color(2, 142, 9));
		g.fillRect(585, 220, 155, 80);
		g.setColor(Color.green);
		g.setFont(new Font("arial", 1, 20));
		g.drawString("Upgrade Speed", 590, 250);
		g.drawString("Cost: " + B2, 590, 285);
		g.drawRect(585, 220, 155, 80);
		
		//FHealth
		g.setColor(new Color(237, 47, 47));
		g.fillRect(585, 320, 155, 80);
		g.setColor(new Color(255, 188, 188));
		g.setFont(new Font("arial", 1, 20));
		g.drawString("Refill Health", 590, 350);
		g.drawString("Cost: " + B3, 590, 385);
		g.drawRect(585, 320, 155, 80);
		g.setColor(Color.magenta);
		g.drawString("Press \'Space\' to go back.", 590, 435);
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//UHealth
		if(mx >= 585 && mx <= 740) {
			if(my >= 120 && my <= 200) {
				if(hud.getCoins() >= getB1()) {
					hud.setCoinsFromCoins(hud.getCoinsFromCoins() - getB1());
					hud.setCoins(hud.getCoins() - getB1());
					B1 += 7;
					hud.bounds += 40;
					HUD.HEALTH = (int) (HUD.HEALTH + (hud.bounds/2.5));
					hud.setGreenValue(HUD.HEALTH*2);
				}
			}
		}
		
		//USpeed
		if(mx >= 585 && mx <= 740) {
			if(my >= 220 && my <= 300) {
				if(hud.getCoins() >= B2) {
					hud.setCoinsFromCoins(hud.getCoinsFromCoins() - B2);
					hud.setCoins(hud.getCoins() - getB2());
					B2 += 6;
					handler.spd++;
				}
			}
		}
		
		//FHealth
		if(mx >= 585 && mx <= 740) {
			if(my >= 320 && my <= 400) {
				if(hud.getCoins() >= B3) {
					hud.setCoinsFromCoins(hud.getCoinsFromCoins() - B3);
					hud.setCoins(hud.getCoins() - B3);
					HUD.HEALTH = (int) (150+ (hud.getBounds()/2.5));
					HUD.HEALTH = Game.clamp(HUD.HEALTH, 0, (int) (100 + (hud.getBounds()/2.5)));
					hud.setGreenValue(HUD.HEALTH*2);
				}
			}
		}
		
	}

	public int getB1() {
		return B1;
	}

	public void setB1(int b1) {
		B1 = b1;
	}
	
	public int getB2() {
		return B2;
	}

	public void setB2(int b2) {
		B2 = b2;
	}
	
}
