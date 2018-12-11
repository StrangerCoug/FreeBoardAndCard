/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecardandboard.objs;

import freecardandboard.enums.CardRank;
import freecardandboard.enums.CardSuit;
import java.util.Objects;

/**
 *
 * @author StrangerCoug <strangercoug@hotmail.com>
 */
public class Card implements Comparable<Card> {
    private final CardRank rank;
    private final CardSuit suit;
    
    private final String[] rankNames = {"Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace",
        "Joker"};
    private final String[] suitNames = {"Clubs", "Diamonds", "Hearts", "Spades",
        "Black", "Red"};
    
    /**
     * Sole constructor.
     * 
     * @param rank  the card's rank
     * @param suit  the card's suit
     */
    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public CardRank getRank() {
        return rank;
    }
    
    public CardSuit getSuit() {
        return suit;
    }

    /**
     * Checks whether this card outranks the card in the argument. This method,
     * unlike {@code compareTo(Card o)}, ignores suit, eliminating some of the
     * overhead from the {@code compareTo(Card o)} method.
     * 
     * @param other  the card to be compared to
     * @return true if the object card is higher in rank than the argument card,
     * false otherwise
     */
    public boolean outranks(Card other) {
        if (other == null)
            throw new NullPointerException();
        
        return this.rank.ordinal() > other.getRank().ordinal();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.rank);
        hash = 59 * hash + Objects.hashCode(this.suit);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        
        if (getClass() != obj.getClass())
            return false;
        
        final Card other = (Card) obj;
        
        return this.rank == other.getRank() && this.suit == other.getSuit();
    }
    
    /**
     * This function is intended for sorting purposes. For simply determining if
     * one card is higher in rank than another, {@code outranks(Card other)}
     * should be called instead as this method also takes suits into account.
     * <p>
     * For the purposes of this method, if two cards are of different suits,
     * then the card of the suit listed second in {@code CardSuit} is the
     * higher card. If two cards have the same suit, then this card is
     * higher than the card in the argument if {@code outranks(Card other)}
     * would return true.
     * 
     * @param other  the card to be compared to
     * @return a positive number if this card is higher than the card in the
     * argument, a negative number if this card is lower than the card in the
     * argument, and 0 if the two cards are identical
     */
    @Override
    public int compareTo(Card other) {
        if (other == null)
            throw new NullPointerException();
        
        return (this.suit.ordinal() * CardRank.values().length +
                this.rank.ordinal()) - (other.getSuit().ordinal() *
                CardRank.values().length + other.getRank().ordinal());
    }
    
    @Override
    public String toString() {
        if (rank == CardRank.JOKER)
            return suitNames[suit.ordinal()] + rankNames[rank.ordinal()];
        
        return rankNames[rank.ordinal()] + " of " + suitNames[suit.ordinal()];
    }
}
