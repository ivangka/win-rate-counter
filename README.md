# Win Rate Counter

[![GitHub license](https://img.shields.io/github/license/ivangka/win-rate-counter.svg?style=plastic)](https://github.com/ivangka/win-rate-counter/blob/master/LICENSE)
![GitHub repo size](https://img.shields.io/github/repo-size/ivangka/win-rate-counter?style=plastic)

This project is a simple Java application designed to track game statistics, including the number of victories, defeats, and win rate. The application provides functionality to add, remove, and display statistics, as well as to save and load statistics to and from a file.

## Features

- **Track Victories and Defeats:** Add or remove victories and defeats.
- **Calculate Win Rate:** Automatically calculates and displays the win rate as a percentage.
- **Persistent Storage:** Saves statistics to a file and reads them back.
- **Clear Statistics:** Clear all statistics and reset the file.

## Project Structure

- **`Statistics` class**: Handles the core functionality for tracking victories, defeats, and calculating win rates.
- **`ReadStatistics` class**: Manages reading statistics from a file.
- **`WriteStatistics` class**: Manages writing statistics to a file and clearing the file.
- **`Main` class**: Provides a command-line interface to interact with the user and manage statistics.

## Installation

To use this project, you need to have Java Development Kit (JDK) installed. You can compile and run the program using the following commands:

```bash
# Compile the program
javac -d bin src/ivangka/main/*.java

# Run the program
java -cp bin ivangka.main.Main
