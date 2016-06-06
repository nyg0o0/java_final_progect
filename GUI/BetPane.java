import javafx.scene.layout.*;
import javafx.scene.control.*;
//import javafx.scene.paint.Color;
import javafx.scene.shape.*;
//import javafx.util.*;
//import java.util.Random;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
public class BetPane extends Pane {
	private int sceneHeight = 250;
	private int sceneWidth = 500;
	Button bigOrSmall = new Button("比  大  小");
	Button twoDices = new Button("兩顆骰子");
	Button threeDices = new Button("三顆骰子");
	Button betsSubmit = new Button("開始試手氣!!");
	final ChoiceBox<String> bigOrSmall_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","比大","比小"));
    final ChoiceBox<String> twoDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> twoDices_2 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","1", "2", "3", "4", "5","6"));
	final ChoiceBox<String> threeDices_1 = new ChoiceBox<String>(FXCollections.observableArrayList("請選擇","不指定","1", "2", "3", "4", "5","6"));
	
	TextArea bets = new TextArea();
	
	public BetPane() {
		bigOrSmall_1.setVisible(false);
		twoDices_1.setVisible(false);
		twoDices_2.setVisible(false);
		threeDices_1.setVisible(false);
		//bets.setVisible(false);
		betsSubmit.setVisible(false);
		initialState();
		getChildren().addAll(bigOrSmall,twoDices,threeDices,bigOrSmall_1,twoDices_1,twoDices_2,threeDices_1,bets,betsSubmit);
	}
	
	public void initialState(){
		int buttonWidth = sceneWidth*1/4;
		int currentX, currentY;
		currentX = sceneHeight/6;
		currentY = sceneHeight/3;
		
		bets.setPromptText("今天要賭多少?");
		bets.setLayoutX(currentX);
		bets.setLayoutY(currentX-10);
		bets.setPrefSize(150,12);
		
		// setLayoutX
		bigOrSmall.setLayoutX(currentX);
		bigOrSmall_1.setTooltip(new Tooltip("選擇比大或比小"));
		bigOrSmall_1.setValue("請選擇");
		bigOrSmall_1.setLayoutX(currentX + 15);
		bigOrSmall_1.setLayoutY(currentY + 60);
		
		twoDices.setLayoutX(currentX = currentX + buttonWidth + 25);
		twoDices_1.setTooltip(new Tooltip("選擇其中一骰子之值"));
		twoDices_1.setValue("請選擇");
		twoDices_1.setLayoutX(currentX + 15);
		twoDices_1.setLayoutY(currentY + 60);

		twoDices_2.setTooltip(new Tooltip("選擇其中另一骰子之值"));
		twoDices_2.setValue("請選擇");
		twoDices_2.setLayoutX(currentX + 15);
		twoDices_2.setLayoutY(currentY + 100);
			
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


		

		twoDices_1.getSelectionModel().selectedIndexProperty()
        .addListener(new ChangeListener<Number>() {
        public void changed(ObservableValue ov, Number value, Number new_value) {
           
        }
        });
		
		bigOrSmall.setOnAction((ActionEvent event) -> {
			bigOrSmall_1.setVisible(true);
			twoDices.setDisable(true);
			threeDices.setDisable(true);
			inputBets();
		});	
		
		twoDices.setOnAction((ActionEvent event) -> {
			twoDices_1.setVisible(true);
			twoDices_2.setVisible(true);
			bigOrSmall.setDisable(true);
			threeDices.setDisable(true);
			inputBets();
		});	
		
		threeDices.setOnAction((ActionEvent event) -> {
			threeDices_1.setVisible(true);
			bigOrSmall.setDisable(true);
			twoDices.setDisable(true);
			inputBets();
		});	
	}
	
	public void inputBets(){
		betsSubmit.setVisible(true);
		betsSubmit.setLayoutX(sceneWidth - 170);
		betsSubmit.setLayoutY(30);
		betsSubmit.setStyle("-fx-font: 20 arial; -fx-base: #FF0000;");
	}

}