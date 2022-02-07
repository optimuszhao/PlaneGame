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
		//通过随机数来随机的改变横坐标的位置
		Random rand = new Random();
		/**
		 * nextInt(15) 表示随机获取0到14的数字 即 [0,15)或[0,14]
		 * 观察图片下表，是1到16 所以需要如下写法
		 */
		int imgIndex = rand.nextInt(15)+1;
		String path = "/img/ep"+(imgIndex<10?0:"")+imgIndex+".png";
		img = Util.getImage(path);
		w = img.getWidth();
		h = img.getHeight();
		x = rand.nextInt(512-w);
		System.out.println(x);
		y = -h;
	}

	public void move() {
		y+=5;
	}
	
}
