/*****************************************************************
 * Rebecca Yuste-Golob-- The Absent Invaders
 * APCS pd 8
 * HW34 -- GridWorld, Part 4
 * 2014-05-02
 *
 * class VoldemortCritter
 *
 * BEACUASE:
 * It was the first thing I came up with, and my team seems to have no opinion in this matter.
 *
 * SPECIFICATIONS:
 * This critter would be like any normal critter, except it would "kill" all other actors in the region (tell them to remove themselves).
 *
 * TEST CASES:
 * When the VoldemortCritter encounters no actors, when it is at the end of the board, when it cannot move.
 *
 * ERRATA:
 * My team made no attempt to help or come up with ideas for how to further develop this class. 
 * 
 *****************************************************************/




public class VoldemortCritter extends Critter {

    public void processActors (ArrayList<Actor> actors) {
	for (Actor a : actors)
	    a.removeSelfFromGrid();
    }

}
