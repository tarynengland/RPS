package RPS.GRUNT;

import javafx.geometry.Bounds;

public class Position {

    private double xPos;
    private double yPos;


    public Position(double x, double y) {
        this.xPos = x;
        this.yPos = y;
    }
    public Position(Bounds b, int radius){
        this(radius + (Math.random() * (b.getWidth() - 2 * radius)),
            radius + (Math.random() * (b.getHeight() -2 * radius)));
    }
    public double getX(){
        return xPos;
    }
    public double getY(){
        return yPos;
    }

    public void moving(Position pos, Bounds b, int radius, Move move){
        pos.xPos += move.getdX();
        pos.yPos += move.getdY();
        if(pos.xPos > b.getWidth() - radius || pos.xPos < radius){
            move.changedX();
            pos.xPos += move.getdX();
        }
        if(pos.yPos > b.getHeight() - radius || pos.yPos < radius){
            move.changedY();
            pos.yPos += move.getdY();
        }
    }
    public double edge(Position pos){
        return Math.sqrt(Math.pow(this.xPos - pos.xPos, 2) + Math.pow(this.yPos - pos.yPos,2));
    }
}
