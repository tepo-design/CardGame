package model;

import model.interfaces.Player;

public class SimplePlayer implements Player
{

    private String id;
    private String playerName;
    private int initialPoints;
    private int betValue;
    private int result;

    public SimplePlayer(String id, String playerName, int initialPoints)
    {
        this.id = id;
        this.playerName = playerName;
        this.initialPoints = initialPoints;
    }

    @Override
    public String getPlayerName()
    {
        return playerName;
    }

    @Override
    public void setPlayerName(String playerName)
    {
        this.playerName = playerName;
    }

    @Override
    public int getPoints()
    {
        return initialPoints;
    }

    @Override
    public void setPoints(int points)
    {
        this.initialPoints = points;
    }

    @Override
    public String getPlayerId()
    {
        return this.id;
    }

    @Override
    public boolean setBet(int bet)
    {
        //Ensure there is enough funds in initial bets to place desired bet

        if ((bet >= 1) && (bet <= this.initialPoints))
        {
            this.betValue = bet;
            return true;
        }

        return false;
    }

    @Override
    public int getBet()
    {
        return betValue;
    }

    @Override
    public void resetBet()
    {
        betValue = 0;
    }

    @Override
    public int getResult()
    {
        return result;
    }

    @Override
    public void setResult(int result)
    {
        this.result = result;
    }

    @Override
    public boolean equals(Player player)
    {
        return player == null ? false : this.id.equals(player.getPlayerId());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Player))
        {
            return false;
        }

        return this == obj || equals((Player) obj);
    }

    @Override
    public int hashCode()
    {
        return this.id.hashCode();
    }

    @Override
    public int compareTo(Player player)
    {
        return this.id.compareTo(player.getPlayerId());
    }

    @Override
    public String toString()
    {
        return String.format("Player: id = %s, name = %s, bet = %s, points = %s, RESULT .. %s", id, playerName, betValue, initialPoints, result);
    }
}


