
/**
 * Write a description of class NameGenerator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NameGenerator
{
    // instance variables - replace the example below with your own
    private String firstname;
    private String lastname;
    private String mothermaidenname;
    private String borntown;

    /**
     * Constructor for objects of class NameGenerator
     */
    public NameGenerator(String first, String last, String mother, String born)
    {
        firstname = first;
        lastname = last;
        mothermaidenname = mother;
        borntown = born;
    }
    
    /**
     * Return your Star Wars name
     */
    public void Name(){
        String trimfirstname = firstname.substring(0, 2);
        String trimlastname = lastname.substring(0, 3);
        String trimmothermaidenname = mothermaidenname.substring(0, 2);
        String trimborntown = borntown.substring(0, 3);
        String swfirstname = trimlastname+trimfirstname;
        String swlastname = trimborntown+trimmothermaidenname;
        String swname = swfirstname+" "+swlastname;
        System.out.println(swname);
    }
}
