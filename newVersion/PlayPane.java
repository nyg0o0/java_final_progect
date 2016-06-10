import javafx.scene.layout.*;
import javafx.scene.control.*;
//import javafx.scene.paint.Color;
import javafx.scene.shape.*;
//import javafx.util.*;
import java.util.Random;
//import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.image.*;

public class PlayPane extends Pane {
	final int WIDTH = 500;
	final int HEIGHT = 500;	
	
    Label lblscene2 = new Label("Scene 2");
	Button button = new Button("test1");
	Button btnScene2 = new Button("Click to go back to First Scene");
	PlayPane(){
		//lblscene2.setLayoutX(200);
		//lblscene2.setLayoutY(200);	
		getChildren().addAll(btnScene2);
		button.setLayoutX(100);
		button.setLayoutY(100);	
		setStyle("-fx-background-color: red;-fx-padding: 10px;");
		getChildren().addAll(lblscene2,button);
		
		
		button.setOnAction((ActionEvent event) -> {
			rollDice();
			
		});	
	}
	
	void rollDice(){
		final int NUM_OF_DICE = 3;
		
		Random random = new Random();
		Image image[] = new Image[NUM_OF_DICE];
		ImageView imageView[] = new ImageView[NUM_OF_DICE];
		
		
		int diceValueSum = 0;
		int[] diceValue = new int[NUM_OF_DICE]; 

		for(int i=0; i < NUM_OF_DICE; i++){
			diceValue[i] = random.nextInt(6)+1;
			diceValueSum += diceValue[i];
		}
		
		final int imageView_WIDTH = 100;
		final int imageView_GAP = 20;
		for(int i=0 ; i< NUM_OF_DICE ; i++){
			image[i] = new Image(diceValue[i] + ".png");
			imageView[i] = new ImageView();
			imageView[i].setImage(image[i]);
			imageView[i].setLayoutX(WIDTH/6 + (i%3) * (imageView_WIDTH + imageView_GAP));
			imageView[i].setLayoutY(200+ HEIGHT/6 + (imageView_WIDTH + imageView_GAP)*(int)(i/3));
			getChildren().addAll(imageView[i]);
		}

		//lblscene2.setText(diceValueSum + " " + diceValue[0] + " " + diceValue[1]  + " " + diceValue[2]);

	}
		
	

}