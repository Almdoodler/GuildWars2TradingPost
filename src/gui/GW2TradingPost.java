package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import main.Main;

public class GW2TradingPost extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnHeaders = {"ID", "Name"};
	private DefaultTableModel model = new DefaultTableModel( columnHeaders, 0 );
	JFrame frame;
	JPanel mainPanel;
	JScrollPane scrollPane;
	JMenuBar menuBarTop;
	JPanel statusPanel;
	
	JLabel statusLabel;
	JButton updateButton;
	JTable table;
	
	JMenu mainMenu;
	JMenu help;
	JMenuItem favListItem;
	JMenuItem save;
	JMenuItem saveAs;
	JMenuItem close;
	JMenuItem helpItem;
	JMenuItem properties;
	
	
	
	public GW2TradingPost(){
		frame = new JFrame("GW 2 Trading Post");
		mainPanel = new JPanel();
		statusPanel = new JPanel();
		menuBarTop = new JMenuBar();
		mainMenu = new JMenu("Datei");
		favListItem = new JMenuItem("Favouriten");
		help = new JMenu("Hilfe");
		save = new JMenuItem("Speichern");
		saveAs = new JMenuItem("Speichern als...");
		close = new JMenuItem("Beenden");
		statusLabel = new JLabel("Letzte Aktualisierung: XX:XX");
		helpItem = new JMenuItem("Hilfe");
		properties = new JMenuItem("Einstellungen");
		updateButton = new JButton("Aktualisiere Daten");
		table = new JTable(model);
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainPanel.setLayout(new BorderLayout());
		
		
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel.setLayout(new BorderLayout());
		statusPanel.setSize(mainPanel.getWidth(), 32);
		statusPanel.add(statusLabel, BorderLayout.EAST);
		statusPanel.add(updateButton, BorderLayout.WEST);
		
		table.setVisible(true);
		
		
		updateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main main= new Main();
				model = main.updateTable((DefaultTableModel)table.getModel());
				table.setModel(model);
				SimpleDateFormat format = new SimpleDateFormat("hh:mm");
				statusLabel.setText("Letzte Aktualsierung: " + format.format(new Date()));
			}
			
		});
		
		favListItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new FavoriteManagment();
			}
			
		});
		
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
			
		});
		
		help.add(helpItem);
		help.add(properties);
		
		mainMenu.add(save);
		mainMenu.add(saveAs);
		mainMenu.add(favListItem);
		mainMenu.addSeparator();
		mainMenu.add(close);
		
		menuBarTop.add(mainMenu);
		menuBarTop.add(help);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(statusPanel, BorderLayout.PAGE_END);
		mainPanel.add(menuBarTop, BorderLayout.PAGE_START);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		GW2TradingPost window = new GW2TradingPost();
	}

}
