package RPS.GUI;


import javafx.animation.AnimationTimer;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import RPS.GRUNT.*;

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
        rock.valueProperty().addListener((observableValue, number, t1) -> rocks = (int) (rock.getValue()));
        paper.valueProperty().addListener((observableValue, number, t1) -> papers = (int) (paper.getValue()));
        scissors.valueProperty().addListener((observableValue, number, t1) -> scissor = (int) (scissors.getValue()));
        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(new PieChart.Data("Rock",1),
                new PieChart.Data("Paper", 1),new PieChart.Data("Scissors", 1));
        pieChart.forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ")));
        chart.setData(pieChart);
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
        RPS = new Teams(rocks,papers,scissor,Objects.ROCK,Objects.PAPER,Objects.SCISSORS,arena.getBoundsInLocal());
        plv = new ArrayList<>();
        for(Player player: RPS.getTeam()){
            PlayerView pv = new PlayerView(player);
            arena.getChildren().add(pv);
            plv.add(pv);
        }
        disableButton(false,true);
        chart.getData().addAll();
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
        updateChart();
    }
    public void updatePlayer(){
        for(PlayerView pv: plv){
            pv.update();
        }
    }
    public void updateChart(){
        double rock = 0.0;
        double paper = 0.0;
        double scissors = 0.0;
        for(Player player: RPS.getTeam()){
            Objects rps = player.getRPS();
            if(rps == Objects.ROCK){
                rock++;
            }else if(rps == Objects.PAPER){
                paper++;
            }else if(rps == Objects.SCISSORS){
                scissors++;
            }
        }
        ObservableList<PieChart.Data> pieChart = FXCollections.observableArrayList(new PieChart.Data("Rock", rock),
                new PieChart.Data("Paper", paper),new PieChart.Data("Scissors", scissors));
        pieChart.forEach(data -> data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty())));
        chart.setData(pieChart);
        chart = new PieChart();

    }
}

