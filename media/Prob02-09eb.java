//34567890123456789012345678901234567890123456789012345678
//Practice Test 3, Prob02
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;

public class Prob02{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    new Prob02Runner().run();
  }//end main method
}//end class Prob02
//End program specifications.
//////////////////////////////////////////////////////////

class Prob02Runner{
  public Prob02Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public void run(){
    Picture pix = new Picture("Prob02.jpg");

    pix = rotatePicture(pix,35);

    pix = mirrorUpperBand(
                 pix,1+pix.getWidth()/4,pix.getWidth()/4);
    pix = mirrorUpperBand(
                   pix,pix.getWidth()/2,pix.getWidth()/2);
    pix = mirrorHoriz(pix);

    //Add your name and display the output picture.
    pix.addMessage("Display your name here.",20,210);

    pix.show();
    System.out.println(pix);
  }//end run
  //----------------------------------------------------//

  //This method accepts a reference to a Picture object
  // and a blank Picture object of the correct size for
  // the rotated image, along with a rotation angle in
  // degrees. It populates and returns the blank Picture
  // object to contain the incoming picture after it has
  // been rotated around its center by the specified
  // rotation angle and translated to the  center of the
  // blank Picture object.
  //The use of the blank picture object is a workaround
  // for a bug in the textbook-CD version of the media
  // library that prevents a Picture object instantiated
  // from width and height only from being displayed in
  // a PictureExplorer object.
  private Picture rotatePicture(Picture pix,
                                double angle){

    //Set up the rotation transform
    AffineTransform rotateTransform =
                                    new AffineTransform();
    rotateTransform.rotate(Math.toRadians(angle),
                           pix.getWidth()/2,
                           pix.getHeight()/2);

    //Get the required dimensions of a rectangle that will
    // contain the rotated image.
    Rectangle2D rectangle2D =
           pix.getTransformEnclosingRect(rotateTransform);
    int resultWidth = (int)(rectangle2D.getWidth());
    int resultHeight = (int)(rectangle2D.getHeight());

    //Set up the translation transform that will translate
    // the rotated image to the center of the new Picture
    // object.
    AffineTransform translateTransform =
                                    new AffineTransform();
    translateTransform.translate(
                      (resultWidth - pix.getWidth())/2,
                      (resultHeight - pix.getHeight())/2);

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
    g2.drawImage(pix.getImage(),translateTransform,null);

    return result;
  }//end rotatePicture
  //----------------------------------------------------//

  //This method mirrors the top half of a picture into
  // the bottom half.
  private Picture mirrorHoriz(Picture pix){
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int midpoint = pix.getHeight()/2;
    int height = pix.getHeight();
    for(int col = 0;col < pix.getWidth();col++){
      for(int row = 0;row < midpoint;row++){
        topPixel = pix.getPixel(col,row);
        bottomPixel =
                   pix.getPixel(col,height-1-row);
        bottomPixel.setColor(topPixel.getColor());
      }//end inner loop
    }//end outer loop

    return pix;
  }//end mirrorHoriz
  //----------------------------------------------------//

  private Picture mirrorUpperBand(
                        Picture pix,int center,int width){
    Pixel leftPixel = null;
    Pixel rightPixel = null;

    for(int row = 0;row < pix.getHeight()/2;row++){
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
}//end class Prob02Runner
//34567890123456789012345678901234567890123456789012345678
