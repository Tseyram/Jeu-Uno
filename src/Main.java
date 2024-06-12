// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import com.eyram.uno.Game;

public class Main {

    // public static ArrayList<NormalCard> sameColorCards = new ArrayList<>();
    // public static ArrayList<JokerCard> jokerCards = new ArrayList<>();
    // public static ArrayList<PlusTwoCard> plusTwoCards = new ArrayList<>();
    // public static ArrayList<PlusForCard> plusForCards = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Game newGame = new Game(2, 5);

        // ArrayList<Card> cards;
        // try {
        // cards = newGame.getAllCards("C:\\Users\\Eyram\\Downloads\\eclipse\\Jeu
        // Uno\\allCards.txt");

        // System.out.println(cards);

        // } catch (Exception e) {

        // e.printStackTrace();
        // }

        newGame.start();
        System.out.println(newGame.getPlayers());
        // newGame.next();
        while (newGame.next()) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            newGame.next();
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }

    }

    // String[] colors = { "blue", "red", "green", "yellow" };
    // for (String color : colors) {
    // sameColorCards = createSameColorCard(color);
    // allCards.addAll(sameColorCards);
    // jokerCards = createJokerCards(color);
    // allCards.addAll(jokerCards);
    // plusTwoCards = createPlusTwoCards(color);
    // allCards.addAll(plusTwoCards);
    // plusForCards = createPlusForCards(color);
    // allCards.addAll(plusForCards);
    // }
    // return allCards;

    // public static ArrayList<NormalCard> createSameColorCard(String color) {

    // sameColorCards.add(new NormalCard("0", color));
    // for (int i = 1; i <= 9; i++) {
    // sameColorCards.add(new NormalCard(Integer.toString(i), color));
    // sameColorCards.add(new NormalCard(Integer.toString(i), color));
    // }
    // return sameColorCards;

    // }

    // public static ArrayList<JokerCard> createJokerCards(String color) {

    // jokerCards.add(new JokerCard("joker", color));
    // return jokerCards;
    // }

    // public static ArrayList<PlusTwoCard> createPlusTwoCards(String color) {

    // plusTwoCards.add(new PlusTwoCard("plusTwo", color));
    // plusTwoCards.add(new PlusTwoCard("plusTwo", color));
    // return plusTwoCards;
    // }

    // public static ArrayList<PlusForCard> createPlusForCards(String color) {

    // plusForCards.add(new PlusForCard("plusTwo", color));
    // return plusForCards;
    // }

}