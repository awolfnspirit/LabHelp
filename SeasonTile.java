import java.awt.FlowLayout;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class SeasonTile extends PictureTile
{

	public SeasonTile(String name) 
	{
		super(name);
	}
	
	/*public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		placeImage(g);
	}
	
	private void placeImage(Graphics g)
	{
		URL url = PictureTile.class.getResource("images/" + name + ".png");
		image = new ImageIcon(url);
		image.paintIcon(this, g, 18, 10);
	}*/

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Season Tiles");

		frame.add(new SeasonTile("Spring"));
		frame.add(new SeasonTile("Summer"));
		frame.add(new SeasonTile("Fall"));
		frame.add(new SeasonTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}
