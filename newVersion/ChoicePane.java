import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.*;
import java.util.Random;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.*;

public class ChoicePane extends Pane {
	final int CHOICE_NUMS = 6;
	final int WIDTH = 500;
	final int HEIGHT = 500;
	Label helloLabel = new Label();
	ImageView choice[] = new ImageView[CHOICE_NUMS];
	Image image[] = new Image[CHOICE_NUMS];
	ImageView imageView[] = new ImageView[CHOICE_NUMS];
 
	Button btnScene1;
	public ChoicePane(){
		initialState();

	}
	
	public void initialState(){
		btnScene1 = new Button("Click to go to Other Scene");
		btnScene1.setLayoutX(200);
		btnScene1.setLayoutY(200);    
		getChildren().addAll(btnScene1);		
		// imageVies Layout
		final int imageView_WIDTH = 100;
		final int imageView_GAP = 50;
		for(int i=0 ; i< CHOICE_NUMS ; i++){
			image[i] = new Image(i+1 + ".png");
			imageView[i] = new ImageView();
			imageView[i].setImage(image[i]);
			imageView[i].setLayoutX(WIDTH/8 + (i%3) * (imageView_WIDTH + imageView_GAP));
			imageView[i].setLayoutY(HEIGHT/6 + (imageView_WIDTH + imageView_GAP)*(int)(i/3));
			getChildren().addAll(imageView[i]);
		}
		
		helloLabel.setText("Hello!!!");
		helloLabel.setLayoutX(WIDTH/8);
		helloLabel.setLayoutY(HEIGHT/10);
		//setStyle("-fx-background-color: tan;-fx-padding: 10px;");
		getChildren().addAll(helloLabel);		
	}
	
}
