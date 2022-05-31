//34567890123456789012345678901234567890123456789012345678

//Practice Test 1, Prob04
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob04{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    Prob04Runner obj = new Prob04Runner();
    DigitalPicture digitalPicture = obj.getDigitalPicture();
    System.out.println(digitalPicture);
    digitalPicture.show();
  }//end main
}//end class Prob04
//End program specifications.
//////////////////////////////////////////////////////////

class Prob04Runner{
  private Picture pic = new Picture("Prob04.jpg");

  public Prob04Runner(){//constructor
    System.out.println("Display your name here.");
    pic.addMessage("Put your name here",10,20);
  }//end constructor
  //----------------------------------------------------//

  //Accessor method
  public Picture getDigitalPicture(){
    return pic;
  }//end getDigitalPicture

}//end class Prob04Runner

//34567890123456789012345678901234567890123456789012345678