import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ClosetGUI extends Application{

    @Override
    public void start(Stage primaryStage){
        Label welcomeLabel = new Label("Welcome to Closet Organizer!");
        Button startButton = new Button("Start Organizing");

        VBox root = new VBox(20);
        root.getChildren().addAll(welcomeLabel,startButton);

        Scene scene = new Scene(root,400,200);

        primaryStage.setTitle("Closet Organizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
