package ui;

import java.util.Random;

/**
 * 敌机类
 * @author TenDo
 *
 */
public class Ep extends flyClass{
	
	//敌机构造方法
	public Ep() {
		img = Util.getImage("/img/ep01.png");
		w = img.getWidth();
		h = img.getHeight();
		
		//通过随机数来随机的改变横坐标的位置
		Random rand = new Random();
		x = rand.nextInt(400);
		System.out.println(x);
		y = 0;
	}
	
}
