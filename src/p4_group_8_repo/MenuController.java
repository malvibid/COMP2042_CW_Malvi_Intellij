package p4_group_8_repo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MenuController {

    //private MenuModel model;
    private Main main;

    @FXML private Button Play;
    @FXML private Button Highscore;
    @FXML private Button Help;
    @FXML private Button Exit;



    //When play button is clicked on in the main menu, then change scene to play game, in startPlay method in Main class.
    public void play(ActionEvent event){
        try {
            main.startPlay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    void setMain(Main main) {
        this.main = main;
    }

}
