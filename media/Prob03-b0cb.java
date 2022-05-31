//34567890123456789012345678901234567890123456789012345678

//Practice Test 1, Prob03
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob03{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob03Runner obj = new Prob03Runner();
    obj.run();
    System.out.println(obj.getPicture());
  }//end main
}//end class Prob03
//End program specifications.
//////////////////////////////////////////////////////////

class Prob03Runner{
  //Instantiate the Picture object.
  private Picture pic = new Picture("Prob03.jpg");

  public Prob03Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  //Accessor methods
  public Picture getPicture(){return pic;}
  //----------------------------------------------------//

  //This method is where the action is.
  public void run(){
    pic.addMessage("Display your name here.",10,20);

    //Get an array of Pixel objects.
    Pixel[] pixels = pic.getPixels();

    //Declare working variables
    Pixel pixel = null;
    int green = 0;
    int blue = 0;
    int width = pic.getWidth();
    int height = pic.getHeight();
    double greenScale = 0;
    double blueScale = 0;

    for(int col = 0;col < width;col++){
      for(int row = 0;row < height;row++){
        pixel = pic.getPixel(col,row);
        green = pixel.getGreen();
        blue = pixel.getBlue();

        greenScale = (double)(height - row)/height;

        blueScale = (double)(row)/height;
        pixel.setGreen((int)(green * greenScale));
        pixel.setBlue((int)(blue * blueScale));
        pixel.setRed(0);
      }//end inner loop
    }//end outer loop

    pic.explore();

  }//end run method
}//end class Prob03Runner

//34567890123456789012345678901234567890123456789012345678