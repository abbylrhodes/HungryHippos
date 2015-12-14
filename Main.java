package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


public class Main extends Application {
	@FXML Button startButton;
	@FXML Button quitButton;
	@FXML Button easyLevelButton;
	@FXML Button hardLevelButton;
	Stage primaryStage;
	Stage primaryStage2;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Test.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void start2(Stage primaryStage2) {
		try {			
			Parent root2 = FXMLLoader.load(getClass().getResource("chooseLevelFX.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage2.setScene(scene2);
			primaryStage2.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@FXML
	private void startButtonAction(ActionEvent event) {
		GamePlay.main();
	}
	
	@FXML
	private void quitButtonAction(ActionEvent event) {
		StartMenu.quit();
		Stage stage = (Stage) quitButton.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	private void hardLevelButtonAction(ActionEvent event) {
		HardLevelBoard.beginHardLevel();
	}
	
	@FXML
	private void easyLevelButtonAction(ActionEvent event) {
		EasyLevelBoard.beginEasyLevel();
	}
}
