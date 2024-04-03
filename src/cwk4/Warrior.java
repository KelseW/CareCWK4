package cwk4;

public class Warrior extends Champion {

    private String weaponType;

    public Warrior(String name, int skillLevel, int entryFee, String weapType) {
        super(name, skillLevel, entryFee);
        weaponType = weapType;
    }

    public String getWeaponName()
    {
        return weaponType;
    }

    @Override
    public boolean canMeetChallenge(ChallengeType type) {
        return type == ChallengeType.FIGHT;
    }

    @Override
    public String toString() {
        return super.toString() + "The weapon type is " + weaponType;
    }

}
