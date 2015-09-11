import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die dice2;
int totalRoll=0;

public void setup()
{
  size(504, 500);
  noLoop();
}

public void draw()
{
  background(255);
  totalRoll=0;
  for(int y = 22 ; y <= 500 ; y +=28 )
{
  for(int x = 0 ; x <= 504 ; x +=28) 
  {
     fill((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
     
     
     dice2 = new Die(x, y);
     dice2.roll();
     dice2.show();
  }
}
  fill(0);
  textSize(15);
  text("Total Roll: " + totalRoll, 80 , 15);
}

public void mousePressed()
{
  redraw();
}

class Die //models one single dice cube
{
  int myDiceNum;
  int myX;
  int myY;
  int diesize;
  //variable declarations here
  Die(int x, int y) //constructor
  {
    myDiceNum = (int)((Math.random()*6)+1);
    myX = x;
    myY = y;
    diesize= 45;
  }
  public void roll()
  {
    myDiceNum =(int)((Math.random()*6)+1);
  }
  public void show()
  {
    stroke(255);
    rect(myX, myY, diesize, diesize);
    int circleSize = diesize/10;

    if (myDiceNum == 1) {
      ellipse(myX+(diesize/3), myY+(diesize/3), circleSize, circleSize); 
      totalRoll += 1;
    }
    if (myDiceNum == 2) {
      ellipse(myX+(diesize/6), myY+(diesize/6), circleSize, circleSize);
      ellipse(myX+3*(diesize/6), myY+3*(diesize/6), circleSize, circleSize); 
      totalRoll += 2;
    }
    if (myDiceNum == 3) {
      ellipse(myX+(diesize/6), myY+(diesize/6), circleSize, circleSize); 
      ellipse(myX+(diesize/3), myY+(diesize/3), circleSize, circleSize); 
      ellipse(myX+3*(diesize/6)+1, myY+3*(diesize/6), circleSize, circleSize); 
      totalRoll += 3;
    }
    if (myDiceNum == 4) {
      ellipse(myX+(diesize/6), myY+(diesize/6), circleSize, circleSize); 
      ellipse(myX+3*(diesize/6), myY+(diesize/6), circleSize, circleSize); 
      ellipse(myX+(diesize/6), myY+3*(diesize/6), circleSize,circleSize);
      ellipse(myX+3*(diesize/6), myY+3*(diesize/6), circleSize,circleSize); 
      totalRoll += 4;
    }
    if (myDiceNum == 5) {
      ellipse(myX+(diesize/6), myY+(diesize/6), circleSize,circleSize); 
      ellipse(myX+3*(diesize/6), myY+(diesize/6), circleSize,circleSize); 
      ellipse(myX+(diesize/6), myY+3*(diesize/6), circleSize,circleSize); 
      ellipse(myX+3*(diesize/6), myY+3*(diesize/6), circleSize,circleSize); 
      ellipse(myX+(diesize/3), myY+(diesize/3), circleSize,circleSize);  
      totalRoll += 5;
    }
    if (myDiceNum == 6) {
      ellipse(myX+(diesize/6), myY+(diesize/6), circleSize,circleSize); 
      ellipse(myX+(diesize/6), myY+2*(diesize/6), circleSize,circleSize); 
      ellipse(myX+(diesize/6), myY+3*(diesize/6), circleSize,circleSize); 
      ellipse(myX+3*(diesize/6), myY+(diesize/6), circleSize,circleSize);
      ellipse(myX+3*(diesize/6), myY+2*(diesize/6), circleSize,circleSize);  
      ellipse(myX+3*(diesize/6), myY+3*(diesize/6), circleSize,circleSize);
      totalRoll += 6;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
