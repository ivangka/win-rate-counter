package ivangka.main;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Formatter;

public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Formatter formatter = new Formatter(System.out);
    private int victories;
    private int games;
    private float winrate;
    private String roundedWinrate = "0,00%";

    public void addVictory() {
        victories++;
        games++;
        setWinrate(victories, games);
    }

    public void addDefeat() {
        games++;
        setWinrate(victories, games);
    }

    public void removeVictory() {
        if (victories == 1 && games == 1) {
            clearStatistics();
            return;
        }
        if (victories == 0 || games == 0) {
            System.out.println("Incorrect action. Try again.\n");
            return;
        }
        victories--;
        games--;
        setWinrate(victories, games);
    }

    public void removeDefeat() {
        if (victories == 0 && games == 1) {
            clearStatistics();
            return;
        }
        if (victories == games || games == 0) {
            System.out.println("Incorrect action. Try again.\n");
            return;
        }
        games--;
        setWinrate(victories, games);
    }

    public void clearStatistics() {
        games = 0;
        victories = 0;
        winrate = 0;
        roundedWinrate = "0,00%";
    }

    public void setStatistics(int victories, int defeats) {
        this.victories = victories;
        this.games = victories + defeats;
        setWinrate(victories, defeats + victories);
    }

    private void setWinrate(int victories, int games) {
        winrate = ((float) victories / (float) games) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        roundedWinrate = (decimalFormat.format(winrate)) + "%";
    }

    public String getRoundedWinrate() {
        return roundedWinrate;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return victories + "/" + games + " (" + roundedWinrate + ")";
    }

    public void showStatistics() {
        System.out.println("\n+------ STATISTICS SUMMARY ------+");
        formatter.format("+  %-16s : %9s  +\n", "Games", games);
        formatter.format("+  %-16s : %9s  +\n", "Victories", victories);
        formatter.format("+  %-16s : %9s  +\n", "Defeats", games-victories);
        formatter.format("+  %-16s : %9s  +\n", "Winrate", roundedWinrate);
        System.out.println("+--------------------------------+\n");
    }
}
