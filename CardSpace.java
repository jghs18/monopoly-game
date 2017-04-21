
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
//import statements
public class CardSpace extends Space//extends-is a type of, contains attributes of Space class
{
    BufferedImage img;//declaring instance field variable img as a BufferedImage
    ImageIcon i;
    boolean pos = true;
    String type;
    //instance field variables
    public CardSpace(String name, ImageIcon n)//constructor for Cardspace class
    {

        i=n;
        JLabel image = new JLabel();//constructs new JLabel object, referenced by 'image'
        image.setIcon(n);//invokes mutator method 'setIcon' on JLabel object referenced by 'image' with explicit paramter 'n'
        northP.add(image);//invokes mutator method 'add' on Jpanel object 'northP' with explicit parameter of type JLabel referenced by 'image'
        //pos = b;
        type = name;
        spaceP.add(northP, BorderLayout.CENTER);
        this.add(spaceP);
        /*img = null;//try catch statement to create imageIcon from a file
        try {
        img = ImageIO.read(n);//initializing img to the BufferedImage returned by invoking static accessor method read with explicit
        //parameter of type File invoked on the class ImageIO
        } catch (IOException ee) {//prevents crashing
        } */
    }

    public void paintComponent(Graphics g)//example of overriding the paintComponent method in the JComponent superclass
    {
        if(pos)
        {
            g.drawImage(img, 500-94, 500-94, null);//invokes mutator method 'drawImage' on Graphics object referenced by 'g' with explicit parameters of varying types
        }
        else
        {
            int xx = 1000-94;//initializing int x and assigning it to the int that is the result of the int
            //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
            //accesor method getWidth invoked on the img with
            int yy = 0;//initializing int x and assigning it to the int that is the result of the int
            //returned by accessor method getWidth invoked on this instance of the class subtracted from the int that resulted from the
            //accesor method getWidth invoked on the img with
            g.drawImage(img, xx, yy, null);//invoking mutator method drawImage on the object referenced by g with explicit parameters of type
            //bufferedImages, int, int, null
        }
    }

    public void setPos(boolean i)//new mutator method
    {
        pos = i;
    }

}
