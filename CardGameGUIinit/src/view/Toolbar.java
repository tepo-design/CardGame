package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;
import controller.BetListener;
import controller.DealButtonListener;
import controller.JCBListener;
import controller.ResetBetListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class Toolbar extends JToolBar 
{

	private GameEngine gameEngine;
	private StatusBar statusBar;
	private SummaryPanel summary;
	
	private JButton deal = new JButton("Deal");
	private JButton placeBet = new JButton("Bet");
	private JButton resetBet = new JButton("Reset bet");
	private JComboBox<String> playerDropDown = new JComboBox<String>();
	
	public Toolbar(GameEngine gameEngine, StatusBar statusBar, SummaryPanel summary)
	{
		this.gameEngine = gameEngine;
		this.statusBar = statusBar;
		this.summary = summary;
		
		this.setLayout(new GridLayout());
		
		this.add(placeBet);
		this.add(resetBet);
		this.add(deal);
		this.add(playerDropDown);
		deal.setEnabled(false);
		playerDropDown.addActionListener(new JCBListener(gameEngine, this, statusBar));
		placeBet.addActionListener(new BetListener(gameEngine, this, summary));
		resetBet.addActionListener(new ResetBetListener(gameEngine, this, summary));
		deal.addActionListener(new DealButtonListener(gameEngine, this, summary));	
	}


	public JComboBox<String> getPlayerJComboBox()
	{
		return playerDropDown;
	}
	
	public void setJCB(JComboBox<String> players)
	{
		this.playerDropDown = players;
	}
	
	public void setDealEnabled(boolean state)
	{
		deal.setEnabled(state);
	}
	
}

