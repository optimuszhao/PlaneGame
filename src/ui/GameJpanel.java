package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameJpanel extends JPanel{
	
	BufferedImage bg;
	
	Hero hero = new Hero();
	Ep ep = new Ep();
	
	public GameJpanel(JFrame f) {
		setBackground(Color.red);
		bg = Util.getImage("/img/bg1.jpg");
		
		//����һ�����������
		MouseAdapter mad = new MouseAdapter() {
			//������ƶ�ʱ�ᴥ���ķ���
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
//				System.out.println("����ƶ���"+e.getX()+"====="+e.getY());
				//��Ҫʵʱ�ı�Ӣ�ۻ���λ��
				hero.x = e.getX();
				hero.y = e.getY();
				
				//ÿ�θı�֮��ˢ�»���
				repaint();
			}
		};
		//�����������뵽��������
		addMouseListener(mad);
		addMouseMotionListener(mad);
		
		//��Ūһ������������
		KeyAdapter kad = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("��");
					hero.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("��");
					hero.moveDown();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("��");
					hero.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("��");
					hero.moveRight();
				}
				repaint();
			}
		};
		//��ӵ����̼��������뵽����ļ�����
		f.addKeyListener(kad);
	}
	
	//��ͼ�ķ���
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bg,0,0,null);
		g.drawImage(hero.img, hero.x-hero.w/2,hero.y-hero.h/2,hero.w,hero.h,null);
		g.drawImage(ep.img,ep.x,ep.y,ep.w,ep.h,null);
	}
	
}
