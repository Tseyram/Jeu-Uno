package com.eyram.uno.cardCreator;

import java.util.ArrayList;

import com.eyram.uno.cards.Card;

public interface CardCreator {

    public Card createCard(String[] cardInfo) throws Exception;

    public ArrayList<Card> parseTxtFormatOscar(String filePath) throws Exception;

}
