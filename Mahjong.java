import java.awt.*;
import java.net.URL;

import javax.swing.*;

public class Mahjong extends JFrame
{
	private GridBagLayout			layer0 = new GridBagLayout();
	private GridBagLayout			layer1 = new GridBagLayout();
	private GridBagLayout			layer2 = new GridBagLayout();
	private GridBagLayout			layer3 = new GridBagLayout();
	private GridBagLayout			layer4 = new GridBagLayout();
	private GridBagConstraints		constraints = new GridBagConstraints();
	
	private Image image;
	RandomTileDeck deckOTiles;
	
	public Mahjong()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new MahjongBoard());
		
		setSize(500, 500);
		
		
		
		setVisible(true);
	}
	
	public class MahjongBoard extends JPanel
	{
		
		
		public MahjongBoard()
		{

			
			
			//-------GridBag Testing
			
			constraints.fill = GridBagConstraints.BOTH;
			
			deckOTiles = new RandomTileDeck();
			
			setLayout(layer0);
			
			addComponent();
			
			/*for(int i = 0; i < deckOTiles.deck.size(); i++)
			{
				System.out.println("before addComponent Call");
				addComponent(deckOTiles.deck.get(i));
			}*/
			
			/*Tile t;
			t = new SeasonTile("Spring");
			//t.setLocation(200, 100);
			addComponent(t, 0, 0);
			
			t = new SeasonTile("Summer");
			//t.setLocation(190, 110);
			addComponent(t, 0, 1);
			
			t = new SeasonTile("Fall");
			//t.setLocation(190, 110);
			addComponent(t, 1, 0);*/
			
			
			///-----/GridBag Testing
			
			//------Original Test
			
			/*
			setLayout(null); //discarding the layout mananger, because we will make our own
			//NOW in Tile must setSize instead of setPreferredSize, after testing???
			
			Tile t;
			
			//off setting tile so they stack nicely
			t = new SeasonTile("Spring");	//going to be on top
			t.setLocation(200, 100);  //this is because there is no layout manager
			add(t);
			
			t = new SeasonTile("Summer");	//next z order down
			t.setLocation(190, 110);  //this is because there is no layout manager
			add(t);
			
			t = new SeasonTile("Fall");	//next z order down
			t.setLocation(180, 120);  //this is because there is no layout manager
			add(t);
			
			t = new SeasonTile("Winter");	//next z order down
			t.setLocation(170, 130);  //this is because there is no layout manager
			add(t);
			*/
			//------/Original Test
	
		}
		private void addComponent()
		{
			
			
			for(int row = 0; row < 8; row++)
			{
				for(int col = 0; col < 12; col++)
				{
					System.out.println("In addComponent row: " + row + " col: " + col);
					
					if(!(deckOTiles.layer0[row][col] == null))
					{
						constraints.gridx = col;
						constraints.gridy = row;
						constraints.gridheight = 1;
						constraints.gridwidth = 1;
						layer0.setConstraints(deckOTiles.layer0[row][col], constraints);
						add(deckOTiles.layer0[row][col]);
						
					}
					
					
					
					/*constraints.gridx = x;
					constraints.gridy = y;
					constraints.gridheight = 1;
					constraints.gridwidth = 1;
					layer0.setConstraints(c, constraints);
					add(c);*/
				}
			}
		}
		
		private void addComponent(Component c, int row, int col)
		{			
			constraints.insets = new Insets(-4, -4, -4, -4);
		
			constraints.gridx = col;
			constraints.gridy = row;
			constraints.gridheight = 1;
			constraints.gridwidth = 1;
			layer0.setConstraints(c, constraints);
			add(c);
		}
		
		/*public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			URL url = PictureTile.class.getResource("images/dragon_bg.pn");
			image = new ImageIcon(url);
			g.drawImage(image, 5, 5, this);
		}*/
	}
	
	public static void main(String[] args)
	{
		new Mahjong();
	}
}
