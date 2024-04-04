package cwk4;
import java.util.*;
import java.io.*;

public abstract class Champion implements Serializable{

    private int entryFee;
    private String name;
    private int skillLevel;
    private ChampionState champState;

    public Champion(String name, int skillLevel, int entryFee ){
        this.entryFee = entryFee;
        this.name = name;
        this.skillLevel = skillLevel;
        this.champState = ChampionState.WAITING;
    }


    /**
     * Returns the Entry Fee of the Champion.
     *
     * @return The Entry Fee of the Champion.
     */
    public int getEntryFee() {
        return entryFee;
    }


    /**
     * Returns the name of the champion
     *
     * @return name
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the skill level of the champion
     *
     * @return skillLevel
     */
    public int getSkillLevel() {
        return skillLevel;
    }

    /**
     * Sets the skill level of the Champion.
     *
     * @param skillLevel The skill level of the Champion.
     */
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Returns the champion's current state
     *
     * @return champState
     */
    public ChampionState getChampState(){
        return champState;
    }

    /**
     * Sets the champion's current state
     */
    public void setChampState(ChampionState champState) {
        this.champState = champState;
    }

    /**
     * returns true is champion is active to fight
     * @return
     */
    public boolean available(){
        return champState == ChampionState.ENTERED;
    }

    public abstract boolean canMeetChallenge(ChallengeType type);

    /**
     * Returns information about our champion
     * name
     * entry fee
     * skill level
     * @return
     */
    public String toString(){
        String s = "";
        s += "\nThe name of the champion is "+ name;
        s += "\nThe entry fee of champion is " + entryFee;
        s += "\nThe skill level of champion is " + skillLevel;
        s += "\nThe Champion's state is " + champState;
        return s;
    }

}
