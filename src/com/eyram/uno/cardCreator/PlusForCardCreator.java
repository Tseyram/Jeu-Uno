package com.eyram.uno.cardCreator;

import com.eyram.uno.cards.Card;
import com.eyram.uno.cards.PlusForCard;

public class PlusForCardCreator extends CardCreatorClass {
    public PlusForCardCreator(CardCreatorClass suivant) {
        super(suivant);

    }

    @Override
    protected Card createCard1(String[] cardInfo) {
        // System.out.println("Je suis dans le parseur de plus 4-----------------");
        if (cardInfo[0].equals("plusFor")) {
            Card newCard = new PlusForCard(cardInfo[0], cardInfo[1], true);
            return newCard;
        }
        return null;
    }

}
