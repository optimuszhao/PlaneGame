package ui;

import javax.swing.JFrame;

public class GameJframe extends JFrame{
	
	public GameJframe() {
		setSize(512, 768);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("大强献给小谭的春节礼物");
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		GameJframe f = new GameJframe();
		GameJpanel p = new GameJpanel();
		f.add(p);
		f.setVisible(true);
	}
	
}
