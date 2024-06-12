package com.eyram.uno.PlayerPlay;

import com.eyram.uno.cards.NormalCard;
import com.eyram.uno.Pioche;
import com.eyram.uno.Player;

import com.eyram.uno.Talon;

public class GoodNamePlay extends PlayerChoiceClass {

    public GoodNamePlay(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        if (talonOfGame.getLastCardOfTalon().isEffect()
                || talonOfGame.getLastCardOfTalon() instanceof NormalCard) {
            return choiceOfPlayer!=0 && currentPlayer.getSetOfCards().get(choiceOfPlayer - 1).getName()
                    .equals(talonOfGame.getLastCardOfTalon().getName());
        }
        return false;
    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {
        talonOfGame.addCard(currentPlayer.removeCard(choiceOfPlayer - 1));
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() - 1);
        talonOfGame.getLastCardOfTalon().setEffect(false);
    }

}
