//34567890123456789012345678901234567890123456789012345678
//Practice Test 2, Prob02
//Copyright 2012 R.G.Baldwin
//********************************************************/
import java.awt.Color;

public class Prob02{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Picture[] pictures = new Prob02Runner().run();
    System.out.println(pictures[0]);
    System.out.println(pictures[1]);
    System.out.println(pictures[2]);
  }//end main method
}//end class Prob02
//End program specifications.
//////////////////////////////////////////////////////////

class Prob02Runner{
  public Prob02Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public Picture[] run(){
    Picture picA = new Picture("Prob02a.jpg");
    Picture picB = new Picture("Prob02b.jpg");

    Picture picC = cropAndFlip(picA,4,5,80,105);

    copyPictureWithCrop(picA,picB,0,0,4,5,77,101);
    copyPictureWithCrop(picC,picB,
                        picB.getWidth()-picC.getWidth(),
                        picB.getHeight()-picC.getHeight(),
                        0,0,77,101);
    picB.addMessage("Display your name here.",10,20);

    picB.explore();

    Picture[] output = {picA,picB,picC};
    return output;
  }//end run
  //----------------------------------------------------//

  //Crops a picture to the specified coordinate values and
  // flips it around a vertical line at its center.
  private Picture cropAndFlip(
                  Picture pic,int x1,int y1,int x2,int y2){
    Picture output = new Picture(x2-x1+1,y2-y1+1);

    int width = output.getWidth();
    Pixel pixel = null;
    Color color = null;
    for(int col = x1;col < (x2+1);col++){
      for(int row = y1;row < (y2+1);row++){
        color = pic.getPixel(col,row).getColor();
        pixel = output.getPixel(width-col+x1-1,row-y1);
        pixel.setColor(color);
      }//end inner loop
    }//end outer loop

    return output;
  }//end crop and flip
  //----------------------------------------------------//

  //Copies part of the source picture onto the destination
  // picture with an offset on both axes after first
  // confirming that the part will fit. Does nothing if it
  // won't fit.
  private void copyPictureWithCrop(
           Picture source,Picture dest,int xOff,
                                       int yOff,
                                       int xCoor,
                                       int yCoor,
                                       int width,
                                       int height){

    //Confirm that source will fit in destination
    if(((width+xOff) <= dest.getWidth()) &&
         ((height+yOff) <= dest.getHeight())){
      Pixel pixel = null;
      Color color = null;
      for(int col = 0;col < width;col++){
        for(int row = 0;row < height;row++){
          color = source.getPixel(
                      col + xCoor,row + yCoor).getColor();
          pixel = dest.getPixel(col+xOff,row+yOff);
          pixel.setColor(color);
        }//end inner loop
      }//end outer loop
    }//end if
  }//end copyPictureWithCrop method
}//end class Prob02Runner
//34567890123456789012345678901234567890123456789012345678