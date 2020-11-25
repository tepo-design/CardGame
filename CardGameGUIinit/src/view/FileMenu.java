package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AddPlayerListener;
import controller.RemovePlayerListener;
//import controller.AddPlayerMenuListener;
//import controller.RemovePlayerMenuListener;
//import model.ViewModel;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class FileMenu extends JMenuBar {

		
		private JMenuBar menuBar = new JMenuBar();
		private JMenu fileMenu = new JMenu("File");
		private JMenuItem addPlayer = new JMenuItem("Add Player");
		private JMenuItem removePlayer = new JMenuItem("Remove Player");
		private GameEngine gameEngine;
		private Toolbar toolBar;
		private SummaryPanel summary;
		
		public FileMenu(GameEngine gameEngine, Toolbar toolBar, SummaryPanel summary)
		{
			this.gameEngine = gameEngine;
			this.toolBar = toolBar;
			this.summary = summary;
						
			addPlayer.addActionListener(new AddPlayerListener(this.gameEngine, this.toolBar, this.summary));
			removePlayer.addActionListener(new RemovePlayerListener(this.gameEngine, this.toolBar, this.summary));
			
			fileMenu.add(addPlayer);
			fileMenu.add(removePlayer);
			menuBar.add(fileMenu);
			
			add(fileMenu);
		}
}
