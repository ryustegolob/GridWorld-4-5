import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

/*Differences from Critter:
  - it looks at all neighbors within 2 steps
  - it changes color based on how many neighbors are around it 
*/

public class BlusterCritter extends Critter{
    private int c;
    private static final double DARKENING_FACTOR = 0.05;

  
    public BlusterCritter(int c){
	super();
	this.c = c;
    }
    
    //changes: check if its two spcaes away
    public ArrayList<Actor> getActors(){
	ArrayList<Actor> actors = new ArrayList<Actor>();
	Location loc = getLocation();
	for(int r = loc.getRow() - 2; r <= loc.getRow() + 2; r++ )
	    for(int c = loc.getCol() - 2; c <= loc.getCol() + 2; c++){// 2 spaces away!
		Location temp = new Location(r,c);
		if(getGrid().isValid(temp)){
		    Actor a = getGrid().get(temp);
		    if(a != null && a != this)//checking if the actor is good to go
			actors.add(a);
		}
	    }
	return actors;
    }
    
    public void processActors(ArrayList<Actor> actors){
	int count = 0;
	for(Actor a: actors)
	    if(a instanceof Critter)
		count++; //couting the number of actors in the area
	if(count < c)
	    lighten();
	else
	    darken(); 
    }
    
    private void darken(){ //just like th flower!
	Color c = getColor();
	int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
	int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
	int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));
	setColor(new Color(red, green, blue));
    }
    
    private void lighten(){//like the flower, but adding instead of subtracting
	Color c = getColor();
	int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
	int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
	int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
	setColor(new Color(red, green, blue));
    }
}
