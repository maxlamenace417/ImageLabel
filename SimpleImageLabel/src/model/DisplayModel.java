package model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class DisplayModel {
	
	public BufferedImage image;
	public Rectangle selection;
	
	public DisplayModel(BufferedImage image){
		this.image=image;
		this.selection = new Rectangle(0, 0, 0, 0);
	}
}
