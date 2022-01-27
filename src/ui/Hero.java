package ui;

import java.awt.image.BufferedImage;

public class Hero extends flyClass{
	//通过构造方法基本的初始化好了一个英雄机的图片和宽高
	public Hero() {
		img = Util.getImage("/img/hero.png");
		w = img.getWidth();
		h = img.getHeight();
	}
	
	public void moveUp() {
		y-=10;
	}
	public void moveDown() {
		y+=10;
	}
	public void moveLeft() {
		x-=10;
	}
	public void moveRight() {
		x+=10;
	}
}
