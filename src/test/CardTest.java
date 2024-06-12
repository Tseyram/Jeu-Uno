package test;

import com.eyram.uno.cards.NormalCard;

public class CardTest {
    public static void run() {
        /*
         * créer un carte,
         * tester la methode equals
         * tester les setters, les guetters
         */
        NormalCard newCard = new NormalCard("0", "red", true);
        System.out.println(newCard.toString());

    }
}