import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
//imports
public class Board implements ActionListener//implements-uses
{
    JFrame mainFrame;
    JPanel mainPanel;
    JPanel topPanel;
    JPanel rightPanel;
    JPanel bottomPanel;
    JLabel dLabel;
    JPanel playerPanel;
    JPanel leftPanel;
    JPanel centerPanel;
    Space[] spaceList;
    JButton endTurn;
    File f1;
    JPanel monopolyContain;
    Dice d;
    Color[] colorList;
    JButton dice;
    ArrayList<Player> pList;
    int pNum;
    boolean endTurnB;
    Player p;
    int index;
    ArrayList<JLabel> bankP = new ArrayList<JLabel>();
    //instance fields
    public Board(ArrayList<Player> p)//Board constructor with explicit parameter of type ArrayList 
    {
        mainFrame = new JFrame("Monopoly");//constructs new JFrame object with explicit parameter of type String, stores to memory location referenced by 'mainFrame'
        //mainFrame.setSize(1050,1050);
        Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();//constructs new Dimension object 'dd', static method 'getDefaultToolkit' invoked from class Toolkit, invokes accessor method 'getScreenSize' on Toolkit object returned by invocation of static method
        mainFrame.setBounds(0,0,dd.width,dd.height);//invokes mutator method 'setBounds' on JFrame object 'mainFrame' with explicit parameters that invoke static fields from Dimension object 'dd'
        mainFrame.setSize(dd);//invokes mutator method 'setSize' on JFrame object 'mainFrame' with explicit parameter 'dd'
        mainPanel = new JPanel();//constructs new JPanel object, stores to memory location referenced by 'mainPanel'
        mainPanel.setLayout(new BorderLayout(0,0));//invokes mutator method 'setLayout' on Jpanel object 'mainPanel' with explicit parameter that constructs a new BorderLayout object with explicit parameters
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on jpanel object 'mainPanel' with explicit parameters that invoke static method 'createLineBorder' with class BorderFactory with explicit parameter that calls static field from color class 'black'
        //invokes mutator methods on Jpanel object 'mainpanel' with explicit parameters-1 constructs a new Borderlayout with explicit parameters, 2nd one invokes static method 'createLineBorder' on class BorderFactory with explicit parameter that uses static field 'black'
        spaceList = new Space[28];//consturcts Arraylsit of type Space, stored to memory location referenced by 'spaceList'
        colorList = new Color[9];//consturcts a new Array of type Color with length 9
        colorList[0] = new Color(99,74,18);//constructs a new color object with explicit parameters of type int, stores to array 'colorList'
        colorList[1] = new Color(119,223,237);//constructs a new color object with explicit parameters of type int, stores to array 'colorList'
        colorList[2] = new Color(252,63,192);//constructs a new color object with explicit parameters of type int, stores to array 'colorList'
        colorList[3] = new Color(252,156,0);//constructs a new color object with explicit parameters of type int, stores to array 'colorList'
        colorList[4] = Color.red;//invokes static field from color class 'red' using class name 'Color', stores to array referenced by 'colorList'
        colorList[5] = Color.yellow;//invokes static field from color class 'red' using class name 'Color', stores to array referenced by 'colorList'
        colorList[6] = Color.green;//invokes static field from color class 'green' using class name 'Color', stores to array referenced by 'colorList'
        colorList[7] = Color.blue;//invokes static field from color class 'blue' using class name 'Color', stores to array referenced by 'colorList'
        colorList[8] = Color.black;//invokes static field from color class 'black' using class name 'Color', stores to array referenced by 'colorList'
        dLabel = new JLabel();//initializes instance field of type JLabel 'dLabel' by constructing new jLabel object
        d = new Dice();//initializes instance field of type Dice 'd' by constructing new Dice object
        pList = p;//initializes instance field of type ArrayList 'pList' to ArrayList referenced by 'p', arraylist is retrieved from explicit parameter of construction from a Board object
        index = 0;//initializes instance field of type int 'index' to 0
    }

