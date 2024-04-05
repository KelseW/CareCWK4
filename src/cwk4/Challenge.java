package cwk4;

public class Challenge {
    private int chalNo;
    private ChallengeType chalType;
    private int skillLevel;
    private boolean result;
    private int reward;
    private String enemy;

    public Challenge(int chalNo, ChallengeType chalType, String enemy, int skillLevel, int reward) {
        this.chalNo = chalNo;
        this.chalType = chalType;
        this.enemy = enemy;
        this.skillLevel = skillLevel;
        this.reward = reward;
    }

    public int getChalNo() {
        return chalNo;
    }

    public ChallengeType getChallengeType() {
        return chalType;
    }

    public boolean doChallenge(Champion champ){
        if (champ != null) {
            return this.skillLevel <= champ.getSkillLevel();
        } else {
            return false;
        }
    }

    public String getEnemy() {
        return enemy;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public int getReward() {
        return reward;
    }

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
