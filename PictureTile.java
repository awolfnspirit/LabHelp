import java.awt.FlowLayout;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public abstract class PictureTile extends Tile
{
	private String name;
	private ImageIcon image;
	
	public PictureTile(String name)
	{
		this.name = name;
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return name;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		placeImage(g);
	}
	
	private void placeImage(Graphics g)
	{
		URL url = PictureTile.class.getResource("images/" + name + ".png");
		image = new ImageIcon(url);
		image.paintIcon(this, g, 18, 10);
	}
	
	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new Bamboo1Tile());

		frame.add(new FlowerTile("Chrysanthemum"));
		frame.add(new FlowerTile("Orchid"));
		frame.add(new FlowerTile("Plum"));
		frame.add(new FlowerTile("Bamboo"));

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
