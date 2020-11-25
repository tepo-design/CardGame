package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.SummaryPanel;
import view.Toolbar;

public class DealButtonListener implements ActionListener
{
	
	private GameEngine gameEngine;
	private Toolbar toolBar;
	private SummaryPanel summary;
	
	public DealButtonListener(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summary = summary;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//pull the player id from the current JComboBox item that is selected
		String jcbSelected = (String) this.toolBar.getPlayerJComboBox().getSelectedItem();
		String idSelected = jcbSelected.substring(0, jcbSelected.indexOf(","));
		
		//deal the player that is currently selected in JComboBox
		for (Player player : this.gameEngine.getAllPlayers())
		{
			if (player.getPlayerId().equals(idSelected)) 
			{
				this.gameEngine.dealPlayer(player, 10);;
			}
		}
		
		//update result of deal
		this.summary.setTextArea();
	}

}
