package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.SummaryPanel;
import view.Toolbar;

public class BetListener implements ActionListener
{

	private GameEngine gameEngine;
	private Toolbar toolBar;
	private SummaryPanel summary;
	private String stringBet;
	private int bet;

	public BetListener(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summary = summary;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.stringBet = JOptionPane.showInputDialog("Enter Bet:");
		
		if (checkForInteger(this.stringBet))
		{

			String nameSelected = (String) this.toolBar.getPlayerJComboBox().getSelectedItem();
			//pull player ID from the JComboBox
			String idSelected = nameSelected.substring(0, nameSelected.indexOf(","));

			for (Player player : this.gameEngine.getAllPlayers())
			{
				if (player.getPlayerId().equals(idSelected)) 
				{
					//check that bet is greater than 0 and player has enough points
					if (this.gameEngine.getPlayer(player.getPlayerId()).setBet(bet))
					{
						continue;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Make sure you have enough funds and you enter a positive number! Try again!", "Please enter a number!", JOptionPane.ERROR_MESSAGE);
					}

				}
			}
			//update summary panel to include bet
			summary.setTextArea();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Hit the bet button and try again!", "Please enter a number!", JOptionPane.ERROR_MESSAGE);
		}

	}

	public boolean checkForInteger(String string)
	{
		try
		{
			this.bet = Integer.parseInt(string);
			return true;
		}
		catch (NumberFormatException e)
		{
			return false;
		}

	}
	

}
