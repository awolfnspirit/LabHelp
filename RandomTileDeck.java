import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class RandomTileDeck //extends JFrame
{
	ArrayList<Tile> deck = new ArrayList<Tile>();
	int gameNumber;
	Tile[] [] layer4 = new Tile[1][1];
	Tile[] [] layer3 = new Tile[2][2];
	Tile[] [] layer2 = new Tile[4][4];
	Tile[] [] layer1 = new Tile[6][6];
	Tile[] [] layer0 = new Tile[8][12];
	
	public RandomTileDeck()
	{
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setTitle("Mah Jong Tiles Demo");
		
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
		
		//System.out.println("Deck size is: " + deck.size());
		
		setPosition();
		
//		pack();
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		setSize(screenSize);
//		setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);
		
		//deal();
		/*for(int i = 0; i < deck.size(); i++)
		{
		JPanel panel = new JPanel();
		panel = deck.get(i);
		add(panel);
		repaint();
		}*/
		
//		setVisible(true);
	}
	
	public void setPosition()
	{
		for (int i = 0; i < deck.size(); i++)
		{
			if(i == 0)
			{
				deck.get(i).zPos = 0;
				layer4[0][0] = deck.get(i);
			}
			else if(i > 0 && i <= 4)
			{
				deck.get(i).zPos = 1;
				switch(i)
				{
				case 1:
					layer3[0][0] = deck.get(i);
					break;
				case 2:
					layer3[0][1] = deck.get(i);
					break;
				case 3:
					layer3[1][0] = deck.get(i);
					break;
				case 4:
					layer3[1][1] = deck.get(i);
					break;
				}
			}
			else if(i > 4 && i <= 20)
			{
				deck.get(i).zPos = 2;
				switch(i)
				{
				case 5:
					layer2[0][0] = deck.get(i);
					break;
				case 6:
					layer2[0][1] = deck.get(i);
					break;
				case 7:
					layer2[0][2] = deck.get(i);
					break;
				case 8:
					layer2[0][3] = deck.get(i);
					break;
				case 9:
					layer2[1][0] = deck.get(i);
					break;
				case 10:
					layer2[1][1] = deck.get(i);
					break;
				case 11:
					layer2[1][2] = deck.get(i);
					break;
				case 12:
					layer2[1][3] = deck.get(i);
					break;
				case 13:
					layer2[2][0] = deck.get(i);
					break;
				case 14:
					layer2[2][1] = deck.get(i);
					break;
				case 15:
					layer2[2][2] = deck.get(i);
					break;
				case 16:
					layer2[2][3] = deck.get(i);
					break;
				case 17:
					layer2[3][0] = deck.get(i);
					break;
				case 18:
					layer2[3][1] = deck.get(i);
					break;
				case 19:
					layer2[3][2] = deck.get(i);
					break;
				case 20:
					layer2[3][3] = deck.get(i);
					break;
				}
			}
			else if(i > 20 && i <= 56)
			{
				deck.get(i).zPos = 3;
				switch(i)
				{
				case 21:
					layer1[0][0] = deck.get(i);
					break;
				case 22:
					layer1[0][1] = deck.get(i);
					break;
				case 23:
					layer1[0][2] = deck.get(i);
					break;
				case 24:
					layer1[0][3] = deck.get(i);
					break;
				case 25:
					layer1[0][4] = deck.get(i);
					break;
				case 26:
					layer1[0][5] = deck.get(i);
					break;
				case 27:
					layer1[1][0] = deck.get(i);
					break;
				case 28:
					layer1[1][1] = deck.get(i);
					break;
				case 29:
					layer1[1][2] = deck.get(i);
					break;
				case 30:
					layer1[1][3] = deck.get(i);
					break;
				case 31:
					layer1[1][4] = deck.get(i);
					break;
				case 32:
					layer1[1][5] = deck.get(i);
					break;
				case 33:
					layer1[2][0] = deck.get(i);
					break;
				case 34:
					layer1[2][1] = deck.get(i);
					break;
				case 35:
					layer1[2][2] = deck.get(i);
					break;
				case 36:
					layer1[2][3] = deck.get(i);
					break;
				case 37:
					layer1[2][4] = deck.get(i);
					break;
				case 38:
					layer1[2][5] = deck.get(i);
					break;
				case 39:
					layer1[3][0] = deck.get(i);
					break;
				case 40:
					layer1[3][1] = deck.get(i);
					break;
				case 41:
					layer1[3][2] = deck.get(i);
					break;
				case 42:
					layer1[3][3] = deck.get(i);
					break;
				case 43:
					layer1[3][4] = deck.get(i);
					break;
				case 44:
					layer1[3][5] = deck.get(i);
					break;
				case 45:
					layer1[4][0] = deck.get(i);
					break;
				case 46:
					layer1[4][1] = deck.get(i);
					break;
				case 47:
					layer1[4][2] = deck.get(i);
					break;
				case 48:
					layer1[4][3] = deck.get(i);
					break;
				case 49:
					layer1[4][4] = deck.get(i);
					break;
				case 50:
					layer1[4][5] = deck.get(i);
					break;
				case 51:
					layer1[5][0] = deck.get(i);
					break;
				case 52:
					layer1[5][1] = deck.get(i);
					break;
				case 53:
					layer1[5][2] = deck.get(i);
					break;
				case 54:
					layer1[5][3] = deck.get(i);
					break;
				case 55:
					layer1[5][4] = deck.get(i);
					break;
				case 56:
					layer1[5][5] = deck.get(i);
					break;
				}
			}
			else
			{
				deck.get(i).zPos = 4;
				switch(i)
				{
				case 57:
					layer0[0][0] = deck.get(i);
					break;
				case 58:
					layer0[0][1] = deck.get(i);
					break;
				case 59:
					layer0[0][2] = deck.get(i);
					break;
				case 60:
					layer0[0][3] = deck.get(i);
					break;
				case 61:
					layer0[0][4] = deck.get(i);
					break;
				case 62:
					layer0[0][5] = deck.get(i);
					break;
				case 63:
					layer0[0][6] = deck.get(i);
					break;
				case 64:
					layer0[0][7] = deck.get(i);
					break;
				case 65:
					layer0[0][8] = deck.get(i);
					break;
				case 66:
					layer0[0][9] = deck.get(i);
					break;
				case 67:
					layer0[0][10] = deck.get(i);
					break;
				case 68:
					layer0[0][11] = deck.get(i);
//					break;
//				case 33:
					layer0[1][0] = new Tile();
//					break;
//				case 34:
					layer0[1][1] = new Tile();
					break;
				case 69:
					layer0[1][2] = deck.get(i);
					break;
				case 70:
					layer0[1][3] = deck.get(i);
					break;
				case 71:
					layer0[1][4] = deck.get(i);
					break;
				case 72:
					layer0[1][5] = deck.get(i);
					break;
				case 73:
					layer0[1][6] = deck.get(i);
					break;
				case 74:
					layer0[1][7] = deck.get(i);
					break;
				case 75:
					layer0[1][8] = deck.get(i);
					break;
				case 76:
					layer0[1][9] = deck.get(i);
//					break;
//				case 43:
					layer0[1][10] = new Tile();
//					break;
//				case 44:
					layer0[1][11] = new Tile();
//					break;
//				case 45:
					layer0[2][0] = new Tile();
					break;
				case 77:
					layer0[2][1] = deck.get(i);
					break;
				case 78:
					layer0[2][2] = deck.get(i);
					break;
				case 79:
					layer0[2][3] = deck.get(i);
					break;
				case 80:
					layer0[2][4] = deck.get(i);
					break;
				case 81:
					layer0[2][5] = deck.get(i);
					break;
				case 82:
					layer0[2][6] = deck.get(i);
					break;
				case 83:
					layer0[2][7] = deck.get(i);
					break;
				case 84:
					layer0[2][8] = deck.get(i);
					break;
				case 85:
					layer0[2][9] = deck.get(i);
					break;
				case 86:
					layer0[2][10] = deck.get(i);
//					break;
//				case 56:
					layer0[2][11] = new Tile();
					break;
				case 87:
					layer0[3][0] = deck.get(i);
					break;
				case 88:
					layer0[3][1] = deck.get(i);
					break;
				case 89:
					layer0[3][2] = deck.get(i);
					break;
				case 90:
					layer0[3][3] = deck.get(i);
					break;
				case 91:
					layer0[3][4] = deck.get(i);
					break;
				case 92:
					layer0[3][5] = deck.get(i);
					break;
				case 93:
					layer0[3][6] = deck.get(i);
					break;
				case 94:
					layer0[3][7] = deck.get(i);
					break;
				case 95:
					layer0[3][8] = deck.get(i);
					break;
				case 96:
					layer0[3][9] = deck.get(i);
					break;
				case 97:
					layer0[3][10] = deck.get(i);
					break;
				case 98:
					layer0[3][11] = deck.get(i);
					break;
				case 99:
					layer0[4][0] = deck.get(i);
					break;
				case 100:
					layer0[4][1] = deck.get(i);
					break;
				case 101:
					layer0[4][2] = deck.get(i);
					break;
				case 102:
					layer0[4][3] = deck.get(i);
					break;
				case 103:
					layer0[4][4] = deck.get(i);
					break;
				case 104:
					layer0[4][5] = deck.get(i);
					break;
				case 105:
					layer0[4][6] = deck.get(i);
					break;
				case 106:
					layer0[4][7] = deck.get(i);
					break;
				case 107:
					layer0[4][8] = deck.get(i);
					break;
				case 108:
					layer0[4][9] = deck.get(i);
					break;
				case 109:
					layer0[4][10] = deck.get(i);
					break;
				case 110:
					layer0[4][11] = deck.get(i);
//					break;
//				case 45:
					layer0[5][0] = new Tile();
					break;
				case 111:
					layer0[5][1] = deck.get(i);
					break;
				case 112:
					layer0[5][2] = deck.get(i);
					break;
				case 113:
					layer0[5][3] = deck.get(i);
					break;
				case 114:
					layer0[5][4] = deck.get(i);
					break;
				case 115:
					layer0[5][5] = deck.get(i);
					break;
				case 116:
					layer0[5][6] = deck.get(i);
					break;
				case 117:
					layer0[5][7] = deck.get(i);
					break;
				case 118:
					layer0[5][8] = deck.get(i);
					break;
				case 119:
					layer0[5][9] = deck.get(i);
					break;
				case 120:
					layer0[5][10] = deck.get(i);
//					break;
//				case 56:
					layer0[5][11] = new Tile();
//					break;
//				case 21:
					layer0[6][0] = new Tile();
//					break;
//				case 22:
					layer0[6][1] = new Tile();
					break;
				case 121:
					layer0[6][2] = deck.get(i);
					break;
				case 122:
					layer0[6][3] = deck.get(i);
					break;
				case 123:
					layer0[6][4] = deck.get(i);
					break;
				case 124:
					layer0[6][5] = deck.get(i);
					break;
				case 125:
					layer0[6][6] = deck.get(i);
					break;
				case 126:
					layer0[6][7] = deck.get(i);
					break;
				case 127:
					layer0[6][8] = deck.get(i);
					break;
				case 128:
					layer0[6][9] = deck.get(i);
//					break;
//				case 31:
					layer0[6][10] = new Tile();
//					break;
//				case 32:
					layer0[6][11] = new Tile();
					break;
				case 129:
					layer0[7][0] = deck.get(i);
					break;
				case 130:
					layer0[7][1] = deck.get(i);
					break;
				case 131:
					layer0[7][2] = deck.get(i);
					break;
				case 132:
					layer0[7][3] = deck.get(i);
					break;
				case 133:
					layer0[7][4] = deck.get(i);
					break;
				case 134:
					layer0[7][5] = deck.get(i);
					break;
				case 135:
					layer0[7][6] = deck.get(i);
					break;
				case 136:
					layer0[7][7] = deck.get(i);
					break;
				case 137:
					layer0[7][8] = deck.get(i);
					break;
				case 138:
					layer0[7][9] = deck.get(i);
					break;
				case 139:
					layer0[7][10] = deck.get(i);
					break;
				case 140:
					layer0[7][11] = deck.get(i);
					break;
				}
			}
		}
	}
	
	/*public void deal()//Tile deal()
	{
		//temp
		JPanel tile = new JPanel();
		Tile t = new Tile();
		
		for(int i = 0; i < deck.size(); i++)
		{
			tile.add(deck.get(i));
			add(tile);
		}
		
		//return t;
	}*/
	
	public static void main(String[] arg)
	{
		new RandomTileDeck();
	}
}