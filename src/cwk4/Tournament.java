package cwk4;
import java.util.*;
import java.io.*;
/**
 * This interface specifies the behaviour expected from CARE
 * as required for 5COM2007 Cwk 4
 * 
 * @author 
 * @version 
 */

public class Tournament implements CARE
{
    private HashMap<String, Champion> reservedChampions = new HashMap<>();

    private HashMap<String, Champion> TeamRoster = new HashMap<>();

    private ArrayList<Challenges> ChallengeArray = new ArrayList<>();
    private String vizier;
    private int treasury;
    private  ArrayList<String> challengeList= new ArrayList<String>();



//**************** CARE ************************** 
    /** Constructor requires the name of the vizier
     * @param viz the name of the vizier
     */  
    public Tournament(String viz)
    {
      
        
       setupChampions();
       setupChallenges();
    }
    
    /** Constructor requires the name of the vizier and the
     * name of the file storing challenges
     * @param viz the name of the vizier
     * @param filename name of file storing challenges
     */  
    public Tournament(String viz, String filename)  //Task 3.5
    {
      
        
       setupChampions();
       readChallenges(filename);
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        String s = "\nVizier: " + vizier ;
        
        return s;
    }
    
    
    /** returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     * @returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     */
    public boolean isDefeated()
    {
        return false;
    }
    
    /** returns the amount of money in the Treasury
     * @returns the amount of money in the Treasury
     */
    public int getMoney()
    {
        return 0;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
        String s = "************ Champions available in reserves********";
        
        return s;
    }
    
        
    /** Returns details of the champion with the given name. 
     * Champion names are unique.
     * @return details of the champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
       
        return "\nNo such champion";
    }    
    
    /** returns whether champion is in reserve
    * @param nme champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme)
    {
        return (false);
    }
 
    // ***************** Team champions ************************   
     /** Allows a champion to be entered for the vizier's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the vizier's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme)
    {
        return -1;
    }
        
     /** Returns true if the champion with the name is in 
     * the vizier's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the vizier's team, false otherwise.
     **/
    public boolean isInViziersTeam(String nme)
    {
        return false;
    }
    
    /** Removes a champion from the team back to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because disqualified
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme)
    {
        Champion champ = getChamp(nme);
        if (champ == null){
            return 2;
        } else if (champ.getChampState() == ChampionState.DISQUALIFIED) { //checks if chsmpion has been disqualified
            return 1;
        }
        else{
            champ.setChampState(ChampionState.WAITING);
            TeamRoster.remove(nme);
            treasury = treasury + (champ.getEntryFee() / 2);
            return 0;
        }
    }
    
    
        
    /**Returns a String representation of the champions in the vizier's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the vizier's team
     **/
    public String getTeam()
    {
        String s = "************ Vizier's Team of champions********";
        if(TeamRoster.isEmpty()){
            return "\nThere are no champions in the team";
        }
        for(Champion champ: TeamRoster.values()){
            s += champ.toString();
        }
        return s;
    }
    
     /**Returns a String representation of the disquakified champions in the vizier's team
     * or the message "No disqualified champions "
     * @return a String representation of the disqualified champions in the vizier's team
     **/
    public String getDisqualified()
    {
        int counter = 0;
        String s = "************ Vizier's Disqualified champions********";
        for(Champion champ: TeamRoster.values()){
            if(champ.getChampState()== ChampionState.DISQUALIFIED){
                s += champ.toString();
                counter++;
            }
        }
        if(counter > 0){return "No disqualified champions";}
        
        return s;
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the  number of the challenge
     * @return true if the  number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         if (num > 0 && num <= ChallengeArray.size()) {
             return true;
         }
         return false;
     }    
   
    /** Provides a String representation of a challenge given by
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/

    public String getChallenge(int num)
    {
        if(isChallenge(num)) {
            ChallengeArray.get(num - 1).toString();
        }
        return "Challenge does not exist";
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        String s = "\n************ All Challenges ************\n";
        if(ChallengeArray.isEmpty()){
            return "There are no challenges";
        }
        for (Challenges xx: ChallengeArray){
            s += xx.toString();
        }
       
        return s;
    }
    
    
       /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team who can meet the 
     * challenge. The results of meeting a challenge will be 
     * one of the following:  
     * 0 - challenge won by champion, add reward to the treasury, 
     * 1 - challenge lost on skills  - deduct reward from
     * treasury and record champion as "disqualified"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and vizier completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int meetChallenge(int chalNo)
    {
        //Nothing said about accepting challenges when bust
        int outcome = -1 ;
        Challenges ww = getSpecificChallenge(chalNo);
        if(ww!=null){
            Champion xx = getChampionForChallenge(chalNo);

        }
        
        return outcome;
    }
 

    //****************** private methods for Task 3 functionality*******************
    //*******************************************************************************
    private void setupChampions()
    {
        

   }
     
    private void setupChallenges() {

    }
    /*---------Helper Functions--------*/
    public Champion getChampionForChallenge(int chalNo){
        Challenges xx = getSpecificChallenge(chalNo);
        for(Champion ww: TeamRoster.values()){
            if(ww.canMeetChallenge(xx.getChallengeType(chalNo)) || ww.available()){
                return ww;
            }
        }
    }

    public Champion getChamp(String nme){
        for(Champion xx: TeamRoster.values()){
            if(xx.getName().equals(nme)){
                return xx;
            }
        }
        return null;
    }

    public Challenges getSpecificChallenge(int No){
        for(Challenges xx: ChallengeArray){
            if(xx.getNo() == No){
                return xx;
            }
        }
        return null;
    }
    /**********End of helper fumctions******/
    // Possible useful private methods
//     private Challenge getAChallenge(int no)
//     {
//         
//         return null;
//     }
//    
//     private Champion getChampionForChallenge(Challenge chal)
//     {
//         
//         return null;
//     }

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3.5 ************************************************/  
    
    // ***************   file write/read  *********************
    /**
     * reads challenges from a comma-separated textfile and stores in the game
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename)
    {
        try {
            File challengeFile = new File("challengesAM.txt");
            Scanner myReader = new Scanner(challengeFile);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                challengeList.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            return;
        }
        int challengeNum = challengeList.size();
        Challenges[] allChallenges = new Challenges[challengeNum];
        for (int num = 0; num < challengeList.size(); num++) {
            String toBeArray = challengeList.get(num);
            int counter = 0;
            StringBuilder word = new StringBuilder();
            char breaker = ',';
            ArrayList<String> challengeFields = new ArrayList<String>();
            while (counter != toBeArray.length()) {

                char letter = toBeArray.charAt(counter);

                if (letter == breaker) {
                    challengeFields.add(word.toString());
                    word = new StringBuilder();
                    counter += 1;
                } else {
                    word.append(Character.toString(letter));
                    counter += 1;
                }
            }
            allChallenges[num] = new Challenges(num, challengeFields.get(0), challengeFields.get(1), challengeFields.get(2), challengeFields.get(3));
        }
    }   
    
     /** reads all information about the game from the specified file 
     * and returns a CARE reference to a Tournament object, or null
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
    public Tournament loadGame(String fname)
    {   // uses object serialisation 
       Tournament yyy = null;
       
       return yyy;
   } 
   
   /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
   public void saveGame(String fname){
        // uses object serialisation 
        
    }
 

}



