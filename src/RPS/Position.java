package RPS;

import javafx.geometry.Bounds;

public class Position {

    private double xPos;
    private double yPos;
    private double dX;
    private double dY;

    public Position(double x, double y) {
        this.xPos = x;
        this.yPos = y;
        if (Math.random() < 0.5) {
            dX = 1;
            dY = -1;
        }else{
            dX = -1;
            dY = 1;
        }
    }
    public Position(Bounds b, int radius){
        this(radius + (Math.random() * (b.getWidth() - 4 * radius)),
            radius + (Math.random() * (b.getHeight() -4 * radius)));
    }
    public double getX(){
        return xPos;
    }
    public double getY(){
        return yPos;
    }
    public double getdX(){
        return dX;
    }
    public double getdY(){
        return dY;
    }
    public void changedX(){
        dX *= -1;
    }
    public void changedY(){
        dY *= -1;
    }
    public void Moving(Position pos, Bounds b, int radius){
        xPos += pos.getdX();
        yPos += pos.getdY();
        if(xPos > b.getWidth() - radius || xPos < radius){
            pos.changedX();
            xPos += pos.getdX();
        }
        if(yPos > b.getHeight() - radius || yPos < radius){
            pos.changedY();
            yPos += pos.getdY();
        }
    }
    public double edge(Position pos){
        return Math.sqrt(Math.pow(this.xPos - pos.xPos, 2) + Math.pow(this.yPos - pos.yPos,2));
    }
}