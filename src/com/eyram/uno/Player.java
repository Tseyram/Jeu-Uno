package com.eyram.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.eyram.uno.PlayerPlay.ChangeColor;
import com.eyram.uno.PlayerPlay.GoodColorPlay;
import com.eyram.uno.PlayerPlay.GoodNamePlay;

import com.eyram.uno.PlayerPlay.PickForCards;
import com.eyram.uno.PlayerPlay.PickTwoCards;
import com.eyram.uno.PlayerPlay.PlayerChoice;
import com.eyram.uno.PlayerPlay.PlayerChoiceClass;
import com.eyram.uno.PlayerPlay.PunishPlayer;

import com.eyram.uno.PlayerPlay.ChoiceToPick;
import com.eyram.uno.cards.Card;

// import com.eyram.uno.cardCreator.CardCreator;

// import com.eyram.uno.cardCreator.JokerCardCreator;
// import com.eyram.uno.cardCreator.NormalCardCreator;
// import com.eyram.uno.cardCreator.PlusForCardCreator;
// import com.eyram.uno.cardCreator.PlusTwoCardCreator;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int numberOfCardsOfPlayer;

    public int getNumberOfCardsOfPlayer() {
        return numberOfCardsOfPlayer;
    }

    public void setNumberOfCardsOfPlayer(int numberOfCardsOfPlayer) {
        this.numberOfCardsOfPlayer = numberOfCardsOfPlayer;
    }

    // private int score;

    private ArrayList<Card> setOfCards = new ArrayList<Card>();

    public ArrayList<Card> getSetOfCards() {
        return setOfCards;
    }

    public void setSetOfCards(ArrayList<Card> setOfCards) {
        this.setOfCards = setOfCards;
    }

    public Player(String name, int numberOfCardByPlayers, ArrayList<Card> setOfCards) {
        setName(name);
        setNumberOfCardsOfPlayer(numberOfCardByPlayers);
        setSetOfCards(setOfCards);

        // this.score = score;

    }

    public void play(Pioche piocheOfGame, Talon talonOfGame) {
        System.out.println(
                "monsieur " + name + "   voici la dernière carte du talon:" + talonOfGame.getLastCardOfTalon());

        System.out.println("Voici vos cartes " + setOfCards.toString());
        System.out.println(
                "Entrer le numero de la carte que vous désirer jouer, (entrer 0 si vous préférez piquer une carte)...");

        Scanner choiceOfPlayer = new Scanner(System.in);

        int theChoiceOfPlayer = choiceOfPlayer.nextInt();
        // choiceOfPlayer.close();


        if (theChoiceOfPlayer >= 0 && theChoiceOfPlayer <= setOfCards.size()) {
            if(theChoiceOfPlayer > 0){
            System.out.println("vous avez joué la carte..." + setOfCards.get(theChoiceOfPlayer - 1));
            System.out.println("nom de la carte du talon..." + talonOfGame.getLastCardOfTalon().getName());
            System.out.println("nom choisi..." + setOfCards.get(theChoiceOfPlayer - 1).getName());
            System.out.println("couleur de la carte du talon..." + talonOfGame.getLastCardOfTalon().getColor());
            System.out.println("couleur choisie..." + setOfCards.get(theChoiceOfPlayer - 1).getColor());}

            PlayerChoice newPlayerChoice;

            PlayerChoiceClass newPunishPlayer = new PunishPlayer(null);
            PlayerChoiceClass newChoiceToPick = new ChoiceToPick(newPunishPlayer);
            PlayerChoiceClass newPickForCards = new PickForCards(newChoiceToPick);
            PlayerChoiceClass newPickTwoCards = new PickTwoCards(newPickForCards);
            PlayerChoiceClass newChangeColor = new ChangeColor(newPickTwoCards);
            PlayerChoiceClass newGoodColorPlay = new GoodColorPlay(newChangeColor);
            PlayerChoiceClass newGoodNamePlay = new GoodNamePlay(newGoodColorPlay);
            newPlayerChoice = newGoodNamePlay;

            newPlayerChoice.apply(theChoiceOfPlayer, this, piocheOfGame, talonOfGame);
            // s'il choisis un joker alors il peut decider de la couleur et déposer le joker
            // if (setOfCards.get(theChoiceOfPlayer - 1) instanceof JokerCard) {
            // colorChoice(Game.setOfColorsOfGame);
            // System.out.println("vous avez choisi la couleur " +
            // colorChoice(Game.setOfColorsOfGame));
            // talonOfGame.addCard(removeCard(theChoiceOfPlayer - 1));
            // numberOfCardsOfPlayer -= 1;
            // // si son choix est de meme nom que la carte du talon , il depose la carte
            // } else if (setOfCards.get(theChoiceOfPlayer - 1).getName()
            // .equals(talonOfGame.getLastCardOfTalon().getName())) {
            // talonOfGame.addCard(removeCard(theChoiceOfPlayer - 1));
            // numberOfCardsOfPlayer -= 1;
            // // si c'est de mem couleur aussi
            // } else if (setOfCards.get(theChoiceOfPlayer -
            // 1).getColor().equals(talonOfGame.getLastCardOfTalon()
            // .getColor())) {
            // if (setOfCards.get(theChoiceOfPlayer - 1) instanceof PlusForCard
            // || setOfCards.get(theChoiceOfPlayer - 1) instanceof PlusTwoCard) {
            // Game.setEffectOfLastCard(true);
            // }
            // talonOfGame.addCard(removeCard(theChoiceOfPlayer - 1));
            // numberOfCardsOfPlayer -= 1;
            // } else {// sinn il est puni
            // pick(piocheOfGame, 1);
            // System.out.println("vous avez été puni");
            // }

        } else {// s'il ne choisis pas un bon umero il recommence
            throw new IllegalArgumentException(" recommencer svp");
        }
        // choiceOfPlayer.close();

    }

    public void pick(Pioche pioche, int numberOfCardsToPick) {
        for (int i = 1; i <= numberOfCardsToPick; i++) {
            this.addCard(pioche.removeCard(pioche.getSetOfCardsOfPioche().size() - 1));
            numberOfCardsOfPlayer += numberOfCardsToPick;
        }

    }

    public String colorChoice(ArrayList<String> setOfColorsOfGame) {
        Collections.shuffle(Game.setOfColorsOfGame);
        return Game.setOfColorsOfGame.get(0);
    }

    public void addCard(Card cardToAdd) {
        if (cardToAdd == null) {
            throw new IllegalArgumentException(" aucune carte à ajouter");
        } else
            setOfCards.add(cardToAdd);
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", numberOfCardsOfPlayer=" + numberOfCardsOfPlayer + ", setOfCards="
                + setOfCards + "]";
    }

    public Card removeCard(int indexOfCardToRemove) {
        if (indexOfCardToRemove < 0 && indexOfCardToRemove >= setOfCards.size()) {
            throw new IllegalArgumentException(" aucune carte à enlever");
        } else
            return setOfCards.remove(indexOfCardToRemove);
    }
    // public int setScore() {
    // if (Player.getNumberOfCardsOfPlayer() == 0) {
    // this.score += 1;
    // }
    // return this.score;
}
