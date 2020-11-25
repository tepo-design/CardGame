package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.SummaryPanel;
import view.Toolbar;

public class ResetBetListener implements ActionListener
{
	
	private GameEngine gameEngine;
	private Toolbar toolBar;
	private SummaryPanel summary;
	
	public ResetBetListener(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summary = summary;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//pull id of player selected from JComboBox
		String nameSelected = (String) this.toolBar.getPlayerJComboBox().getSelectedItem();
		String idSelected = nameSelected.substring(0, nameSelected.indexOf(","));
		
		for (Player player : this.gameEngine.getAllPlayers())
		{
			if (player.getPlayerId().equals(idSelected)) 
			{
				this.gameEngine.getPlayer(player.getPlayerId()).resetBet();
			}
		}
		
		summary.setTextArea();

	}

}
