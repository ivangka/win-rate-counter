package ivangka.main;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Main class to interact with the user and manage game statistics.
 */
public class Main {

    /**
     * Constant for storing the loaded statistics.
     */
    private static final Statistics STATISTICS = ReadStatistics.readStatistics();

    /**
     * Formatter for formatting strings.
     */
    private static Formatter formatter = new Formatter(System.out);

    /**
     * Method to show the manual with available commands.
     */
    public static void showManual() {

        System.out.println("\n+------------ MANUAL ------------+");
        formatter.format("+  %-19s : %6d  +\n", "Add victory", 1);
        formatter.format("+  %-19s : %6d  +\n", "Add defeat", 0);
        formatter.format("+  %-19s : %6d  +\n", "Remove victory", -11);
        formatter.format("+  %-19s : %6d  +\n", "Remove defeat", -10);
        formatter.format("+  %-19s : %6d  +\n", "Show statistics", 100);
        formatter.format("+  %-19s : %6d  +\n", "Set statistics", 101);
        formatter.format("+  %-19s : %6d  +\n", "Clear statistics", 102);
        formatter.format("+  %-19s : %6d  +\n", "Show manual", 200);
        formatter.format("+  %-19s : %6d  +\n", "EXIT", 400);
        System.out.println("+--------------------------------+\n");

    }

    /**
     * Main method to run the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // print manual in the console
        showManual();

        // print current statistics in the console
        System.out.println("Current statistics:");
        System.out.println(STATISTICS + "\n");

        int switcher = 1;
        label1:

        while (switcher == 1) {

            int code = scanner.nextInt();

            switch (code) {

                case 0:
                    STATISTICS.addDefeat();
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case 1:
                    STATISTICS.addVictory();
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case -11:
                    STATISTICS.removeVictory();
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case -10:
                    STATISTICS.removeDefeat();
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case 100:
                    STATISTICS.showStatistics();
                    continue label1;
                case 101:
                    System.out.println("\nEnter the number of wins:");
                    int victories = scanner.nextInt();
                    System.out.println();
                    System.out.println("Enter the number of defeats:");
                    int defeats = scanner.nextInt();
                    System.out.println();
                    STATISTICS.setStatistics(victories, defeats);
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case 102:
                    System.out.println("Enter 102 again to confirm clearing statistics or any other number to cancel.\n");
                    int confirmation = scanner.nextInt();
                    if (confirmation != 102) break;
                    STATISTICS.clearStatistics();
                    WriteStatistics.writeStatistics(STATISTICS);
                    break;
                case 200:
                    showManual();
                    continue label1;
                case 400:
                    switcher = 0;
                    break;
                default:
                    System.out.println("Invalid code. Try again.\n");
                    continue;

            }

            if (switcher == 1) {
                System.out.println("Current statistics:");
                System.out.println(STATISTICS + "\n");
            }

        }

    }
}
