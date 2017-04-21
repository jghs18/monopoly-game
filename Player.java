import javax.swing.*;
import java.io.File;
//imports 
public class Player
{
    String name;
    JLabel imgLabel;
    int balance;
    boolean turn;
    int pos;
    int ref;
    //instance field variables
    public Player(String n, int r)//constructor for Player class with explciit parameter that takes in various variable types
    {
        name = n;
        imgLabel = new JLabel();
        //initializes instance field variables
        balance = 700;//initializes value of instance field variable of type int 'balance' to 1500
        //icon = new ImageIcon(f.getPath());//initializes instance field variable of type ImageIcon 'icon' to new ImageIcon constructed with explcit parameter that invokes accessor method 'getPath' on parameter variable 'f'

        pos = 0;
        ref = r;
        //initializes instance field variables
        //imgLabel.setIcon(icon);//invokes mutator method 'setIcon' on Jlabel object 'imgLabel' wtih explicit parameter of type ImageIcon referenced by 'icon'
        imgLabel.setText(n);
    }

    public int getBalance()//new accessor method
    {
        return balance;
    }

    public Player(){}//empy argument constructor

    public void withdraw(int x)//new accessor method 'withdraw'
    {
        balance-=x;//sets value of int referenced by mathematical operation
        System.out.println("works");
    }

    public int getRef()//new accessor method
    {
        return ref;
    }

    public int getPos()//new accessor method
    {
        return pos;
    }

    public void setPos(int p)//new mutator method
    {
        pos = p;
    }

    public void payRentTo(Player other, int rent)//new mutator method
    {
        balance -= rent;
        other.addToBalance(rent);
    }

    public void addToBalance(int value)//new mutator method
    {
        balance += value;
    }

    public void takeFromBalance(int value)//new mutator method
    {
        balance -= value;
    }

    public void setTurn()//new mutator method
    {
        turn = true;
    }

    public void nextTurn()//new mutator method
    {
        turn=false;
    }

    public String getName()//new accessor method
    {
        return name;
    }

    public void setBalance(int b)//new mutator method
    {
        balance = b;
    }

    public JLabel getImgLabel()//new accessor method
    {
        return imgLabel;
    }

}
