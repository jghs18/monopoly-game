
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    
    public boolean catDog(String str) {
        int cat = 0;
        int dog = 0;
        if(str.contains("cat")&&(!str.contains("dog")))
        {
            return false;
        }
        if(str.contains("dog")&&(!str.contains("cat")))
        {
            return false;
        }
        for(int i = 0; i<str.length(); i++)
        {
            if (str.contains("cat"))
            {
                cat++;
            }
            if(str.contains("dog"))
            {
                dog++;
            }
            str = str.substring(i);
        }

        if(cat==dog) return true;
        return true;
    }


}
