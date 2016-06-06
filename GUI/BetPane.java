import javafx.scene.layout.*;
import javafx.scene.control.*;
//import javafx.scene.paint.Color;
import javafx.scene.shape.*;
//import javafx.util.*;
import java.util.Random;
//import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.image.*;
public class BetPane extends Pane {
	int sceneHeight = 500;
	int sceneWidth = 500;
	final int NUM_OF_DICE = 3;
	int[] diceValue = new int[NUM_OF_DICE]; 
	int diceValueSum;
	Button bigOrSmall = new Button("比  大  小");
	Button twoDices = new Button("兩顆骰子");
	Button threeDices = new Button("三顆骰子");
	Button betsSubmit = new Button("開始試手氣!!");
	final ChoiceBox<String> bigOrSmall_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","比大","比小"));
    final ChoiceBox<String> twoDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> twoDices_2 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> threeDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","不指定","1", "2", "3", "4", "5","6"));
	Line line1 = new Line(0,sceneHeight/2,sceneWidth,sceneHeight/2);
	Line line2 = new Line(0,sceneHeight/2 + 150,sceneWidth,sceneHeight/2 + 150);
	Label oddsLabel = new Label();
	Label statusLabel = new Label();
	TextArea bets = new TextArea();
	//final Alert alert = new Alert(AlertType.INFORMATION);

	ImageView dice[] = new ImageView[NUM_OF_DICE];
Random random = new Random();
	public BetPane() {
		bigOrSmall_1.setVisible(false);
		twoDices_1.setVisible(false);
		twoDices_2.setVisible(false);
		threeDices_1.setVisible(false);
		betsSubmit.setVisible(false);
		initialState();
		getChildren().addAll(bigOrSmall,twoDices,threeDices,bigOrSmall_1,twoDices_1,twoDices_2,threeDices_1,bets,betsSubmit,line1,line2,oddsLabel,statusLabel);
	}
	
