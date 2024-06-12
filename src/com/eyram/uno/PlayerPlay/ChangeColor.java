package com.eyram.uno.PlayerPlay;

import com.eyram.uno.Game;
import com.eyram.uno.cards.JokerCard;
import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.Talon;

public class ChangeColor extends PlayerChoiceClass {

    public ChangeColor(PlayerChoiceClass suivant) {
        super(suivant);

    }

    @Override
    public boolean isMyExpertise(int choiceOfPlayer, Player currentPlayer, Talon talonOfGame) {
        if ( talonOfGame.getLastCardOfTalon() instanceof JokerCard) {
            return talonOfGame.getLastCardOfTalon().isEffect();
        }
        return false;
    }

    @Override
    public void apply1(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame) {
        currentPlayer.colorChoice(Game.setOfColorsOfGame);
        System.out.println("la couleur choisie est la suivante : " + currentPlayer.colorChoice(Game.setOfColorsOfGame));
        talonOfGame.addCard(currentPlayer.removeCard(choiceOfPlayer - 1));
        currentPlayer.setNumberOfCardsOfPlayer(currentPlayer.getNumberOfCardsOfPlayer() - 1);
        talonOfGame.getLastCardOfTalon().setColor(currentPlayer.colorChoice(Game.setOfColorsOfGame));
        talonOfGame.getLastCardOfTalon().setEffect(false);
    }

}