package main;

import javax.swing.*;
import java.util.ArrayList;

public class Player extends GameplayElement{


    public Player(int x, int y, int tileSize) {
        super(x, y);
        this.width = 2*tileSize;
        this.height = 2*tileSize;
        this.fallingSpeed = 0;
        this.gravityFactor = 0;
        this.icon1 = new ImageIcon("Pictures//Student1.png");
        this.icon2 = new ImageIcon("Pictures//Student2.png");
        this.animation = false;
    }

    public final int jumpSpeed = 15;

    private int animationCounter = 0;

    public boolean animation;
    public int direction = 1;

    public ImageIcon icon1;
    public ImageIcon icon2;

    public void Move(int moveMatrix[], int speed, ArrayList<Platform> platforms){


        if(this.isOnPlatform(platforms)){
            this.fallingSpeed =0;
            this.gravityFactor = 0;
            if(moveMatrix[0] == 1){
                this.fallingSpeed = -1*this.jumpSpeed;
            }
            if((animationCounter%8) == 0){
                if(this.animation) {
                    this.animation = false;
                    animationCounter++;
                }
                else this.animation = true;

            }

        }
        else
            this.animation = false;
            gravityFactor = 1;

        int gravity_move = gravity();

        if(gravity_move > 0){
            this.worldPositionY += gravity_move;
            int y = this.collision_check(Side.Up, platforms);
            if(y >= 0)
                this.worldPositionY = y - this.height;
        }

        if(gravity_move < 0){
            this.worldPositionY += gravity_move;
            int y = this.collision_check(Side.Down, platforms);
            if(y >= 0) {
                this.worldPositionY = y;
                this.fallingSpeed = 0;

            }
        }






        if(moveMatrix[1] == 1){
            this.worldPositionX += speed;
            this.direction = 1;
            int x = this.collision_check(Side.Left, platforms);
            if(x >= 0)
                this.worldPositionX = x - this.width;
            animationCounter++;
        }
        if(moveMatrix[1] == -1){
            this.worldPositionX -= speed;
            this.direction = -1;
            int x = this.collision_check(Side.Right, platforms);
            if(x >= 0)
                this.worldPositionX = x;
            animationCounter++;
        }















        //this.worldPositionY = this.worldPositionY + (moveMatrix[0] * speed);


    }

    public boolean platformCollision[] = {false, false, false, false};

    public boolean isFlying;


    public boolean falling = false;
    public float gravityFactor;
    int fallingSpeed;

    public int gravity(){
        int move = this.fallingSpeed;
        this.fallingSpeed += this.gravityFactor;
        return move;
    }




    public int collision_check(Side side, ArrayList<Platform> platforms){

        for (int i= 0; i<platforms.size(); i++){
            if(this.collision(platforms.get(i)))
                return platforms.get(i).getBounds(side);
        }
        return -1;

    }

    public boolean isOnPlatform(ArrayList<Platform> platforms){

        for(int i=0; i < platforms.size(); i++){
            if((this.getBounds(Side.Right) > platforms.get(i).getBounds(Side.Left)) && (this.getBounds(Side.Left) < platforms.get(i).getBounds(Side.Right))){
                if((this.getBounds(Side.Down) == platforms.get(i).getBounds(Side.Up)))
                    return true;
            }
        }
        return false;
    }





/*
0 - up
1 - down
2 - right
3 - left
 */

//    public void platformCollisionDetect(ArrayList<Platform> platforms){
//         for (int i=0; i < platforms.size(); i++){
//             Platform platform = platforms.get(i);
//             if (this.positionX <= platform.getPositionX() - platform.getWidth()) {
//
//                 platformCollision[3] = true;
//                 this.positionX = platform.getPositionX() - platform.getWidth();
//             }
//             if (this.positionX + this.width >= platform.getPositionX()) {
//                 platformCollision[2] = true;
//                 this.positionX = platform.getPositionX() - this.width;
//             }
//             if (this.positionY <= platform.getPositionY() - platform.getHeight()) {
//                 platformCollision[1] = true;
//                 this.positionY = platform.getPositionY() - platform.getHeight();
//             }
//             if (this.positionY + this.height <= platform.getPositionY()) {
//                 platformCollision[0] = true;
//                 this.positionY = platform.getPositionY() - this.height;
//             }
//
//         }
//    }
//
//    public void gravity(){
//
//        if (platformCollision[1] == false){
//            if (!falling ){
//                falling = true;
//                gravityFactor = (float) 1.3;
//                this.positionX -= gravityFactor;
//
//            }
//            else{
//                gravityFactor = gravityFactor * gravityFactor;
//            }
//        }
//        else if (falling)
//            falling = false;
//
//    }
//






}
