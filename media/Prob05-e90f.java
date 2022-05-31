//34567890123456789012345678901234567890123456789012345678

//Practice Test 1, Prob05
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob05{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob05Runner obj = new Prob05Runner();
    DigitalPicture[] digitalPictures = obj.getDigitalPictures();

    System.out.println(digitalPictures[0]);
    digitalPictures[0].show();

    System.out.println(digitalPictures[1]);
    digitalPictures[1].show();
  }//end main
}//end class Prob05
//End program specifications.
//////////////////////////////////////////////////////////

class Prob05Runner{
  private DigitalPicture[] digitalPictures =
                                    new DigitalPicture[2];

  public Prob05Runner(){//constructor
    System.out.println("Display your name here.");
    Picture picA = new Picture("Prob05a.jpg");
    picA.addMessage("Put your name here",10,20);
    digitalPictures[1] = picA;

    Picture picB = new Picture("Prob05b.jpg");
    picB.addMessage("Put your name here",10,290);
    digitalPictures[0] = picB;

  }//end constructor
  //----------------------------------------------------//

  //Accessor method
  public DigitalPicture[] getDigitalPictures(){
    return digitalPictures;
  }//end getDigitalPictures

}//end class Prob05Runner

//34567890123456789012345678901234567890123456789012345678