package RPS.GRUNT;

import javafx.geometry.Bounds;

public class Player {

    private Objects rps;
    private Position spot;
    private Position here;
    private Move move;

    private Bounds arena;

    public Player(Objects rps, Bounds arena){
        this.rps = rps;
        spot = new Position(arena, 10);
        this.arena = arena;
        here = new Position(spot.getX(), spot.getY());
        move = new Move();
    }
    public Position getHere(){
        return here;
    }
    public Objects getRPS() {
        return rps;
    }
    public void move(){
        spot.moving(here, arena, 10, move);
    }
    public void clash(Player opponent){
        if(this.here.edge(opponent.here) < 2 * 6){
            if(opponent.rps == Objects.ROCK && this.rps == Objects.SCISSORS){
                this.rps = Objects.ROCK;
            }else if(opponent.rps == Objects.SCISSORS && this.rps == Objects.PAPER){
                this.rps = Objects.SCISSORS;
            }else if(opponent.rps == Objects.PAPER && this.rps == Objects.ROCK) {
                this.rps = Objects.PAPER;
            }
        }
    }
}
