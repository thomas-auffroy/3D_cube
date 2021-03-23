import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	Panel pan = new Panel();
	
	public Window() {
		// TODO Auto-generated constructor stub
		this.setTitle("3D");
		this.setSize(1000,1000);		
		this.setContentPane(pan);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan.setBackground(Color.black);
		
		this.setVisible(true);	
		
		
		move();
	}
	
	public void move () {
		while (true) {
			pan.repaint();
		}
	}
	
	public static void main(String[] args) {
		new	Window();
		
	}

}
