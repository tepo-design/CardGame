package view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.interfaces.GameEngine;
import model.interfaces.Player;


@SuppressWarnings("serial")
public class SummaryPanel extends JTextArea {

    private JTextArea textArea;
    private GameEngine gameEngine;

    public SummaryPanel(GameEngine gameEngine) 
    {        
    	this.gameEngine = gameEngine;
    	
        setLayout(new GridLayout(1,1));
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(50, 100));
        
        add(scrollPane);
        scrollPane.setVisible(true);
       
    }
    
    
    //method used in multiple classes to reset summary panel when changes occur
    public JTextArea setTextArea() 
    {
    	String playerInfo = " ";
	
		for (Player p : gameEngine.getAllPlayers())
		{
			playerInfo += p.toString() + "\n";
		}
		
    	textArea.setText(playerInfo);
        textArea.setVisible(true);
        this.revalidate();
		this.repaint();
		
        return this.textArea;
    }

}
