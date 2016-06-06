import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class SicBoControl extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		int sceneHeight = 500;
		int sceneWidth = 500;
		
		
		BetPane bet1 = new BetPane(); 
		DicePane rollDice1 = new DicePane();
		
		
		Scene scene = new Scene(bet1, sceneWidth, sceneHeight);
		primaryStage.setScene(scene); // Place the scene in the stage


		primaryStage.setTitle("SicBo Game!"); // Set the stage title

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
