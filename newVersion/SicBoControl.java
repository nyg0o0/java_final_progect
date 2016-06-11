import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

public class SicBoControl extends Application {
    Scene scene1;
    Stage thestage;
    ChoicePane pane = new ChoicePane();

    @Override
    public void start(Stage primaryStage) throws Exception {
		thestage = primaryStage;
        scene1 = new Scene(pane, 500, 500);
        primaryStage.setTitle("SicBo!!!");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
		
	public static void main(String[] args) {
		launch(args);
	}
}
