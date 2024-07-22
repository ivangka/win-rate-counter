package ivangka.main;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Formatter;

/**
 * Class to track game statistics such as victories, games, and win rate.
 *
 * @author ivangka
 */
public class Statistics implements Serializable {

    /**
     * Field for serializing the object.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Formatter for formatting strings.
     */
    private static Formatter formatter = new Formatter(System.out);

    /**
     * Field to store the number of victories.
     */
    private int victories;

    /**
     * Field to store the number of games.
     */
    private int games;

    /**
     * Field to store the win rate as a float.
     */
    private float winrate;

    /**
     * String to store the rounded win rate.
     */
    private String roundedWinRate = "0,00%";

    /**
     * Method to add a victory.
     */
    public void addVictory() {

        victories++;
        games++;
        setWinRate(victories, games);

    }

    /**
     * Method to add a defeat.
     */
    public void addDefeat() {
        games++;
        setWinRate(victories, games);
    }

    /**
     * Method to remove a victory.
     */
    public void removeVictory() {

        // if there is only one game and one victory, clear statistics
        if (victories == 1 && games == 1) {
            clearStatistics();
            return;
        }

        // check for valid action
        if (victories == 0 || games == 0) {
            System.out.println("Incorrect action. Try again.\n");
            return;
        }

        victories--;
        games--;
        setWinRate(victories, games);

    }

    /**
     * Method to remove a defeat.
     */
    public void removeDefeat() {

        // if there are no victories and only one defeat, clear statistics
        if (victories == 0 && games == 1) {
            clearStatistics();
            return;
        }

        // check for valid action
        if (victories == games || games == 0) {
            System.out.println("Incorrect action. Try again.\n");
            return;
        }

        games--;
        setWinRate(victories, games);

    }

    /**
     * Method to clear statistics.
     */
    public void clearStatistics() {

        games = 0;
        victories = 0;
        winrate = 0;
        roundedWinRate = "0,00%";

    }

    /**
     * Method to set statistics.
     *
     * @param victories the number of victories
     * @param defeats   the number of defeats
     */
    public void setStatistics(int victories, int defeats) {

        this.victories = victories;
        this.games = victories + defeats;
        setWinRate(victories, defeats + victories);

    }

    /**
     * Private method to calculate the win rate.
     *
     * @param victories the number of victories
     * @param games     the number of games
     */
    private void setWinRate(int victories, int games) {

        winrate = ((float) victories / (float) games) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        roundedWinRate = (decimalFormat.format(winrate)) + "%";

    }

    /**
     * Getter for the rounded win rate.
     *
     * @return the rounded win rate as a string
     */
    public String getRoundedWinRate() {
        return roundedWinRate;
    }

    /**
     * Getter for victories.
     *
     * @return the number of victories
     */
    public int getVictories() {
        return victories;
    }

    /**
     * Setter for victories.
     *
     * @param victories the number of victories to set
     */
    public void setVictories(int victories) {
        this.victories = victories;
    }

    /**
     * Getter for games.
     *
     * @return the number of games
     */
    public int getGames() {
        return games;
    }

    /**
     * Setter for games.
     *
     * @param games the number of games to set
     */
    public void setGames(int games) {
        this.games = games;
    }

    /**
     * Override the toString method to output statistics as a string.
     *
     * @return a string representation of the statistics
     */
    @Override
    public String toString() {
        return victories + "/" + games + " (" + roundedWinRate + ")";
    }

    /**
     * Method to print statistics to the console.
     */
    public void showStatistics() {

        System.out.println("\n+------ STATISTICS SUMMARY ------+");
        formatter.format("+  %-16s : %9s  +\n", "Games", games);
        formatter.format("+  %-16s : %9s  +\n", "Victories", victories);
        formatter.format("+  %-16s : %9s  +\n", "Defeats", games - victories);
        formatter.format("+  %-16s : %9s  +\n", "WinRate", roundedWinRate);
        System.out.println("+--------------------------------+\n");

    }

}
