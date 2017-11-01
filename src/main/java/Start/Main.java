package Start;
import JavaFXFunctionality.ContentOfPatientTableView;
import Model.ViewState;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
