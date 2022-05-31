//34567890123456789012345678901234567890123456789012345678

//Practice Test 1, Prob01
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.Color;

public class Prob01{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob01Runner obj = new Prob01Runner();
    obj.run();

    System.out.println(obj.getMars());
    System.out.println(obj.getJoe());
    System.out.println(obj.getSue());
  }//end main
}//end class Prob01
//End program specifications.
//////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////

class Prob01Runner{
  //Instantiate the World and Turtle objects.
  private World mars = new World(300,274);
  private Turtle joe = new Turtle(mars);
  private Turtle sue = new Turtle(mars);

  public Prob01Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  //Accessor methods
  public Turtle getJoe(){return joe;}
  public Turtle getSue(){return sue;}
  public World getMars(){return mars;}
  //----------------------------------------------------//

  //This method is where the action is.
  public void run(){
    //Replace the default all-white picture with another
    // picture.
    mars.setPicture(new Picture("Prob01.jpg"));
    mars.getPicture().addMessage(
                         "Display your name here.",10,20);

    //Manipulate the turtle named joe.
    joe.setName("joe");
    joe.setBodyColor(Color.RED);
    joe.setShellColor(Color.BLUE);
    joe.setPenColor(Color.YELLOW);
    joe.setPenWidth(3);
    joe.turn(180);
    joe.forward();
    joe.turn(-135);
    joe.setPenColor(Color.BLUE);
    joe.forward(150);

    //Manipulate the turtle named sue
    sue.setName("sue");
    sue.setPenWidth(5);
    sue.setPenColor(Color.RED);
    sue.moveTo(300-183,274-170);
    sue.setPenDown(false);
    sue.moveTo(300-216,274-203);
    sue.setPenDown(true);
    sue.moveTo(300-250,274-237);
  }//end run method
}//end class Prob01Runner
//34567890123456789012345678901234567890123456789012345678
