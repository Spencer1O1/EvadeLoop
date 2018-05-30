package com.main;

import java.awt.image.BufferedImage;

public class Icon {

	private BufferedImage icon;
	
	public Icon(BufferedImage ico) {
		this.icon = ico;
	}
	
	public BufferedImage grabImage(int col, int row, int width, int height) {
		BufferedImage img = icon.getSubimage((row * 32) - 32, (col * 32) - 32, width, height);
		return img;
	}
	
}
