//34567890123456789012345678901234567890123456789012345678
//Practice Test 2, Prob05
//Copyright 2012 R.G.Baldwin
//********************************************************

public class Prob05{
  //DO NOT MODIFY THE CODE IN THIS CLASS DEFINITION.
  public static void main(String[] args){
    MyPicture pic = new Prob05Runner().run();
    System.out.println(pic);
    pic.addMessage("String",10,50);
    pic.show();
  }//end main method
}//end class Prob05
//End program specifications.
//////////////////////////////////////////////////////////

class Prob05Runner{
  public Prob05Runner(){
    System.out.println("Display your name here.");
  }//end constructor
  //----------------------------------------------------//

  public MyPicture run(){
    return new MyPicture("Prob05.jpg");
  }//end run
  //----------------------------------------------------//
}//end class Prob05Runner
//======================================================//

class MySimplePicture extends SimplePicture{
  MySimplePicture(String fileName){//constructor
    super(fileName);
  }//end constructor
  //----------------------------------------------------//

  //Overridden addMessagemethod
  public void addMessage(
                        String message,int xPos,int yPos){
    super.addMessage("Modified "+message,xPos,yPos);
  }//end addMessage
  //----------------------------------------------------//
}//end class MySimplePicture
//======================================================//

class MyPicture extends MySimplePicture{
  MyPicture(String fileName){
    super(fileName);
  }//end constructor
}//end class MyPicture


//34567890123456789012345678901234567890123456789012345678
