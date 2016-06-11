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
	final int NUM_OF_DICE = 3;
	final int WIDTH = 500;
	final int HEIGHT = 500;	
	final int imageView_WIDTH = 100;
	final int imageView_GAP = 30;	
    Label resultLabel = new Label();
	Button btnScene2 = new Button("再來試試看!");
	int diceValueSum = 0;
	int[] diceValue = new int[NUM_OF_DICE]; 	
	int betOption = -1;
	int betDice1 = -1;
	int betDice2 = -1;
	
	PlayPane(){
		//betOption = option;
		//if(betOption==1||betOption==3){
		//	betDice1 =  Integer.parseInt(twoDices_1);
		//	betDice2 =  Integer.parseInt(twoDices_1);
		//}
		//else if(betOption==2){
		//	betDice1 =  Integer.parseInt(twoDices_1);
		//}
		//setStyle("-fx-background-color: red;-fx-padding: 10px;");
		//resultLabel.setText(String.valueOf(option));
		allEvent();
		initialLayout();
		rollDice();
		

	}
	
	public void initialLayout(){
		//resultLabel.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		//resultLabel.setLayoutY(HEIGHT -  (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);  	
		resultLabel.setStyle("-fx-font: 30 arial; -fx-color: 	#FF0000;");
		
		btnScene2.setStyle("-fx-font: 20 arial; -fx-base: 	#FF0000;");
		btnScene2.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		btnScene2.setLayoutY(HEIGHT -  (imageView_WIDTH + imageView_GAP)*(int)(6/3)/4);    
		btnScene2.setPrefWidth( imageView_WIDTH*3 + imageView_GAP*2 );
		getChildren().addAll(resultLabel, btnScene2);
	}
	
	void allEvent(){
		btnScene2.setOnAction((ActionEvent event) -> {
			rollDice();	
		});	
	}
	void getResult(){

		
	}
	
	//判斷是否為’圍骰’
	public boolean triples(){
		if(diceValue[1]==diceValue[2] && diceValue[2]==diceValue[3])
			return true;
		else
			return false;
	}//end triples

	//判斷’大’的輸贏
	public boolean big(){
		if(diceValueSum>=11 && diceValueSum<=17 && triples()==false){
			resultLabel.setText("Win!!!");
			return true;
		}
		else{
			resultLabel.setText("Lose!!");
			return false;
		}
	}//end big

	//判斷’小’ 輸贏
	public boolean small(){
		if(diceValueSum>=4 && diceValueSum<=10 && triples()==false){
			resultLabel.setText("Win!!!");
			return true;
		}
		else{
			resultLabel.setText("Lose!!");
			return false;
		}
	}//end small	
	
	void rollDice(){

		
		Random random = new Random();
		Image image[] = new Image[NUM_OF_DICE];
		ImageView imageView[] = new ImageView[NUM_OF_DICE];
		
		diceValueSum = 0;
		//diceValue = new int[NUM_OF_DICE]; 

		for(int i=0; i < NUM_OF_DICE; i++){
			diceValue[i] = random.nextInt(6)+1;
			diceValueSum += diceValue[i];
		}
		

		for(int i=0 ; i< NUM_OF_DICE ; i++){
			image[i] = new Image(".\\dicePic\\" + diceValue[i] + ".png");
			imageView[i] = new ImageView();
			imageView[i].setImage(image[i]);
			imageView[i].setLayoutX(WIDTH/8 + (i%3) * (imageView_WIDTH + imageView_GAP));
			imageView[i].setLayoutY(HEIGHT/7 + (imageView_WIDTH + imageView_GAP)*(int)(i/3)+20);
			getChildren().addAll(imageView[i]);
		}

		//resultLabel.setText(diceValueSum + " " + diceValue[0] + " " + diceValue[1]  + " " + diceValue[2]);

	}
		
	

}