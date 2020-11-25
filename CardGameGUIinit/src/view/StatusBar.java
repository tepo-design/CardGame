package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

//import model.ViewModel;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class StatusBar extends JPanel 
{
	private JLabel currentPlayer = new JLabel();

	
	public StatusBar(GameEngine gameEngine) 
	{
		setLayout(new GridLayout(1,3));
		Border border = BorderFactory.createLineBorder(Color.BLACK);		
		currentPlayer.setBorder(border);
		currentPlayer.setText("No players exist in the game");
		add(currentPlayer);
	}
	
	public void setCurrentPlayer(String playerName)
	{
		this.currentPlayer.setText("Current Player Selected - Player ID: " + playerName);
	}
	
	
}

