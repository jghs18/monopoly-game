import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane; 
//imports classes for use in GameEngine class
public class GameEngine implements ActionListener//implements=uses ActionListener
{
    Board board;
    ArrayList<Player> pList = new ArrayList<Player>();
    //ArrayList<Integer> intList = new ArrayList<Integer>();
    int losers;
    int index;
    int playerNumber;
    JFileChooser fC;
    File file;
    //instance fields: declares and initializes variables that will be used later in class
    public GameEngine()//constructor for GameEngine class, initializes instance field variables
    {
        fC = new JFileChooser();//initializes instance field variable referenced by 'fC' of type JFileChooser
        losers = 0;//initializes instance field variable of type int referenced by primitive variable 'losers' to 0
        index = 0;//initializes instance field variable of type int referenced by primitive variable 'index' to 0
        String pN = JOptionPane.showInputDialog(null, "How many players?\nRecommended to play with a maximum of 4." );//invokes static method showInputDialog with implicit parameter JOptionPane,and explicit paramter of "null, Player 1, enter a word", stores user input to newly constructed memory location with return type of String
        if(pN==null)
        {
            System.exit(0);
        }
        while(pN.equals(""))
        {            
            pN = JOptionPane.showInputDialog(null, "How many players?\nMaximum of 4.\nRecommended to play with 4." );//invokes static method showInputDialog with implicit parameter JOptionPane,and explicit paramter of "null, Player 1, enter a word", stores user input to newly constructed memory location with return type of String
            if(pN==null)
            {
                System.exit(0);
            }
        }
        playerNumber = Integer.parseInt(pN);//invokes static mutator method 'parseInt', static methods are invoked with class name 'Integer', explicit parameter of type String referenced by 'pN', stores value returned to integer value referenecd by 'playerNumber'

        fC.addActionListener(this);//invokes mutator method 'addActionListener' on variable of type JFileChooser referenced by 'fC', 'this' in explicit  parameter refers to this specific class
        for (int i=1;i<playerNumber+1;i++)//for loop, initializes newly declared int to 0, conditional of int i< int referenced by 'playerNumber'
        {
            String name = JOptionPane.showInputDialog(null, "Player " + i + " enter your name." );//initializes variable of type String, invokes static method 'showInputDialog' with class name with explicit parameter, stores value returned to memory location referenced by 'name'
            pList.add(new Player(name, i ));
            if (name ==null)//if statement, checks if String referenced by 'name' is null-there is nothing stored in it, it is a blank string
            {
                System.exit(0);//invokes mutator method 'exit' on implicit parameter 'System' with explicit parameter 0
            }//invokes mutator method 'add' on ArrayList referenced by 'pList', constructs new Player in explicit parameter with explicit parameters, stores in ArrayList 'pList'
        }

        board = new Board(pList);//initializes variable of type Board referenced by 'board', constructs instance of Board class with explicit parameter of type ArrayList referenced by 'pList'
        board.displayBoard();//invokes mutator method 'displayBoard' on implicit parameter of type Board referenced by 'board'

    }

    public void playGame()//new mutator method
    {
        index = 0;//sets value of int variable 'index' to 0

        boolean win = false;//constructs new boolean variable referenced by 'win', set to false
        board.playTurn(pList.get(index));//invokes mutator method 'playTurn' on Board object referenced by 'board' with explicit parameter that invokes accessor method 'get' on ArrayList referenced by 'pList' with explicit parameter of type int referenced by 'index'

    }

    public void actionPerformed(ActionEvent e)//overrides actionPerformed method that is initially defined in ActionListener class
    {
        /*if(e.getSource()==board.getEndTurn())//if statement, invokes accessor method 'getSource' on ActionEvent referenced by 'e', checks equivalence of value returned to value returned by invoking accessor method 'getEndTurn' on Board object 'board'
        {
        index++;//arithmatic operation
        board.playTurn(pList.get(index));//invokes mutator method 'playTurn' on Board object referenced by 'board' with explicit parameter that invokes accessor method 'get' on ArrayList object referenced by 'pList' with 

        }*/

    }

    public void nextTurn(Player player)//new mutator method with explicit paremeter of type Player
    {
        player.nextTurn();//invokes mutator method 'nextTurn' on Player object referenced by 'player'
    }

    public void setIndex(int x)//new mutator method with explicit parameter of type int
    {
        index = x;//sets instance field variable of type int 'index' equal to parameter variable 'x'
    }

}

