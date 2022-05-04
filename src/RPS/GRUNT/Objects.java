package RPS.GRUNT;

import javafx.scene.paint.Color;

public enum Objects {
    ROCK {
        public Color getColor() {
            return Color.BROWN;
        }
    },
    PAPER{
        public Color getColor(){
            return Color.WHITE;
        }
    },
    SCISSORS {
        public Color getColor(){
            return Color.LIMEGREEN;
        }
    };
    public abstract Color getColor();
}
