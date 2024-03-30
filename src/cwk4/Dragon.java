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

    public boolean setTalk(boolean talk){
        talks = talk
    }

    @Override
    public String toSring() {
        return super.toSring() + "Can champion talk: " + talks;
    }
}
