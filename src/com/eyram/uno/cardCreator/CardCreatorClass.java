package com.eyram.uno.cardCreator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.eyram.uno.cards.Card;
import com.eyram.uno.Game;

public abstract class CardCreatorClass implements CardCreator {

    protected CardCreatorClass suivant;

    public CardCreatorClass(CardCreatorClass suivant) {
        this.suivant = suivant;
    }

    public Card createCard(String[] cardInfo) throws Exception {
        Card newCard = createCard1(cardInfo);
        if (newCard != null) {
            return newCard;

        } else if (this.suivant != null)
            return this.suivant.createCard(cardInfo);
        else
            // throw new Exception("I can't parse this card = (" + cardInfo[0] + ", " +
            // cardInfo[1] + ")");
            return null;

    }

    protected abstract Card createCard1(String[] cardInfo) throws Exception;

    @Override
    public ArrayList<Card> parseTxtFormatOscar(String filePath) {
        ArrayList<Card> cards = new ArrayList<Card>();

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                String[] line = fileReader.readLine().split(" ");

                Card newCard = createCard(line);
                if (newCard != null) {
                    // System.out.println("Je n'ai pas pu parser cette ligne = " + line[0] + " -- "
                    // + line[1]);
                    cards.add(newCard);
                    Game.setOfColorsOfGame.add(newCard.getColor());
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return cards;
    }

}
