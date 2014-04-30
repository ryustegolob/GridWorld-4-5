import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

//A RockHound will "eat" rocks! It only needs to override the processActors method

public class RockHound extends Critter{ 

    public void processActors(ArrayList<Actor> actors){
	for (Actor a : actors){ 
	    if (a instanceof Rock)
		a.removeSelfFromGrid(); //eatin' rocks
	}
    }
}
