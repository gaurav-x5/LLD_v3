package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatCategory;

@Getter
@Setter
public class Seat {
    int seatId;
    int row;
    SeatCategory seatCategory;
}
