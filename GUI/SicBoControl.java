import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class SicBoControl extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		int sceneHeight = 250;
		int sceneWidth = 500;
		
		BetPane bet1 = new BetPane(); 
		
		BetPane bet2 = new BetPane(); 
		bet1.setVisible(false);
		Scene scene = new Scene(bet1, sceneWidth, sceneHeight);

		
		primaryStage.setTitle("SicBo Game!"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
	public static void main(String[] args) {
		launch(args);
	}
}
