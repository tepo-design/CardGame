package client;

import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.MainFrame;

public class A2TestClient 
{

	public static void main(String[] args) {

		GameEngine gameEngine = new GameEngineImpl();

		SwingUtilities.invokeLater(new Runnable() 
		{

			@Override
			public void run() {
				new MainFrame(gameEngine);
			}
		});
	}

}
