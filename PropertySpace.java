import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
//imports
public class PropertySpace extends Space implements ActionListener//extends-is a type of, implements-uses
{
    int pos;
    boolean pressed;
    JLabel propertyName;
    static String[] propertyList = {"","600's Bathroom","100's Bathroom","","300's Bathroom","Little Theater","Cafeteria","","Snack Shack",
            "Commons","Counseling","Library","Campus Ministry","Quad","","200's Building",
            "Burns Pavilion","Alumni Gym","Graham Theater","Football Field","Robotics Lab","Quad", "Dean's Office","Faculty Lounge","Front Office",
            "Athletics Office","Andre House","Chech's Room"};
    static int[] priceList = {0,60,60,0,100,100,120,0,140,
            140,160,180,180,200,0,220,
            220,240,260,260,280,300,300,320,
            340,0,350,400};
    JLabel cost;
    JLabel owner;
    Color colorT;
    boolean secondColor;
    JPanel infoPanel;
    JFrame infoFrame;
    String ownerName;
    JButton buy;
    JButton info;
    JPanel topColor;
    JPanel bottom;
    JPanel buyPanel;
    JFrame buyFrame;
    JPanel confirmContainer;
    Cornerspace[]cornerList;
    String propertyTitle;
    JButton yes;
    JButton cancel;
    JButton closeInfo;
    int rent;
    int p;
    Player user;
    //instance field variables
    public PropertySpace(Color c, int pp)//PropertySpace constructor
    {
        p = pp;
        rent = priceList[pp]/8;
        //initializes instance field variables
        
        colorT = c;
        northP.setLayout(new GridLayout(4,1,0,0));
        northP.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on JPanel obejct 'northP' with explicit parameter that invokes static accessor method 'createLineBorder' with explicit parameter that calls static field of color class 'black'
        topColor = new JPanel();
        topColor.setBackground(c);//invokes mutator method 'setBackground' on jpanel object 'topColor' with explicit parameter 'c'

        propertyName = new JLabel(propertyTitle, JLabel.CENTER);//initializes instance feidl variable of type JLabel 'propertyName'

        cost = new JLabel("", JLabel.CENTER);
        //cost.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        owner = new JLabel("Owner: " + ownerName + "   " + "$" + priceList[p], JLabel.CENTER);
        //owner.setFont(new Font("Lucida Grande", Font.PLAIN, 15));

        bottom = new JPanel();
        buy = new JButton("Buy");

        confirmContainer = new JPanel();
        confirmContainer.setLayout(new GridLayout(1,2));
        yes = new JButton("Yes");
        yes.addActionListener(this);//invokes mutator method 'addActionListener' on JButton object 'yes' with explicit parameter 'this', 'this' refers to actionPerformed method that is overridden below
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        confirmContainer.add(yes);
        confirmContainer.add(cancel);//invokes mutator method 'add' on Jpanel object 'confirmContainer' with explicit parameter of type JButton 'cancel'

        closeInfo = new JButton("Close Window");
        closeInfo.addActionListener(this);

        buy.addActionListener(this);

        info = new JButton("Info");
        info.addActionListener(this);
       
        this.drawSpace(new Color(0,0,0));//invokes mutator method 'drawSpace' on implicit parameter 'this' with explicit parameter that constructs a new color

    }

