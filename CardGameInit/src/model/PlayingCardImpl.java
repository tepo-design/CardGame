package model;

import model.interfaces.PlayingCard;

public class PlayingCardImpl implements PlayingCard {

    private Suit suit;
    private Value value;
    private int score;
    

    public PlayingCardImpl (Suit suit, Value value)
    {
        this.suit = suit;
        this.value = value;
       
    }

    @Override
    public Suit getSuit()
    {
        return suit;
    }

    @Override
    public Value getValue()
    {
        return value;
    }

    @Override
    public int getScore()
    {
    	int scoreOfCard = 0;
    	switch (value)
        {
            case EIGHT:
                scoreOfCard = 8;
                break;

            case NINE:
                scoreOfCard = 9;
                break;

            case TEN:

            case JACK:

            case QUEEN:

            case KING:
                scoreOfCard = 10;
                break;

            case ACE:
                scoreOfCard = 11;
                break;
        }
    	
        return scoreOfCard;
    }

    @Override
    public String toString()
    {
        return String.format("Suit: %s, Value: %s, Score: %s", this.suit, this.value, this.score);
    }

    @Override
    public boolean equals(PlayingCard card)
    {
        if (this.value == card.getValue() && this.suit == card.getSuit())
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof PlayingCard))
        {
            return false;
        }

        return this == obj || equals((PlayingCard) obj);
    }

    @Override
    public int hashCode()
    {
        return value.hashCode() + suit.hashCode();
    }


}
