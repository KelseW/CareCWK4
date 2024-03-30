package cwk4;
import java.util.*;
import java.io.*;

public class Champion {
    private int entryFee;
    private String name;
    private int skillLevel;

    public Champion(String name, int skillLevel, int entryFee ){
        this.entryFee = entryFee;
        this.name = name;
        this.skillLevel = skillLevel;
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
     * Sets the skill level of the Campion.
     *
     * @param skillLevel The skill level of the Campion.
     */
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Returns information about our champion
     * name
     * entry fee
     * skill level
     * @return
     */
    public String toSring(){
        String s = "";
        s += "The name of the champion is "+ name;
        s += "The entry fee of champion is " + entryFee;
        s += "The skill level of champion is " + skillLevel;
        return s;
    }

}
