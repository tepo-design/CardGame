package model;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.PlayingCard;
import view.interfaces.GameEngineCallback;

import java.util.*;

public class GameEngineImpl implements GameEngine {
	private List<Player> listOfPlayers = new LinkedList<>();
	private List<GameEngineCallback> listOfGECallbacks = new LinkedList<>();

	public GameEngineImpl() {

	}

	@Override
	public void dealPlayer(Player player, int delay) throws IllegalArgumentException {
		// Set starter points for the round as 0, incremented by variable score each
		// card
		int points = 0;
		Deque<PlayingCard> deck = this.getShuffledHalfDeck();
		PlayingCard cardDealt;
		int score = 0;

		while (points <= BUST_LEVEL) {

			try {

				if (delay < 0) {
					throw new IllegalArgumentException("invalid delay");
				}

				Thread.sleep(delay);

			} catch (InterruptedException e) {
				break;
			}

			try {
				// Deal first card off the top of the deck
				cardDealt = deck.getFirst();
			}

			catch (NoSuchElementException e) {
				deck = this.getShuffledHalfDeck();
				cardDealt = deck.getFirst();
			}

			for (GameEngineCallback cb : listOfGECallbacks) {
				cb.nextCard(player, cardDealt, this);
			}

			score = cardDealt.getScore();
			points += score;

			if (points > 42) {
				for (GameEngineCallback currentTwo : listOfGECallbacks) {
					currentTwo.bustCard(player, cardDealt, this);
				}
			}

			deck.removeFirst();

		}

		// result of round before bust card
		int result = points - score;

		for (GameEngineCallback current : listOfGECallbacks) {
			current.result(player, result, this);
		}

		player.setResult(result);
	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
		int points = 0;
		Deque<PlayingCard> deck = this.getShuffledHalfDeck();
		PlayingCard cardDealt;
		int score = 0;

		while (points <= BUST_LEVEL) {
			try {
				if (delay < 0) {
					throw new IllegalArgumentException("invalid delay");
				}

				Thread.sleep(delay);
			} catch (InterruptedException e) {
				break;
			}

			try {
				cardDealt = deck.getFirst();
			} catch (NoSuchElementException e) {
				deck = this.getShuffledHalfDeck();
				cardDealt = deck.getFirst();
			}

			for (GameEngineCallback cb : listOfGECallbacks) {
				cb.nextHouseCard(cardDealt, this);
			}

			score = cardDealt.getScore();
			points += score;

			if (points > 42) {
				for (GameEngineCallback currentTwo : listOfGECallbacks) {
					currentTwo.houseBustCard(cardDealt, this);
				}
			}

			deck.removeFirst();

		}

		int result = points - score;

		for (Player current : listOfPlayers) {
			applyWinLoss(current, result);
		}

		for (GameEngineCallback current : listOfGECallbacks) {
			current.houseResult(result, this);
		}

		for (Player current : listOfPlayers) {
			current.resetBet();
		}
	}

	@Override
	public void applyWinLoss(Player player, int houseResult) {
		int bet = player.getBet();
		int points = player.getPoints();

		// If house beats player, subtract bet
		if (houseResult > player.getResult()) {
			player.setPoints(points - bet);
		}
		// If player beats house, add bet
		if (player.getResult() > houseResult) {
			player.setPoints(points + bet);
		}
	}

	@Override
	public void addPlayer(Player player) {
		// If current playerId exists in the list, remove that player and replace with
		// new player
		listOfPlayers.removeIf(current -> player.getPlayerId().equals(current.getPlayerId()));
		listOfPlayers.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		// Iterate through player list to find player with id parameter
		for (Player current : this.listOfPlayers) {
			if (id.equals(current.getPlayerId())) {
				return current;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		return listOfPlayers.remove(player);
	}

	@Override
	public boolean placeBet(Player player, int bet) {

		if (player.setBet(bet)) {
			return true;
		}

		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		listOfGECallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return listOfGECallbacks.remove(gameEngineCallback);
	}

	@Override
	public List<Player> getAllPlayers() {

		Collections.sort(listOfPlayers);

		return Collections.unmodifiableList(listOfPlayers);
	}

	@Override
	public Deque<PlayingCard> getShuffledHalfDeck() {
		// Implement as linkedlist first to be able to use shuffle feature
		LinkedList<PlayingCard> deck = new LinkedList<>();

		for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
			for (PlayingCard.Value value : PlayingCard.Value.values()) {
				deck.add(new PlayingCardImpl(suit, value));
			}
		}

		Collections.shuffle(deck);

		return deck;
	}
}
