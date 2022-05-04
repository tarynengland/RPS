package RPS.GUI;

import RPS.GRUNT.Player;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
