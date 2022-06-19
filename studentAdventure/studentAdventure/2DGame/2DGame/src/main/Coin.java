package main;

import javax.swing.*;

public class Coin extends GameplayElement{

    public Coin(int x, int y, int tileSize) {

        super(x, y);
        this.height = tileSize*2;
        this.icon = new ImageIcon("Pictures//Coin.png");
        this.width = this.height * (this.icon.getIconHeight()/this.icon.getIconWidth());
    }
    public ImageIcon icon;
}
