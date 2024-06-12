package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.cards.PlusForCard;
import com.eyram.uno.Talon;

public class PickForCards extends PlayerChoiceClass {

    public PickForCards(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        if (talonOfGame.getLastCardOfTalon() instanceof PlusForCard) {
            return talonOfGame.getLastCardOfTalon().isEffect();
        }

        return false;
    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {

        currentPlayer.pick(piocheOfGame, 4);
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() + 4);
        System.out.println("le player " + currentPlayer.getName() + " a pioché 4 cartes");

        talonOfGame.getLastCardOfTalon().setEffect(false);

    }

}
