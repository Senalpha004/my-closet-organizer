import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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

        startButton.setOnAction(e -> showOrganizer(primaryStage));
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void showOrganizer(Stage stage){
        Label typeLabel = new Label("Clothing type: ");
        TextField typeInput = new TextField();

        Label nameLabel = new Label("Clothing name: ");
        TextField nameInput = new TextField();

        Button addButton = new Button("Add to Closet");

        VBox layout = new VBox(15);
        layout.getChildren().addAll(typeLabel,typeInput,nameLabel,nameInput,addButton);

        Scene organizerScene = new Scene(layout,400,200);
        stage.setTitle("Organizer Closet");
        stage.setScene(organizerScene);
    }
}
