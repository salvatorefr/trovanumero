package it.polito.tdp.numero;
	
import it.polito.tdp.numero.model.NumeroModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			NumeroModel model= new NumeroModel();	
			FXMLLoader loader= new FXMLLoader(getClass().getResource("Numero.fxml"));
			BorderPane root = (BorderPane)loader.load();
			numeroController controller= loader.getController();
			controller.setModel(model);
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
