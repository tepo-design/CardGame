package controller;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback 
{

	private GameEngineCallback gameEngine = new GameEngineCallbackImpl();
	
	@Override
	public void nextCard(Player player, PlayingCard card, GameEngine engine) 
	{
		gameEngine.nextCard(player, card, engine);
	}

	@Override
	public void bustCard(Player player, PlayingCard card, GameEngine engine) 
	{
		gameEngine.bustCard(player, card, engine);		
	}

	@Override
	public void result(Player player, int result, GameEngine engine) 
	{
		gameEngine.result(player, result, engine);		
	}

	@Override
	public void nextHouseCard(PlayingCard card, GameEngine engine) 
	{
		gameEngine.nextHouseCard(card, engine);				
	}

	@Override
	public void houseBustCard(PlayingCard card, GameEngine engine) 
	{
		gameEngine.houseBustCard(card, engine);		
	}

	@Override
	public void houseResult(int result, GameEngine engine) 
	{
		gameEngine.houseResult(result, engine);		
	}

}
