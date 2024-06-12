package com.eyram.uno;

import com.eyram.uno.cards.Card;

import java.util.ArrayList;

public class Talon {
    private ArrayList<Card> setOfCardsOfTalon = new ArrayList<>();

    public Talon(ArrayList<Card> setOfCardsOfTalon) {
        setSetOfCardsOfTalon(setOfCardsOfTalon);
    }

    public ArrayList<Card> getSetOfCardsOfTalon() {
        return setOfCardsOfTalon;
    }

    public void setSetOfCardsOfTalon(ArrayList<Card> setOfCardsOfTalon) {
        this.setOfCardsOfTalon = setOfCardsOfTalon;
    }

    public void addCard(Card cardToAdd) {
        if (cardToAdd == null) {
            throw new IllegalArgumentException(" aucune carte à ajouter");
        } else
            setOfCardsOfTalon.add(cardToAdd);
    }

    public Card removeCard(int indexOfCardToRemove) {
        if (indexOfCardToRemove < 0 && indexOfCardToRemove >= setOfCardsOfTalon.size()) {
            throw new IllegalArgumentException(" aucune carte à enlever");
        } else
            return getSetOfCardsOfTalon().remove(indexOfCardToRemove);
    }

    public Card getLastCardOfTalon() {
        int sizeOfTalon = setOfCardsOfTalon.size();
        Card lastCardOfTalon = setOfCardsOfTalon.get(sizeOfTalon - 1);
        return lastCardOfTalon;
    }

    @Override
    public String toString() {
        return "Talon [setOfCardsOfTalon=" + setOfCardsOfTalon + "]";
    }
}
