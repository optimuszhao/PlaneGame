package ui;

import javax.swing.JFrame;

public class GameJframe extends JFrame{
	
	public GameJframe() {
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ɻ���ս");
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		GameJframe f = new GameJframe();
		f.setVisible(true);
	}
	
}
