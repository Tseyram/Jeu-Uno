package com.eyram.uno.cardCreator;

import com.eyram.uno.cards.Card;
import com.eyram.uno.cards.NormalCard;

public class NormalCardCreator extends CardCreatorClass {
    public NormalCardCreator(CardCreatorClass suivant) {
        super(suivant);

    }

    @Override
    protected Card createCard1(String[] cardInfo) {
        if (cardInfo[0].length() == 1) {
            Card newCard = new NormalCard(cardInfo[0], cardInfo[1], true);
            return newCard;
        }

        return null;
    }
}
