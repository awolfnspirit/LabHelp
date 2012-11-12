import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * class MCalendar prints a calendar of the current month (taken from the computer's clock).
 * Opens a new window and prints each day as a text field placed inside of a GridBagLayout.
 * The current day (from the computer's clock) is painted red.
 */


public class MCalendar extends JFrame
{
	private GridBagLayout			calendar = new GridBagLayout();
	private GridBagConstraints		constraints = new GridBagConstraints();
	private	Border				border = BorderFactory.createRaisedSoftBevelBorder();
	private	static GregorianCalendar	now = new GregorianCalendar();


	public MCalendar()
	{
		this(now.get(Calendar.MONTH), now.get(Calendar.YEAR));
	}


	public MCalendar(int month)
	{
		this(month, now.get(Calendar.YEAR));
	}


	public MCalendar(int month, int year)
	{
		setTitle("Monthly Calendar");
		setSize(300, 300);

		addWindowListener ( new WindowAdapter()		// WindowListener handler
		{	public void windowClosing(WindowEvent e)
			{ System.exit(0); }
		} );


		setLayout(calendar);				// sets a Gridbag Layout manager


		// sets both the width and heigth of all objects to that
		// of the widest and the heighest displayed object

		constraints.fill = GridBagConstraints.BOTH;


		printHeader(month, year);
		paintDays();
		paintMonth(month, year);

		setVisible(true);
	}


	private void addComponent(Component c, int row, int col)
	{
		addComponent(c, row, col, 1, 1);
	}


	private void addComponent(Component c, int row, int col, int height, int width)
	{
		constraints.gridx = col;
		constraints.gridy = row;
		constraints.gridheight = height;
		constraints.gridwidth = width;
		calendar.setConstraints(c, constraints);
		add(c);
	}



	// Creates a JLabel object that has the month and year and is 7
	// columns wide.  The JLabel is placed in a JPanel, which is constrained
	// to 0,0 in the GridBagLayout.  A raised beveled border is put around the JPanel.

	private void printHeader(int month, int year)
	{
		String monthName[] = { "January",   "February",  "March",
					"April",    "May",       "June",
					"July",     "August",    "September",
					"October",  "November",  "December"
			 	     };

		JPanel header = new JPanel();
		header.add(new JLabel(monthName[month] + ", " + year, JLabel.CENTER));
		header.setBorder(border);

		addComponent(header, 0, 0, 1, 7);
	}



	// Seven JLabel objects are created; each holds one day of the week.
	// Each JLabel is put in a JPanel, which has a raised beveled border.
	// Each JPanel is constrained to be at 1,0 through 1,6 and is added to
	// the GridBagLayout.

	private void paintDays()
	{
		String dayNames[] = {"Su", "Mo", "Tu", "We", "Th", "Fi", "Sa"};
		for (int i = 0; i < 7; i++)
		{
			JPanel	day = new JPanel();
			day.add(new JLabel(dayNames[i], JLabel.RIGHT));
			day.setBorder(border);
			addComponent(day, 1, i);
		}
	}



	// One JLabel object is created for each day in the month.  Each JLabel is
	// placed in a JPanel.  The JPanel object corresponding to the
	// current date is highlighted (the background color is set to red
	// and the foreground color is set to white) if displaying the current month and year.
	// "day" is the day of the week on which the month begins.
	// Each JPane object is constrained at a location (row and column)
	// beginning at 2,day; the column "col" is incremented until it becomes
	// 7, at which time it is reset to 0 and the row "row" is incremented.

	private void paintMonth(int month, int year)
	{
		int			mon_len[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		GregorianCalendar	firstday = new GregorianCalendar(year, month, 1); // 1st day of the month
		int			date = 0;
		int			day = firstday.get(Calendar.DAY_OF_WEEK);
		int			row = 2;
		int			col = day-1;


		if (firstday.isLeapYear(year))				// pretty obvious
			mon_len[1]++;

		if (now.get(Calendar.YEAR) == year && now.get(Calendar.MONTH) == month)
			date = now.get(Calendar.DATE);

		for (int k = 1; k < day; k++)				// blanks before first day of month
		{
			JPanel blank = new JPanel();
			blank.setBorder(border);
			addComponent(blank, row, k-1);
		}

		for (int k = 0; k < mon_len[month]; k++)
		{
			JPanel dayLabel = new JPanel();
			dayLabel.setBorder(border);

			if (date > 0 && k+1 == date)
			{
				dayLabel.setBackground(Color.RED);
				dayLabel.setForeground(Color.WHITE);
			}

			dayLabel.add(new JLabel((k+1) + "", JLabel.RIGHT));
			addComponent(dayLabel, row, col++);

			if (col == 7)
			{
				col = 0;
				row++;
			}
		}

		for (int k = col; k < 7; k++)				// blanks after last day of month
		{
			JPanel blank = new JPanel();
			blank.setBorder(border);
			addComponent(blank, row, k);
		}
	}


	public static void main(String[] args)
	{
		switch(args.length)
		{
			case 0 : new MCalendar();
				 break;
			case 1 : new MCalendar(Integer.parseInt(args[0]));
				 break;
			case 2 : new MCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				 break;
			default: System.err.println("USAGE: java MCalendar [ month [ year ] ]");
				 break;
		}
	}
}

