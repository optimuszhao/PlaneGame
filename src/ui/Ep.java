package ui;

import java.util.Random;

/**
 * �л���
 * @author TenDo
 *
 */
public class Ep extends flyClass{
	int type;//�л����
	//�л����췽��
	public Ep() {
		//ͨ�������������ĸı�������λ��
		Random rand = new Random();
		/**
		 * nextInt(15) ��ʾ�����ȡ0��14������ �� [0,15)��[0,14]
		 * �۲�ͼƬ�±���1��16 ������Ҫ����д��
		 */
		int imgIndex = rand.nextInt(14)+1;
		type = imgIndex;
		String path = "/img/ep"+(imgIndex<10?0:"")+imgIndex+".png";
		img = Util.getImage(path);
		w = img.getWidth();
		h = img.getHeight();
		x = rand.nextInt(512-w);
		y = -h;
		hp = imgIndex/2+1;
		//�������������Ѫ��
	}
	
	public void move() {
		y+=5;
	}
	
}
