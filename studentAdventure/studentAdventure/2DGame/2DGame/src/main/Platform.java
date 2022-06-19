package main;

public class Platform extends  GameplayElement{

    public Platform(int x, int y, int tileSize) {
        super(x, y);
        this.width = 4*tileSize;
        this.height = tileSize;
    }
}



