package ui;

import java.awt.image.BufferedImage;

/**
 * �ӵ�
 * @author TenDo
 *
 */
public class Fire extends flyClass{
	
	/**
	 * ͨ��һ�������������ӵ����ƶ���ʽ
	 * 0:��ʾ��ֱ����
	 * 1:����
	 * 2:����
	 */
	int movef = 0; 
	
	//�ӵ��Ĺ��췽��
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
