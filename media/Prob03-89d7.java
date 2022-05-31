//34567890123456789012345678901234567890123456789012345678
//Practice Test 2, Prob03
//Copyright 2012 R.G.Baldwin
//********************************************************/
import java.awt.Color;
public class Prob03{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob03Runner obj = new Prob03Runner();
    obj.run();
  }//end main
}//end class Prob03
//End program specifications.
//////////////////////////////////////////////////////////


class Prob03Runner{

  public Prob03Runner(){//constructor
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  public void run(){
    //Instiantiate, display and crop the four input
    // images. They must be cropped to remove the Alice
    // runtime window material. The three skater images
    // are also cropped to remove excess blank green
    // background.

    //Note that the three views of the skater are bmp
    // images instead of jpg images in order to preserve
    // the pure green background color. Storing the
    // images as jpg files would corrupt the background
    // color in the low order bits.
    //A view facing the front of the skater.
    Picture front = new Picture("Prob03a.bmp");
    front = crop(front,123,59,110,256);

    //A view showing the right side of the skater.
    Picture right = new Picture("Prob03b.bmp");
    right = crop(right,123,59,110,256);

    //A view showing the left side of the skater.
    Picture left = new Picture("Prob03c.bmp");
    left = crop(left,123,59,110,256);

    //This will be the background for the new picture.
    Picture snowScene = new Picture("Prob03d.jpg");
    snowScene = crop(snowScene,6,59,344,256);

    snowScene = mirrorBand(snowScene,
                           snowScene.getWidth()/2,
                           snowScene.getWidth()/2);

    //Draw the front view of the skater on the snowScene
    // at full size.
    greenScreenDraw(front,snowScene,117,0);

    //Draw the left side view of the skater on the
    // snowScene at half size.
    left = left.getPictureWithHeight(256/2);
    greenScreenDraw(left,snowScene,55,64);

    //Draw the right side view of the skater on the
    // snowScene at one-third size.
    right = right.getPictureWithHeight(256/3);
    greenScreenDraw(right,snowScene,260,96);

    //Display students name on the final output and
    // display it.
    snowScene.addMessage("Display your name here.",10,15);
    snowScene.explore();
    System.out.println(snowScene);
  }//end run method
  //----------------------------------------------------//

  //Assumes a source image with a pure green background.
  // Copies all non-green pixels from the source image to
  // the destination image at the location explained
  // below. Note that JPEG images typically won't have
  // a pure green background even if they had a pure
  // green background before being compressed into the
  // JPEG format.  BMP images work well for this.
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
  //----------------------------------------------------//

  private Picture mirrorBand(
                        Picture pix,int center,int width){
    Pixel leftPixel = null;
    Pixel rightPixel = null;

    for(int row = 0;row < pix.getHeight();row++){
      for(int cnt=0;cnt < width;cnt++){
        int leftCol = center-cnt;
        int rightCol = center+cnt;
        leftPixel = pix.getPixel(leftCol,row);
        rightPixel = pix.getPixel(rightCol,row);
        rightPixel.setColor(leftPixel.getColor());
      }//end inner loop
    }//end outer loop

    return pix;
  }//end mirrorUpperBand
  //----------------------------------------------------//
}//end class Prob03Runner


//34567890123456789012345678901234567890123456789012345678
