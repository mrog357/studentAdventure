package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel 
    implements Runnable {

    // SCREEN SETTS
//    final int orginalSetTile = 20; // tile 16x16 pixels
//    final int scale = 3; // scaling of the Tile

    final int TileSize = 20; // 48x48

    final int maxScreenCol = 60;
    final int maxScreenRow = 30;

    final int screenWidth = maxScreenCol * TileSize; // 960 pixels
    final int screenHeight = maxScreenRow * TileSize; // 768 pixels



    int positionOffset = 0;

    Player player = new Player(200, 200, TileSize);
    Map map = new Map();

    //Object platforms[] = new Object[5];



     //Platform platforms[] = new Platform[4];
    ArrayList<Platform> platforms = new ArrayList<Platform>();
    ArrayList<Coin> coins = new ArrayList<>();








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
        //player.setWidth(20);
        //player.setHeight(20);
        for(int i=0; i<map.platformsPlacement.length; i++){
            for(int j=0; j<map.platformsPlacement[i].length; j++) {

                if(map.platformsPlacement[i][j] > 0) platforms.add(new Platform(j*TileSize*4, (i*4+3)*TileSize, TileSize));
                if(map.platformsPlacement[i][j] == 2) coins.add(new Coin(((j*4+1)*TileSize), (i*4+1)*TileSize, TileSize));
            }
        }



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

        int moveMatrix[] = {0,0};

        if (keyH.pressedUp == true){
            moveMatrix[0] = 1;

        }
//        if(keyH.pressedDown == true){
//            moveMatrix[0] += 1;
//        }
        if(keyH.pressedLeft == true){
            moveMatrix[1] -= 1;
        }
        if(keyH.pressedRight == true){
            moveMatrix[1] += 1;
        }

        move(moveMatrix);

    }

    public void move(int moveMatrix[]){

        player.Move(moveMatrix, speed, platforms);



        if((player.getWorldPositionX() > screenWidth/3 ) && !((map.endIndex - player.getWorldPositionX()) < 2*screenWidth/3)) {
            positionOffset = player.worldPositionX - screenWidth/3;
        }












    }
    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        if(player.animation)
            g2.drawImage(player.icon2.getImage(),(player.getPositionX(positionOffset) - (player.direction-1)*TileSize ), player.getPositionY(TileSize), player.direction*player.getWidth(), player.getHeight(), null );
        else
            g2.drawImage(player.icon1.getImage(),(player.getPositionX(positionOffset) - (player.direction-1)*TileSize ), player.getPositionY(TileSize), player.direction*player.getWidth(), player.getHeight(), null );
        for(int i=0; i<platforms.size(); i++) {
            Platform toDisplay = platforms.get(i);
            g2.fillRect(toDisplay.getPositionX(positionOffset), toDisplay.getPositionY(TileSize), toDisplay.getWidth(), toDisplay.getHeight());
        }

        for(int i=0; i<coins.size(); i++) {
            Coin toDisplay = coins.get(i);
            g2.drawImage(toDisplay.icon.getImage(), toDisplay.getPositionX(positionOffset), toDisplay.getPositionY(TileSize), toDisplay.getWidth(), toDisplay.getHeight(), null);
        }

        g2.dispose();
    }

}
