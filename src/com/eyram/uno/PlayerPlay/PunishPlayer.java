package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.Talon;

public class PunishPlayer extends PlayerChoiceClass {

    public PunishPlayer(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        return choiceOfPlayer!=0 && !currentPlayer.getSetOfCards().get(choiceOfPlayer - 1).getName()
                .equals(talonOfGame.getLastCardOfTalon().getName())
                && !currentPlayer.getSetOfCards().get(choiceOfPlayer - 1).getColor()
                .equals(talonOfGame.getLastCardOfTalon()
                        .getColor());
    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {
        currentPlayer.pick(piocheOfGame, 2);
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() + 2);
    }

}
