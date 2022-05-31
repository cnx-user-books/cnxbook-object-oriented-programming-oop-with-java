//34567890123456789012345678901234567890123456789012345678
//Practice Test 3, Prob04
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;

public class Prob04{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    new Prob04Runner().run();
  }//end main method
}//end class Prob04
//End program specifications.
//////////////////////////////////////////////////////////

class Prob04Runner{
  public Prob04Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public void run(){
    Picture pix = new Picture("Prob04a.jpg");

    //Clip the picture to a RoundRectangle on a
    // Green background.
    pix = clipToRoundRectangle(pix);

    //Add your name and display the output picture.
    pix.addMessage("Display your name here.",10,20);
    pix.show();

    System.out.println(pix);
  }//end run
  //----------------------------------------------------//

  private Picture clipToRoundRectangle(Picture pix){
    Picture result = new Picture(pix.getWidth(),
                                 pix.getHeight());
    result.setAllPixelsToAColor(Color.GREEN);

    //Get the graphics2D object
    Graphics2D g2 = (Graphics2D)(result.getGraphics());

    //Create a RoundRectangle for clipping
    RoundRectangle2D.Double roundRectangle =
           new RoundRectangle2D.Double(0,
                                       0,
                                       pix.getWidth(),
                                       pix.getHeight(),
                                       pix.getWidth()/2,
                                       pix.getHeight()/2);

    //Use the RoundRectangle for clipping
    g2.setClip(roundRectangle);

    //Draw the image
    g2.drawImage(pix.getImage(),0,0,pix.getWidth(),
                                pix.getHeight(),
                                null);

    return result;
  }//end clipToRoundRectangle
  //----------------------------------------------------//

}//end class Prob04Runner
//34567890123456789012345678901234567890123456789012345678
