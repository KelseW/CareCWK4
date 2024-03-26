package cwk4; 


/**
 * Details of your team
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teamwork
{
    private String[] details = new String[12];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "CS58";
        
        details[1] = "Kovacs Sotet";
        details[2] = "Krisztian";
        details[3] = "21003480";

        details[4] = "Lynn";
        details[5] = "Cooper";
        details[6] = "21040493";

        details[7] = "Tavershima";
        details[8] = "Bemshima";
        details[9] = "21005873";


        details[10] = "Wemhoener";
        details[11] = "Kelsey";
        details[12] = "21080573";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
