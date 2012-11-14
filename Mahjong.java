import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.*;

public class Mahjong extends JFrame implements MouseListener
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
		
		setSize(800, 800);
		pack();
		
		
		setVisible(true);
	}
	
	public void mousePressed(MouseEvent e)	//one of five methods in MouseListener
	{
		/*Die	die = (Die)e.getSource();
		
		if (e.getButton() == MouseEvent.BUTTON3)
		{
			//die.setBackground(Color.RED);
			//die.removeMouseListener(this);

			//Use to remove tiles
			remove(die);	// other side of add
			revalidate();
		}
		else
			die.roll();*/
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public class MahjongBoard extends JPanel
	{
		
		
		public MahjongBoard()
		{

			
			
			//-------GridBag Testing
			
			constraints.fill = GridBagConstraints.BOTH;
			
			deckOTiles = new RandomTileDeck();
			
			//setLayout(layer4);
			
			//addComponent(4);
			
			setLayout(layer0);
			addComponent(4);
			addComponent(0);
			
			
			///-----/GridBag Testing
	
		}
		private void addComponent(int layer)
		{
			switch(layer)
			{
			case 4:
			{
				int row = 0;
				int col = 0;

					if(!(deckOTiles.layer4[row][col] == null))
					{
						constraints.insets = new Insets(-6, -6, -6, -6);
						
						constraints.gridx = col;
						constraints.gridy = row;
						constraints.gridheight = 1;
						constraints.gridwidth = 1;
						layer0.setConstraints(deckOTiles.layer4[row][col], constraints);
						
						add(deckOTiles.layer4[row][col]);
						
						//setComponentZOrder(deckOTiles.layer4[row][col], 0);
						
						System.out.println(deckOTiles.layer4[row][col].getParent().getComponentZOrder(deckOTiles.layer4[row][col]));
					}
					
				break;
			}
			case 0:
				for(int row = 7; row >= 0; row--)
				{
					for(int col = 0; col < 12; col++)
					{
						
						if(!(deckOTiles.layer0[row][col] == null))
						{
							constraints.insets = new Insets(-6, -6, -6, -6);
							
							constraints.gridx = col;
							constraints.gridy = row;
							constraints.gridheight = 1;
							constraints.gridwidth = 1;
							layer0.setConstraints(deckOTiles.layer0[row][col], constraints);
							
							add(deckOTiles.layer0[row][col]);
							
							System.out.println(deckOTiles.layer0[row][col].getParent().getComponentZOrder(deckOTiles.layer0[row][col]));
						}
					}
				}
				break;
			}
		}
		
		private void addComponent(Component c, int row, int col)
		{			
			constraints.insets = new Insets(-6, -6, -6, -6);
		
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
