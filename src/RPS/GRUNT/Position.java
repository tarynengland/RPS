package RPS.GRUNT;

import javafx.geometry.Bounds;

public class Position {

    private double xPos;
    private double yPos;
    private double dX;
    private double dY;

    public Position(double x, double y) {
        this.xPos = x;
        this.yPos = y;
        dX = -1;
        dY = 1;
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
    public double getdX(){
        return dX*2;
    }
    public double getdY(){
        return dY*2;
    }
    public void changedX(){
        dX *= -1;
    }
    public void changedY(){
        dY *= -1;
    }
    public void moving(Position pos, Bounds b, int radius){
        xPos += dX;
        yPos += dY;
        if(xPos > b.getWidth() - radius || xPos < radius){
            pos.changedX();
            xPos += dX;
        }
        if(yPos > b.getHeight() - radius || yPos < radius){
            pos.changedY();
            yPos += dY;
        }
    }
    public double edge(Position pos){
        return Math.sqrt(Math.pow(this.xPos - pos.xPos, 2) + Math.pow(this.yPos - pos.yPos,2));
    }
}
