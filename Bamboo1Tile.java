import java.awt.FlowLayout;

import javax.swing.JFrame;


public class Bamboo1Tile extends PictureTile
{	
	public Bamboo1Tile()
	{
		super("Sparrow");
	}
	
	public String toString()
	{
		return "Bamboo 1";
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo 1 Tile");

		frame.add(new Bamboo1Tile());

		frame.pack();
		frame.setVisible(true);
	}
}
