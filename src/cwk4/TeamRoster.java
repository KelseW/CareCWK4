package cwk4;

import java.util.ArrayList;

public class TeamRoster {
    private int playerID;
    private ArrayList<Champion> teamRoster = new ArrayList<Champion>();
    public TeamRoster(int id){
        playerID = id;
    }
    //method to add a champion to the roster
    public String addToRoster(Champion champ){
        teamRoster.add(champ);
        return champ.getName()+" has been added the roster";
    }
    //method to remove a champion to the roster
    public String removeFromRoster(Champion champ){
        teamRoster.remove(champ);
        return champ.getName()+" has been removed from roster";
    }
    //method to return the team roster
    public ArrayList<Champion> getTeamRoster() {
        return teamRoster;
    }
}
