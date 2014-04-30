import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/*Differences:
  - makes everything move around it!
*/

public class KingCrab extends CrabCritter{
 
    public int distance(Location loc1, Location loc2){ // distance between two locations!
	int x1 = loc1.getRow();
	int y1 = loc1.getCol();
	int x2 = loc2.getRow();
	int y2 = loc2.getCol();
	double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5;
	return (int)Math.floor(dist);
    }
    

    private boolean moveAway(Actor a){ // can the actor move away?
	ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());//wide open spaces
	for(Location loc:locs){
	    if(distance(getLocation(), loc) > 1){//more than 1 away
		a.moveTo(loc);//be gone!
		return true;
	    }
	}
	return false; //welp this is awkward
    }
  
    public void processActors(ArrayList<Actor> actors){
	for (Actor a : actors){
	    if (!moveAway(a)){ //if you can't move away
		a.removeSelfFromGrid(); //be gone forever!
	    }
	}
    }


}
