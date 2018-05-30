package com.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1810247406099463112L;
	
	private BufferedImage icon_image;

	public Window(int width, int height, String title, Game game){
		
		Icon ico = new Icon(Game.icoImage);
		
		icon_image = ico.grabImage(1, 1, 64, 64);
		
		JFrame frame = new JFrame(title);
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.setVisible(true);
		frame.setIconImage(icon_image);
		game.start();
	}
	
}
