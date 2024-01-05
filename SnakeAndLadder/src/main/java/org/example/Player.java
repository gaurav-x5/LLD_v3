package org.example;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

    String playerId;
    int currentPosition;

    public Player(String id, int currentPosition) {
        this.currentPosition = currentPosition;
        this.playerId = id;
    }

}
