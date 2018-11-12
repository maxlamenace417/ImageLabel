package utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Utils {

	public static BufferedImage loadImage(String filePath) {
		BufferedImage image=null;
		try{
			File imageFile = new File(filePath);
			image = ImageIO.read(imageFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return image;
	}
}
