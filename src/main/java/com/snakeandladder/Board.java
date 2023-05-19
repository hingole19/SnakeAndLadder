package com.snakeandladder;

import java.util.HashMap;
import java.util.Map;

public class Board {

	private static final Map<Integer, Integer> snakes;
	private static final Map<Integer, Integer> ladders;

	static {
		snakes = new HashMap<>();
		snakes.put(32, 10);
		snakes.put(36, 6);
		snakes.put(48, 26);
		snakes.put(62, 18);
		snakes.put(88, 24);
		snakes.put(95, 56);
		snakes.put(97, 78);

		ladders = new HashMap<>();
		ladders.put(1, 38);
		ladders.put(4, 14);
		ladders.put(8, 30);
		ladders.put(21, 42);
		ladders.put(28, 76);
		ladders.put(50, 67);
		ladders.put(71, 92);
		ladders.put(80, 99);
	}

	public static int applySnakeOrLadder(int position) {
		if (snakes.containsKey(position)) {
			System.out.println("Sorry! You are bitten by snake");
			return snakes.get(position);
		} else if (ladders.containsKey(position)) {
			System.out.println("Yes! You have found ladder ");
			return ladders.get(position);
		}
		return position;
	}
}
