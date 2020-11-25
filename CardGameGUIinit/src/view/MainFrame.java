package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class MainFrame extends JFrame 
{
	
	private GameEngine gameEngine;
	private Toolbar toolBar;
	private FileMenu fileMenu;
	private SummaryPanel summary;
	private StatusBar statusBar;
	private CardPanel cardPanel;	
	
	public MainFrame(GameEngine gameEngine)
	{
		this.setLayout(new BorderLayout());
		this.gameEngine = gameEngine;
		
		
		this.summary = new SummaryPanel(gameEngine);
		this.statusBar = new StatusBar(gameEngine);
		this.toolBar = new Toolbar(gameEngine, this.statusBar, this.summary);
		this.fileMenu = new FileMenu(gameEngine, this.toolBar, this.summary);
		this.cardPanel = new CardPanel(gameEngine);
				
		JPanel topOfFrame = new JPanel(new BorderLayout());
		topOfFrame.add(fileMenu, BorderLayout.NORTH);
		topOfFrame.add(toolBar, BorderLayout.CENTER);
		topOfFrame.add(cardPanel, BorderLayout.SOUTH);
		
		add(topOfFrame, BorderLayout.NORTH);
		add(this.summary, BorderLayout.CENTER);
		add(this.statusBar, BorderLayout.SOUTH);
		
		this.setSize(900,720);
		this.setVisible(true);
	}

}