    public void actionPerformed(ActionEvent e)//overriden actionPerformed method
    {
        if (e.getSource()==buy)//invokes accessor method 'getSource' on ActionEvent 'e', checks equivalence of value returned to JButton 'buy'
        {
            buyPanel = new JPanel();//constructs new Jpanel object, stores to memory location referenced by 'buyPanel'
            buyPanel.setLayout(new GridLayout(5,1));//invokes mutator setLayout method on the object referenced by buyPanel

            buyPanel.add(topColor);//invoking mutator method add on the object reference buyPanel
            buyPanel.add(propertyName);//invoking mutator add method on the object reference buyPanel with explicit parameter propertyName
            buyPanel.add(cost);
            //invokes mutator method 'add' on Jpanel object 'buypanel' with various explicit parameters all of type Jlabel
            JLabel confirm = new JLabel("Are you sure you want to buy this property?", JLabel.CENTER);
            confirm.setFont(new Font("Lucida Grande", Font.BOLD, 15));
            buyPanel.add(confirm);

            buyPanel.add(confirmContainer);
            buyFrame = new JFrame();
            buyFrame.setSize(400,500);
            buyFrame.add(buyPanel);
            buyFrame.setVisible(true);
            //various mutator methods invoked on JFrame object 'buyFrame' with varying explicit parameters
        }
        if (e.getSource()==info)//invokes accessor method 'getSource' on ActionEvent 'e', checks equivalence of value returned to JButton 'info'----contents of this block is the same as the previous block, just varying text in each jlabel
        {
            infoPanel = new JPanel();
            infoPanel.setLayout(new GridLayout(4,1));
            infoPanel.add(topColor);
            infoPanel.add(propertyName);
            JLabel rentLabel = new JLabel("Rent: $" + priceList[pos]/8, JLabel.CENTER);
            rentLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
            infoPanel.add(rentLabel);
            infoPanel.add(closeInfo);

            infoFrame = new JFrame();
            infoFrame.setSize(500,444);
            infoFrame.add(infoPanel);
            infoFrame.setVisible(true);
        }

        if  (e.getSource()==cancel)//invokes accessor method 'getSource' on ActionEvent 'e', checks equivalence of value returned to JButton 'cancel'
        {
            buyFrame.dispatchEvent(new WindowEvent(buyFrame, WindowEvent.WINDOW_CLOSING));//invokes mutator method 'dispatchEvent' on JFrame object 'buyFrame' with explicit parameter that constructs a new WindowEvent with explicit parameters that invoke static field 'WINDOW_CLOSING'
        }
        if  (e.getSource()==yes)//invokes accessor method 'getSource' on ActionEvent 'e', checks equivalence of value returned to JButton 'yes'
        {
            buyFrame.dispatchEvent(new WindowEvent(buyFrame, WindowEvent.WINDOW_CLOSING));//invokes mutator method 'dispatchEvent' on JFrame object 'buyFrame' with explicit parameter that constructs a new WindowEvent with explicit parameters that invoke static field 'WINDOW_CLOSING'
            buyPanel.add(topColor);
        }
        if  (e.getSource()==closeInfo)//invokes accessor method 'getSource' on ActionEvent 'e', checks equivalence of value returned to JButton 'closeInfo'
        {
            infoFrame.dispatchEvent(new WindowEvent(infoFrame, WindowEvent.WINDOW_CLOSING));//invokes mutator method 'dispatchEvent' on JFrame object 'buyFrame' with explicit parameter that constructs a new WindowEvent with explicit parameters that invoke static field 'WINDOW_CLOSING'
        }
    }

    public void drawSpace(Color tC)//new mutator method with explicit parameter of type Color 'tC'
    {
        JPanel jj =  new JPanel();
        bottom.setLayout(new GridLayout(1,2));
        jj.setBackground(tC);
        //northP.add(j);
        pos = p;
        if(secondColor)//if statement, checks value of boolean variable 'secondcolor'
        {
            northP.add(jj);//invokes mutator method 'add' on Jpanel object 'northP' wtih explicit parameter of type Jpanel 'jj'
        }
        else 
        {
            northP.add(topColor);
            bottom.add(buy);
        }
        if(owned)
        {
            bottom.remove(buy);
        }
        bottom.add(info);
        propertyName.setText(propertyList[p]);
        northP.add(propertyName);
        cost.setText("$" + priceList[p]);
        //northP.add(cost);
        northP.add(owner);
        northP.add(bottom);
        spaceP.add(northP, BorderLayout.CENTER);
        this.add(spaceP);

    }

    public JButton getYesButton()//new accessor method
    {
        return yes;   
    }

    public int getCost(int pos)//new accessor method, requires explicit parameter
    {
        return priceList[pos];
    }

    public JPanel getColorLabel()//new accessor method
    {
        return topColor;
    }

    public Player getOwner()//new accessor method
    {
        return user;
    }
    
    public int getRent()//new accessor method
    {
        return rent;
    }
    public void setOwner(Player p)//new mutator method with explicit parameter of type Player
    {
        if (!owned)//if statement-boolean value 'owned' is negated, if value returned is true, the following block will execute
        {
            ownerName = p.getName();//invokes accessor method 'getName' on Player object 'p', stores value returned to String referened by 'ownerName'
            user = p;
            owner.setText("Owner: " + ownerName + "   " + "$" + priceList[p.getPos()]);//invokes mutator method 'setText' on jLabel object 'owner' with explicit parameter of type string whcih invoeks accessor method 'getPos' on Player object 'p'
            owned = true;
        }
    }
    public boolean isOwned()//new accessor method
    {
        return owned;    
    }
    public void setColorLabel(Player p, Color tC)//new mutator method with explicit parameter of type Player and of type Color
    {
        secondColor = true;//sets value of boolean variable 'secondColor' to true
        this.drawSpace(tC);//invokes mutator method 'drawSpace' on implicit parameter 'this', with explicit parameter of type Color 'tC'
    }
}
