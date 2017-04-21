 import java.util.Random;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
//imports
public class Dice
{
    private int first;
    JLabel dRoll;
    private int second;
    private Random gen;
    String str1;
    String str2;
    //instance field variables
    public Dice()//constuctor
    {
        gen = new Random();
    }

    public  int roll()//new accessor method
    {
        first = gen.nextInt(4)+1;//invokes accessor method 'nextInt' on Random object 'gen' with explicit parameter 4, mathematical operation adding 1, stores value returned to instance field first
        second = gen.nextInt(4)+1;
        str1 = Integer.toString(first);//invokes static mutator method 'toString' on class name 'Integer' with explicit parameter 'first', stores value returned to memory location referenced by 'str1'
        str2 = Integer.toString(second);
        dRoll = new JLabel(str1+str2);//initializes instance field variable 'droll', construtcts new JLabel object with explicit parameter 'str1 + str2'        
        return first+second;
    }
    
    public String getStr()//new accessor method
    {
        return   " rolled a: "+ str1+ " and a " + str2;
    }
    
    public boolean Doubles()//new accesssor method
    {
        if (first==second) return true;
        else return false;
    }
}
