package entity;

//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.GamePanel;
import game.Keyhandler;

public class Player extends Entity{
    
    GamePanel gp;
    Keyhandler keyh;

    public Player(GamePanel gp, Keyhandler keyh){

        this.gp = gp;
        this.keyh = keyh;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";

    }
    public void getPlayerImage(){
        try{
            up1= ImageIO.read(getClass().getResourceAsStream("/player/b1.png/"));
            up2= ImageIO.read(getClass().getResourceAsStream("/player/b2.png/"));
            up3= ImageIO.read(getClass().getResourceAsStream("/player/b3.png/"));
            down1= ImageIO.read(getClass().getResourceAsStream("/player/fwd1.png/"));
            down2= ImageIO.read(getClass().getResourceAsStream("/player/fwd2.png/"));
            down3= ImageIO.read(getClass().getResourceAsStream("/player/fwd3.png/"));
            left1= ImageIO.read(getClass().getResourceAsStream("/player/l1.png/"));
            left2= ImageIO.read(getClass().getResourceAsStream("/player/l2.png/"));
            left3= ImageIO.read(getClass().getResourceAsStream("/player/l3.png/"));
            right1= ImageIO.read(getClass().getResourceAsStream("/player/r1.png/"));
            right2= ImageIO.read(getClass().getResourceAsStream("/player/r2.png/"));
            right3= ImageIO.read(getClass().getResourceAsStream("/player/r3.png/"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyh.upPressed)
        {
           direction = "up";  
           y -= speed;
        }
        else if(keyh.downPressed)
        {
            direction = "down";  
            y += speed;
        }
        if(keyh.leftPressed)
        {
            direction = "left";  
            x -= speed;
        }
        else if(keyh.rightPressed)
        {
            direction = "right";  
            x += speed ;
        }
        
        spriteCounter++;
        if(spriteCounter>12)
        {
            if(spriteNum==1){
                spriteNum = 2;
            }
            else if(spriteNum==2){
                spriteNum = 3;
            }
            else if(spriteNum==3)
                spriteNum=1;
                spriteCounter =0;
        }
    }
    
    public void draw(Graphics2D g2){
 //       g2.setColor(Color.WHITE);
 //       g2.fillRect(x,y,gp.tileSize,gp.tileSize);
      BufferedImage image = null;
      switch(direction){
        case "up":
            if(spriteNum ==1) 
            {
                image = up1;
            }
            if(spriteNum ==2) 
            {
                image = up2;
            }
            if(spriteNum ==3) 
            {
                image = up3;
            }
            
            break;
        case "down":
            if(spriteNum ==1) 
            {
                image = down1;
            }
            if(spriteNum ==2) 
            {
                image = down2;
            }
            if(spriteNum ==3) 
            {
                image = down3;
            }
            break;
        case "left":
            if(spriteNum ==1) 
            {
                image = left1;
            }
            if(spriteNum ==2) 
            {   
                image = left2;
            }
            if(spriteNum ==3) 
            {
                image = left3;
            }
            
            break;
        case "right":
            if(spriteNum ==1) 
            {
                image = right1;
            }
            if(spriteNum ==2) 
            {
                image = right2;
            }
            if(spriteNum ==3) 
            {
                image = right3;
            }
            
            break;
       

       }
        g2.drawImage(image,x,y,gp.tileSize,gp.tileSize,null);
    }
    
}
