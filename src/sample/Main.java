package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private double posX, posY;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        root.setOnMousePressed(e -> {
            posX = primaryStage.getX() - e.getScreenX();
            posY = primaryStage.getY() - e.getScreenY();
        });

        root.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() + posX);
            primaryStage.setY(e.getScreenY() + posY);
        });

        Controller controller = loader.getController();
        controller.setStage(primaryStage);

        Scene scene = new Scene(root, 360, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setTitle("NIZER");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
