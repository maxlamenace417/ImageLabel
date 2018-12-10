package model;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DisplayModel {
	
	public BufferedImage image;
	public Rectangle selection;
	public List<Point> polygon;
	
	public DisplayModel(BufferedImage image){
		this.image=image;
		this.selection = new Rectangle(0, 0, 0, 0);
		this.polygon = new ArrayList<>();
	}
}
