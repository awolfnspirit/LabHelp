import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class CharacterTile extends Tile
{
	//private	static	final	Dimension	SIZE = new Dimension(85, 85);
	protected char symbol;
	protected String chinese;
	protected String wan = "\u842C";
	
	public CharacterTile(char symbol)
	{
		
		this.symbol = symbol;
		setToolTipText(toString());
		
		switch(this.symbol)
		{
		case '1':
			chinese =  "\u4E00";
			break;
		case '2':
			chinese =  "\u4E8C";
			break;
		case '3':
			chinese =  "\u4E09";
			break;
		case '4':
			chinese =  "\u56DB";
			break;
		case '5':
			chinese =  "\u4E94";
			break;
		case '6':
			chinese =  "\u516D";
			break;
		case '7':
			chinese =  "\u4E03";
			break;
		case '8':
			chinese =  "\u516B";
			break;
		case '9':
			chinese =  "\u4E5D";
			break;

		case 'N':
			chinese =  "\u5317";
			break;
		case 'E':
			chinese =  "\u6771";
			break;
		case 'W':
			chinese =  "\u897F";
			break;
		case 'S':
			chinese =  "\u5357";
			break;
		case 'C':
			chinese =  "\u4E2D";
			break;
		case 'F':
			chinese =  "\u767C";
			break;
		}
		
	}
	
	public boolean matches(Tile other)
	{
		CharacterTile otherObject = (CharacterTile) other;
 
		return super.matches(otherObject) && symbol == otherObject.symbol;
	}
	
	public String toString()
	{
		String out = " ";
		
		switch(this.symbol)
		{
		case '1':
			out =  "Character " + this.symbol;
			break;
		case '2':
			out =  "Character " + this.symbol;
			break;
		case '3':
			out = "Character " + this.symbol;
			break;
		case '4':
			out = "Character " + this.symbol;
			break;
		case '5':
			out = "Character " + this.symbol;
			break;
		case '6':
			out = "Character " + this.symbol;
			break;
		case '7':
			out = "Character " + this.symbol;
			break;
		case '8':
			out = "Character " + this.symbol;
			break;
		case '9':
			out = "Character " + this.symbol;
			break;

		case 'N':
			out = "North Wind";
			break;
		case 'E':
			out = "East Wind";
			break;
		case 'W':
			out = "West Wind";
			break;
		case 'S':
			out = "South Wind";
			break;
		case 'C':
			out = "Red Dragon";
			break;
		case 'F':
			out = "Green Dragon";
			break;
		}
		
		return out;
	}
	
	protected void paintComponent(Graphics g) 	//does the drawing, only include statements that can be executed multiple times, paintComponent is called multiple times
	{
		super.paintComponent(g);	//paintComponent is a method in JPanel, sets up a clear canvas
		
		//setSize(600,800);
		//setPreferredSize(SIZE);
		g.setColor(Color.red);
		g.drawString(String.valueOf(this.symbol), 65, 20);
		
		g.setColor(Color.black);
		if(!(this.chinese == null))
		{
			Font f = g.getFont().deriveFont(45F);
			g.setFont(f);
			if(this.chinese == "\u5317" || this.chinese == "\u6771" || this.chinese == "\u897F" || this.chinese == "\u5357")
			{
				g.drawString(this.chinese, 25, 55);
				
			}
			else if(this.chinese == "\u4E2D")
			{
				g.setColor(Color.red);
				g.drawString(this.chinese, 25, 55);
			}
			else if(this.chinese == "\u767C")
			{
				g.setColor(Color.green);
				g.drawString(this.chinese, 25, 55);
			}
			else
			{
				Font f2 = g.getFont().deriveFont(25F);
				g.setFont(f2);
				g.drawString(this.chinese, 35, 30);
			}
		}
		
		if(this.chinese != "\u5317" && this.chinese != "\u6771" && this.chinese != "\u897F" && this.chinese != "\u5357" && this.chinese != "\u4E2D" && this.chinese != "\u767C")
		{
			g.setColor(Color.red);
			g.drawString(this.wan, 35, 60);
		}
		
			
		
		
		/*Graphics2D g2 = (Graphics2D)g;
		g2.drawPolygon(xPoints, yPoints, 16);
		Color c1 = Color.blue;
		Color c2 = Color.lightGray;
		GradientPaint gradient = new GradientPaint(20,20,c1,80,80,c2,true);
		g2.setPaint(gradient);
		g2.fillPolygon(xFill, yFill, 7);*/
	}
	
	
	public static void main(String[] args)
	{
		JFrame		frame = new JFrame();
		JPanel		tiles = new JPanel();
		JScrollPane	scroller = new JScrollPane(tiles);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");
		frame.add(scroller);

		// Try something like this if your tiles don't fit on the screen.
		// Replace "tile width" and "tile height" with your values.
		//scroller.setPreferredSize(new Dimension(8 * tile width, 40 + tile height));

		tiles.add(new CharacterTile('1'));
		tiles.add(new CharacterTile('2'));
		tiles.add(new CharacterTile('3'));
		tiles.add(new CharacterTile('4'));
		tiles.add(new CharacterTile('5'));
		tiles.add(new CharacterTile('6'));
		tiles.add(new CharacterTile('7'));
		tiles.add(new CharacterTile('8'));
		tiles.add(new CharacterTile('9'));
		tiles.add(new CharacterTile('N'));
		tiles.add(new CharacterTile('E'));
		tiles.add(new CharacterTile('W'));
		tiles.add(new CharacterTile('S'));
		tiles.add(new CharacterTile('C'));
		tiles.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
	
}
