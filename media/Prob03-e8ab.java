//34567890123456789012345678901234567890123456789012345678
//Practice Test 3, Prob03
//Copyright 2012 R.G.Baldwin
//********************************************************
import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;

public class Prob03{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    new Prob03Runner().run();
  }//end main method
}//end class Prob03
//End program specifications.
//////////////////////////////////////////////////////////

class Prob03Runner{
  public Prob03Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public void run(){
    Picture pic = new Picture(300,300);
    pic.setAllPixelsToAColor(Color.MAGENTA);

    process(pic);
    //Add your name and display the output picture.
    pic.addMessage("Display your name here.",10,20);
    pic.show();
    System.out.println(pic);
  }//end run
  //----------------------------------------------------//

  private void process(Picture pic){

    Graphics2D g2 = (Graphics2D)(pic.getGraphics());

    int width = pic.getWidth();
    int height = pic.getHeight();

    //Translate origin to center of Frame
    g2.translate(width/2,height/2);
    g2.setColor(Color.BLUE);
    //Draw x-axis
    g2.draw(new Line2D.Double(-width/2,0.0,width/2,0.0));
    //Draw y-axis
    g2.draw(new Line2D.Double(0.0,-width/2,0.0,height/2));

    //Upper left quadrant, Solid CYAN fill
    Ellipse2D.Double circle1 =
      new Ellipse2D.Double(-96,-128,64,128);
    g2.setPaint(Color.CYAN);
    g2.fill(circle1);
    g2.draw(circle1);

    //Upper right quadrant
    Ellipse2D.Double circle2 =
       new Ellipse2D.Double(32,-128,64,128);
    g2.setPaint(new GradientPaint(64,0,Color.GREEN,
                                  64,-32,Color.RED,true));
    g2.fill(circle2);
    g2.draw(circle2);


    //Lower right quadrant
    Ellipse2D.Double circle3 =
       new Ellipse2D.Double(0,32,128,64);
    g2.setPaint(
            new GradientPaint(-128,-64,Color.BLUE,
                              -107,-64,Color.RED,true));
    g2.fill(circle3);
    g2.draw(circle3);

    //Lower left quadrant
    Ellipse2D.Double circle4 =
      new Ellipse2D.Double(-128,32,128,64);
    g2.setPaint(
            new GradientPaint(19,19,Color.GREEN,
                              64,64,Color.BLUE,true));

    g2.fill(circle4);
    g2.draw(circle4);

  }//end process

}//end class Prob03Runner
//34567890123456789012345678901234567890123456789012345678
