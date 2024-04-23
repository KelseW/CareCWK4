package cwk4;

public class Dragon extends Champion{
    private  boolean talks;
    public Dragon(String name, int skillLevel, int entryFee, boolean talks) {
        super(name, skillLevel, entryFee);
        this.talks = talks;
    }

    public boolean canTalk(){
        return talks;
    }

    public void setTalk(boolean talk){
        talks = talk;
    }

    @Override
    public String toString(){
        return super.toString() + "\nCan talk:  " + talks;
    }

    @Override
    public boolean canMeetChallenge(ChallengeType type) {
        boolean canMeetMystery = type == ChallengeType.MYSTERY && canTalk();
        boolean canMeetEither = type == ChallengeType.FIGHT || canMeetMystery;
        return canMeetEither;
    }
}
