package JavaFXFunctionality;

import javafx.stage.Stage;

public class StageFunctionality {
	
	public static void setStageProperties(Stage stage)
	{
		stage.sizeToScene();
		stage.centerOnScreen();
		stage.setResizable(false);
	}

}
