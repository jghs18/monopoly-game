
/**
 * Write a description of class Starter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Starter
{
    
    public Starter()//constructor for starter class
    {
    }
    public static void main(String args[])//main method for starter class
    {
        GameEngine gE = new GameEngine();//constructs instance of GameEngine, stores to memory location referenced by object reference gE
        gE.playGame();//invokes accessor method 'playGame' on implicit parameter 'gE' which is of type GameEngine
    }
}
