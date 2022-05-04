package RPS.GUI;

import RPS.GRUNT.Objects;
import RPS.GRUNT.Player;
import RPS.GRUNT.Teams;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

//import java.awt.*;
import java.util.ArrayList;

public class RPSController {
    @FXML
    Pane arena;

    @FXML
    Button start;

    @FXML
    Button stop;

    @FXML
    Button reset;

    @FXML
    Slider rock;

    @FXML
    Slider paper;

    @FXML
    Slider scissors;

    @FXML
    PieChart chart;

    int rocks;
    int papers;
    int scissor;
    Teams RPS;
    ArrayList<PlayerView> plv;
    private Movement clock;

    private class Movement extends AnimationTimer {

        private long FRAMES_PER_SEC = 50L;
        private long INTERVAL = 1000000000L / FRAMES_PER_SEC;

        private long last = 0;

        @Override
        public void handle(long now) {
            if (now - last > INTERVAL) {
                royale();
                updateViews();
                last = now;

            }
        }
    }
    @FXML
    public void initialize(){
        rock.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rocks = (int) (rock.getValue());
            }
        });
        paper.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                papers = (int) (paper.getValue());
            }
        });
        scissors.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                scissor = (int) (scissors.getValue());
            }
        });
        clock = new Movement();
        chart = new PieChart();
        disableButton(true, true);
        arena.setBackground(new Background(new BackgroundFill(Color.WHEAT, null, null)));
    }
    public void disableButton(boolean start1, boolean stop1){
        start.setDisable(start1);
        stop.setDisable(stop1);
    }
    @FXML
    public void startup(){
        clock.stop();
        arena.getChildren().clear();
        RPS = new Teams( Math.abs(rocks + papers + scissor)-1, Objects.PAPER, arena.getBoundsInLocal());
        plv = new ArrayList<>();
        for(Player player: RPS.getTeam()){
            PlayerView pv = new PlayerView(player);
            arena.getChildren().add(pv);
            plv.add(pv);
        }
        disableButton(false,true);
        updateViews();
    }
    @FXML
    public void royale(){
        RPS.royale();
    }
    @FXML
    public void start(){
        clock.start();
        disableButton(true, false);
    }
    @FXML
    public void stop(){
        clock.stop();
        disableButton(false, true);
    }
    public void updateViews(){
        updatePlayer();
    }
    public void updatePlayer(){
        for(PlayerView pv: plv){
            pv.update();
        }
    }
}

