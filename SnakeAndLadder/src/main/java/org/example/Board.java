package org.example;

import java.util.Random;

public class Board {
    Cell[][] cells;

    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        initialize(boardSize);
        addSnakesLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void addSnakesLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        Random random = new Random();
        while (numberOfSnakes > 0) {
            int snakeHead = random.nextInt(100);
            int snakeTail = random.nextInt(100);
            
            if(snakeTail >= snakeHead) continue;;
            
            Jump snakeObj = new Jump();
            snakeObj.start = snakeHead;
            snakeObj.end = snakeTail;
            
            Cell cell = getCell(snakeHead);
            cell.jump = snakeObj;
            
            numberOfSnakes--;
        }

        while(numberOfLadders > 0) {
            int ladderHead = random.nextInt(100);
            int ladderTail = random.nextInt(100);

            if(ladderHead >= ladderTail) continue;;

            Jump ladderObj = new Jump();
            ladderObj.start = ladderHead;
            ladderObj.end = ladderTail;

            Cell cell = getCell(ladderHead);
            cell.jump = ladderObj;

            numberOfLadders--;
        }
    }

    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];

    }

    private void initialize(int boardSize) {
        cells = new Cell[boardSize][boardSize];

        for(int i=0;i<boardSize;i++) {
            for(int j=0; j<boardSize;j++) {
                Cell cellObj = new Cell();
                cells[i][j] = cellObj;
            }
        }
    }


}
