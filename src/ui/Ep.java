package ui;

import java.util.Random;

/**
 * �л���
 * @author TenDo
 *
 */
public class Ep extends flyClass{
	
	//�л����췽��
	public Ep() {
		img = Util.getImage("/img/ep01.png");
		w = img.getWidth();
		h = img.getHeight();
		
		//ͨ�������������ĸı�������λ��
		Random rand = new Random();
		x = rand.nextInt(400);
		System.out.println(x);
		y = 0;
	}
	
}
