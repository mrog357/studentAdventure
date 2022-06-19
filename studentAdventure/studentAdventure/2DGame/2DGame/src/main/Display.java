package main;

public class Display {

    public int positionX, positionY;
    public int width, height;

    public Display(int x, int y){
        this.positionX= x;
        this.positionY= y;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPositionY() {
        return positionY;
    }




    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int width) {
        this.height = width;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }






    public int getPositionX() {
        return positionX;
    }
}
