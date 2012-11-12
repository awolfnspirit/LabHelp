import java.awt.Color;
import java.awt.Graphics;


public class BambooTile extends RankTile
{

	public BambooTile(int rank) 
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Bamboo " + rank;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawBamboo(g);
	}
	
	private void drawBamboo(Graphics g)
	{
		switch(rank)
		{
			case 4:
				g.setColor(Color.BLUE);
				g.fillRect(28, 15, 5, 12);
				g.fillOval(25, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 15, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(25, 18, 10, 5);
				g.fillOval(25, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(58, 15, 5, 12);
				g.fillOval(55, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(59, 15, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(55, 18, 10, 5);
				g.fillOval(55, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(28, 45, 5, 12);
				g.fillOval(25, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 45, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 48, 10, 5);
				g.fillOval(25, 56, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(58, 45, 5, 12);
				g.fillOval(55, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(59, 45, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(55, 48, 10, 5);
				g.fillOval(55, 56, 10, 5);
				break;
			case 2:
				g.setColor(Color.BLUE);
				g.fillRect(43, 15, 5, 12);
				g.fillOval(40, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(44, 15, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(40, 18, 10, 5);
				g.fillOval(40, 26, 10, 5);
				
				
				g.setColor(Color.GREEN);
				g.fillRect(43, 45, 5, 12);
				g.fillOval(40, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(44, 45, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(40, 48, 10, 5);
				g.fillOval(40, 56, 10, 5);
				break;
			case 5:
				g.setColor(Color.BLUE);
				g.fillRect(28, 15, 5, 12);
				g.fillOval(25, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 15, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(25, 18, 10, 5);
				g.fillOval(25, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(63, 15, 5, 12);
				g.fillOval(60, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 15, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(60, 18, 10, 5);
				g.fillOval(60, 26, 10, 5);
				
				g.setColor(Color.RED);
				g.fillRect(45, 30, 5, 12);
				g.fillOval(42, 25, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 30, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(42, 33, 10, 5);
				g.fillOval(42, 41, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(28, 45, 5, 12);
				g.fillOval(25, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 45, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 48, 10, 5);
				g.fillOval(25, 56, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 45, 5, 12);
				g.fillOval(60, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 45, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 48, 10, 5);
				g.fillOval(60, 56, 10, 5);
				break;
			case 3:
				g.setColor(Color.BLUE);
				g.fillRect(43, 15, 5, 12);
				g.fillOval(40, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(44, 15, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(40, 18, 10, 5);
				g.fillOval(40, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(28, 45, 5, 12);
				g.fillOval(25, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 45, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 48, 10, 5);
				g.fillOval(25, 56, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(58, 45, 5, 12);
				g.fillOval(55, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(59, 45, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(55, 48, 10, 5);
				g.fillOval(55, 56, 10, 5);
				break;
			case 6:
				g.setColor(Color.GREEN);
				g.fillRect(28, 15, 5, 12);
				g.fillOval(25, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 15, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 18, 10, 5);
				g.fillOval(25, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(63, 15, 5, 12);
				g.fillOval(60, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 15, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(60, 18, 10, 5);
				g.fillOval(60, 26, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 15, 5, 12);
				g.fillOval(42, 10, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 15, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 18, 10, 5);
				g.fillOval(42, 26, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(28, 45, 5, 12);
				g.fillOval(25, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 45, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(25, 48, 10, 5);
				g.fillOval(25, 56, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 45, 5, 12);
				g.fillOval(60, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 45, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 48, 10, 5);
				g.fillOval(60, 56, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(45, 45, 5, 12);
				g.fillOval(42, 40, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 45, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(42, 48, 10, 5);
				g.fillOval(42, 56, 10, 5);
				break;
			case 7:
				g.setColor(Color.RED);
				g.fillRect(45, 6, 5, 12);
				g.fillOval(42, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 6, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(42, 9, 10, 5);
				g.fillOval(42, 17, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(28, 29, 5, 12);
				g.fillOval(25, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 29, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 32, 10, 5);
				g.fillOval(25, 40, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(63, 29, 5, 12);
				g.fillOval(60, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 29, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(60, 32, 10, 5);
				g.fillOval(60, 40, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 29, 5, 12);
				g.fillOval(42, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 29, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 32, 10, 5);
				g.fillOval(42, 40, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(28, 52, 5, 12);
				g.fillOval(25, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(25, 54, 10, 5);
				g.fillOval(25, 62, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 52, 5, 12);
				g.fillOval(60, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 54, 10, 5);
				g.fillOval(60, 62, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(45, 52, 5, 12);
				g.fillOval(42, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(42, 54, 10, 5);
				g.fillOval(42, 62, 10, 5);
				break;
				
			case 8:
				g.setColor(Color.GREEN);
				g.fillRect(28, 6, 5, 12);
				g.fillOval(25, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 6, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(25, 9, 10, 5);
				g.fillOval(25, 17, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(63, 6, 5, 12);
				g.fillOval(60, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 6, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(60, 9, 10, 5);
				g.fillOval(60, 17, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 6, 5, 12);
				g.fillOval(42, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 6, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 9, 10, 5);
				g.fillOval(42, 17, 10, 5);
				
				g.setColor(Color.RED);
				g.fillRect(33, 29, 5, 12);
				g.fillOval(30, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(34, 29, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(30, 32, 10, 5);
				g.fillOval(30, 40, 10, 5);
				
				g.setColor(Color.RED);
				g.fillRect(58, 29, 5, 12);
				g.fillOval(55, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(59, 29, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(55, 32, 10, 5);
				g.fillOval(55, 40, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(28, 52, 5, 12);
				g.fillOval(25, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(25, 54, 10, 5);
				g.fillOval(25, 62, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 52, 5, 12);
				g.fillOval(60, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 54, 10, 5);
				g.fillOval(60, 62, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(45, 52, 5, 12);
				g.fillOval(42, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(42, 54, 10, 5);
				g.fillOval(42, 62, 10, 5);
				break;
				
			case 9:
				g.setColor(Color.RED);
				g.fillRect(28, 6, 5, 12);
				g.fillOval(25, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 6, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(25, 9, 10, 5);
				g.fillOval(25, 17, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 6, 5, 12);
				g.fillOval(60, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 6, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 9, 10, 5);
				g.fillOval(60, 17, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 6, 5, 12);
				g.fillOval(42, 1, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 6, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 9, 10, 5);
				g.fillOval(42, 17, 10, 5);
				
				g.setColor(Color.RED);
				g.fillRect(28, 29, 5, 12);
				g.fillOval(25, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 29, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(25, 32, 10, 5);
				g.fillOval(25, 40, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 29, 5, 12);
				g.fillOval(60, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 29, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 32, 10, 5);
				g.fillOval(60, 40, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 29, 5, 12);
				g.fillOval(42, 24, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 29, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 32, 10, 5);
				g.fillOval(42, 40, 10, 5);
				
				g.setColor(Color.RED);
				g.fillRect(28, 52, 5, 12);
				g.fillOval(25, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(29, 52, 1, 12);
				g.setColor(Color.RED);
				g.fillOval(25, 54, 10, 5);
				g.fillOval(25, 62, 10, 5);
				
				g.setColor(Color.BLUE);
				g.fillRect(63, 52, 5, 12);
				g.fillOval(60, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(64, 52, 1, 12);
				g.setColor(Color.BLUE);
				g.fillOval(60, 54, 10, 5);
				g.fillOval(60, 62, 10, 5);
				
				g.setColor(Color.GREEN);
				g.fillRect(45, 52, 5, 12);
				g.fillOval(42, 47, 10, 5);
				g.setColor(Color.WHITE);
				g.fillRect(46, 52, 1, 12);
				g.setColor(Color.GREEN);
				g.fillOval(42, 54, 10, 5);
				g.fillOval(42, 62, 10, 5);
				break;
				
		}
	}
}
