package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.Talon;
import com.eyram.uno.cards.JokerCard;
import com.eyram.uno.cards.NormalCard;

public class ChoiceToPick extends PlayerChoiceClass {

    public ChoiceToPick(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        return choiceOfPlayer == 0 &&
                (!talonOfGame.getLastCardOfTalon().isEffect()
                        || (talonOfGame.getLastCardOfTalon() instanceof NormalCard
                || talonOfGame.getLastCardOfTalon() instanceof JokerCard));
    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {
        currentPlayer.pick(piocheOfGame, 1);
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() + 1);

    }

}
