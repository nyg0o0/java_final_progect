import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.*;
import java.util.Random;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
//import javafx.scene.control.ChoiceBox<T>;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class ChoicePane extends Pane {
	final int NUM_OF_DICE = 3;	
	final int CHOICE_NUMS = 6;
	final int WIDTH = 500;
	final int HEIGHT = 500;
	final int imageView_WIDTH = 100;
	final int imageView_GAP = 30;
	int diceValueSum = 0;
	int[] diceValue = new int[NUM_OF_DICE]; 		
	int option = -1;
	
    final ChoiceBox<String> twoDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> twoDices_2 = new ChoiceBox<String>(FXCollections.observableArrayList("1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> threeDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("1", "2", "3", "4", "5","6"));

	Label resultLabel = new Label();
	Label helloLabel = new Label();
	Label betOfOddsLabel = new Label();
	TextArea betOfOdds = new TextArea();
	
	ImageView choice[] = new ImageView[CHOICE_NUMS];
	Image image[] = new Image[CHOICE_NUMS];
	ImageView imageView[] = new ImageView[CHOICE_NUMS];

	Button btnScene1,btnScene2;
	
	public ChoicePane(){
		initialLayout();
		choiceBoxLayout();
		btnScene1.setDisable(true);
	}

	public void initialLayout(){
		btnScene1 = new Button("試試運氣吧!!!");
		btnScene1.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		btnScene1.setLayoutY(HEIGHT -  (imageView_WIDTH + imageView_GAP)*(int)(6/3)/4);    
		btnScene1.setPrefWidth( imageView_WIDTH*3 + imageView_GAP*2 );
		btnScene1.setStyle("-fx-font: 20 arial; -fx-base: 	#6A5ACD;");
		btnScene2 = new Button("再來一次!!!");
		btnScene2.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		btnScene2.setLayoutY(HEIGHT -  (imageView_WIDTH + imageView_GAP)*(int)(6/3)/4);    
		btnScene2.setPrefWidth( imageView_WIDTH*3 + imageView_GAP*2 );
		btnScene2.setStyle("-fx-font: 20 arial; -fx-base: 	#FF0000;");
		btnScene2.setVisible(false);
		getChildren().addAll(btnScene1,btnScene2);	
		for(int i=0 ; i< CHOICE_NUMS ; i++){
			image[i] = new Image(".\\choicePic\\" + (i+1) + ".png");
			imageView[i] = new ImageView();
			imageView[i].setOpacity(1);
			imageView[i].setImage(image[i]);
			imageView[i].setLayoutX(WIDTH/8 + (i%3) * (imageView_WIDTH + imageView_GAP));
			imageView[i].setLayoutY(HEIGHT/7 + (imageView_WIDTH + imageView_GAP)*(int)(i/3));
			getChildren().addAll(imageView[i]);
		}
		
		//betOfOdds.setLayoutX();
		//betOfodds.setLayoutY();
		helloLabel.setText("Hello!!!");
		helloLabel.setLayoutX(WIDTH/8);
		helloLabel.setLayoutY(HEIGHT/15);
		//setStyle("-fx-background-color: tan;-fx-padding: 10px;");
		//getChildren().addAll(helloLabel);	
		
		resultLabel.setVisible(false);		
		getChildren().addAll(resultLabel);
		allEvent();
	}
	public void pane1Visible(){
		for(int i=0 ; i< CHOICE_NUMS ; i++){
			imageView[i].setVisible(false);
		}
		
		betOfOddsLabel.setVisible(false);
		betOfOdds.setVisible(false);
		btnScene1.setVisible(false);
		twoDices_1.setVisible(false);
		twoDices_2.setVisible(false);
		threeDices_1.setVisible(false);
		btnScene2.setVisible(true);
	}
	void choiceBoxLayout(){
		betOfOddsLabel.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		betOfOddsLabel.setLayoutY(HEIGHT/2+ (imageView_WIDTH + imageView_GAP)*(int)(6/3)/3);
		betOfOddsLabel.setStyle("-fx-font: 18 arial;");
		
		betOfOdds.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		betOfOdds.setLayoutY(HEIGHT/2+ (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		betOfOdds.setStyle("-fx-font: 18 arial;");
		betOfOdds.setPrefWidth(imageView_WIDTH);
		betOfOdds.setPrefHeight(20);
		betOfOdds.setPromptText("下賭注!");
		
		threeDices_1.setTooltip(new Tooltip("選擇圍骰的點數"));
		threeDices_1.setValue("1");
		threeDices_1.setLayoutX(WIDTH/8 + (2%3) * (imageView_WIDTH + imageView_GAP));
		threeDices_1.setLayoutY(HEIGHT/2+ (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		threeDices_1.setPrefWidth(100);
		
		twoDices_1.setTooltip(new Tooltip("兩骰其中一個點數"));
		twoDices_1.setValue("1");
		twoDices_1.setLayoutX(WIDTH/8 + (1%3) * (imageView_WIDTH + imageView_GAP));
		twoDices_1.setLayoutY(HEIGHT/2 + (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		twoDices_1.setPrefWidth(100);		
		
		twoDices_2.setTooltip(new Tooltip("兩骰其中另一個點數"));
		twoDices_2.setValue("1");
		twoDices_2.setLayoutX(WIDTH/8 + (2%3) * (imageView_WIDTH + imageView_GAP));
		twoDices_2.setLayoutY(HEIGHT/2 + (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		twoDices_2.setPrefWidth(100);
		
		choiceBoxVisible();

		getChildren().addAll(betOfOdds,betOfOddsLabel,twoDices_1,twoDices_2, threeDices_1);
	}
		
	
	void choiceBoxVisible(){
		if(option==1){
			twoDices_1.setVisible(true);
			twoDices_2.setVisible(true);
			threeDices_1.setVisible(false);
		}
		else if(option==4){
			twoDices_1.setVisible(false);
			twoDices_2.setVisible(true);
			threeDices_1.setVisible(false);
		}
		else if(option==5){
			twoDices_1.setVisible(false);
			twoDices_2.setVisible(false);
			threeDices_1.setVisible(true);			
		}
		else{
			twoDices_1.setVisible(false);
			twoDices_2.setVisible(false);
			threeDices_1.setVisible(false);			
		}
	}
	void rollDice(){
		Random random = new Random();
		Image image2[] = new Image[NUM_OF_DICE];
		ImageView imageView2[] = new ImageView[NUM_OF_DICE];
		
		diceValueSum = 0;

		for(int i=0; i < NUM_OF_DICE; i++){
			diceValue[i] = random.nextInt(6)+1;
			diceValueSum += diceValue[i];
		}
		

		for(int i=0 ; i< NUM_OF_DICE ; i++){
			image2[i] = new Image(".\\dicePic\\" + diceValue[i] + ".png");
			imageView2[i] = new ImageView();
			imageView2[i].setImage(image2[i]);
			imageView2[i].setLayoutX(WIDTH/8 + (i%3) * (imageView_WIDTH + imageView_GAP));
			imageView2[i].setLayoutY(HEIGHT/7 + (imageView_WIDTH + imageView_GAP)*(int)(i/3)+20);
			getChildren().addAll(imageView2[i]);
		}
	}	
	
	void getResult(){
		switch(getOption()){
			case 0:
				if(big()){
					
				}
				if(big())
					resultLabel.setText("Win!!"+ String.valueOf(option));
				else
					resultLabel.setText("Lose!!"+ String.valueOf(option));
				break;
			case 1:
				int guess1 = Integer.parseInt(twoDices_1.getValue());
				int guess2 = Integer.parseInt(twoDices_2.getValue());
				
				if(twoDiceCombination(guess1,guess2))
					resultLabel.setText("Win!!");
				else
					resultLabel.setText("Lose!!");
				break;
	
			case 2:
				if(triples())
					resultLabel.setText("Win!!"+ String.valueOf(option));
				else
					resultLabel.setText("Lose!!"+ String.valueOf(option));
				break;

			case 3:
				if(small())
					resultLabel.setText("Win!!"+ String.valueOf(option));
				else
					resultLabel.setText("Lose!!"+ String.valueOf(option));
				break;
			case 4:
				if(specificDoubles(Integer.parseInt(twoDices_2.getValue())))
					resultLabel.setText("Win!!" + twoDices_2.getValue());
				else
					resultLabel.setText("Lose!!"+ String.valueOf(twoDices_2.getValue()));
				break;
			
			case 5:
				if(specificTriples(Integer.parseInt(threeDices_1.getValue())))
					resultLabel.setText("Win!!");
				else
					resultLabel.setText("Lose!!");
				break;				
			default:
		}		
		
		resultLabel.setVisible(true);
		
	}
	
	//判斷是否為’圍骰’
	public boolean triples(){
		if(diceValue[0]==diceValue[1] && diceValue[1]==diceValue[2])
			return true;
		else
			return false;
	}//end triples

	//判斷’大’的輸贏
	public boolean big(){
		if(diceValueSum>=11 && diceValueSum<=17 && triples()==false)
			return true;
		else
			return false;
	}//end big

	//判斷’小’ 輸贏
	public boolean small(){
		if(diceValueSum>=4 && diceValueSum<=10 && triples()==false){

			return true;
		}
		else{
			
			return false;
		}
	}//end small
	public boolean twoDiceCombination(int guess1,int guess2){
		if(diceValue[0] == guess1){
			if(diceValue[1] == guess2 || diceValue[2] == guess2){
				return true;
			}
			else{
				return false;
			}	
		}
		else if(diceValue[1] == guess1){
			if(diceValue[0] == guess2 || diceValue[2] == guess2){
				return true;
			}
			else{
				return false;
			}	
		}
		else if(diceValue[2] == guess1){
			if(diceValue[0] == guess2 || diceValue[1] == guess2){
				return true;
			}
			else{
				return false;
			}	
		}
		else{
			return false;
		}
	}//end twoDiceCombination
	//判斷’雙骰’的輸贏
	public boolean specificDoubles(int guessTwo){
		if(diceValue[0] == guessTwo && diceValue[1] == guessTwo){
			return true;
		}
		else if(diceValue[1] == guessTwo && diceValue[2] == guessTwo){
			return true;
		}
		else if(diceValue[0] == guessTwo && diceValue[2] == guessTwo){
			return true;
		}
		else{
			return false;
		}
	}//end specificDoubles
	
	//判斷’圍骰’的輸贏
	public boolean specificTriples(int guessThree){
		if(triples()){
			if(guessThree==diceValue[0])
				return true;
			else
				return false;
		}
		else{
			return false;
		}
	}//end specificTriples	
	
	public void allEvent(){
		betOfOdds.textProperty().addListener((observable, oldValue, newValue) -> {
			btnScene1.setDisable(false);
		});
		btnScene1.setOnMouseClicked(e -> {
			try {
				if(Integer.parseInt(betOfOdds.getText())>=0){
					pane1Visible();
					rollDice();
					getResult();
				}
			}
			catch (Exception ex) {
				//System.out.println("something wrong");
			}

		});	
		btnScene2.setOnMouseClicked(e -> {
			rollDice();
			getResult();
		});			
		imageView[0].setOnMouseClicked(e -> {
			setOption(0);
			
			betOfOddsLabel.setText("您選擇賭比大, 賠率為 1:1");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==0){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();		
			//if()
					
		});		
		imageView[1].setOnMouseClicked(e -> {	
			setOption(1);
			betOfOddsLabel.setText("您選擇賭兩骰, 賠率為 1:8");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==1){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();

		
		});	
		
		imageView[2].setOnMouseClicked(e -> {
			setOption(2);
			betOfOddsLabel.setText("您選擇賭全骰, 賠率為 1:5");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==2){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();		
		});	
		imageView[3].setOnMouseClicked(e -> {
			setOption(3);
			betOfOddsLabel.setText("您選擇賭比小, 賠率為 1:1");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==3){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();			
		});	
		imageView[4].setOnMouseClicked(e -> {
			setOption(4);
			betOfOddsLabel.setText("您選擇賭雙骰, 賠率為 1:24");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==4){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();			
		});	
		imageView[5].setOnMouseClicked(e -> {
			setOption(5);
			betOfOddsLabel.setText("你選擇賭圍骰, 賠率為 1:150");
			for(int i=0 ; i< CHOICE_NUMS ; i++){
				if(i==5){
					imageView[i].setOpacity(1);
					continue;
				}
				imageView[i].setOpacity(0.5);
			}
			choiceBoxVisible();	
					
		});	
		
		twoDices_1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           
        }			
		});	
		
		twoDices_2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           
		   
        }			
		});	
		
		threeDices_1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
			 //if(Integer.parseInt(new_value) !=0)
				//btnScene1.setDisable(false);
        }			
		});	
	}
	
	void setOption(int opt){
		option = opt;
	}	
	
	int getOption(){
		
		return option;
	}
}