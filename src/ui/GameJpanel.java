package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameJpanel extends JPanel{
	
	BufferedImage bg;
	
	public GameJpanel() {
		setBackground(Color.red);
		bg = Util.getImage("/img/bg1.jpg");
	}
	
	//»­Í¼µÄ·½·¨
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg,0,0,null);
	}
	
}
