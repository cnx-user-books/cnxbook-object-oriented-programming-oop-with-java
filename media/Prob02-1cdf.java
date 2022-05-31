//34567890123456789012345678901234567890123456789012345678

//Practice Test 1, Prob02
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob02{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob02Runner obj = new Prob02Runner();
    obj.run();
    System.out.println(obj.getPicture());
  }//end main
}//end class Prob02
//End program specifications.
//////////////////////////////////////////////////////////

class Prob02Runner{
  private Picture pic = new Picture("Prob02.jpg");

  public Prob02Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  //Accessor method
  public Picture getPicture(){return pic;}
  //----------------------------------------------------//

  //This method is where the action is.
  public void run(){
    //Display the raw picture.
    pic.addMessage("Display your name here.",10,20);

    //Set the red color components to 0 and invert the
    // blue and green color components for every pixel in
    // the picture.
    Pixel[] pixelArray = pic.getPixels();
    for(Pixel pixel:pixelArray ){
      pixel.setRed(0);
      pixel.setGreen(255 - pixel.getGreen());
      pixel.setBlue(255 - pixel.getBlue());
    }//end for loop

    //Display the modified picture
    pic.explore();
  }//end run method
}//end class Prob02Runner

//34567890123456789012345678901234567890123456789012345678