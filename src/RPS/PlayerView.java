package RPS;

import javafx.scene.Parent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class PlayerView extends Parent {

    private Circle c;
    private Player player;

    public PlayerView(Player player){
        this.player = player;
        c = new Circle();
        update();
        c.setStroke(Color.BLACK);
        getChildren().add(c);
    }
    public void update(){
        c.setFill(player.getRPS().getColor());
        c.setRadius(5);
        c.setTranslateX(player.getHere().getX());
        c.setTranslateY(player.getHere().getY());
    }
}
