package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;
import view.Toolbar;

public class JCBListener implements ActionListener
{
	private GameEngine gameEngine;
	private Toolbar toolBar;
	private StatusBar statusBar;
	
	public JCBListener(GameEngine gameEngine, Toolbar toolBar, StatusBar statusBar)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.statusBar = statusBar;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String nameSelected = (String) this.toolBar.getPlayerJComboBox().getSelectedItem();
		this.statusBar.setCurrentPlayer(nameSelected);

		String idSelected = nameSelected.substring(0, nameSelected.indexOf(","));

		//when you refresh JComboBox and click on a player, if they made a valid bet, deal will be active
		for (Player player : gameEngine.getAllPlayers())
		{
			if (player.getPlayerId().equals(idSelected))
			{
				if (player.getBet() > 0)
				{
					this.toolBar.setDealEnabled(true);
				}
				else
				{
					this.toolBar.setDealEnabled(false);
				}
			}
		}

	}


}
