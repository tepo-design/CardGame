package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.SummaryPanel;
import view.Toolbar;

public class AddPlayerListener implements ActionListener 
{
	
	private GameEngine gameEngine;
	private Toolbar toolBar;
	private SummaryPanel summary;
	private String playerName;
	private int id = 0;
	private String initialPoints;
	private int playerPoints;
	
	public AddPlayerListener(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summary = summary;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{

		this.playerName = JOptionPane.showInputDialog("Enter Player Name:");
		this.initialPoints = JOptionPane.showInputDialog("Enter your initial points:");
		
		if (checkForInteger(this.initialPoints))
		{
			gameEngine.addPlayer(new SimplePlayer(String.valueOf(id), this.playerName, this.playerPoints));

			toolBar.getPlayerJComboBox().addItem(this.id + ", Player Name: " + this.playerName);
			//refresh summary panel
			summary.setTextArea();

			id++;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Choose Add Player in the menu and try again!", "Please enter a number!", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	
	public boolean checkForInteger(String string)
	{
		try
		{
			this.playerPoints = Integer.parseInt(string);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
}
