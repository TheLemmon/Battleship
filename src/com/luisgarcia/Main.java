package com.luisgarcia;

import com.luisgarcia.models.Board;
import com.luisgarcia.models.Boat;
import com.luisgarcia.models.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//	    Scanner scanner = new Scanner(System.in);
//	    int board_size = scanner.nextInt();

        // Testing

        Player playerOne = new Player("Luis Fernando", new Board(new Boat[10]));
        Boat[] playerOneBoats = playerOne.getBoard().getBoats();
        playerOneBoats[0] = new Boat(1, 3, 5, 3  );
        System.out.println(playerOne.getBoard().checkPosition(new Boat(6, 3, 6, 3)));
        playerOne.getBoard().checkAvailable(new Boat(6, 3, 6, 3));

    }
}
