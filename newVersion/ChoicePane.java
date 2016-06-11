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
	
	final int CHOICE_NUMS = 6;
	final int WIDTH = 500;
	final int HEIGHT = 500;
	final int imageView_WIDTH = 100;
	final int imageView_GAP = 30;
	
	int option;
	
    final ChoiceBox<String> twoDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> twoDices_2 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> threeDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));

	Label helloLabel = new Label();
	Label betOfOddsLabel = new Label();
	TextArea betOfOdds = new TextArea();
	
	ImageView choice[] = new ImageView[CHOICE_NUMS];
	Image image[] = new Image[CHOICE_NUMS];
	ImageView imageView[] = new ImageView[CHOICE_NUMS];

	Button btnScene1;
	
	public ChoicePane(){
		initialLayout();
		choiceBoxLayout();
		

		
	}
	
	public void initialLayout(){
		btnScene1 = new Button("試試運氣吧!!!");
		btnScene1.setLayoutX(WIDTH/8 + (0%3) * (imageView_WIDTH + imageView_GAP));
		btnScene1.setLayoutY(HEIGHT -  (imageView_WIDTH + imageView_GAP)*(int)(6/3)/4);    
		btnScene1.setPrefWidth( imageView_WIDTH*3 + imageView_GAP*2 );
		btnScene1.setStyle("-fx-font: 20 arial; -fx-base: 	#6A5ACD;");
		//btnScene1.setDisable(true);
		getChildren().addAll(btnScene1);	
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
		
		allEvent();
	}
	public void pane1Visible(){
		for(int i=0 ; i< CHOICE_NUMS ; i++){
			imageView[i].setVisible(false);
		}

		betOfOddsLabel.setVisible(false);
		betOfOdds.setVisible(false);
		btnScene1.setVisible(false);
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
		threeDices_1.setValue("請選擇");
		threeDices_1.setLayoutX(WIDTH/8 + (2%3) * (imageView_WIDTH + imageView_GAP));
		threeDices_1.setLayoutY(HEIGHT/2+ (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		threeDices_1.setPrefWidth(100);
		
		twoDices_1.setTooltip(new Tooltip("兩骰其中一個點數"));
		twoDices_1.setValue("請選擇");
		twoDices_1.setLayoutX(WIDTH/8 + (1%3) * (imageView_WIDTH + imageView_GAP));
		twoDices_1.setLayoutY(HEIGHT/2 + (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		twoDices_1.setPrefWidth(100);		
		
		twoDices_2.setTooltip(new Tooltip("兩骰其中另一個點數"));
		twoDices_2.setValue("請選擇");
		twoDices_2.setLayoutX(WIDTH/8 + (2%3) * (imageView_WIDTH + imageView_GAP));
		twoDices_2.setLayoutY(HEIGHT/2 + (imageView_WIDTH + imageView_GAP)*(int)(6/3)/2);
		twoDices_2.setPrefWidth(100);
		
		choiceBoxVisible();

		getChildren().addAll(betOfOdds,betOfOddsLabel,twoDices_1,twoDices_2, threeDices_1);
	}
	
	public void ChoiceBoxChage(ActionEvent e){
		checkButtonDisable();
    }	
	
	void choiceBoxVisible(){
		if(option==1 || option==4){
			twoDices_1.setVisible(true);
			twoDices_2.setVisible(true);
			threeDices_1.setVisible(false);
		}
		else if(option==6){
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
	
	public void allEvent(){
		btnScene1.setOnMouseClicked(e -> {
			pane1Visible();
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
           checkButtonDisable();
        }			
		});	
		
		twoDices_2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           checkButtonDisable();
        }			
		});	
		
		threeDices_1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           checkButtonDisable();
        }			
		});	
	}
	
	void setOption(int opt){
		option = opt;
	}	
	
	int getOption(){
		
		return option;
	}
	
	void checkButtonDisable(){
		/*
		switch(option){
			case 1:
				if(!twoDices_1.getValue().equals("請選擇") || !twoDices_2.getValue().equals("請選擇"))
					btnScene1.setDisable(false);
				break;
			case 2:
				if(!threeDices_1.getValue().equals("請選擇"))
					btnScene1.setDisable(false);
				break;
			case 3:
				if(!twoDices_1.getValue().equals("請選擇")|| !twoDices_2.getValue().equals("請選擇"))
					btnScene1.setDisable(false);
				break;
			default:
				btnScene1.setDisable(false);
			
		}
		*/
	
	}
	
	
}