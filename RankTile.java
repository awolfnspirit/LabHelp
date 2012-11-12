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
	
	public boolean matches(Object other)
	{		
		RankTile otherObject = (RankTile) other;

		return super.matches(otherObject) && rank == otherObject.rank;
	}
	

}
