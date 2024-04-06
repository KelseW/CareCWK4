package cwk4;

public class Challenge {
    private int chalNo;//int typ for the number of challenge
    private ChallengeType chalType; //creates enum for the challenge type
    private int skillLevel;//int type for skill level required for challenge
    private boolean result; //boolean for result of a challenge
    private int reward; //int type for what the reward of the challenge is
    private String enemy; // String for the name of the enemy in the challenge

    public Challenge(int chalNo, ChallengeType chalType, String enemy, int skillLevel, int reward) {
        //constructor class assigns each variable inputted to its respective variable in the class
        this.chalNo = chalNo;
        this.chalType = chalType;
        this.enemy = enemy;
        this.skillLevel = skillLevel;
        this.reward = reward;
    }

    public int getChalNo() {
        return chalNo;
    }//returns the challenge number

    public ChallengeType getChallengeType() {
        return chalType;
    } //returns the challenge type

    public boolean doChallenge(Champion champ){
        if (champ != null) {
            return this.skillLevel <= champ.getSkillLevel();
        } else {
            return false;
        }
    }

    public String getEnemy() {
        return enemy;
    } //returns the enemy of the challenge

    public int getSkillLevel() {
        return skillLevel;
    } //returns the skill level of the enemy

    public int getReward() {
        return reward;
    } //returns the reward of winning the challenge

    public String toString(){
        String s  = "";
        s += "\nChallenge No: " + this.chalNo;
        s += "\nThe challenge type is: " + chalType.toString();
        s += "\nThe Enemy is: " + enemy;
        s += "\nThe skill level is: " + skillLevel;
        s += "\nThe reward is: " + reward;
        return s;
    }

}
