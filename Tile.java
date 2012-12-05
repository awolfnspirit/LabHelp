import java.awt.*;			//package without subclasses
import java.awt.event.*;	//package subclasses
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;		//All three are the common used for graphics


public class Tile extends JPanel
{
	int xPos;
	int yPos;
	int zPos;
	
	private	static	final	Dimension	SIZE = new Dimension(90, 90);
	
	int[] xPoints = {10, 5, 5, 80, 85, 10};
	int[] yPoints = {0, 5, 80, 80, 75, 75};
	int[] xFill = {5, 0, 0, 75, 80, 5};
	int[] yFill = {5, 10, 85, 85, 80, 80};
	
	public Tile()
	{
		setSize(86, 86);
		setPreferredSize(SIZE);
	}
		
	protected void paintComponent(Graphics g) 	//does the drawing, only include statements that can be executed multiple times, paintComponent is called multiple times
	{
		super.paintComponent(g);	//paintComponent is a method in JPanel, sets up a clear canvas
		
		//setOpaque(false);
		
		g.drawRect(10, 0, 75, 75);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawPolygon(xPoints, yPoints, 6);
		
		Color c1 = Color.blue;
		Color c2 = Color.lightGray;
		GradientPaint gradient = new GradientPaint(10,10,c1,45,45,c2,true);
		g2.setPaint(gradient);
		g2.fillPolygon(xFill, yFill, 6);
		g2.setPaint(Color.black);
	}
	
	public boolean matches(Tile other)
	{
		return getClass() == other.getClass();
	}
	
	public void setZOrder()
	{
		zPos = getParent().getComponentZOrder(this);
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
	
}
