package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.cards.PlusTwoCard;
import com.eyram.uno.Talon;

public class PickTwoCards extends PlayerChoiceClass {

    public PickTwoCards(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        return talonOfGame.getLastCardOfTalon().isEffect()
                && talonOfGame.getLastCardOfTalon() instanceof PlusTwoCard;

    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {

        currentPlayer.pick(piocheOfGame, 2);
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() + 2);
        System.out.println("le player " + currentPlayer.getName() + " a pioché 2 cartes");

        talonOfGame.getLastCardOfTalon().setEffect(false);

    }

}
