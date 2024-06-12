package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.Talon;

public abstract class PlayerChoiceClass implements PlayerChoice {

    protected PlayerChoiceClass suivant;

    public PlayerChoiceClass(PlayerChoiceClass suivant) {
        this.suivant = suivant;
    }

    @Override
    public void apply(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {

        boolean ItIsMyExpertise = isMyExpertise(choiceOfPlayer, currentPlayer, talonOfGame);
        if (ItIsMyExpertise)
            apply1(choiceOfPlayer, currentPlayer, piocheOfGame, talonOfGame);
        else if (this.suivant != null)
            this.suivant.apply(choiceOfPlayer, currentPlayer, piocheOfGame, talonOfGame);
        else
            System.out.println("Votre choix ne peux pas être traité");

    }

    public abstract boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame);

    public abstract void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame);
}
