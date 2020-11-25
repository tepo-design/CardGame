package view;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class CardPanel extends JPanel 
{
	private GameEngine gameEngine;
	
	public CardPanel(GameEngine gameEngine)
	{
		this.gameEngine = gameEngine;
	}
}
