package cwk4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Challenges {
    private ArrayList<String> challengeList = new ArrayList<String>();
    public Challenges() {

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
    }
    public ArrayList<String> getChallengeFields(int num) {
        String toBeArray = challengeList.get(num - 1);
        int counter = 0;
        String word = "";
        char breaker = ',';
        ArrayList<String> challengeFields = new ArrayList<String>();
        while (counter != toBeArray.length()) {

            char letter = toBeArray.charAt(counter);

            if(letter == breaker) {
                challengeFields.add(word);
                word = "";
                counter += 1;
            } else {
                word += Character.toString(letter);
                counter += 1;
            }

        }
        return challengeFields;
    }
    public ArrayList<String> getChallenges(){
        return challengeList;
    }
    public String getChallengeLine(int num){
        return challengeList.get(num-1);
    }
}
