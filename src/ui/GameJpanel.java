package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameJpanel extends JPanel{
	
	BufferedImage bg;
	
	Hero hero = new Hero();
	
	int score;//����
	
	//��һ�������洢�л������ƶ��Ĵ�����û20����ȥ�����µĵл�
	int moveCount = 0;
	
	/**
	 * ����һ���л��Ĵ�Ӫ
	 * ��Ϊ�л���������δ֪�����ԣ����ü��ϣ�����ʹ������ 
	 */
//	Ep ep = new Ep();
	List<Ep> eps = new ArrayList<Ep>();
	
	//�ӵ���
	List<Fire> fs = new ArrayList<Fire>();
	
	/**
	 * ��Ҫһ����ʼ��Ϸ�ķ���
	 */
	public void action() {
		new Thread() {
			public void run() {
				while(true) {
					//�л��볡
					epEnter();
					epMove();
					//�ӵ��볡
					fireEnter();
					fireMove();
					
					//�ж��Ƿ��ел����ӵ� ����
					shootEp();
					//ÿִ��һ�ξ���Ϣһ��
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}
	
	//���������ӵ�
	protected void shootEp() {
		for(int i=0;i<fs.size();i++) {
			if(isShoot(fs.get(i))) {
				fs.remove(i);
			}
		}
	}
	
	//�ж�����ӵ���û�д����˵л�
	private boolean isShoot(Fire f) {
		//ѭ�����еĵл������´��ݽ�������һ���ӵ��Ƿ�������κ�һ���л�
		for(int i=0;i<eps.size();i++) {
			Ep p = eps.get(i);
			if((	   f.x+f.w)>=p.x && 
					 (p.x+p.w)>= f.x && 
					f.y <= (p.y+p.h) && 
					f.y>=p.y) {
				eps.remove(i);
				score+=1;
				return true;
			}
		}
		return false;
	}

	//�ӵ��ƶ�
	protected void fireMove() {
		for(int i=0;i<fs.size();i++) {
			Fire f = fs.get(i);
			f.move(f.movef);
		}
	}
	
	//�ӵ�������
	int foreCount = 0;
	//�ӵ��볡
	protected void fireEnter() {
		foreCount++;
		if(foreCount>10) {
			Fire f1 = new Fire(hero.x-43,hero.y-20,1);//���
			fs.add(f1);
			Fire f2 = new Fire(hero.x+18,hero.y-20,2);//�Ҳ�
			fs.add(f2);
			Fire f3 = new Fire(hero.x-12,hero.y-30,0);//�м�
			fs.add(f3);
			foreCount = 0;
		}
		
	}

	/*
	 * �л����ֵķ���
	 */
	protected void epEnter() {
		moveCount++;
		if(moveCount > 10) {
			//����һ���л�
			Ep ep = new Ep();
			//���л����뵽��Ӫ��
			eps.add(ep);
			moveCount = 0;
		}
	}
	
	/**
	 * �л����еķ���
	 */
	protected void epMove() {
		for(int i = 0;i<eps.size();i++) {
			Ep e = eps.get(i);
			e.move();
		}
	}

	public GameJpanel(JFrame f) {
		setBackground(Color.red);
		bg = Util.getImage("/img/bg1.jpg");
		
		//����һ�����������
		MouseAdapter mad = new MouseAdapter() {
			//������ƶ�ʱ�ᴥ���ķ���
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
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
		//������
		g.drawImage(bg,0,0,null);
		//��Ӣ�ۻ�
		g.drawImage(hero.img, hero.x-hero.w/2,hero.y-hero.h/2,hero.w,hero.h,null);
		
		//���Ƶл���Ӫ�еĵл�
		for(int i = 0 ; i<eps.size();i++) {
			g.drawImage(eps.get(i).img,eps.get(i).x,eps.get(i).y,eps.get(i).w,eps.get(i).h,null);
		}
		//���ӵ�
		for(int i = 0 ; i<fs.size() ; i++) {
			Fire f = fs.get(i);
			g.drawImage(f.img,f.x,f.y,f.w,f.h,null);
		}
		
		//������
		g.setColor(Color.white);
		g.setFont(new Font("����", Font.BOLD,20));
		g.drawString("�÷�="+score, 30,30);
	}
	
}
