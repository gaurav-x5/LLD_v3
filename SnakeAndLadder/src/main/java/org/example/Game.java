package org.example;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game() {
        initialize();
    }

    private void initialize() {
        players = new LinkedList<Player>();
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while(winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is:" + playerTurn.playerId + " current position is: " + playerTurn.currentPosition);

            int diceRoll = dice.rollDice();

            int playerNewPosition = playerTurn.currentPosition + diceRoll;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;

            System.out.println("player turn is:" + playerTurn.playerId + " new Position is: " + playerNewPosition);

            if(playerNewPosition >= board.cells.length * board.cells.length -1) {
                winner = playerTurn;
            }
        }

        System.out.println("Winner is : ---> " + winner.playerId);
    }

    private int jumpCheck(int playerNewPosition) {
        if(playerNewPosition > board.cells.length * board.cells.length -1) {
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition) {
            String jumpBy = (cell.jump.start < cell.jump.end) ? "Ladder" : "Snake";
            System.out.println("Jump done by : " + jumpBy);
            return cell.jump.end;
        }

        return playerNewPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }

}
