package com.snakeandladder;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnakeAndLadderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakeAndLadderApplication.class, args);
		Scanner sc = new Scanner(System.in);
		try {		
			System.out.println("\nEnter number of players");
			int playerCount = sc.nextInt();
			sc.nextLine();
			Game game = new Game(playerCount);
			game.initializePlayers();
			game.play();
		}catch(Exception e) {
			System.out.println("Invalid Input !");
		}finally {
			sc.close();
		}
	}

}
