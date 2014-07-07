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
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;

public class GW2TradingPost extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame;
	JPanel mainPanel;
	JMenuBar menuBarTop;
	JPanel statusPanel;
	
	JLabel statusLabel;
	JButton updateButton;
	
	JMenu mainMenu;
	JMenu help;
	JMenu favListMenu;
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
		favListMenu = new JMenu("Favouriten");
		help = new JMenu("Hilfe");
		save = new JMenuItem("Speichern");
		saveAs = new JMenuItem("Speichern als...");
		close = new JMenuItem("Beenden");
		statusLabel = new JLabel("Letzte Aktualisierung: XX:XX:XX");
		helpItem = new JMenuItem("Hilfe");
		properties = new JMenuItem("Einstellungen");
		updateButton = new JButton("Aktualisiere Daten");
		
		frame.setSize(800, 600);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainPanel.setLayout(new BorderLayout());
		
		
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		statusPanel.setLayout(new BorderLayout());
		statusPanel.setSize(mainPanel.getWidth(), 32);
		statusPanel.add(statusLabel, BorderLayout.EAST);
		statusPanel.add(updateButton, BorderLayout.WEST);
		
		updateButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
				statusLabel.setText("Letzte Aktualsierung: " + format.format(new Date()));
			}
			
		});
		
		help.add(helpItem);
		help.add(properties);
		
		mainMenu.add(save);
		mainMenu.add(saveAs);
		mainMenu.addSeparator();
		mainMenu.add(close);
		
		menuBarTop.add(mainMenu);
		menuBarTop.add(favListMenu);
		menuBarTop.add(help);
		mainPanel.add(statusPanel, BorderLayout.PAGE_END);
		mainPanel.add(menuBarTop, BorderLayout.PAGE_START);
		frame.add(mainPanel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		GW2TradingPost window = new GW2TradingPost();
	}

}
