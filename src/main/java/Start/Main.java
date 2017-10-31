package Start;
import Controllers.LogInController;
import JavaFXFunctionality.ContentOfPatientTableView;
import Model.Account;
import Model.DoctorAccount;
import Model.ViewState;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{
	
	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage stage) throws Exception {
		ContentOfPatientTableView model = new ContentOfPatientTableView();
		ViewState viewState = new ViewState(model,stage);
        viewState.showLogIn();
        Scene scene = new Scene(viewState.currentViewProperty().get());
        scene.rootProperty().bind(viewState.currentViewProperty());
        stage.setScene(scene);
        stage.show();
		
		
		
	}

}
