import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Panel extends JPanel implements MouseInputListener, KeyListener{
	private Figure figure = new Figure();
	private double theta = Math.PI/20, phi = Math.PI/20, zoom = 1.0; // theta = rotation on Y, phi = rotation on X
	private int lastPosX = 0, lastPosY = 0;
	private boolean leftArrow = false, rightArrow = false, upArrow = false, downArrow = false, zoomUp = false, zoomDown = false;

	public Panel() {
		// TODO Auto-generated constructor stub
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		requestFocus();
		Graphics2D g2 = (Graphics2D) g;	
		
		rotateView();
		zoomView();
		
		try {
			drawCuboid(-150,150,300,300,-300,g2);
			drawOrthogonal(g2);
			
		} catch (SizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void zoomView() {
		if (this.zoomUp) {this.zoom += 0.001;}
		if (this.zoomDown) {this.zoom -= 0.001;}
		if (this.zoom < 0) {zoom = 0;}
	}
	public void rotateView() {
		if (this.leftArrow) {this.theta -= 0.005;}
		if (this.rightArrow) {this.theta += 0.005;}

		if (this.upArrow) {this.phi -= 0.005;} 
		if (this.downArrow) {this.phi += 0.005;}
	}
	
	public void drawOrthogonal(Graphics2D g) throws SizeException {
		int[][] coord = this.figure.orthogonal(this.theta, this.phi, this.zoom);
		AffineTransform saveXform = g.getTransform();
		g.translate(this.getWidth()/2, this.getHeight()/2);
		
		g.setColor(Color.green);
		g.drawLine(0, 0, coord[0][0], coord[0][1]);
		g.drawString("x",coord[0][0], coord[0][1]);

		g.setColor(Color.blue);
		g.drawLine(0, 0, coord[1][0], coord[1][1]);
		g.drawString("y",coord[1][0], coord[1][1]);
		
		g.setColor(Color.red);
		g.drawLine(0, 0, coord[2][0], coord[2][1]);	
		g.drawString("z",coord[2][0], coord[2][1]);	
				
		g.setTransform(saveXform);
		}
	
	/**
	 * public void drawCuboid
	 * Build a cuboid with the given attributes.
	 * 
	 * @param x - x coordinates for the left top corner.
	 * @param y - y coordinates for the left top corner.
	 * @param height - height of the square.
	 * @param width - width of the square.
	 * @param length - length of the cuboid
	 * @param g - current Graphics.
	 * @throws SizeException
	 */	
	public void drawCuboid(int x, int y, int height, int width, int length, Graphics2D g) throws SizeException {		
		int[][] coord = this.figure.cuboid(x, y, height, width, length, this.theta, this.phi, this.zoom);
		AffineTransform saveXform = g.getTransform();
		g.translate(this.getWidth()/2, this.getHeight()/2);
		
		g.setColor(Color.white);
		
		g.drawString("A",coord[0][0], coord[1][0]);
		g.drawString("B",coord[0][1], coord[1][1]);
		g.drawString("C",coord[0][2], coord[1][2]);
		g.drawString("D",coord[0][3], coord[1][3]);
		
		g.drawString("E",coord[0][4], coord[1][4]);
		g.drawString("F",coord[0][5], coord[1][5]);
		g.drawString("G",coord[0][6], coord[1][6]);
		g.drawString("H",coord[0][7], coord[1][7]);
		
		
		g.drawLine(coord[0][0], coord[1][0], coord[0][1], coord[1][1]);
		g.drawLine(coord[0][0], coord[1][0], coord[0][2], coord[1][2]);
		g.drawLine(coord[0][2], coord[1][2], coord[0][3], coord[1][3]);
		g.drawLine(coord[0][3], coord[1][3], coord[0][2], coord[1][2]);
		
		
		
		g.drawLine(coord[0][0], coord[1][0], coord[0][4], coord[1][4]);
		g.drawLine(coord[0][4], coord[1][4], coord[0][5], coord[1][5]);
		g.drawLine(coord[0][5], coord[1][5], coord[0][1], coord[1][1]);
		
		g.drawLine(coord[0][2], coord[1][2], coord[0][6], coord[1][6]);
		g.drawLine(coord[0][6], coord[1][6], coord[0][7], coord[1][7]);
		g.drawLine(coord[0][7], coord[1][7], coord[0][3], coord[1][3]);
		
		g.drawLine(coord[0][1], coord[1][1], coord[0][3], coord[1][3]);
		g.drawLine(coord[0][4], coord[1][4], coord[0][6], coord[1][6]);
		g.drawLine(coord[0][5], coord[1][5], coord[0][7], coord[1][7]);
		
		g.setTransform(saveXform);
	}	
	
	@Override
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		this.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		
		if (lastPosX != event.getX()) {
			if (lastPosX < event.getX()) {this.theta += 0.02;}
			else {this.theta -= 0.02;}
			lastPosX = event.getX();
		}
		
		if (lastPosY != event.getY()) {
			if (lastPosY < event.getY()) {this.phi += 0.02;}
			else {this.phi -= 0.02;}
			lastPosY = event.getY();
		}		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {leftArrow = true;}
		else if (event.getKeyCode() == KeyEvent.VK_UP) {upArrow = true;} 
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {rightArrow = true;} 
		else if (event.getKeyCode() == KeyEvent.VK_DOWN) {downArrow = true;}
		else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
			this.theta = Math.PI/20;
			this.phi = Math.PI/20;
			this.zoom = 1;
		}	
		else if (event.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {zoomDown = true;}
		else if (event.getKeyCode() == KeyEvent.VK_PAGE_UP) {zoomUp = true;}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		if (event.getKeyCode() == KeyEvent.VK_LEFT) {leftArrow = false;}
		else if (event.getKeyCode() == KeyEvent.VK_UP) {upArrow = false;} 
		else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {rightArrow = false;} 
		else if (event.getKeyCode() == KeyEvent.VK_DOWN) {downArrow = false;}
		else if (event.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {zoomDown = false;}
		else if (event.getKeyCode() == KeyEvent.VK_PAGE_UP) {zoomUp = false;}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
