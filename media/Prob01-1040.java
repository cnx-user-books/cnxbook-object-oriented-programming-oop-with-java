//34567890123456789012345678901234567890123456789012345678
//Practice Test 2, Prob01
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob01{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Picture pic = new Prob01Runner().run();
    System.out.println(pic);
  }//end main method
}//end class Prob01
//End program specifications.
//////////////////////////////////////////////////////////

class Prob01Runner{
  public Prob01Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//
  public Picture run(){
    Picture pix = new Picture("Prob01.jpg");

    //Call the mirrorUpperBand method to modify the top
    // half of the picture.
    pix = mirrorUpperBand(
                 pix,1+pix.getWidth()/4,pix.getWidth()/4);
    pix = mirrorUpperBand(
                   pix,pix.getWidth()/2,pix.getWidth()/2);

    //Mirror the top half into the bottom half.
    pix = mirrorHoriz(pix);
    //Add your name and display the output picture.
    pix.addMessage("Display your name here.",10,20);

    pix.explore();
    return pix;

  }//end run
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

}//end class Prob01Runner
//34567890123456789012345678901234567890123456789012345678
