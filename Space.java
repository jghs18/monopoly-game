import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.io.*;
//imports
public class Space extends JPanel//extends-is a type of
{
    String n;
    JPanel spaceP;//this is essentially the Space itself
    JPanel northP = new JPanel();
    JPanel playersP;
    JPanel player1spot = new JPanel();//panel that holds player icon
    JPanel player2spot = new JPanel();
    JPanel player3spot = new JPanel();
    JPanel player4spot = new JPanel();
    JPanel sidePlayerPanel;
    boolean owned;
    //instance field variables
    public Space()//constructor for space class
    {
        owned = false;
        spaceP = new JPanel();
        //initialization of instance field variables
        spaceP.setLayout(new BorderLayout(0,0));//invokes mutator method 'setLayout' on JPanel object 'spaceP' with explicit parameter that consturcts new BorderLayout with explicit parameters
        //this.setPreferredSize(new Dimension(150,60));
        
        playersP = new JPanel();
        playersP.setLayout(new GridLayout(4,1,0,0));
        playersP.add(player1spot);
        playersP.add(player2spot);
        playersP.add(player3spot);
        playersP.add(player4spot);
        //invoking mutator method 'add' on JPanel object 'playersP' with explicit parameters of type JPanel
        
        sidePlayerPanel = new JPanel();
        sidePlayerPanel.setLayout(new GridLayout(4,1));
        

        spaceP.add(playersP, BorderLayout.WEST);
        

    }
    
    public void remove(Player p)//new mutator method with explicit parameter of type Player
    {
        int ref = p.getRef();
        if (ref==1) player1spot.removeAll();//removes all components in a panel
        else if (ref==2) player2spot.removeAll();
        else if (ref==3) player3spot.removeAll();
        else player4spot.removeAll();//invokes mutator method 'removeAll' on JPanel object 'player4spot'
        //if else statement-depending on which equivalenec statement is true, a certain method will be invoked
    }
    
    public JPanel getPlayerSpot(int ref)//new accesor method
    {
        if (ref==1) return player1spot;
        if (ref==2) return player2spot;
        if (ref==3) return player3spot;
        else return player4spot;
        //if else statement-depending on which equivalenec statement is true, a certain return statement will be used
    }
    
    public boolean hasOwner()//new accessor method
    {
        return owned;
    }
    
    public int getRent()//new accessor method
    {
        return 0;
    }
    
    public Player getOwner()//new accessor method --> overridden in the PropertySpace Class
    {
        return new Player();
    }

    public void setName(String n)//new mutator method
    {

    }
    public JButton getYesButton(){return new JButton();}//new accessor method
    public int getCost(int pos){return 0;}//new accessor method with explicit parameter of type int
    public void setOwner(Player p){}//new mutator method with explicit parameter of type Player
 
    public void setColorLabel(Player p, Color c){}//new mutator method with explicit parameter of type Player and of type Color
    public JPanel getColorLabel(){return new JPanel();}//new accessor method

}
