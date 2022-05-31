//34567890123456789012345678901234567890123456789012345678
//Practice Test 3, Prob05
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;

public class Prob05{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    new Prob05Runner().run();
  }//end main method
}//end class Prob05
//End program specifications.
//////////////////////////////////////////////////////////

class Prob05Runner{
  public Prob05Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public void run(){
    Picture penguin = new Picture("Prob05a.jpg");
    Picture hare = new Picture("Prob05b.jpg");
    penguin = crop(penguin,6,58,330,252);
    hare = crop(hare,6,58,330,252);

    hare = clipToPolygon(hare,Color.RED);
    penguin = clipToPolygon(penguin,Color.GREEN);

    merge(hare,penguin);

    hare.addMessage("Display your name here.",10,20);
    hare.show();
    System.out.println(hare);
  }//end run
  //----------------------------------------------------//

  //Assumes both pictures have the same dimensions.
  // Does a linear merge on two pictures based on the
  // distance of each pixel from the left side of the
  // picture.
  private void merge(Picture left,Picture right){
    int width = left.getWidth();
    int height = left.getHeight();

    double scaleL = 0;
    double scaleR = 0;
    int redL = 0;
    int greenL = 0;
    int blueL = 0;
    int redR = 0;
    int greenR = 0;
    int blueR = 0;
    Pixel pixelL = null;
    Pixel pixelR = null;

    for(int row = 0;row < height;row++){
      for(int col = 0;col < width;col++){
        scaleR = (double)col/width;
        scaleL = 1.0 - scaleR;
        pixelL = left.getPixel(col,row);
        pixelR = right.getPixel(col,row);

        redL = pixelL.getColor().getRed();
        greenL = pixelL.getColor().getGreen();
        blueL = pixelL.getColor().getBlue();

        redR = pixelR.getColor().getRed();
        greenR = pixelR.getColor().getGreen();
        blueR = pixelR.getColor().getBlue();

        redL = (int)(redL*scaleL + redR*scaleR);
        greenL = (int)(greenL*scaleL + greenR*scaleR);
        blueL = (int)(blueL*scaleL + blueR*scaleR);

        pixelL.setColor(new Color(redL,greenL,blueL));
      }//end inner loop
    }//end outer loop
  }//end merge
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

  private Picture clipToPolygon(Picture pix,Color color){
    Picture result = new Picture(pix.getWidth(),
                                 pix.getHeight());
    result.setAllPixelsToAColor(color);

    //Get the graphics2D object
    Graphics2D g2 = (Graphics2D)(result.getGraphics());

    int xPoints[] = {0,
                     pix.getWidth()/2,
                     pix.getWidth(),
                     pix.getWidth()/2
                    };

    int yPoints[] = {pix.getHeight()/2,
                     0,
                     pix.getHeight()/2,
                     pix.getHeight()
                    };

    //Create a Polygon for clipping
    Polygon polygon = new Polygon(xPoints,yPoints,4);

    //Use the Polygon for clipping
    g2.setClip(polygon);

    //Draw the image
    g2.drawImage(pix.getImage(),0,0,pix.getWidth(),
                                pix.getHeight(),
                                null);
    return result;
  }//end clipToPolygon
  //----------------------------------------------------//
}//end class Prob05Runner
//34567890123456789012345678901234567890123456789012345678
