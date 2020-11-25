package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
//import view.PlayerGUI;
import view.SummaryPanel;
import view.Toolbar;

public class RemovePlayerListener implements ActionListener 
{

	private GameEngine gameEngine;
	private Toolbar toolBar;
	private SummaryPanel summary;
	
	public RemovePlayerListener(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summary = summary;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		try 
		{
			//get number of index that is selected on JComboBox
			//remove from JComboBox
			int selectedIndex = toolBar.getPlayerJComboBox().getSelectedIndex();
			JComboBox<String> players = toolBar.getPlayerJComboBox();
			players.removeItemAt(selectedIndex);
			this.toolBar.setJCB(players);

			int count = 0;
			Player playerToRemove = null;

			for (Player player : this.gameEngine.getAllPlayers())
			{
				//once playerToRemove is set, break out of loop
				if (count > selectedIndex) break;

				//gameEngine and JComboBox will have same order
				//set playerToRemove as index selected in JComboBox
				if (count == selectedIndex)
				{
					playerToRemove = player;
				}

				count++;
			}
			
			//remove player from gameEngine
			if(playerToRemove != null)
			{
				this.gameEngine.removePlayer(playerToRemove);
			}

			//refresh summary panel to account for removal 
			summary.setTextArea();
			
		}
		catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "No players to remove!", "Error!", JOptionPane.ERROR_MESSAGE);
		}

		
	}

}
