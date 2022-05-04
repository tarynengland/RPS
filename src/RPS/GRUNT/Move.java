package RPS.GRUNT;

public class Move {
    private double dX;
    private double dY;

    public Move() {
        if (Math.random() < 0.25) {
            this.dX = 1;
            this.dY = 1;
        } else if(Math.random() < 0.50){
            this.dX = -1;
            this.dY = -1;
        }else if(Math.random() < 0.75){
            this.dX = -1;
            this.dY = 1;
        }else{
            this.dX = 1;
            this.dY = -1;
        }
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
}
