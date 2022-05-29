package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel 
    implements Runnable {

    // SCREEN SETTS
    final int orginalSetTile = 16; // tile 16x16 pixels
    final int scale = 3; // scaling of the Tile
    
    final int TileSize = orginalSetTile * scale; // 48x48 
    final int maxScreenCol = 24;
    final int maxScreenRow = 16;
    final int screenWidth = maxScreenCol * TileSize; // 960 pixels
    final int screenHeight = maxScreenRow * TileSize; // 768 pixels

    // player default position
        int player_x = 200;
        int player_y = 200;
        int speed = 4;
        int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    
    
    public GamePanel() {
        
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.DARK_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startThread(){
        gameThread = new Thread(this);
        gameThread.start();
    } 


    public void run(){

            double drawinterval = 1000000000/FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;


            while(gameThread != null){

                currentTime = System.nanoTime();

                delta += (currentTime - lastTime) / drawinterval;

                lastTime = currentTime;

                if(delta >= 1){
                    update();
                    repaint();
                    delta--;
                }

                

            }

    }

    public void update(){

        if (keyH.pressedUp == true){
            player_y -= speed;
        }
        else if(keyH.pressedDown == true){
            player_y += speed;
        }
        else if(keyH.pressedLeft == true){
            player_x -= speed;
        }
        else if(keyH.pressedRight == true){
            player_x += speed;
        }

    }
    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(player_x, player_y, TileSize, TileSize);
        
        g2.dispose();
    }

}
