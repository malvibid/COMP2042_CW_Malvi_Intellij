package p4_group_8_repo;

import javafx.scene.image.Image;

//Vehicles class controls the cars/Trucks.
public class Vehicles extends Actor {
	private int speed;
	@Override
	public void act(long now) {
		
        //Depending on the lane cars are moving towards right side or left side. When the car goes off the screen, it re-enters from starting side.
        //The following code re-sets the position of the car if its off screen.
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}
	
	public Vehicles(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
