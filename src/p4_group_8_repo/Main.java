package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private Parent root;

	String assetsPath = "file:src/p4_group_8_repo/FroggerAssets/";

	AnimationTimer timer;
	MyStage background;
	Frog frog;

	public static void main(String[] args) {
		launch(args);
	}


	public void start(Stage primaryStage) throws Exception{


		this.primaryStage = primaryStage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
		root = loader.load();

		MenuController menuController = loader.getController();
		menuController.setMain(this);

		primaryStage.setTitle("Frogger");
		primaryStage.setScene(new Scene(root, 600, 800));
		primaryStage.show();

		
	}


	public void startPlay() throws Exception {


			background = new MyStage();
			Scene scene  = new Scene(background,600,800);

			//Vehicles truck = new Vehicles(assetsPath+"truck1Right.png", 25, 25, 3);
			//Vehicles truck1 = new Vehicles(assetsPath+"truck2Right.png", 100, 100,2 );
			//Vehicles truck2 = new Vehicles(assetsPath+"truck1Right.png",0,  150, 1);

			BackgroundImage froggerback = new BackgroundImage(assetsPath+"Background.png");

			background.add(froggerback);

			background.add(new Log(assetsPath+"log3.png", 150, 0, 166, 0.75));
			background.add(new Log(assetsPath+"log3.png", 150, 220, 166, 0.75));
			background.add(new Log(assetsPath+"log3.png", 150, 440, 166, 0.75));
			//background.add(new Log(assetsPath+"log3.png", 150, 0, 166, 0.75));
			background.add(new Log(assetsPath+"logs.png", 300, 0, 276, -2));
			background.add(new Log(assetsPath+"logs.png", 300, 400, 276, -2));
			//background.add(new Log(assetsPath+"logs.png", 300, 800, 276, -2));
			background.add(new Log(assetsPath+"log3.png", 150, 50, 329, 0.75));
			background.add(new Log(assetsPath+"log3.png", 150, 270, 329, 0.75));
			background.add(new Log(assetsPath+"log3.png", 150, 490, 329, 0.75));
			//background.add(new Log(assetsPath+"log3.png", 150, 570, 329, 0.75));

			background.add(new Turtle(500, 376, -1, 130, 130));
			background.add(new Turtle(300, 376, -1, 130, 130));
			background.add(new WetTurtle(700, 376, -1, 130, 130));
			background.add(new WetTurtle(600, 217, -1, 130, 130));
			background.add(new WetTurtle(400, 217, -1, 130, 130));
			background.add(new WetTurtle(200, 217, -1, 130, 130));
			//background.add(new Log(assetsPath+"log2.png", 200, 100, 1));
			//background.add(new Log(assetsPath+"log2.png", 0, 100, 1));
			//background.add(new Log(assetsPath+"log2.png", 100, 120, -1));
			//background.add(new Log(assetsPath+"log2.png", 200, 120, -1));
			//background.add(new Log(assetsPath+"log2.png", 100, 140, 1));
			//background.add(new Log(assetsPath+"log2.png", 200, 140, 1));
			//background.add(new Log(assetsPath+"log2.png", 100, 160, -1));
			//background.add(new Log(assetsPath+"log2.png", 300, 160, -1));
			//background.add(new Log(assetsPath+"log2.png", 100, 180, 1));
			//background.add(new Log(assetsPath+"log2.png", 200, 180, 1));
			//background.add(new Log(assetsPath+"log2.png", 100, 200, -1));
			//background.add(new Log(assetsPath+"log2.png", 200, 200, -1));
			//background.add(new Log(assetsPath+"log2.png", 100, 220, 1));
			//background.add(new Log(assetsPath+"log2.png", 200, 220, 1));
			//background.add(new Log(assetsPath+"log2.png", 400, 220, 1));
			//End end2 = new End();
			//End end3 = new End();
			//End end4 = new End();
			//End end5 = new End();

			//adjusted the X value manually.
			background.add(new End(15,98));
			background.add(new End(143,98));
			background.add(new End(142 + 141-13,98));
			background.add(new End(140 + 141-13+141-13+1,98));
			background.add(new End(138 + 141-13+141-13+141-13+3,98));

			//frog has to be placed on top of logs but below cars.
			frog = new Frog(assetsPath+"file:src/p4_group_8_repo/FroggerAssets/froggerUp.png");
			background.add(frog);


			background.add(new Vehicles(assetsPath+"truck1"+"Right.png", 0, 649, 1, 120, 120));
			background.add(new Vehicles(assetsPath+"truck1"+"Right.png", 300, 649, 1, 120, 120));
			background.add(new Vehicles(assetsPath+"truck1"+"Right.png", 600, 649, 1, 120, 120));
			//background.add(new Vehicles(assetsPath+"truck1"+"Right.png", 720, 649, 1, 120, 120));
			background.add(new Vehicles(assetsPath+"car1Left.png", 100, 597, -1, 50, 50));
			background.add(new Vehicles(assetsPath+"car1Left.png", 250, 597, -1, 50, 50));
			background.add(new Vehicles(assetsPath+"car1Left.png", 400, 597, -1, 50, 50));
			background.add(new Vehicles(assetsPath+"car1Left.png", 550, 597, -1, 50, 50));
			background.add(new Vehicles(assetsPath+"truck2Right.png", 0, 540, 1, 200, 200));
			background.add(new Vehicles(assetsPath+"truck2Right.png", 500, 540, 1, 200, 200));
			background.add(new Vehicles(assetsPath+"car1Left.png", 500, 490, -5, 50, 50));
			background.add(new Digit(0, 30, 360, 25));
			//background.add(truck);
			//background.add(truck1);
			//background.add(truck2);

			//background.start() - method in World class launches the application.
			background.start();
			primaryStage.setScene(scene);
			primaryStage.show();
			startGame();
	}



	//This timer keeps track of the score.
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (frog.changeScore()) {
            		setNumber(frog.getPoints());
            	}
            	if (frog.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+ frog.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }

	//start method for score timer.
	public void startGame() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new Digit(k, 30, 360 - shift, 25));
    		  shift+=30;
    		}
    }
}
