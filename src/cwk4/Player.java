package cwk4;
import java.util.ArrayList;

public class Player {
    private int playerTreasury;
    private String playerName;
    private String playerRole;
    private int playerID;

    public Player(String nme, String clas, int id, int treas){
        playerName = nme;
        playerRole = clas;
        playerID = id;
        playerTreasury = treas;
    }

    public int getPlayerTreasury() {
        return playerTreasury;
    }

    public int getPlayerID() {
        return playerID;
    }
    public String getPlayerRole() {
        return playerRole;
    }
    public String getPlayerName(){
        return playerName;
    }

    public String addGulden(int gulden){
        playerTreasury+=gulden;
        return gulden+" Gulden has been added to Treasury";
    }
    public String removeGulden(int gulden){
        playerTreasury-=gulden;
        return gulden+" Gulden has been removed from Treasury";
    }
    public String toString(){
        return playerID+"\n"+playerName+"\n"+playerRole+"\n"+playerTreasury+"\n";
    }
}
