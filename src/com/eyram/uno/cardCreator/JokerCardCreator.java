package com.eyram.uno.cardCreator;

import com.eyram.uno.cards.Card;
import com.eyram.uno.cards.JokerCard;

public class JokerCardCreator extends CardCreatorClass {
    public JokerCardCreator(CardCreatorClass suivant) {
        super(suivant);

    }

    @Override
    protected Card createCard1(String[] cardInfo) {
        if (cardInfo[0].equals("joker")) {
            Card newCard = new JokerCard(cardInfo[0], cardInfo[1], true);
            return newCard;
        }
        return null;
    }

}
