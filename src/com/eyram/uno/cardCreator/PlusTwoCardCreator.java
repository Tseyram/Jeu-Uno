package com.eyram.uno.cardCreator;

import com.eyram.uno.cards.Card;
import com.eyram.uno.cards.PlusTwoCard;

public class PlusTwoCardCreator extends CardCreatorClass {

    public PlusTwoCardCreator(CardCreatorClass suivant) {
        super(suivant);

    }

    @Override
    protected Card createCard1(String[] cardInfo) {
        if (cardInfo[0].equals("plusTwo")) {
            Card newCard = new PlusTwoCard(cardInfo[0], cardInfo[1], true);
            return newCard;
        }
        return null;
    }

}
