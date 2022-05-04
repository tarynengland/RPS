package RPS.GRUNT;


import javafx.geometry.Bounds;

import java.util.ArrayList;

public class Teams {

    private ArrayList<Player> team;
    public static Objects role;

    public Teams(int members, Objects role, Bounds arena){
        team = new ArrayList<>();
        for (int i = 0; i <= members; i++){
            Player player = new Player(role, arena);
            team.add(player);
        }
    }
    public ArrayList<Player> getTeam(){
        return team;
    }
    public void move(){
        for (Player player: team){
            player.move();
        }
    }
    public void clashing(){
        for(Player player: team){
            for(Player opponent: team){
                player.clash(opponent);
            }
        }
    }
    public void royale(){
        move();
        clashing();
    }
}
