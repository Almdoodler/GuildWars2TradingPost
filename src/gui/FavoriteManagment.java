package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FavoriteManagment extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel;
	private JPanel gridPanel;
	private JButton confirmButton;
	private JButton newFavoriteList;
	private JButton cancelButton;
	private JLabel label1;
	
	protected FavoriteManagment(){
		frame = new JFrame("Favoriten bearbeiten");
		confirmButton = new JButton("Bestätigen");
		cancelButton =new JButton("Abbrechen");
		panel = new JPanel();
		gridPanel = new JPanel();
		
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		panel.setLayout(new BorderLayout());
		gridPanel.setLayout(new GridLayout());
		
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();	
			}
			
		});
		
		confirmButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
			
		});
		
		gridPanel.add(confirmButton);
		gridPanel.add(cancelButton);
		panel.add(gridPanel, BorderLayout.SOUTH);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void main (String args[]){
		new FavoriteManagment();
	}

}
