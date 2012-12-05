import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JFrame;


public abstract class RankTile extends Tile
{
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}
	
	public boolean matches(Tile other)
	{	
		RankTile otherObject = (RankTile) other;

		return rank == otherObject.rank && super.matches(otherObject);
	}
	

}
