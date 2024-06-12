package com.eyram.uno;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

import com.eyram.uno.cardCreator.CardCreator;
import com.eyram.uno.cardCreator.CardCreatorClass;

import com.eyram.uno.cardCreator.JokerCardCreator;
import com.eyram.uno.cardCreator.NormalCardCreator;
import com.eyram.uno.cardCreator.PlusForCardCreator;
import com.eyram.uno.cardCreator.PlusTwoCardCreator;
import com.eyram.uno.cards.Card;

public class Game {
    // arguments publics
    public static ArrayList<Card> allCards = new ArrayList<>(); // set de toutes les cartes du jeu
    public static ArrayList<String> setOfColorsOfGame = new ArrayList<>(); // set de toutes les couleurs
    public static final String ALL_CARDS_FILE_PATH = "C:\\Users\\Eyram\\Downloads\\eclipse\\Jeu Uno\\allCards.txt";
    // chemin du fichier servant à créer toutes les cartes
    private ArrayList<Player> players = new ArrayList<>(); // liste servant à enregistrer tous les joueurs du jeu
    private Talon talon = new Talon(new ArrayList<Card>()); // talon du jeu
    private Player currentPlayer = null; // current player du jeu
    private Pioche pioche = new Pioche(new ArrayList<>()); // pioche du jeu
    private int numberOfPlayers; // nombre des joueurs à définir
    private int numberOfCardByPlayers; // nombre des cartes par joeurs au début du jeu à définir
    //private static boolean effectOfLastCard;
    private ArrayList<Player> playersInOrder = new ArrayList<>();
    // getters et setters des arguments privés

    public ArrayList<Player> getPlayersInOrder() {
        return playersInOrder;
    }

    public void setPlayersInOrder(ArrayList<Player> playersInOrder) {
        this.playersInOrder = playersInOrder;
    }

    //public boolean isEffectOfLastCard() {
      //  return effectOfLastCard;
    //}

    //public static void setEffectOfLastCard(boolean effectOfLastCard) {
       // Game.effectOfLastCard = effectOfLastCard;
    //}

    public Talon getTalon() {
        return talon;
    }

    public void setTalon(Talon talon) {
        this.talon = talon;
    }

    public Pioche getPioche() {
        return pioche;
    }

    public void setPioche(Pioche pioche) {
        this.pioche = pioche;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers <= 1) {
            throw new IllegalArgumentException("Nombre de player inférieur à 1");
        }
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getNumberOfCardByPlayers() {
        return numberOfCardByPlayers;
    }

    public void setNumberOfCardByPlayers(int numberOfCardByPlayers) {
        this.numberOfCardByPlayers = numberOfCardByPlayers;
    }

    public Game(int numberOfPlayers, int numberOfCardByPlayers) {
        setNumberOfPlayers(numberOfPlayers);
        setNumberOfCardByPlayers(numberOfCardByPlayers);
    }

