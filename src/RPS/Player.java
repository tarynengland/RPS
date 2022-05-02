package RPS;

import javafx.geometry.Bounds;

public class Player {

    private Objects rps;
    private Position spot;

    private Bounds arena;

    public Player(Objects rps, Bounds arena){
        this.rps = rps;
        spot = new Position(arena, 5);
        this.arena = arena;
    }
    public void move(){
        spot.moving(spot, arena, 5);
    }
    public boolean clash(Player opponent){
        if(this.spot.edge(opponent.spot) < 2 * 5){
            if(opponent.rps == Objects.ROCK && this.rps == Objects.SCISSORS){
                this.rps = Objects.ROCK;
            }else if(opponent.rps == Objects.SCISSORS && this.rps == Objects.PAPER){
                this.rps = Objects.SCISSORS;
            }else if(opponent.rps == Objects.PAPER && this.rps == Objects.ROCK){
                this.rps = Objects.PAPER;
            }
            return true;
        }
        return false;
    }
}
