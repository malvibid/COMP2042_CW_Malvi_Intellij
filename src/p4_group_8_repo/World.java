package p4_group_8_repo;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;


//World class is responsible for making this game dynamic i.e., changing the game state overtime. It sets the environment for Frogger to run.
//It implements the animation timer which is an infinite loop that updates the game objects and renders the scene to the screen, at a rate of approximately 60 times per second.
public abstract class World extends Pane {
    private AnimationTimer timer;
    
    public World() {
    	
        //listens for changes in scene and updates the values according to new changes values.
    	sceneProperty().addListener(new ChangeListener<Scene>() {

    	    //Changed method keeps a record of which keys are currently active. It does this by maintaining an array list of actor objects.
            //When a key is initially pressed, a representation of the KeyEvent's KeyCode is added to the list, when the key is released we remove it from the list. This is controlled from the Frog class.
			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    //This timer is responsible for updating the actors in real-time, i.e. responsible for making it move.
    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);
                
                for (Actor anActor: actors) {
                	anActor.act(now);
                }
      
            }
        };
    }

    //Starts actors AnimationTimer.
    public void start() {
    	createTimer();
        timer.start();
    }

    //Stops actors AnimationTimer. This would freeze the objects in place. Useful for pausing or ending the game.
    public void stop() {
        timer.stop();
    }
    
    public void add(Actor actor) {
        getChildren().add(actor);
    }

    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    public abstract void act(long now);
}
