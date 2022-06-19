package main;

public class GameplayElement {

    public GameplayElement(int x, int y) {

        this.worldPositionX = x;
        this.worldPositionY = y;


    }

    public int getPositionX(int positionOffset){

        return (this.worldPositionX - positionOffset);
    }

    public int getPositionY(int TileSize){

        return (this.worldPositionY + 4*TileSize);
    }




    public int worldPositionX, worldPositionY;

    public int getWidth() {
        return width;
    }

    public int width;

    public int getHeight() {
        return height;
    }

    public int height;

    public int getWorldPositionY() {
        return worldPositionY;
    }

    public int getWorldPositionX() {
        return worldPositionX;
    }

    public int getBounds(Side side){
        switch(side){
            case Up:
                return this.worldPositionY;
            case Down:
                return (this.worldPositionY + this.height);
            case Right:
                return (this.worldPositionX + this.width);
            case Left:
                return this.worldPositionX;
            default:
                return 0;
        }
    }

    public boolean collision(GameplayElement analyzed){

        if(this.getBounds(Side.Right) > analyzed.getBounds(Side.Left)) {
            if (this.getBounds(Side.Left) < analyzed.getBounds(Side.Right)) {
                if (this.getBounds(Side.Down) > analyzed.getBounds(Side.Up)) {
                    if (this.getBounds(Side.Up) < analyzed.getBounds(Side.Down))
                        return true;
                }
            }
        }
        return false;
    }


}

