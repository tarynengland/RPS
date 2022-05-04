module RPS {
    requires javafx.fxml;
    requires javafx.controls;
    exports RPS.GRUNT;
    opens RPS.GRUNT;
    exports RPS.GUI;
    opens RPS.GUI;
}