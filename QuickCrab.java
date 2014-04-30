import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;

/*Differences:
  - moves 2 spaces away instead of 1 (when possible)
*/

public class QuickCrab extends CrabCritter{

    public ArrayList<Location> getMoveLocations(){
	ArrayList<Location> locs = new ArrayList<Location>();
	Grid g = getGrid();
	twoAway(locs,getDirection() + Location.LEFT);//spaces that are good to move to that are 2 away
	twoAway(locs,getDirection() + Location.RIGHT); // only left and righ though
	if (locs.size() == 0)
	    return super.getMoveLocations();
	return locs;
    }

    private void twoAway(ArrayList<Location> locs,int dir){//gets spaces that are good to move to that are 2 away
	Grid g = getGrid();
	Location loc = getLocation();
	Location temp = loc.getAdjacentLocation(dir);
	if(g.isValid(temp) && g.get(temp) == null){// looks to see the temp is valid
	    Location loc2 = temp.getAdjacentLocation(dir); //finds a place adjacent to the temp -> 2 away
	    if(g.isValid(loc2) && g.get(loc2)== null)
		locs.add(loc2);
	}
    }
}
