//34567890123456789012345678901234567890123456789012345678
//Practice Test 3, Prob01
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Color;

public class Prob01{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    new Prob01Runner().run();
  }//end main method
}//end class Prob01
//End program specifications.
//////////////////////////////////////////////////////////

class Prob01Runner{
  public Prob01Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public void run(){
    Picture pic = new Picture("Prob01.jpg");

    pic = cropAndFlip(pic,100,100,300,300);
    pic = rotatePicture(pic,90);

    pic.addMessage("Display your name.",10,15);
    pic = rotatePicture(pic,-90);
    pic.show();
    System.out.println(pic);
  }//end run
  //----------------------------------------------------//

  //This method accepts a reference to a Picture object
  // along with a rotation angle in degrees. It creates
  // and returns a new Picture object that is of the
  // correct size to contain and display the incoming
  // picture after it has been rotated around its center
  // by the specified rotation angle and translated to the
  // center of the new Picture object.
  private Picture rotatePicture(Picture pic,double angle){

    //Set up the rotation transform
    AffineTransform rotateTransform =
                                    new AffineTransform();
    rotateTransform.rotate(Math.toRadians(angle),
                           pic.getWidth()/2,
                           pic.getHeight()/2);

    //Get the required dimensions of a rectangle that will
    // contain the rotated image.
    Rectangle2D rectangle2D =
           pic.getTransformEnclosingRect(rotateTransform);
    int resultWidth = (int)(rectangle2D.getWidth());
    int resultHeight = (int)(rectangle2D.getHeight());

    //Set up the translation transform that will translate
    // the rotated image to the center of the new Picture
    // object.
    AffineTransform translateTransform =
                                    new AffineTransform();
    translateTransform.translate(
                      (resultWidth - pic.getWidth())/2,
                      (resultHeight - pic.getHeight())/2);

    //Concatenate the two transforms so that the image
    // will first be rotated around its center and then
    // translated to the center of the new Picture object.
    translateTransform.concatenate(rotateTransform);
    //Create a new Picture object to contain the results
    // of the transformation.
    Picture result = new Picture(
                                resultWidth,resultHeight);

    //Get the graphics context of the new Picture object,
    // apply the transform to the incoming picture and
    // draw the transformed picture on the new Picture
    // object.
    Graphics2D g2 = (Graphics2D)result.getGraphics();
    g2.drawImage(pic.getImage(),translateTransform,null);

    return result;
  }//end rotatePicture
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
}//end class Prob01Runner
//34567890123456789012345678901234567890123456789012345678
