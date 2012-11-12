import java.awt.Color;
import java.awt.Graphics;


public class WhiteDragonTile extends Tile
{
	
	public WhiteDragonTile()
	{
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawWhiteDragon(g);
	}
	
	private void drawWhiteDragon(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(17, 8, 60, 60);
		g.drawRect(25, 16, 45, 45);
		//fillers
		g.fillRect(17, 9, 11, 8);
		g.fillRect(38, 9, 11, 8);
		g.fillRect(58, 9, 11, 8);
		
		g.fillRect(70, 17, 8, 11);
		g.fillRect(70, 37, 8, 11);
		g.fillRect(70, 57, 8, 11);
		
		g.fillRect(48, 61, 11, 8);
		g.fillRect(26, 61, 11, 8);
		
		g.fillRect(17, 28, 8, 11);
		g.fillRect(17, 49, 8, 11);
	}
}
