import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
public class SicBoControl extends Application {
    Scene scene1, scene2;
    Stage thestage;
    ChoicePane pane1 = new ChoicePane();
	PlayPane pane2 = new PlayPane(); 	

    @Override
    public void start(Stage primaryStage) throws Exception {
		thestage = primaryStage;
        pane1.btnScene1.setOnAction(e-> ButtonClicked(e));
        pane2.btnScene2.setOnAction(e-> ButtonClicked(e));

        scene1 = new Scene(pane1, 500, 500);
        scene2 = new Scene(pane2, 500, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
	
	public void ButtonClicked(ActionEvent e){
        if (e.getSource()==pane1.btnScene1)
            thestage.setScene(scene2);
        else
            thestage.setScene(scene1);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
