//34567890123456789012345678901234567890123456789012345678
//Practice Test 2, Prob04
//Copyright 2012 R.G.Baldwin
//********************************************************/

import java.awt.Color;
public class Prob04{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob04Runner obj = new Prob04Runner();
    obj.run();
  }//end main
}//end class Prob04
//End program specifications.
//////////////////////////////////////////////////////////

class Prob04Runner{

  public Prob04Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  public void run(){

    Picture skater = new Picture("Prob04a.bmp");
    skater = crop(skater,6,59,392,200);

    Picture hole = new Picture("Prob04b.bmp");
    hole = crop(hole,6,59,392,293);


    Picture snowScene = new Picture("Prob04c.jpg");
    snowScene = crop(snowScene,6,59,392,293);

    modifyBackground(hole,snowScene);

    //Apply a red tint to the skater
    redTint(skater);

    //Draw the skater on the snowScene.
    greenScreenDraw(skater,snowScene,0,45);

    //Display students name on the final output and
    // display it.
    snowScene.addMessage("Display your name here.",10,15);
    snowScene.show();
    System.out.println(snowScene);

  }//end run method
  //----------------------------------------------------//

  //Assumes the source has a pure green background.
  // Applies a red tint to every pixel that is not pure
  // green.
  private void redTint(Picture pic){
    Pixel[] pixels = pic.getPixels();
    Color color = null;
    int red = 0;
    int green = 0;
    int blue = 0;
    for(int cnt = 0;cnt < pixels.length;cnt++){
      color = pixels[cnt].getColor();
      //Apply a red tint to all non-green pixels
      if(!(color.equals(Color.GREEN))){
        //Increase the value of the red component
        red = color.getRed();
        if(red*1.25 < 255){
          red = (int)(red * 1.25);
        }else{
          red = 255;
        }//end else
        //Decrease the value of blue and green
        green = (int)(color.getGreen()*0.8);
        blue = (int)(color.getBlue()*0.8);

        //Apply the new color to the pixel.
        pixels[cnt].setColor(new Color(red,green,blue));
      }//end if
    }//end for loop
  }//end redTint
  //----------------------------------------------------//

  private void modifyBackground(
                           Picture pattern,
                           Picture dest){

    Pixel[] patternPixels = pattern.getPixels();
    Pixel[] destPixels = dest.getPixels();
    Color color = null;
    int red = 0;
    int green = 0;
    int blue = 0;

    for(int cnt = 0;cnt < patternPixels.length;cnt++){
      color = patternPixels[cnt].getColor();
      if(color.equals(Color.GREEN)){
        color = destPixels[cnt].getColor();
        destPixels[cnt].setColor(color.brighter());
      }else{
        color = destPixels[cnt].getColor();
        red = 0;
        green = 0;
        blue = 255;
        destPixels[cnt].setColor(new Color(red,green,blue));
      }//end else
    }//end for loop
  }//end modifyBackground
  //----------------------------------------------------//

  private void greenScreenDraw(
                           Picture source,
                           Picture dest,
                           //Place the upper-left corner
                           // of the source image at the
                           // following location in the
                           // destination image.
                           int destX,
                           int destY){
    int width = source.getWidth();
    int height = source.getHeight();
    Pixel pixel = null;
    Color color = null;

    for(int row = 0;row < height;row++){
      for(int col = 0;col < width;col++){
        color = source.getPixel(col,row).getColor();
        if(!(color.equals(Color.GREEN))){
          pixel = dest.getPixel(destX + col,destY + row);
          pixel.setColor(color);
        }//end if
      }//end inner loop
    }//end outer loop

  }//end greenScreenDraw
  //----------------------------------------------------//

  //Crops a Picture object to the given width and height
  // with the upper-left corner located at startCol and
  // startRow.
  private Picture crop(Picture pic,int startCol,
                                   int startRow,
                                   int width,
                                   int height){
    Picture output = new Picture(width,height);

    int colOut = 0;
    int rowOut = 0;
    int col = 0;
    int row = 0;
    Pixel pixel = null;
    Color color = null;
    for(col = startCol;col < startCol+width;col++){
      for(row = startRow;row < startRow+height;row++){
        color = pic.getPixel(col,row).getColor();
        pixel = output.getPixel(colOut,rowOut);
        pixel.setColor(color);
        rowOut++;
      }//end inner loop
      rowOut = 0;
      colOut++;
    }//end outer loop
    return output;
  }//end crop

}//end class Prob04Runner

//34567890123456789012345678901234567890123456789012345678
