package RPS;

import javafx.geometry.Bounds;

import java.util.ArrayList;

public class Teams {

    private ArrayList<Player> team;
    private static int members;
    private Objects role;

    public Teams(int members, Bounds arena){
        team = new ArrayList<Player>();
        for (int i = 0; i <= members; i++){
            Player player = new Player(role, arena);
            team.add(player);
        }
    }
}
