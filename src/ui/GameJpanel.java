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
		
		//创建一个鼠标适配器
		MouseAdapter mad = new MouseAdapter() {
			//当鼠标移动时会触发的方法
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
//				System.out.println("鼠标移动了"+e.getX()+"====="+e.getY());
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
		g.drawImage(bg,0,0,null);
		g.drawImage(hero.img, hero.x-hero.w/2,hero.y-hero.h/2,hero.w,hero.h,null);
		g.drawImage(ep.img,ep.x,ep.y,ep.w,ep.h,null);
	}
	
}
