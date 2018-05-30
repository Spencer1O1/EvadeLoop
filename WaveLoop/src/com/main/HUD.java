package com.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {

	public int bounds = 0;
	public static int HEALTH = 150;
	
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	private int coins = 0;
	private int coinsFromCoins = 0;
	
	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, (int) (100 + (bounds/2.5)));
		
		greenValue = HEALTH*2;
		greenValue = Game.clamp(greenValue, 0, 255);
		
		score++;
		
		coins = coinsFromCoins;
	}
	
	public void render(Graphics g) {
		g.setFont(new Font("arial", 1, 15));
		g.setColor(Color.gray);
		g.fillRect(16, 15, (250 + bounds), 40);
		g.setColor(new Color(125, greenValue, 0));
		g.fillRect(16, 15, (int) (HEALTH*2.5), 40);
		g.setColor(Color.white);
		g.drawRect(16, 15, (250 + bounds), 40);
		
		g.setColor(Color.yellow);
		g.drawString("Coins: " + coins ,105, 80);
		g.setColor(Color.blue);
		g.drawString("Score: " + score , 180, 80);
		g.setColor(Color.green);
		g.drawString("Level: " + level , 30, 80);
		g.setColor(Color.magenta);
		g.drawString("\'F\' for Shop", 30, 120);
		g.setColor(Color.red);
		g.drawString("\'P\' for Pause", 30, 160);
		g.setColor(Color.orange);
	}
	

	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public void setCoinsFromCoins(int coinsfromcoins) {
		this.coinsFromCoins = coinsfromcoins;
	}
	public int getCoinsFromCoins() {
		return coinsFromCoins;
	}
	public int getBounds() {
		return bounds;
	}
	public void setGreenValue(int greenvalue) {
		this.greenValue = greenvalue;
	}
	
	}
	