    public void displayBoard()//new mutator method
    {
        topPanel = new JPanel();//initializes instance field variable of type jpanel 'topPanel' by constructing a new Jpanel object
        topPanel.setLayout(new GridLayout(1,8));//invokes mutator method 'setLayout' on Jpanel object 'topPanel' with explicit parameter taht constructs a new GridLayout with explicit parameter of type int
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on jpanel object 'topPanel' with explicit parameter that invokes static method 'createLineBorder' with class name 'Border Factory' with explicit parameter that calls static field from color class 'black' on class Color

        for(int i = 0; i<=7; i++)//for loop-checks value of int i
        {
            if (i==0)//checks equivalence of int variable 'i' to 0
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/Go.jpg"), false);//constructs new Cornerspace object with explicit parameter that consturcts a new ImageIcon with explicit parameters, stores to spaceList at position 'i'

            }
            else if (i==7)//checks equivalence of int variable 'i' to 7
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/jail.jpg"), false);//constructs new Cornerspace object with explicit parameter that consturcts a new ImageIcon with explicit parameters, stores to spaceList at position 'i'

            }

            else if(i==3)//checks equivalence of int variable 'i' to 3
            {
                spaceList[i] = new CardSpace("Community Chest", new ImageIcon("Images/ComChest.jpg"));//constructs new Cornerspace object with explicit parameter that consturcts a new ImageIcon with explicit parameters, stores to spaceList at position 'i'

            }
            else if(i>=1&&i<=2)//checks equivalence of int variable 'i' to less than or equal to 1 and less than or equal to 2
            {
                spaceList[i] = new PropertySpace(colorList[0], i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'

            }
            else if(i>=4&&i<=6)//checks equivalence of int variable 'i' to less than or equal to 4 and less than or equal to 6
            {
                spaceList[i] = new PropertySpace(colorList[1],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'

            }

            topPanel.add(spaceList[i]);//invokes mutator method 'add' on Jpanel object 'topPanel' with explicit parameter of type Space, space is retrieved from ArrayList 'spaceList' at position of int value 'i'
        }
        rightPanel = new JPanel();//initializes instance field variable of type JPanel 'rightPanel' to construction of new jpanel
        rightPanel.setLayout(new GridLayout(6,1));//invokes mutator method 'setLayout' on JPanel object 'rightpanel' with explicit parameter that constructs a new GridLayout with explicit parameters of type int
        rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on jpanel object 'rightpanel' with explicit parameter of static method 'createLineBorder' which is invoked on class 'BorderFactory' with explicit parameter that calls static field of color class 'black'

        for(int i = 8; i<=13; i++)//for loop-initializes new int value 'i' to 8, checks equivalence of int value 'i' to less than or equal to 13, mathematical operation addition 
        {

            if(i>=8&&i<=10)//checks equivalence of int value 'i' to greater than or equal to 9 and less than or equal to 10
            {
                spaceList[i] = new PropertySpace(colorList[2],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'

            }
            else if(i>=11&&i<=13)//checks equivalence of int value 'i' to greater than or equal to 11 and less than or equal to 13
            {
                spaceList[i] = new PropertySpace(colorList[3],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'
                spaceList[i].setPreferredSize(spaceList[i].getPreferredSize());//invokes mutator method 'setPreferredSize' on Space object stored in ArrayList 'spaceList' at position of int value 'i', with explicit parmater of type int, int is retreived from invoking accessor method 'getPreferredSize'; on Space object stored in ArrayList 'spaceList' at position of int value 'i'
                spaceList[i].validate();//invokes mutator method 'validate' on Space object stored in ArrayList 'spaceList' at position of int value 'i'

            }
            rightPanel.add(spaceList[i]);//invokes mutator method 'add' on Jpanel object 'rightPanel' with explicit parameter of type Space, Space is retrieved from ArrayList 'spaceList' at position of int value 'i'
        }

        bottomPanel = new JPanel();//initializes instance field variable of type Jpanel 'bottomPanel' to newly constructed jpanel object
        bottomPanel.setLayout(new GridLayout(1,8));//invokes mutator method 'setLayout' on Jpanel object 'bottomPanel' with explicit parameter that constructs a new GridLayout with explicit parameter of type int
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on Jpanel object 'bottomPanel' with explicit parameter of static method 'createLineBorder' which is invoked on class 'BorderFactory' with explicit parameter that calls static field of color class 'black'

        for(int i = 21; i>=14; i--)//initializes int value 'i' to 21, checks equivalence of int value 'i' is greater than or equal to 14
        {
            if (i==21)//checks equivalence of int value 'i' to 21
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/gtj.jpg"), false);//constructs new Cornerspace object with explicit parameter that consturcts a new ImageIcon with explicit parameters, stores to spaceList at position 'i'

            }
            else if (i==14)//checks equivalence of int value 'i' to 14
            {
                spaceList[i]=new Cornerspace(new ImageIcon("Images/freeparking.jpg"), false);//constructs new Cornerspace object with explicit parameter that consturcts a new ImageIcon with explicit parameters, stores to spaceList at position 'i'

            }

            if(i>=18&&i<=20)//checks equivalence of int value 'i' greater than or equal to 18 and less than or equal to 20
            {
                spaceList[i] = new PropertySpace(colorList[5],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'

            }
            else if(i>=15&&i<=17)//checks equivalence of int value 'i' greater than or equal to 15 and less than or equal to 17
            {
                spaceList[i] = new PropertySpace(colorList[4],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'
            }

            bottomPanel.add(spaceList[i]);//invokes mutator method 'add' on JPanel object 'bottomPanel' with explicit parameter of type Space, space is retrieved from ArrayList 'spaceList' at position of int value 'i'
        }

        leftPanel = new JPanel();//initializes instance field variable of type Jpanel 'leftpanel' to newly constructed jpanel object
        leftPanel.setLayout(new GridLayout(5,1));//invokes mutator method 'setLayout' on Jpanel object 'leftPanel' with explicit parameter that constructs a new Gridlayout with explicit parameters of type int
        leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on Jpanel object 'leftPanel' with explicit parameter of static method 'createLineBorder' which is invoked on class 'BorderFactory' with explicit parameter that calls static field of color class 'black'

        for(int i = 26; i>=22; i--)//initializes int value 'i' to 26, checks equivalence of int value 'i' is greater than or equal to 22
        {
            if(i>=25&&i<=26)//checks equivalence of int value 'i' greater than or equal to 25 and less than or equal to 26
            {
                spaceList[i] = new PropertySpace(colorList[7],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'
                leftPanel.add(spaceList[i]);//invokes mutator method 'add' on jpanel object 'leftPanel' with explicit parameter of type Space, space is returned from ArrayList 'spaceList' at position of int value 'i'
            }
            else if(i>=22&&i<=24)//checks equivalence of int value 'i' greater than or equal to 22 and less than or equal to 24
            {
                spaceList[i] = new PropertySpace(colorList[6],i);//constructs new PropertySpace object with explicit parameter of type color and int, color is retrieved from arrayList 'colorList', stored to ArrayList 'spaceList' at position of int value 'i'
                leftPanel.add(spaceList[i]);//invokes mutator method 'add' on jpanel object 'leftPanel' with explicit parameter of type Space, space is returned from ArrayList 'spaceList' at position of int value 'i'
            }

        }
        topPanel.setPreferredSize(new Dimension(200,160));//invokes mutator method 'setPreferedSize' on Jpanel object 'topPanel' with explicit parameter that constructs a new Dimension with explicit parameters of type int
        bottomPanel.setPreferredSize(new Dimension(200,160));//invokes mutator method 'setPreferredSize' on JPanel object 'bottomPanel' with explicit parameter that constructs a new Dimension with explicit parameters of type int

        mainPanel.add(topPanel, BorderLayout.NORTH);//invokes mutator method 'add' on jPanel object 'mainpanel' with explicit parameters of type Jpanel and that invoke static field 'NORTH' from BorderLayout class
        mainPanel.add(rightPanel, BorderLayout.EAST);//invokes mutator method 'add' on jPanel object 'mainpanel' with explicit parameters of type Jpanel and that invoke static field 'EAST' from BorderLayout class
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);//invokes mutator method 'add' on jPanel object 'mainpanel' with explicit parameters of type Jpanel and that invoke static field 'SOUTH' from BorderLayout class
        mainPanel.add(leftPanel,BorderLayout.WEST);//invokes mutator method 'add' on jPanel object 'mainpanel' with explicit parameters of type Jpanel and that invoke static field 'WEST' from BorderLayout class

        monopolyContain = new JPanel();//initializes instance field variable of type jpanel 'monopolyContain' to newly constructed Jpanel object 
        monopolyContain.setLayout(new BorderLayout());//invokes mutator method 'setLayout' on Jpanel object 'monopolycontain' with explicit parameter that constructs a new BorderLayout
        Cornerspace main = new Cornerspace(new ImageIcon("Images/monopolymain copy.png"), true);//constructs a new cornerspace object, stores to memory location referenced by 'main', constuction has explicit parameter of type imageicon, in explicit parameter new ImageIcon is constructed wtih explicit paramter fo type String
        ImageIcon iCD = new ImageIcon("Images/dice.png");//constructs a new imageicon object with explicit parameter of type String, stores to memory location referenced by 'iCD'
        dice = new JButton(iCD);//initializes instance field variable of type jbutton 'dice' with explicit parameter of type ImageIcon 'iCD'
        dice.setSize(iCD.getIconWidth()+4, iCD.getIconHeight()+1);//invokes mutator method 'setSize' on JButton object 'dice' with explicit parameters of type int, explicit parameters use accessor methods 'getIconHeight' from ImageIcon object 'iCD'
        endTurn = new JButton(); //initializes instance field variable of type jButton 'endTurn' to newly constructed jButton

        playerPanel = new JPanel();//initializes instance field variable of type Jpanel 'playerPanel' to newly constructed JPanel object
        playerPanel.setLayout(new GridLayout(pList.size()+1, 1));//invokes mutator method 'setLayout' on jpanel object 'playerpanel' with explicit parameter that constructs a new GridLayout with explicit parameter of type int
        playerPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invokes mutator method 'setBorder' on Jpanel object 'playerPanel' with explicit parameter of static method 'createLineBorder' which is invoked on class 'BorderFactory' with explicit parameter that calls static field of color class 'black'

        for(int i = 0; i<pList.size(); i++)//for loop-initializs int value 'i' to 0
        {
            JLabel jL = new JLabel();//constructs a new jlabel object, stores to memory location referenced by 'jL'
            jL.setText(pList.get(i).getName() + ":  $" + Integer.toString(pList.get(i).getBalance()));//invokes mutator method 'setText' on JLabel object 'jL' with explicit parameter of type String, explicit parameter calls accessor method 'getName' on String object returned by 'get' on ArrayList 'pList' at position of int value 'i', also calls static method 'toString' from Integer class with explicit parameter that invokes accessor method 'getbalance' on value returned by invoking 'get' method on ArrayList 'pList' at position of int value 'i'
            jL.setFont(new Font("Lucida Grande", Font.BOLD, 20));//invokes mutator method 'setFont' on jlabel object 'jL' with explicit parameter that contructs a new font object
            playerPanel.add(jL);//invokes mutator method 'add' on jpanel object 'playerpanel' with explicit parameter of type jlabel 'jL'
            bankP.add(jL);//invokes mutator methoed 'add' on ArrayList object 'bankP' with explicit parameter of type jlabel 'jL'
        }
        JPanel containerYE = new JPanel();//constructs new jpanel object, stores to memory location referenced by 'containerYe'
        containerYE.setLayout(new BorderLayout());//invoke mutator method 'setlayout' on Jpanel object 'containerYe' with explicit parameter that construccts a new BorderLayout
        containerYE.add(main, BorderLayout.NORTH);//invokes mutator method 'add' on jpanel object 'containerYe' with explicit parameter that uses static field 'NORTH' from class BorderLayout
        containerYE.add(playerPanel, BorderLayout.CENTER);//invokes mutator method 'add' on Jpanel object 'containerYe' with explicit parameter of type jpanel and uses static field 'CENTER' from class BorderLayout
        monopolyContain.add(containerYE, BorderLayout.CENTER);//invokes mutator method 'add' on JFrame object 'monopolycontain' with explicit parameter that uses static field from BorderLayout class 'CENTER'
        monopolyContain.add(endTurn,BorderLayout.EAST);//invokes mutator method 'add' on JFrame object 'monopolycontain' with explicit parameter that uses static field from BorderLayout class 'EAST'
        monopolyContain.add(dLabel,BorderLayout.WEST);//invokes mutator method 'add' on JFrame object 'monopolycontain' with explicit parameter that uses static field from BorderLayout class 'WEST'
        monopolyContain.add(dice, BorderLayout.SOUTH);//invokes mutator method 'add' on JFrame object 'monopolycontain' with explicit parameter that uses static field from BorderLayout class 'SOUTH'

        mainPanel.add(monopolyContain, BorderLayout.CENTER);//invokes mutator method 'add' on jpanel object 'mainpanel' with explicit parameter that uses static field from BorderLayout class 'CENTER'
        mainFrame.add(mainPanel);//invokes mutator method 'add' on JFrame object 'mainFrame' with explicit parameter of type jpanel 'mainpanel'
        mainFrame.setVisible(true);//invokes mutator method 'setvisible' on JFrame object 'mainFrame' with explicit parameter of type boolean

        main.setPos(false);//invokes mutator method 'setPos' on Cornerspace object 'main' with explicit parameter of type boolean
        dice.addActionListener(this);//invokes mutator method 'addActionListener' on Dice object 'dice' with explicit parameter of this-this refers to the action performed method below
        endTurn.addActionListener(this);//invokes mutator method 'addActionListener' on jbutton object 'endTurn' with explicit parameter of this-this refers to action performed method below

        for (int i = 0; i<pList.size(); i++)//put everyone on Go space---initializes int value of 'i' to 0
        {
            this.add(pList.get(i),i+1, 0);//invokes mutator method 'add' on 'this'-this refers to this class
        }
        for (int i = 1; i<=2; i++)//initializes int value of 'i' to 1, checks equivalence of int value 'i' if less than or equal to 2
        {
            spaceList[i].getYesButton().addActionListener(this);//invokes mutator method 'addActionListener' on JButton object returned by method 'getYesButton' invoked on Space object at position of int value 'i' in spaceList,explicit parameter of this refers to action performed method below
        }
        for (int i = 4; i<=6; i++)//initializes int value of 'i' to 4, checks equivalence of int value 'i' if less than or equal to 6
        {
            spaceList[i].getYesButton().addActionListener(this);//invokes mutator method 'addActionListener' on JButton object returned by method 'getYesButton' invoked on Space object at position of int value 'i' in spaceList,explicit parameter of this refers to action performed method below
        }
        for (int i = 8; i<=13; i++)//initializes int value of 'i' to 8, checks equivalence of int value 'i' if less than or equal to 13
        {
            spaceList[i].getYesButton().addActionListener(this);//invokes mutator method 'addActionListener' on JButton object returned by method 'getYesButton' invoked on Space object at position of int value 'i' in spaceList,explicit parameter of this refers to action performed method below
        }
        for (int i = 15; i<=20; i++)//initializes int value of 'i' to 15, checks equivalence of int value 'i' if less than or equal to 20
        {
            spaceList[i].getYesButton().addActionListener(this);//invokes mutator method 'addActionListener' on JButton object returned by method 'getYesButton' invoked on Space object at position of int value 'i' in spaceList,explicit parameter of this refers to action performed method below
        }
        for (int i = 22; i<=26; i++)//initializes int value of 'i' to 22, checks equivalence of int value 'i' if less than or equal to 26
        {
            spaceList[i].getYesButton().addActionListener(this);//invokes mutator method 'addActionListener' on JButton object returned by method 'getYesButton' invoked on Space object at position of int value 'i' in spaceList,explicit parameter of this refers to action performed method below
        }

    }

    public void add(Player p, int playerRef, int pos)//new mutator method with explicit parameters of various types
    {
        Space space = spaceList[pos];//Space object in ArrayList 'spaceList' at position of parameter int value 'pos' is stored to space object referenced by 'space'
        JPanel spot = space.getPlayerSpot(playerRef);//constructs new jpanel object 'spot' from invoking accessor method 'getPlayerSpot' on Space object 'space' with explicit parameter of int parameter variable 'playerRef'
        spot.add(p.getImgLabel());//invokes mutator method 'add' on JPanel object 'spot' with explicit parameter of type image, image is retrieved frokm invoking accessor method 'getImgLabel' on Player 'p'
    }

    public void actionPerformed(ActionEvent e)//overrides actionPerformed method
    {
        if(e.getSource()==dice)//checks equivalence of value returned by invoking acessor method 'getSource' on implicit parameter of type ActionEvent 'e' to Jbutton 'dice'
        {
            endTurn.setText("End " + p.getName() + "'s turn");//invokes mutator method 'setText' on jbutton object 'endTurn' with explicit parameter that invokes acessor method 'getName' on Player object 'p'
            int rollResult = d.roll();//creates a new int value returned by invoking accessor method 'roll' on implicit parameter of type Dice 'd', stores to int 'rollResult'

            dLabel.setText(p.getName()+ d.getStr());//invokes mutator method 'setText' on implicit parameter of type JLabel 'dLabel' with implicit parameter that invokes acessor method 'getName' on player object 'p' and invoking accessor method 'getSTr' on Dice object 'd'

            move(p, rollResult);//invokes mutator method 'move' with explicit parameters of type Player 'p' and int 'rollResult'
            Space rent = spaceList[p.getPos()];//constructs a new Space object 'rent' from Space object returned from ArrayList 'spaceList' at position of int value returned by invoking accessor method 'getPos' on Player object 'p'

            if((rent.hasOwner()))//invokes accessor method 'hasOwner' on Space object 'rent'
            {
                p.setBalance(p.getBalance()-rent.getRent());//invokes mutator method 'setBalanec' on Player object 'p' with explicit parameter that invokes accessor method 'getBalance' on player object 'p' and accesssor method 'getRent' on Space object 'rent'
                rent.getOwner().setBalance(rent.getOwner().getBalance()+rent.getRent());//invokes mutator method 'setBalance' on Player returned by invoking accessor method 'getOwner' on Space object 'rent', with explicit parameter that invokes accessor method 'getbalcne' on Player returned by invoking accessor method 'getOwner' on Space object 'rent'
                
                for(int i = 0; i<pList.size(); i++)
                {
                    bankP.get(i).setText(pList.get(i).getName() + "  $" + Integer.toString(pList.get(i).getBalance()));//invokes mutator method 'setText' on JLabel object returned by invoking accssor method 'get' on ArrayList 'bankP' with explicit parameter of type int 'i' with explicit paramter that invokes static method 'toString' on class Integer with explicit parameter that invokes accessor method 'getBalance'

                }
            }
        }
        if(e.getSource()==endTurn)//checks equivalence of value returned by invoking acessor method 'getSource' on implicit parameter of type ActionEvent 'e' to Jbutton 'endTurn'
        {
            index++;
            if (index>3) index = 0;//needs to adjust for number of players
            playTurn(pList.get(index));//invokes mutator method 'playTurn' with explicit parameter of type Player returned by invoking accssor method 'get' on ArrayList 'pList' with explicit parameter of type int 'index'

        }
        if(e.getSource()==(spaceList[p.getPos()].getYesButton()))//checks equivalence of value returned by invoking acessor method 'getSource' on implicit parameter of type ActionEvent 'e' to Jbutton 'Yes' returned by invoking accessor method 'getyesButton' on space object in ArrayList 'spaceList' at position returned by invoing accessor method 'getPos' on Player object 'p'
        {

            Color passIn = new Color(0,0,0);//constructs a new color object 'passIn' with explicit parameters of type int
            p.withdraw(spaceList[p.getPos()].getCost(p.getPos()));//invokes mutator method 'withdraw' on Player object 'p' with explicit parameter of type int, int is returned from invoking accesor method 'getCost' on space in ArrayList 'spaceList' at position returned by invoking accesor method 'getPos' on Player object p
            spaceList[p.getPos()].setOwner(p);//invokes mutator method 'setOwner' on implicit parameter of type Space in ArrayList 'spaceList' at position returned by invoking accessor method 'getPos' on Player object 'p'

            JPanel cL = spaceList[p.getPos()].getColorLabel();//initializes Jpanel object 'cL', invokes accessor method 'getColorLabel' on on implicit parameter of type Space in ArrayList 'spaceList' at position returned by invoking accessor method 'getPos' on Player object 'p'
            //all these if statements control the color of the panel after a panel has been bought
            if(p.getPos()==1||p.getPos()==2)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = new Color(99,74,18);//constructs new Color object with explicit parameters of type int, stores to Color object 'passIn'
            }
            if(p.getPos()==4||p.getPos()==6||p.getPos()==5)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[1];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==8||p.getPos()==10||p.getPos()==9)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[2];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==11||p.getPos()==13||p.getPos()==12)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[3];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==15||p.getPos()==17||p.getPos()==16)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[4];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==18||p.getPos()==20||p.getPos()==19)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[5];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==22||p.getPos()==24||p.getPos()==23)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[6];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            if(p.getPos()==26||p.getPos()==27)//invokes accessor method 'getPos' on Player object 'p' and checks equivalence to boundary values
            {
                passIn = colorList[7];//stores Color returned from ArrayList 'colorList' at integer value in brackets to Color variable 'passIn'
            }
            spaceList[p.getPos()].setColorLabel(p, passIn);//invokes mutator method 'setColorLabel' on Space object in ArrayList 'spaceList' at position of int value returned by invoking accessor method 'getPos' on Player object 'p'

        }
        for(int i = 0; i<pList.size(); i++)
        {
            bankP.get(i).setText(pList.get(i).getName() + "  $" + Integer.toString(pList.get(i).getBalance()));//invokes mutator method 'setText' on JLabel object returned by invoking accssor method 'get' on ArrayList 'bankP' with explicit parameter of type int 'i' with explicit paramter that invokes static method 'toString' on class Integer with explicit parameter that invokes accessor method 'getBalance'

        }

        mainFrame.repaint();//invokes mutator method 'repaint' on implicit parameter of type JFrame 'mainFrame'
        mainFrame.setVisible(true);//invokes mutator method 'setVisible' on implicit parameter of type JFrame 'mainFrame' with explicit parameter of type boolean


    }

    public void drawBoard()//new mutator method
    {
        mainFrame.add(mainPanel);//invokes mutator method 'add' on JFrame object with explicit parameter of type JPanel 'mainpanel'
        mainFrame.setVisible(true);//invokes mutator method 'setVisible' on implicit parameter of type JFrame 'mainFrame' with explicit parameter of type boolean

    }

    public void playTurn(Player player)//new mutator method with explicit parameter of type Player
    {
        p = player;//sets value of instance field variable of type Player 'p' equal to parameter variable of type Player 'player'
    }

    public JButton getEndTurn()//new acceessor method
    {
        return endTurn;
    }

    public void move(Player p, int roll)//new mutator method with explicit parameters of type Player and int
    {
        Space current = spaceList[p.getPos()];//sets Space object returned from ArrayList 'spaceList' at position returned by invoing accessor method 'getPos' on Player object 'p' equal to new Space object 'current'
        current.remove(p);//invokes mutator method 'remove' on Space object 'current' with explicit parameter of type Player 'p'
        int newSpaceInt = p.getPos() + roll; //creates new int 'newSpaceInt' equal to value returned by invoking accesssor method 'getPos' on Player object 'p'
        if (newSpaceInt>27) 
        {
            newSpaceInt-=27;//adjusting for cycling
            p.addToBalance(100);//invokes mutator method 'addToBalance' on implicit parameter of type Player 'p' with explicit parameter of type int

        }
        p.setPos(newSpaceInt);//invokes mutator method 'setPos' on Player object 'p' with explicit parameter of type int 'newSpaceInt'
        this.add(p,p.getRef(), newSpaceInt);//invokes mutator method 'add' on implicit parameter this with explicit parameters of type Player, and invokes accessor method 'getRef' on player object 'p'
    }
}