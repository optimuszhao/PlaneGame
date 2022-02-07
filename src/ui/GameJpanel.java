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
	
	int score;//分数
	
	//用一个变量存储敌机向下移动的次数，没20次再去生成新的敌机
	int moveCount = 0;
	
	/**
	 * 创建一个敌机的大本营
	 * 因为敌机的数量是未知，所以，采用集合，而不使用数组 
	 */
//	Ep ep = new Ep();
	List<Ep> eps = new ArrayList<Ep>();
	
	//子弹库
	List<Fire> fs = new ArrayList<Fire>();
	
	/**
	 * 需要一个开始游戏的方法
	 */
	public void action() {
		new Thread() {
			public void run() {
				while(true) {
					//敌机入场
					epEnter();
					epMove();
					//子弹入场
					fireEnter();
					fireMove();
					
					//判断是否有敌机被子弹 打中
					shootEp();
					//每执行一次就休息一会
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
	
	//便利所有子弹
	protected void shootEp() {
		for(int i=0;i<fs.size();i++) {
			if(isShoot(fs.get(i))) {
				fs.remove(i);
			}
		}
	}
	
	//判断这个子弹有没有打中了敌机
	private boolean isShoot(Fire f) {
		//循环所有的敌机，看下传递进来的这一个子弹是否击中了任何一个敌机
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

	//子弹移动
	protected void fireMove() {
		for(int i=0;i<fs.size();i++) {
			Fire f = fs.get(i);
			f.move(f.movef);
		}
	}
	
	//子弹计数器
	int foreCount = 0;
	//子弹入场
	protected void fireEnter() {
		foreCount++;
		if(foreCount>10) {
			Fire f1 = new Fire(hero.x-43,hero.y-20,1);//左侧
			fs.add(f1);
			Fire f2 = new Fire(hero.x+18,hero.y-20,2);//右侧
			fs.add(f2);
			Fire f3 = new Fire(hero.x-12,hero.y-30,0);//中间
			fs.add(f3);
			foreCount = 0;
		}
		
	}

	/*
	 * 敌机出现的方法
	 */
	protected void epEnter() {
		moveCount++;
		if(moveCount > 10) {
			//创建一个敌机
			Ep ep = new Ep();
			//将敌机加入到大本营中
			eps.add(ep);
			moveCount = 0;
		}
	}
	
	/**
	 * 敌机飞行的方法
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
		
		//创建一个鼠标适配器
		MouseAdapter mad = new MouseAdapter() {
			//当鼠标移动时会触发的方法
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				//需要实时改变英雄机的位置
				hero.x = e.getX();
				hero.y = e.getY();
				
				//每次改变之后，刷新画框
				repaint();
			}
		};
		//将适配器加入到鼠标监听中
		addMouseListener(mad);
		addMouseMotionListener(mad);
		
		//在弄一个键盘适配器
		KeyAdapter kad = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("上");
					hero.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("下");
					hero.moveDown();
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("左");
					hero.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("右");
					hero.moveRight();
				}
				repaint();
			}
		};
		//添加到键盘监听器加入到窗体的监听中
		f.addKeyListener(kad);
	}
	
	//画图的方法
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//画背景
		g.drawImage(bg,0,0,null);
		//画英雄机
		g.drawImage(hero.img, hero.x-hero.w/2,hero.y-hero.h/2,hero.w,hero.h,null);
		
		//绘制敌机大本营中的敌机
		for(int i = 0 ; i<eps.size();i++) {
			g.drawImage(eps.get(i).img,eps.get(i).x,eps.get(i).y,eps.get(i).w,eps.get(i).h,null);
		}
		//画子弹
		for(int i = 0 ; i<fs.size() ; i++) {
			Fire f = fs.get(i);
			g.drawImage(f.img,f.x,f.y,f.w,f.h,null);
		}
		
		//画分数
		g.setColor(Color.white);
		g.setFont(new Font("楷体", Font.BOLD,20));
		g.drawString("得分="+score, 30,30);
	}
	
}
