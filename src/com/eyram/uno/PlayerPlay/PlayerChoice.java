package
        com.eyram.uno.PlayerPlay;

import com.eyram.uno.Pioche;
import com.eyram.uno.Player;
import com.eyram.uno.Talon;

public interface PlayerChoice {
    public void apply(int choiceOfPlayer, Player currentPlayer, Pioche piocheOfGame, Talon talonOfGame);

}
