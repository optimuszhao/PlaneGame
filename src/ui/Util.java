package ui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 工具类
 * @author TenDo
 */
public class Util {
	
	/**
	 * 根据图片路径获取图片
	 * @param path
	 * @return
	 */
	public static BufferedImage getImage(String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(Util.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}
	
}
