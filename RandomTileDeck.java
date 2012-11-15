import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RandomTileDeck extends JFrame
{
	ArrayList<Tile> deck = new ArrayList<Tile>();
	long gameNumber;
//	Tile[] [] layer4 = new Tile[1][1];
//	Tile[] [] layer3 = new Tile[2][2];
//	Tile[] [] layer2 = new Tile[4][4];
//	Tile[] [] layer1 = new Tile[6][6];
//	Tile[] [] layer0 = new Tile[8][12];
	
	int tileHeight;
	int tileWidth;
	int ti;
	int centerX;
	int centerY;
	
	int layer3;
	int layer2;
	int layer1;
	
	public RandomTileDeck()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mah Jong Tiles Demo");
		gameNumber = new Date().getTime();
		Random rand = new Random(gameNumber);
		
		for(int i = 0; i < 4; i++)
		{
			deck.add(new CharacterTile('1'));
			deck.add(new CharacterTile('2'));
			deck.add(new CharacterTile('3'));
			deck.add(new CharacterTile('4'));
			deck.add(new CharacterTile('5'));
			deck.add(new CharacterTile('6'));
			deck.add(new CharacterTile('7'));
			deck.add(new CharacterTile('8'));
			deck.add(new CharacterTile('9'));
			deck.add(new CharacterTile('N'));
			deck.add(new CharacterTile('E'));
			deck.add(new CharacterTile('W'));
			deck.add(new CharacterTile('S'));
			deck.add(new CharacterTile('C'));
			deck.add(new CharacterTile('F'));
			deck.add(new CircleTile(1));
			deck.add(new CircleTile(2));
			deck.add(new CircleTile(3));
			deck.add(new CircleTile(4));
			deck.add(new CircleTile(5));
			deck.add(new CircleTile(6));
			deck.add(new CircleTile(7));
			deck.add(new CircleTile(8));
			deck.add(new CircleTile(9));
			deck.add(new WhiteDragonTile());
			deck.add(new Bamboo1Tile());
		}
		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Bamboo"));
		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));
		
		Collections.shuffle(deck, rand);
		
		//setPosition();
		
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
		
		add(new MahjongBoard());
		
		
		setVisible(true);
	}
	
	public class MahjongBoard extends JPanel implements MouseListener
	{
	
		public MahjongBoard()
		{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			setLayout(null);
			
			//Tile t = new Tile();
			
			tileWidth = deck.get(0).getWidth();
			tileHeight = deck.get(0).getWidth();
			ti = tileWidth / 2;
			
			for(int i = 0; i < deck.size(); i++)
			{
				
				//add a method that iterates through the array list getting the locations and setting the x and y of each tile
				
				//----layer 0
				if(i == 0)
				{
				deck.get(i).setLocation((screenSize.width - tileWidth) / 2, (screenSize.height - tileHeight) / 2);
				deck.get(i).addMouseListener(this);
				add(deck.get(i));
				
				centerX = deck.get(i).getLocation().x;
				centerY = deck.get(i).getLocation().y;
				}
				
				//----layer 1 row 2 and 1
				if(i > 0 && i < 5)
				{
					deck.get(i).setLocation((deck.get(i-1).getLocation().x) - ti, (deck.get(i-1).getLocation().y) + ti);
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					deck.get(i).setLocation((deck.get(i-2).getLocation().x), (deck.get(i-2).getLocation().y) - (tileHeight - 10));
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), (deck.get(i-1).getLocation().y));
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
				}
				//----layer 2 row 4
				if(i > 4 && i < 20)
				{
					deck.get(i).setLocation((centerX) - (tileWidth + ti), (centerY) + (tileWidth + ti));
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					
					for(int w = 1; w < 4; w++)
					{
						deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
						deck.get(i).addMouseListener(this);
						add(deck.get(i));
						i++;
						//---- layer 2 row 3
						if(w == 3)
						{
							deck.get(i).setLocation((centerX) - (tileWidth + ti), ((centerY) + (tileWidth - ti + 10))); // fix width and height = - 10
							deck.get(i).addMouseListener(this);
							add(deck.get(i));
							i++;
							
							for(w = 1; w < 4; w++)
							{
								deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
								deck.get(i).addMouseListener(this);
								add(deck.get(i));
								i++;
								//----layer 2 row 2
								if(w == 3)
								{
									deck.get(i).setLocation((centerX) - (tileWidth + ti), (centerY - ti + 20)); // fix width and height = - 10
									deck.get(i).addMouseListener(this);
									add(deck.get(i));
									i++;
									
									for(w = 1; w < 4; w++)
									{
										deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
										deck.get(i).addMouseListener(this);
										add(deck.get(i));
										i++;
										
										//----layer 2 row 1
										if(w == 3)
										{
											deck.get(i).setLocation((centerX) - (tileWidth + ti), (centerY) - (tileWidth + 10) ); // fix width and height = - 10
											deck.get(i).addMouseListener(this);
											add(deck.get(i));
											i++;
											
											for(w = 1; w < 4; w++)
											{
												deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
												deck.get(i).addMouseListener(this);
												add(deck.get(i));
												i++;
											}
										}
									}
								}
							}
						}
					}
				}
			
			
			//----layer 3 row 6
			if(i > 21 && i < 58)
			{
				deck.get(i).setLocation((centerX) - ((tileWidth * 2) + ti), (centerY) + ((tileWidth * 2) + ti) ); // fix width and height = - 10
				deck.get(i).addMouseListener(this);
				add(deck.get(i));
				i++;
				
				for(int w = 1; w < 6; w++)
				{
					deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					//----layer 3 row 5
					if(w == 5)
					{
						deck.get(i).setLocation((centerX) - ((tileWidth * 2) + ti), (centerY) + (tileWidth + ti + 10));
						deck.get(i).addMouseListener(this);
						add(deck.get(i));
						i++;
						
						for(w = 1; w < 6; w++)
						{
							deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
							deck.get(i).addMouseListener(this);
							add(deck.get(i));
							i++;
							//----layer 3 row 4
							if(w == 5)
							{
								deck.get(i).setLocation((centerX) - ((tileWidth *2) + ti), ((centerY) + (tileWidth - ti + 20))); // fix width and height = - 10
								deck.get(i).addMouseListener(this);
								add(deck.get(i));
								i++;
								
								for(w = 1; w < 6; w++)
								{
									deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
									deck.get(i).addMouseListener(this);
									add(deck.get(i));
									i++;
									//----layer 3 row 3
									if(w == 5)
									{
										deck.get(i).setLocation((centerX) - ((tileWidth *2) + ti), (centerY - 10 ));
										deck.get(i).addMouseListener(this);
										add(deck.get(i));
										i++;
										
										for(w = 1; w < 6; w++)
										{
											deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
											deck.get(i).addMouseListener(this);
											add(deck.get(i));
											i++;
											//----layer 3 row 2
											if(w == 5)
											{
												deck.get(i).setLocation((centerX) - ((tileWidth * 2) + ti), (centerY - tileHeight) );
												deck.get(i).addMouseListener(this);
												add(deck.get(i));
												i++;
												
												for(w = 1; w < 6; w++)
												{
													deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
													deck.get(i).addMouseListener(this);
													add(deck.get(i));
													i++;
													//----layer 3 row 1
													if(w == 5)
													{
														deck.get(i).setLocation((centerX) - ((tileWidth * 2) + ti), (centerY) - (tileWidth * 2) + 10 ); // fix width and height = - 10
														deck.get(i).addMouseListener(this);
														add(deck.get(i));
														i++;
														
														for(w = 1; w < 6; w++)
														{
															deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
															deck.get(i).addMouseListener(this);
															add(deck.get(i));
															i++;
															
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
			
			//return t;
			}
		}
		
		
		public void mousePressed(MouseEvent e)	//one of five methods in MouseListener
		{
			Tile tile = (Tile)e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				remove(tile);	// other side of add
				repaint();
				//revalidate();
			}
			
		}
		
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String[] arg)
	{
		new RandomTileDeck();
	}
}