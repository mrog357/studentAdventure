package main;

import java.util.ArrayList;

public class Map {

    public int platformsPlacement[][];

    public int getEndIndex() {
        return endIndex;
    }

    public int endIndex;


    public Map() {
        int create[][] = {
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 2, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        this.platformsPlacement = create;
        this.endIndex = create[1].length * 4 * 20;

    }
}
