package memoryGame;
import java.util.*;


public class TileControl {
 
    int circle1, circle2;
    int cross1, cross2;
    int diamond1, diamond2;
    int dice1 , dice2;
    int donut1, donut2;
    int eclipse1, eclipse2;
    int eclipse3, eclipse4;
    int grapes1, grapes2;
    int heart1, heart2;
    int L1, L2;
    int rectangle1, rectangle2;
    int snowflake1, snowflake2;
    int sqdonut1, sqdonut2;
    int square1, square2;
    int star1, star2;
    int tear1, tear2;
    int triangle1, triangle2;
    int X1, X2;
    
    // 4X4 game
    
    //generate random numbers & assign them to each shape twice.  its their location on the game board.
    public void initShuffle4x4Tiles(){
        int n = 0;

        List<Integer> randomCollection = new ArrayList<>();
        for (int i = 0; i <= 15; i++){
            randomCollection.add(i); 
        }
        Collections.shuffle(randomCollection);

        //assign each shape their locations
        circle1 = randomCollection.get(n);
        n++;
        circle2 = randomCollection.get(n);
        n++;
        cross1 = randomCollection.get(n);
        n++;       
        cross2 = randomCollection.get(n);
        n++   ;   
        diamond1 = randomCollection.get(n);
        n++;
        diamond2 = randomCollection.get(n);
        n++; 
        donut1 = randomCollection.get(n);
        n++;
        donut2 = randomCollection.get(n);
        n++;
        eclipse1 = randomCollection.get(n);
        n++;
        eclipse2 = randomCollection.get(n);
        n++; 
        square1 = randomCollection.get(n);
        n++;
        square2 = randomCollection.get(n);
        n++;
        star1 = randomCollection.get(n);
        n++;
        star2 = randomCollection.get(n);
        n++;
        X1 = randomCollection.get(n);
        n++;
        X2 = randomCollection.get(n);
        n++; 
    }
    
    //The type returned is a code from 0-7 that theoretically corresponds to a "shape". 
    //gives us some way of testing matches.
    public int get4x4TileType(int ID){
        int type = 100;
        
        if (ID == circle1 || ID == circle2){
            type = 0;
        }
        else if (ID == cross1 || ID == cross2){
            type = 1;
        }
        else if (ID == diamond1 || ID == diamond2){
            type = 2;
        }
        else if (ID == donut1 || ID == donut2){
            type = 3;
        }
        else if (ID == eclipse1 || ID == eclipse2){
            type = 4;
        }
        else if (ID == square1 || ID == square2){
            type = 5;     
        }
        else if (ID == star1 || ID == star2){
            type = 6;
        }
        else if (ID == X1 || ID == X2){
            type = 7;
        }
        return type;
    }

    //6X6 game

   
    //generate random numbers & assign them to each shape twice.  its their location on the game board.
    public void initShuffle6x6Tiles(){
        int n = 0;
 
        List<Integer> randomCollection = new ArrayList<>();
        for (int i = 0; i <= 35; i++){
            randomCollection.add(i); 
        }
        Collections.shuffle(randomCollection);

        circle1 = randomCollection.get(n);
        n++;
        circle2 = randomCollection.get(n);
        n++;
        cross1 = randomCollection.get(n);
        n++;       
        cross2 = randomCollection.get(n);
        n++   ;   
        diamond1 = randomCollection.get(n);
        n++;
        diamond2 = randomCollection.get(n);
        n++;
        dice1 = randomCollection.get(n);
        n++;
        dice2 = randomCollection.get(n);
        n++;
        donut1 = randomCollection.get(n);
        n++;
        donut2 = randomCollection.get(n);
        n++;
        eclipse1 = randomCollection.get(n);
        n++;
        eclipse2 = randomCollection.get(n);
        n++;
        eclipse3 = randomCollection.get(n);
        n++;
        eclipse4 = randomCollection.get(n);
        n++;
        grapes1 = randomCollection.get(n);
        n++;
        grapes2 = randomCollection.get(n);
        n++;
        heart1 = randomCollection.get(n);
        n++;
        heart2 = randomCollection.get(n);
        n++;
        L1 = randomCollection.get(n);
        n++;
        L2 = randomCollection.get(n);
        n++;
        rectangle1 = randomCollection.get(n);
        n++;
        rectangle2 = randomCollection.get(n);
        n++;
        snowflake1 = randomCollection.get(n);
        n++;
        snowflake2 = randomCollection.get(n);
        n++;
        sqdonut1 = randomCollection.get(n);
        n++;
        sqdonut2 = randomCollection.get(n);
        n++;
        square1 = randomCollection.get(n);
        n++;
        square2 = randomCollection.get(n);
        n++;
        star1 = randomCollection.get(n);
        n++;
        star2 = randomCollection.get(n);
        n++;
        tear1 = randomCollection.get(n);
        n++;
        tear2 = randomCollection.get(n);
        n++;
        triangle1 = randomCollection.get(n);
        n++;
        triangle2 = randomCollection.get(n);
        n++;
        X1 = randomCollection.get(n);
        n++;
        X2 = randomCollection.get(n);
        n++; 
    }
    
    //The type returned is a code from 0-7 that theoretically corresponds to a "shape". 
    //gives us some way of testing matches.
    public int get6x6TileType(int ID){
        int type = 100;
        
        if (ID == circle1 || ID == circle2){
            type = 0;
        }
        else if (ID == cross1 || ID == cross2){
            type = 1;
        }
        else if (ID == diamond1 || ID == diamond2){
            type = 2;
        }
        else if (ID == dice1 || ID == dice2){
            type = 3;
        }
        else if (ID == donut1 || ID == donut2){
            type = 4;
        }
        else if (ID == eclipse1 || ID == eclipse2){
            type = 5;
        }
        else if (ID == eclipse3 || ID == eclipse4){
            type = 6;
        }
        else if (ID == grapes1 || ID == grapes2){
            type = 7;
        }
        else if (ID == heart1 || ID == heart2){
            type = 8;
        }
        else if (ID == L1 || ID == L2){
            type = 9;
        }
        else if (ID == rectangle1 || ID == rectangle2){
            type = 10;
        }
        else if (ID == snowflake1 || ID == snowflake2){
            type = 11;
        }
        else if (ID == sqdonut1 || ID == sqdonut2){
            type = 12;
        }
        else if (ID == square1 || ID == square2){
            type = 13;      
        }
        else if (ID == star1 || ID == star2){
            type = 14;
        }
        else if (ID == tear1 || ID == tear2){
            type = 15;
        }
        else if (ID == triangle1 || ID == triangle2){
            type = 16;
        }       
        else if (ID == X1 || ID == X2){
            type = 17;
        }
        return type;
    }
}
