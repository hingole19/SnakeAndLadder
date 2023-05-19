package com.snakeandladder;

import java.util.Random;
import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class Game {
	private static final int TOP = 100;
	private final int playerCount;
	private final Player[] players;
	private final Random ran;

	public Game(int playercount) {
		this.playerCount = playercount;
		this.players = new Player[playercount];
		this.ran = new Random();
	}

	public void initializePlayers() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < playerCount; i++) {
			System.out.println("Enter name of the player " + (i + 1) + " :-");
			String name = sc.nextLine();
			players[i] = new Player(name);
		}
	}

	public void play() {
		int currentPlayer = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("<----WELCOME TO THE GAME---->");
		int i = 0;
		while(i < playerCount) {
			Player player = players[i];
			System.out.println("Hello " + player.getName() + " !");
			i++;
		}
		
		while (true) {
			Player player = players[currentPlayer];
			System.out.print("\n" + player.getName() + "! this is your turn. Press enter to roll the dice...");
			sc.nextLine();
			int diceValue = getDiceValue();
			System.out.println(player.getName() + " rolled a " + diceValue);

			int newPos = player.getPosition() + diceValue;

			if (newPos <= TOP) {
				player.setPosition(Board.applySnakeOrLadder(newPos));
				System.out.println(player.getName() + " moved to position " + player.getPosition());
			}
			
			System.out.println("To check game Status (y/n)");
			String choice = sc.nextLine().trim().toLowerCase();
			if (choice.equals("y") || choice.equals("n")) {
				switch (choice) {
				case "y":
					checkGameStatus();
					break;
				case "n":
					continue;
				}
			}else {
				System.out.println("Invalid Input");
			}
				
			
			if (player.getPosition() == TOP) {
				System.out.println("\n Congratulations!" + player.getName() + ", You have won the game!");
				break;
			}
			currentPlayer = (currentPlayer + 1) % playerCount;
		}
	}

	private void checkGameStatus() {
		System.out.println("\n ------------ GAME STATUS ------------");
		System.out.println("There are "+playerCount+" players in the game");
		int i = 0;
		while(i < playerCount) {
			Player player = players[i];
			System.out.println("Player  " +player.getName()+ " is on the postion of "+player.getPosition());
			i++;
		}
	}

	private int getDiceValue() {
		return ran.nextInt(6) + 1;
	}

	public boolean isGameFinished() {
		int i = 0;
		while(i < playerCount) {
			return TOP == players[i].getPosition();
		}
		return false;
	}
}
