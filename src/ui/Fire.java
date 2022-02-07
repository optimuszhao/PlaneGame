package ui;

import java.awt.image.BufferedImage;

/**
 * 子弹
 * @author TenDo
 *
 */
public class Fire extends flyClass{
	
	/**
	 * 通过一个数据来控制子弹的移动方式
	 * 0:表示垂直向上
	 * 1:左上
	 * 2:右上
	 */
	int movef = 0; 
	
	//子弹的构造方法
	public Fire(int fx,int fy,int movef) {
		img = Util.getImage("/img/fire.png");
		x = fx;
		y = fy;
		w = img.getWidth()/4;
		h = img.getHeight()/4;
		this.movef = movef;
	}
	
	public void move(int movef) {
		if(movef == 1) {
			y -= 8;
			x -= 1;
		}else if(movef == 2) {
			y -= 8;
			x += 1;
		}else {
			y -= 8;
		}
	}
	
}
