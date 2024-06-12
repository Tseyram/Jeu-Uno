package com.eyram.uno.cards;

import com.eyram.uno.Game;

import java.util.ArrayList;
import java.util.Objects;

public class NormalCard extends Card {

    public NormalCard(String name, String color, boolean effect) {
        super(name, color, effect);
    }

    @Override
    public ArrayList<Card> request() {
        ArrayList<Card> requesList = new ArrayList<>();
        for (Card card : Game.allCards) {
            if (Objects.equals(card.getName(), this.getName())) {
                requesList.add(card);
            } else if (Objects.equals(card.getColor(), this.getColor())) {
                requesList.add(card);
            }

        }
        return requesList;
    }

}
