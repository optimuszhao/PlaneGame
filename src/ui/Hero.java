package ui;

import java.awt.image.BufferedImage;

public class Hero extends flyClass{
	//ͨ�����췽�������ĳ�ʼ������һ��Ӣ�ۻ���ͼƬ�Ϳ��
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
