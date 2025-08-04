package closetGUI;

import closetGUI.ClothingItem;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ClosetViewer {
    public static void showCloset(Stage owner, ArrayList<ClothingItem> clothingItems){
        Stage viewerStage = new Stage();
        viewerStage.setTitle("Your Closet");
        viewerStage.initOwner(owner);

        ListView<String> listView = new ListView<>();
        for (ClothingItem clothingItem : clothingItems){
            listView.getItems().add(
                    clothingItem.getName() + " (" + clothingItem.getType() + ") ⭐ " + (clothingItem.isFav() ? "true" : "false")
            );
        }

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            viewerStage.close();
        });

        VBox window = new VBox(15, listView, closeButton);
        window.setPrefSize(350, 400);
        window.setStyle("-fx-padding: 15;");

        Scene scene = new Scene(window);
        viewerStage.setScene(scene);
        viewerStage.show();
    }
}
