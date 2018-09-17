package starfield;


import java.awt.Color;
import java.awt.Graphics;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Elizabeth Mertens
 */
public class Hero extends Character {
 
    //fields 
    //(Variables/attributes) (defines things)

    private int health;
    
    //constructor
    public Hero(){
     super ();
     health=3;
    }
    
    public Hero(int x, int y, Color color, int size, String name){
        super(x,y,color,size,name);
        health=3;
    }

    //Getters
    public int getHealth(){
       return health; 
    }
            
   
    //public methods 
    //(how to perform actions/ "what does [hero, enemy, coin, etc.] do?"
   
   
    public void collect() {
        
    }
    
    public void teleport () {
        
    }
    
    //private methods  
    //(calculations that things [hero, etc] do, behind the scenes)
    private void grow () {
       
    }
    
    private void canTeleport () {
        
    }
    
}
