package RPS.GRUNT;


import javafx.geometry.Bounds;

import java.util.ArrayList;

public class Teams {

    private ArrayList<Player> team;

    public Teams(int members1, int members2, int members3, Objects role1, Objects role2, Objects role3, Bounds arena){
        team = new ArrayList<>();
        for (int i = 0; i < members1; i++){
            Player player = new Player(role1, arena);
            team.add(player);
        }
        for(int i = 0; i < members2; i++){
            Player player = new Player(role2, arena);
            team.add(player);
        }
        for(int i = 0; i < members3; i++) {
            Player player = new Player(role3, arena);
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
