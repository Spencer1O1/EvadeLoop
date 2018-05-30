package com.main;

import java.util.Random;

public class Spawn {
	
	private Handler handler;
	private HUD hud;
	private Game game;
	
	private int Timer = 150;
	private int Timer2 = 250;
	
	private int scoreKeep = 0;
	
	private Random r = new Random();
	
	public Spawn(Handler handler, HUD hud, Game game) {
		this.handler = handler;
		this.hud = hud;
		this.game = game;
	}
	
	public void tick() {
		Timer--;
		Timer2--;
		scoreKeep ++;
		
		if(game.diff == 0) {
			if(Timer <= 0) {
					Timer = 150;
					handler.addObject(new Coin(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.Coin, handler, hud));
					Timer = 150;
				}
		}
		if(game.diff == 1) {
			if(Timer2 <= 0) {
					Timer2 = 250;
					handler.addObject(new Coin(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.Coin, handler, hud));
					Timer2 = 250;
				}
		}
		
		if(scoreKeep >= 750) {
			scoreKeep = 0;
			hud.setLevel(hud.getLevel() + 1);
			
			if(game.diff == 1) {
				
				if(hud.getLevel() == 2) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.HardEnemy, handler, hud, game));
				}else if(hud.getLevel() == 3) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 4) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 5) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 6) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.HardEnemy, handler, hud, game));
				}else if(hud.getLevel() == 7) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.HardEnemy, handler, hud, game));
				}else if(hud.getLevel() == 8) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 9) {
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.HardEnemy, handler, hud, game));
					handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.HardEnemy, handler, hud, game));
				}else if(hud.getLevel() == 10) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 11) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 12) {
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 13) {
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 14) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 15) {
					handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.SmartEnemy, handler));
				}else if(hud.getLevel() == 16) {
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 17) {
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 18) {
					handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.FastEnemy, handler));
				}else if(hud.getLevel() == 19) {
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}else if(hud.getLevel() == 20) {
					handler.clearEnemies();
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
					handler.addObject(new EnemyBoss(r.nextInt(Game.WIDTH - 90), r.nextInt(Game.HEIGHT - 90), ID.EnemyBoss, handler, game, hud));
				}
				
				
			}
			
		}
			
			///////
			
	}
	
	public int getTimer() {
		return Timer;
	}
	public void setTimer(int Timer) {
		this.Timer = Timer;
	}
	public int getTimer2() {
		return Timer2;
	}
	public void setTimer2(int Timer2) {
		this.Timer2 = Timer2;
	}

	public void setScoreKeep(int scoreKeep) {
		this.scoreKeep = scoreKeep;
	}

}
