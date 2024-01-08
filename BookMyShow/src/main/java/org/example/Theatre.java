package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.City;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Theatre {

    int theatreId;
    String address;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show> shows = new ArrayList<>();


}