    // méthode start pour débuter le jeu
    public void start() throws Exception {

        allCards = getAllCards(ALL_CARDS_FILE_PATH);
        // méthode pour créer toutes les cartes du jeu par le fichier qui regroupe les
        // noms et les couleurs des cartes
        Collections.shuffle(allCards); // mélange des cartes
        Scanner nameOfPlayer = new Scanner(System.in);

        // création des joueurs du jeu : nom et attribution des cartes à tour de role
        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Entrer le nom du joueur " + i + "...");
            String theNameOfPlayer = nameOfPlayer.nextLine();
            Player player = new Player(theNameOfPlayer, numberOfCardByPlayers, new ArrayList<>());
            this.addPlayer(player);
            for (int j = 0; j < numberOfCardByPlayers; j++) {
                player.addCard(allCards.get(j * numberOfPlayers + i - 1));
                // les joueurs recoivent les cartes à tour de role

            }
        }
        // nameOfPlayer.close();
        currentPlayer = players.get(0); // le current player est le premier joueur
        // créé
        talon.addCard(allCards.get(numberOfCardByPlayers * numberOfPlayers)); // le
        // talon récupère sa première cartee
        // ici toutes les autres cartes vont dans la pioche du jeu
        for (int k = numberOfPlayers * numberOfCardByPlayers + 1; k < allCards.size(); k++) {
            pioche.addCard(allCards.get(k));
        }
        //effectOfLastCard = true;

    }

    // cette methode est pour les tours de chaque joeur
    public boolean next() {
        // avant de faire jouer et pick le current player je verifie si je dois
        // recharger la pioche

        if (pioche.getSetOfCardsOfPioche().size() == 1) {
            refillPioche(pioche, talon);
        }

        int nextIndex = 0; // ici le nextIndex permet d'identifier le joueur prochain
        int lastIndex = players.indexOf(currentPlayer) - 1;
        if (players.indexOf(currentPlayer) == 0) {
            lastIndex = players.size() - 1;
        }
        Player previousPlayer = players.get(lastIndex);
        if (players.indexOf(currentPlayer) != players.size() - 1) {
            nextIndex = players.indexOf(currentPlayer) + 1;

            // tant qu'on n'a pas atteint le dernier joeur, le nextIndex est incrémenté de 1
        }
        if (previousPlayer.getSetOfCards().isEmpty()) {

            players.remove(previousPlayer);
            System.out.println("le player " + previousPlayer.getName() + " est sorti du jeu");
            playersInOrder.add(previousPlayer);
        }
        if (players.size() == 1) {
            playersInOrder.add(players.get(0));
            stop(playersInOrder);
            System.out.println("le player " + players.get(0).getName() + "  est le grand perdant du jeu");
            return false;
        }

        currentPlayer.play(pioche, talon);

        // appel de la methode request qui donne la requete au joueur actuel et selon
        // la requette agit sur le talon et la pioche
        currentPlayer = players.get(nextIndex);// on change de current player à la fin
        return true;

    }

    // méthode pour finir le jeu
    public void stop(ArrayList<Player> playersInOrder) {

        System.out.println("voici l'ordre de sortie des joueurs \n");
        for (Player player : playersInOrder) {
            System.out.println(player.getName() + "\n");
        }
    }

    // methode qui indique au joeur ce qu'il doit faire
    // public static void request(Player player, Pioche pioche, Talon talon) {

    // Card lastCardOfTalon = talon.getLastCardOfTalon();// je recupère la dernier
    // carte au dessus du talon
    // if (lastCardOfTalon instanceof PlusTwoCard) {
    // // si c'est une carte plusTwo alors le joeur doit obligatoirement pick 2
    // cartes
    // player.pick(pioche, 2);
    // System.out.println("le player " + player.getName() + " a pioché 2 cartes");
    // effectOfLastCard = false;
    // } else if (lastCardOfTalon instanceof PlusForCard) { // ou dans ce cas il
    // pick 4 cartes
    // player.pick(pioche, 4);
    // System.out.println("le player " + player.getName() + " a pioché 4 cartes");
    // effectOfLastCard = false;

    // else if (lastCardOfTalon instanceof JokerCard) {
    // lastCardOfTalon.setColor(player.colorChoice(setOfColorsOfGame));
    // System.out.println("vous avez choisi la couleur " +
    // player.colorChoice(Game.setOfColorsOfGame));
    // player.play(pioche, talon);

    // }else

    // {player.play(pioche,talon);}

    // }

    // méthode pour recharger la pioche si elle arrivait à s'épuiser avant la fin du
    // jeu
    public void refillPioche(Pioche pioche, Talon talon) {
        // on récupère toutes les cartes du talon sauf la dernière
        for (int i = 1; i <= talon.getSetOfCardsOfTalon().size() - 1; i++) {
            pioche.addCard(talon.removeCard(0));
        }
    }

    public void addPlayer(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("pointeur nul");
        } else
            getPlayers().add(player);

    }

    public ArrayList<Card> getAllCards(String allCardsFilePath) throws Exception {
        CardCreator newCardCreator;

        CardCreatorClass newNormalCardCreator = new NormalCardCreator(null);
        CardCreatorClass newJokerCardCreator = new JokerCardCreator(newNormalCardCreator);
        CardCreatorClass newPlusTwoCardCreator = new PlusTwoCardCreator(newJokerCardCreator);
        CardCreatorClass newPlusForCardCreator = new PlusForCardCreator(newPlusTwoCardCreator);
        newCardCreator = newPlusForCardCreator;

        return newCardCreator.parseTxtFormatOscar(allCardsFilePath);

        // try (BufferedReader fileReader = new BufferedReader(new
        // FileReader(allCardsFilePath))) {
        // while (fileReader.ready()) {

        // String[] line = fileReader.readLine().split(" ");

        // allCards.add(newCardCreator.createCard(line));
        // }

        // }

        // catch (FileNotFoundException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // return allCards;
    }

}
