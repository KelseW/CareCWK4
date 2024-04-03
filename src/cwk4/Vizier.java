package cwk4;

import java.util.ArrayList;

public class Vizier extends Player{
    //boolean which is used to see if game for player is still active
    private boolean gameState = true;

    /*
    Constructor for vizier class that extends to Player
    which constructs its supers class
    */
    public Vizier(String nme, int id, int treas) {
        super(nme, "Vizier", id, treas);
        TeamRoster Roster = new TeamRoster(getPlayerID());
    }

    //checks to see if vizier is able to buy certain champion
    public boolean checkGuldChamp(Champion champ){
        boolean buyable = false;
        int cost = champ.getEntryFee();
        if (cost <=getPlayerTreasury()){
            buyable = true;
        }
        return buyable;
    }
    // returns game state
    public boolean isGameState() {
        return gameState;
    }
    @Override
    //overrides the toString in super with the toString from super and own variables
    public String toString(){
        return gameState+"\n"+super.toString();
    }

}
