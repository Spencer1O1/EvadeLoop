package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4088146271165387233L;
	
	public static final int WIDTH = 880, HEIGHT = WIDTH / 12 * 9;

	private Thread thread;
	private boolean running = false;
	
	public static boolean paused = false;
	public int diff = 0;
	
	private Random r;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private Shop shop;
	private int backred = 0;
	private int backgreen = 40;
	private int backblue = 91;
	
	public enum STATE {
		Menu,
		Shop,
		Select,
		Help,
		Game,
		End;
	};
	
	public static STATE gameState = STATE.Game;
	
	public static BufferedImage sprite_sheet;
	public static BufferedImage icoImage;
	
	public Game() {
		
		BufferedImageLoader loader = new BufferedImageLoader();
		
		sprite_sheet = loader.loadImage("/Sprite_Sheet.png");
		icoImage = loader.loadImage("/InIcon.png");
		
		handler = new Handler();
		hud = new HUD();
		shop = new Shop(handler, hud);
		menu = new Menu(this, handler, hud, shop);
		this.addKeyListener(new KeyInput(handler, this, hud, shop));
		this.addMouseListener(menu);
		this.addMouseListener(shop);
		
		AudioPlayer.load();
		
		AudioPlayer.getMusic("music").loop();
		
		new Window(WIDTH, HEIGHT, "Evade", this);
		
		spawner = new Spawn(handler, hud, this);

		r = new Random();
		
		if(gameState == STATE.Game)
		{
			handler.addObject(new Player(WIDTH/2-16, HEIGHT/2-16, ID.Player, handler));
			handler.clearEnemies();
			handler.addObject(new HardEnemy(r.nextInt(WIDTH- 75), r.nextInt(HEIGHT- 75), ID.HardEnemy, handler, hud, null));
			handler.addObject(new SmartEnemy(r.nextInt(WIDTH- 75), r.nextInt(HEIGHT- 75), ID.SmartEnemy, handler));

			diff = 1;
		} else {
			for(int i = 0; i < 16; i++) {
				handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH - 75), r.nextInt(Game.HEIGHT - 75), ID.MenuParticle, handler));
			}
		}
		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
			}
		}
		stop();
	}
	
	private void tick() {
		
		if(gameState == STATE.Game)
		{
			if(!paused) {
				hud.tick();
				spawner.tick();
				handler.tick();
				
				if(HUD.HEALTH <= 0) {
					HUD.HEALTH = 150;
					gameState = STATE.End;
					handler.clearEnemies();
					for(int i = 0; i < 10; i++) {
						handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.MenuParticle, handler));
					}
				}
			}
			
		}else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Select || gameState == STATE.Help) {
			menu.tick();
			handler.tick();
		}
		
		if(Game.gameState == STATE.End || Game.gameState == STATE.Menu) {
			spawner.setTimer(150);
			spawner.setTimer2(250);
			spawner.setScoreKeep(0);
		}

	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(backred, backgreen, backblue));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if (tempObject.getId() == ID.Player || tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.HardEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy) {
				tempObject.render(g);
			}
		}
		
		if(paused) {
			g.setColor(Color.red);
			g.drawString("PAUSED", 805, 20);
		}
		
		if(gameState == STATE.Game){
			hud.render(g);
		} else if(gameState == STATE.Shop) {
			shop.render(g);
			hud.render(g);
		} else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.Select) {
			menu.render(g);
		}
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else
			return var;
	}

	public static void main(String args[]) {
		new Game();
	}

	public void setBackred(int backred) {
		this.backred = backred;
	}
	public int getBackred() {
		return backred;
	}
	public void setBackgreen(int backgreen) {
		this.backgreen = backgreen;
	}
	public int getBackgreen() {
		return backgreen;
	}
	public void setBackblue(int backblue) {
		this.backblue = backblue;
	}
	public int getBackblue() {
		return backblue;
	}
	
}
