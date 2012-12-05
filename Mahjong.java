import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Mahjong extends JFrame
{
	ArrayList<Tile> deck = new ArrayList<Tile>();
	MahjongBoard board;
	private ImageIcon image;
	private Tile selected = null;			//To hold the selected Tile
	private Tile againstSelected = null;	//To hold the second Tile to compare
	private Tile forUndo1;
	private Tile forUndo2;
	long gameNumber = 0;
	
	int tileHeight;
	int tileWidth;
	int ti;
	int centerX;
	int centerY;
	
	int layer3;
	int layer2;
	int layer1;
	
	JScrollPane scrollPane;
	JPanel scrollPanel;
	
	public Mahjong()
	{
		gameNumber = new Date().getTime();
		new Mahjong(gameNumber);
	}
	
	public Mahjong(long number)
	{
		gameNumber = number;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mah Jong Tiles Demo");
		
		Random rand = new Random(number);

		
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
			
			deck.add(new BambooTile(2));
			deck.add(new BambooTile(3));
			deck.add(new BambooTile(4));
			deck.add(new BambooTile(5));
			deck.add(new BambooTile(6));
			deck.add(new BambooTile(7));
			deck.add(new BambooTile(8));
			deck.add(new BambooTile(9));
			
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

		pack();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
		
		//----Adding the menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Game");
		JMenu options = new JMenu("Move");
		
		JMenuItem newGame = new JMenuItem("Play");
		newGame.setToolTipText("Start a new game.");
		newGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "Start a new game?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(selection == JOptionPane.YES_OPTION)
					new Mahjong();
				else
					return;
			}
		});
		fileMenu.add(newGame);
		
		JMenuItem restart = new JMenuItem("Restart");
		restart.setToolTipText("Restart the current game.");
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to restart the game?", "Restarting the game!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(selection == JOptionPane.YES_OPTION)
					new Mahjong(gameNumber);
				else
					return;
			}
		});
		fileMenu.add(restart);
		
		JMenuItem numbered = new JMenuItem("Numbered");
		numbered.setToolTipText("Play a numbered (and therefore a repeatable game).");
		numbered.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				new Mahjong();
			}
		});
		fileMenu.add(numbered);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setToolTipText("Exit the game.");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the game?", "Exiting the game!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(selection == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					return;
			}
		});
		fileMenu.add(exit);
		
		menuBar.add(fileMenu);
		
		//---Options Menu
		JMenuItem undo = new JMenuItem("Undo");
		undo.setToolTipText("Undo your last move.");
		undo.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				board.undoOperation();
			}
		});
		options.add(undo);
		
		menuBar.add(options);
		
		//----Adding the game board
		add(board = new MahjongBoard());
		
		//----Adding the sidebar to show removed tiles
		scrollPanel = new JPanel();
		scrollPane = new JScrollPane(scrollPanel);
		scrollPane.setPreferredSize(new Dimension(tileWidth + 10, 50));
		
		add(scrollPane, BorderLayout.EAST);
		
		setVisible(true);
	}
	
	public Object getValue(String arg0) {return null;}

	public void putValue(String arg0, Object arg1) {}

	public class MahjongBoard extends JPanel implements MouseListener
	{
		private PlayClip clip = new PlayClip("audio/stone-scraping.wav", true);
	
		public MahjongBoard()
		{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			setLayout(null);
			
			tileWidth = deck.get(0).getWidth();
			tileHeight = deck.get(0).getWidth();
			ti = tileWidth / 2;
			
			//---Placing Tiles
				int i = 0;
				//add a method that iterates through the array list getting the locations and setting the x and y of each tile
				
				//----layer 0
				deck.get(i).setLocation(((screenSize.width - tileWidth) - 50) / 2, ((screenSize.height - tileHeight) / 2) - ti);
				deck.get(i).addMouseListener(this);
				add(deck.get(i));

				centerX = deck.get(i).getLocation().x;
				centerY = deck.get(i).getLocation().y;
				
				i++;

				//----layer 1 row 2 and 1
					deck.get(i).setLocation((centerX) - (ti), (centerY) + (ti));
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
					
					i++;

				//----layer 2 row 4
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
			//----layer 3 row 6
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

			//----layer 4 row 8
				deck.get(i).setLocation((centerX) - ((tileWidth * 5) + 22), (centerY) + ((tileWidth * 3) + ti) ); // fix width and height = - 10
				deck.get(i).addMouseListener(this);
				add(deck.get(i));
				i++;
				
				for(int w = 1; w < 12; w++)
				{
					deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
					deck.get(i).addMouseListener(this);
					add(deck.get(i));
					i++;
					
					//----layer 4 row 7
					if(w == 11)
					{
						deck.get(i).setLocation((centerX) - ((tileWidth * 3) + ti), (centerY) + ((tileHeight * 2) + ti + 10) ); // fix width and height = - 10
						deck.get(i).addMouseListener(this);
						add(deck.get(i));
						i++;
						
						for(w = 1; w < 8; w++)
						{
							deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
							deck.get(i).addMouseListener(this);
							add(deck.get(i));
							i++;
							
							//----layer 4 row 6
							if(w == 7)
							{
								deck.get(i).setLocation((centerX) - ((tileWidth * 4) + ti - 10), (centerY) + ((tileHeight) + ti + 20) ); // fix width and height = - 10
								deck.get(i).addMouseListener(this);
								add(deck.get(i));
								i++;
								
								for(w = 1; w < 10; w++)
								{
									deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
									deck.get(i).addMouseListener(this);
									add(deck.get(i));
									i++;
									
									//----layer 4 row 5
									if(w == 9)
									{
										//----left oddball tile
										deck.get(i).setLocation((centerX) - (tileWidth * 6 + 12), (centerY + ti - 10));
										deck.get(i).addMouseListener(this);
										add(deck.get(i));
										i++;
										
										deck.get(i).setLocation((centerX) - (tileWidth * 5 + 22), (centerY + (tileHeight - 13)));
										deck.get(i).addMouseListener(this);
										add(deck.get(i));
										i++;
										
										for(w = 1; w < 12; w++)
										{
											deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
											deck.get(i).addMouseListener(this);
											add(deck.get(i));
											i++;
											
											//----layer 4 row 4
											if(w == 11)
											{
												deck.get(i).setLocation((centerX) - (tileWidth * 5 + 22), (centerY ));
												deck.get(i).addMouseListener(this);
												add(deck.get(i));
												i++;
												
												for(w = 1; w < 12; w++)
												{
													
													deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
													deck.get(i).addMouseListener(this);
													add(deck.get(i));
													i++;

													
													if(w == 11)
													{
														//----Right Oddballs
														deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), (centerY + ti - 10));
														deck.get(i).addMouseListener(this);
														add(deck.get(i));
														i++;
														
														deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), (centerY + ti - 10));
														deck.get(i).addMouseListener(this);
														add(deck.get(i));
														i++;
													//----layer 4 row 3	
														deck.get(i).setLocation((centerX) - ((tileWidth * 4) + ti - 10), (centerY - tileHeight) + 10);
														deck.get(i).addMouseListener(this);
														add(deck.get(i));
														i++;
														
														for(w = 1; w < 10; w++)
														{
															deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
															deck.get(i).addMouseListener(this);
															add(deck.get(i));
															i++;
															
															//----layer 4 row 2
															if(w == 9)
															{
																deck.get(i).setLocation((centerX) - ((tileWidth * 3) + ti), centerY - ((tileHeight * 2) - 20 ));
																deck.get(i).addMouseListener(this);
																add(deck.get(i));
																i++;
																
																for(w = 1; w < 8; w++)
																{
																	deck.get(i).setLocation((deck.get(i-1).getLocation().x) + (tileWidth - 10), deck.get(i-1).getLocation().y);
																	deck.get(i).addMouseListener(this);
																	add(deck.get(i));
																	i++;
																	
																	//----layer 4 row 1
																	if(w == 7)
																	{
																		deck.get(i).setLocation((centerX) - ((tileWidth * 5) + 24), (centerY) - ((tileWidth * 3) - ti + 10) );
																		deck.get(i).addMouseListener(this);
																		add(deck.get(i));
																		i++;
																		
																		for(w = 1; w < 12; w++)
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
						}
					}
				}
			for(int j = 0; j < deck.size();j++)
			{
				deck.get(j).setForeground(Color.black);
				
				//----Setting zOrder
				deck.get(j).setZOrder();
			}
		}
		
		
		public void mousePressed(MouseEvent e)	//one of five methods in MouseListener
		{			
			Tile tile = (Tile)e.getSource();
			
			if (e.getButton() == MouseEvent.BUTTON1)
			{
				boolean tileToRight = false;
				boolean tileToLeft = false;
				boolean tileOnTop = false;
				
				System.out.println(tile.getLocation().x);
				System.out.println(tile.getLocation().y);
				System.out.println(tile.zPos);
				
				for(int i = 0; i < deck.size(); i++)
				{
					//---If a tile can be seen from the side but has a tile on top
					if(deck.get(i).getLocation().x == tile.getLocation().x + 10 && deck.get(i).getLocation().y == tile.getLocation().y - 10 )
					{
						tileOnTop = true;
					}
					//---If layer 4 single tile is still in play
					if(tile.zPos > 0 && tile.zPos < 5)
					{
						for(int j = 0; j < deck.size(); j++)
						{
							if(deck.get(j).zPos == 0)
							{
								tileOnTop = true;
							}
						}
					}
						
						
					//Directly Left or Right
					if(deck.get(i).getLocation().x == tile.getLocation().x - 76 && deck.get(i).getLocation().y == tile.getLocation().y)
						tileToLeft = true;
					else if(deck.get(i).getLocation().x == tile.getLocation().x + 76 && deck.get(i).getLocation().y == tile.getLocation().y)
						tileToRight = true;
					
					//---For Odd tiles on left and right end
					else if((deck.get(i).getLocation().x == tile.getLocation().x - 76 && deck.get(i).getLocation().y == tile.getLocation().y - 40))
						tileToLeft = true;
					else if(deck.get(i).getLocation().x == tile.getLocation().x - 76 && deck.get(i).getLocation().y == tile.getLocation().y + 33)
						tileToLeft = true;
					else if((deck.get(i).getLocation().x == tile.getLocation().x - 76 && deck.get(i).getLocation().y == tile.getLocation().y + 40))
						tileToLeft = true;
					else if(deck.get(i).getLocation().x == tile.getLocation().x - 76 && deck.get(i).getLocation().y == tile.getLocation().y - 33)
						tileToLeft = true;
					
					else if((deck.get(i).getLocation().x == tile.getLocation().x + 76 && deck.get(i).getLocation().y == tile.getLocation().y - 40))
						tileToRight = true;
					else if(deck.get(i).getLocation().x == tile.getLocation().x + 76 && deck.get(i).getLocation().y == tile.getLocation().y + 33)
						tileToRight = true;
					else if((deck.get(i).getLocation().x == tile.getLocation().x + 76 && deck.get(i).getLocation().y == tile.getLocation().y + 40))
						tileToRight = true;
					else if(deck.get(i).getLocation().x == tile.getLocation().x + 76 && deck.get(i).getLocation().y == tile.getLocation().y - 33)
						tileToRight = true;
				}
				
				if(tileOnTop == false && (tileToLeft == false || tileToRight == false))
					{
						if(tile.getForeground() == Color.black)
						{
							tile.setForeground(Color.RED);
							
							if(selected == null)
								selected = tile;
							else
								againstSelected = tile;
							
						}
						else
						{
							tile.setForeground(Color.black);
							selected = null;
							againstSelected = null;
						}
					}
				}
			
			if(selected != null && againstSelected != null)
			{
				compare();
			}
			
			repaint();
		}
		
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		
		public void undoOperation()
		{
			if(forUndo1 != null && forUndo2 != null)
			{
				int selection = JOptionPane.showConfirmDialog(null, "Are you sure you want to undo?", "Undo?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(selection == JOptionPane.YES_OPTION)
				{
					forUndo1.addMouseListener(this);
					add(forUndo1, forUndo1.zPos);
					forUndo1.setForeground(Color.black);
					repaint();
	
					forUndo2.addMouseListener(this);
					add(forUndo2, forUndo2.zPos);
					forUndo2.setForeground(Color.black);
					repaint();
					
					scrollPanel.remove(selected);
					scrollPanel.repaint();
					scrollPane.repaint();
					
					forUndo1 = null;
					forUndo2 = null;
					
					revalidate();
					board.revalidate();
				}
				else
					return;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There is nothing to Undo!",
						"Ooops!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		public void toTheScroll(Tile t)
		{
			//t.setBackground(null);
			t.removeMouseListener(this);
			scrollPanel.add(t, 0);
			scrollPane.add(scrollPanel);
			scrollPane.revalidate();
		}
		
		public void compare()
		{
			if(selected.getClass().equals(againstSelected.getClass()) && selected.matches(againstSelected))
			{
				forUndo1 = selected;
				forUndo2 = againstSelected;
				
				toTheScroll(selected);
				selected.setForeground(Color.black);
				againstSelected.setForeground(Color.black);
				
				clip.play();
				
				remove(selected);
				//selected.zPos = 500;
				selected = null;
				
				remove(againstSelected);
				//againstSelected.zPos = 500;
				againstSelected = null;
			}
			else
			{
				selected.setForeground(Color.black);
				selected = null;
				againstSelected.setForeground(Color.black);
				againstSelected = null;
			}
			repaint();
			revalidate();
		}
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			placeImage(g);
		}
		
		private void placeImage(Graphics g)
		{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			
			URL url = PictureTile.class.getResource("images/dragon_bg.png");
			image = new ImageIcon(url);
			image.paintIcon(this, g, centerX / 2, centerY / 2 );
		}
	}
	
	public static void main(String[] arg)
	{
		new Mahjong();
	}

	
}