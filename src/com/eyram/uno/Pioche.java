package com.eyram.uno;

import com.eyram.uno.cards.Card;

import java.util.ArrayList;

public class Pioche {
    // private int numberOfCardsInPioche;
    private ArrayList<Card> setOfCardsOfPioche = new ArrayList<>();

    public Pioche(ArrayList<Card> setOfCardOfPioche) {
        setSetOfCardsOfPioche(setOfCardsOfPioche);
    }

    public ArrayList<Card> getSetOfCardsOfPioche() {
        return setOfCardsOfPioche;
    }

    public void setSetOfCardsOfPioche(ArrayList<Card> setOfCardsOfPioche) {
        this.setOfCardsOfPioche = setOfCardsOfPioche;
    }

    public void addCard(Card cardToAdd) {
        if (cardToAdd == null) {
            throw new IllegalArgumentException(" aucune carte à ajouter");
        } else
            getSetOfCardsOfPioche().add(cardToAdd);
    }

    public Card removeCard(int indexOfCardToRemove) {
        if (indexOfCardToRemove < 0 && indexOfCardToRemove >= setOfCardsOfPioche.size()) {
            throw new IllegalArgumentException(" aucune carte à enlever");
        } else
            return getSetOfCardsOfPioche().remove(indexOfCardToRemove);
    }

    // public int getNumberOfCardsInPioche() {
    // return numberOfCardsInPioche;
    // }

    @Override
    public String toString() {
        return "Pioche [setofCardsOfPioche=" + setOfCardsOfPioche + "]";
    }

    // public void setNumberOfCardsInPioche(int numberOfCardsInPioche) {
    // this.numberOfCardsInPioche = getSetofCardOfPioche().size();
    // }

}