	public void initialState(){
		
		int buttonWidth = sceneWidth*1/4;
		int currentX, currentY;
		currentX = sceneWidth/12;
		currentY = sceneHeight/6 +50;
		
		line1.getStrokeDashArray().addAll(5d);
		line2.getStrokeDashArray().addAll(5d);
		bets.setPromptText("今天要賭多少?");
		bets.setLayoutX(currentX);
		bets.setLayoutY(currentY-50);
		bets.setPrefSize(150,12);
		oddsLabel.setLayoutX( sceneWidth / 2 - 30);
		oddsLabel.setLayoutY(currentY-50);
		betsSubmit.setLayoutX(sceneWidth / 2 + 75);
		betsSubmit.setLayoutY(currentY-50);		
		
		statusLabel.setLayoutX(sceneWidth/4);
		statusLabel.setLayoutY(sceneHeight/2 + 150 + 20);
		statusLabel.setStyle("-fx-font: 25 arial;");
		// setLayoutX
		bigOrSmall.setLayoutX(currentX);
		bigOrSmall_1.setTooltip(new Tooltip("選擇比大或比小"));
		bigOrSmall_1.setValue("請選擇");
		bigOrSmall_1.setLayoutX(currentX + 15);
		bigOrSmall_1.setLayoutY(currentY + 60);
		
		twoDices.setLayoutX(currentX = currentX + buttonWidth + 25);
		twoDices_1.setTooltip(new Tooltip("選擇其中一骰子之值"));
		twoDices_1.setValue("請選擇");
		twoDices_1.setLayoutX(currentX-10 );
		twoDices_1.setLayoutY(currentY + 60);
		twoDices_1.setPrefWidth(70);

		twoDices_2.setTooltip(new Tooltip("選擇其中另一骰子之值"));
		twoDices_2.setValue("請選擇");
		twoDices_2.setLayoutX(currentX + 70);
		twoDices_2.setLayoutY(currentY + 60);
		twoDices_2.setPrefWidth(70);	
		
		threeDices.setLayoutX(currentX = currentX + buttonWidth + 25);
		threeDices_1.setTooltip(new Tooltip("選擇三顆骰子相同的點數"));
		threeDices_1.setValue("請選擇");
		threeDices_1.setLayoutX(currentX + 15);
		threeDices_1.setLayoutY(currentY + 60);		
		
		// setLayoutY
		bigOrSmall.setLayoutY(currentY);
		twoDices.setLayoutY(currentY);
		threeDices.setLayoutY(currentY);
		
		// setStyle
		bigOrSmall.setStyle("-fx-font: 20 arial; -fx-base: 	#6A5ACD;");
		twoDices.setStyle("-fx-font: 20 arial; -fx-base: #9370DB;");
		threeDices.setStyle("-fx-font: 20 arial; -fx-base: 	#7B68EE;");
		
		// set button width
		bigOrSmall.setPrefWidth( buttonWidth );
		twoDices.setPrefWidth( buttonWidth );
		threeDices.setPrefWidth( buttonWidth );		


		bigOrSmall_1.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           inputBets();
			oddsLabel.setText("比大: 1賠1\n比小: 1賠1");
		}
        });				

		twoDices_1.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           inputBets();
		   oddsLabel.setText("兩骰: 1賠8\n雙骰: 1賠24");
        }
        });

		twoDices_2.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           inputBets();
		   oddsLabel.setText("兩骰: 1賠8\n雙骰: 1賠24");
        }
        });

		threeDices_1.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
			inputBets();
			oddsLabel.setText("全骰: 1賠5\n圍骰: 1賠150");
        }
        });		
		bigOrSmall.setOnAction((ActionEvent event) -> {
			bigOrSmall_1.setVisible(true);
			twoDices.setDisable(true);
			threeDices.setDisable(true);
			
		});	
		
		twoDices.setOnAction((ActionEvent event) -> {
			twoDices_1.setVisible(true);
			twoDices_2.setVisible(true);
			bigOrSmall.setDisable(true);
			threeDices.setDisable(true);
			
		});	
		
		threeDices.setOnAction((ActionEvent event) -> {
			threeDices_1.setVisible(true);
			bigOrSmall.setDisable(true);
			twoDices.setDisable(true);
			
		});	
	}
	
	public void inputBets(){
		betsSubmit.setVisible(true);
		betsSubmit.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
		
		betsSubmit.setOnAction((ActionEvent event) -> {
			if(betOK()==true){
				rollDice();
			}
			else{
				/*
				alert.setTitle("小提示"); //設定對話框視窗的標題列文字
				alert.setHeaderText("請確定已輸入賭金或賭注"); //設定對話框視窗裡的標頭文字。若設為空字串，則表示無標頭
				alert.showAndWait(); //顯示對話框，並等待對話框被關閉時才繼續執行之後的程式
				*/
			}
		});	
		
	}

	void rollDice(){
		int diceCurrentX = -sceneWidth/12;
		diceValueSum = 0;
		diceValue[0] = diceValue[1] = diceValue[2] =0;
		for(int i=0 ; i < NUM_OF_DICE; i++){
			
			diceValue[i] = random.nextInt(6)+1;
			diceValueSum = diceValueSum + diceValue[i];
			dice[i] = new ImageView(new Image(getClass().getResource(".\\dicePic\\" + diceValue[i] + ".png").toExternalForm()));
			
			getChildren().add(dice[i]);
			dice[i].setLayoutX(diceCurrentX = diceCurrentX+120);
			dice[i].setLayoutY(sceneHeight/2 + 20);
		
		}
		if( bigOrSmall_1.isVisible()==true){
			if(bigOrSmall_1.getValue()=="比大"){
				big();
			}
			else{
				small();
			}
		}
		else if( twoDices.isVisible()==true && twoDices_2.isVisible()==true && twoDices_1.getValue()!="請選擇" && twoDices_2.getValue()!="請選擇" ){
			
		}
		else if( threeDices.isVisible()==true && threeDices_1.getValue()!="請選擇"){
			
		}
		else{
			
		}
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
			statusLabel.setText("Win!!!");
			return true;
		}
		else{
			statusLabel.setText("Lose!!");
			return false;
		}
	}//end big

	//判斷’小’ 輸贏
	public boolean small(){
		if(diceValueSum>=4 && diceValueSum<=10 && triples()==false){
			statusLabel.setText("Win!!!");
			return true;
		}
		else{
			statusLabel.setText("Lose!!");
			return false;
		}
	}//end small
	
	public boolean betOK(){
		
        try {
            Integer.valueOf(bets.getText());
			if( bigOrSmall_1.isVisible()==true &&  bigOrSmall_1.getValue()!="請選擇"){
				return true;
			}
			else if( twoDices.isVisible()==true && twoDices_2.isVisible()==true && twoDices_1.getValue()!="請選擇" && twoDices_2.getValue()!="請選擇" ){
				return true;
			}
			else if( threeDices.isVisible()==true && threeDices_1.getValue()!="請選擇"){
				return true;
			}
			else{
				return false;
			}
        }
        catch (Exception ex) {
            return false;
        }
	}

}