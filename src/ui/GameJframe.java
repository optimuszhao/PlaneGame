package ui;

import javax.swing.JFrame;

public class GameJframe extends JFrame{
	
	public GameJframe() {
		setSize(512, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("·É»ú´óÕ½");
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		GameJframe f = new GameJframe();
		GameJpanel p = new GameJpanel(f);
		p.action();
		f.add(p);
		f.setVisible(true);
	}
	
}
