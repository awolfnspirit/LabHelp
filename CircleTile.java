import java.awt.*;

import javax.swing.JFrame;


public class CircleTile extends RankTile
{
	
	public CircleTile(int rank) 
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Circle " + rank;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawCircle(g);
	}
	
	private void drawCircle(Graphics g)
	{
		
		switch(rank)
		{
			case 1:
				g.setColor(Color.GREEN);
				g.fillOval(16, 6, 60, 60);
				g.setColor(Color.RED);
				g.fillOval(40, 30, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(44, 34, 3, 3);
				
				g.fillOval(25, 34, 3, 3);
				g.fillOval(65, 34, 3, 3);
				g.fillOval(45, 10, 3, 3);
				g.fillOval(45, 55, 3, 3);
				g.fillOval(58, 18, 3, 3);
				g.fillOval(31, 49, 3, 3);
				g.fillOval(31, 18, 3, 3);
				g.fillOval(58, 49, 3, 3);
				break;
			case 4:
				g.setColor(Color.BLUE);
				g.fillOval(25, 45, 12, 12);
				g.fillOval(55, 15, 12, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 15, 12, 12);
				g.fillOval(55, 45, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 49, 3, 3);
				g.fillOval(59, 19, 3, 3);
				g.fillOval(29, 19, 3, 3);
				g.fillOval(59, 49, 3, 3);
				break;
			case 2:
				g.setColor(Color.GREEN);
				g.fillOval(40, 15, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(44, 19, 3, 3);
				g.setColor(Color.RED);
				g.fillOval(40, 45, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(44, 49, 3, 3);
				break;
			case 5:
				g.setColor(Color.GREEN);
				g.fillOval(25, 45, 12, 12);
				g.fillOval(55, 15, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 49, 3, 3);
				g.fillOval(59, 19, 3, 3);
				//flow through
			case 3:
				g.setColor(Color.BLUE);
				g.fillOval(25, 15, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 19, 3, 3);
				g.setColor(Color.RED);
				g.fillOval(40, 30, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(44, 34, 3, 3);
				g.setColor(Color.GREEN);
				g.fillOval(55, 45, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(59, 49, 3, 3);
				break;
			case 6:
				g.setColor(Color.GREEN);
				g.fillOval(25, 15, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 19, 3, 3);
				
				g.setColor(Color.RED);
				g.fillOval(25, 30, 12, 12);
				g.fillOval(25, 45, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 34, 3, 3);
				g.fillOval(29, 49, 3, 3);
				
				g.setColor(Color.GREEN);
				g.fillOval(55, 15, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(59, 19, 3, 3);
				
				g.setColor(Color.RED);
				g.fillOval(55, 30, 12, 12);
				g.fillOval(55, 45, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(59, 34, 3, 3);
				g.fillOval(59, 49, 3, 3);
				break;
			case 7:
				g.setColor(Color.GREEN);
				g.fillOval(25, 10, 12, 12);
				g.fillOval(42, 15, 12, 12);
				g.fillOval(60, 20, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 14, 3, 3);
				g.fillOval(46, 19, 3, 3);
				g.fillOval(64, 24, 3, 3);
				
				g.setColor(Color.RED);
				g.fillOval(30, 35, 12, 12);
				g.fillOval(30, 50, 12, 12);
				g.fillOval(55, 35, 12, 12);
				g.fillOval(55, 50, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(34, 39, 3, 3);
				g.fillOval(34, 54, 3, 3);
				g.fillOval(59, 39, 3, 3);
				g.fillOval(59, 54, 3, 3);
				break;
				
			case 8:
				g.setColor(Color.BLUE);
				g.fillOval(25, 10, 12, 12);
				g.fillOval(25, 23, 12, 12);
				g.fillOval(55, 10, 12, 12);
				g.fillOval(55, 23, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 14, 3, 3);
				g.fillOval(29, 27, 3, 3);
				g.fillOval(59, 14, 3, 3);
				g.fillOval(59, 27, 3, 3);
				
				g.setColor(Color.BLUE);
				g.fillOval(25, 37, 12, 12);
				g.fillOval(25, 51, 12, 12);
				g.fillOval(55, 37, 12, 12);
				g.fillOval(55, 51, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 41, 3, 3);
				g.fillOval(29, 55, 3, 3);
				g.fillOval(59, 41, 3, 3);
				g.fillOval(59, 55, 3, 3);
				break;
				
			case 9:
				g.setColor(Color.GREEN);
				g.fillOval(25, 12, 12, 12);
				g.setColor(Color.RED);
				g.fillOval(40, 30, 12, 12);
				g.setColor(Color.BLUE);
				g.fillOval(55, 50, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 16, 3, 3);
				g.fillOval(44, 34, 3, 3);
				g.fillOval(59, 54, 3, 3);
				
				g.setColor(Color.BLUE);
				g.fillOval(25, 50, 12, 12);
				g.setColor(Color.GREEN);
				g.fillOval(55, 12, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 54, 3, 3);
				g.fillOval(59, 16, 3, 3);
				
				g.setColor(Color.RED);
				g.fillOval(25, 30, 12, 12);
				g.fillOval(55, 30, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(29, 34, 3, 3);
				g.fillOval(59, 34, 3, 3);
				
				g.setColor(Color.GREEN);
				g.fillOval(40, 12, 12, 12);
				g.setColor(Color.BLUE);
				g.fillOval(40, 50, 12, 12);
				g.setColor(Color.WHITE);
				g.fillOval(44, 16, 3, 3);
				g.fillOval(44, 54, 3, 3);
				break;
				
		}
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}

}
