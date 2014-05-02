//Mark--The Absent Invaders 
// "git@github.com:ryustegolob/GridWorld-4-5.git"
//APCS pd 8 
//HW35 -- GridWorld, Part 5
//2014-05-01
//See hw35.txt file for Set 10 and 11
package info.gridworld.grid;

import java.util.ArrayList;

import java.util.*;

public class UnboundedGrid2<E> extends Grid<E>{

    private Object[][] board; 
    int _sideLen;
  
    public UnboundedGrid2(){
        board = new Object[16][16];
	_sideLen = board.length;
    }

    public int getNumRows(){
        return -1;
    }

    public int getNumCols(){
        return -1;
    }

    public boolean isValid(Location loc){
        return true;
    }

    public ArrayList<Location> getOccupiedLocations(){
        ArrayList<Location> a = new ArrayList<Location>();
	for(int i = 0; i < _sideLen; i++){
	    for(int j = 0; j < _sideLen; j++){
		Location lo = new Location(i,j); 
		if(lo.getRow() != null && lo.getCol() != null)
		    a.add(lo); 
	    }
	}
	return a; 
    }

    public E get(Location loc)
    {
        if (loc == null)
            throw new NullPointerException("loc == null");
	return board[ loc.getRow()][ loc.getCol()]; 
    }//O(1) 

    public E put(Location loc, E obj) {
        if (loc == null)
            throw new NullPointerException("loc == null");
        if (obj == null)
            throw new NullPointerException("obj == null");
        while(loc.getRow() >= _sideLen || loc.getCol() >= _sideLen)
	    makeBigger(); 
	int x = loc.getRow(); 
	int y = loc.getCol(); 
       	board[x][y] = obj; 
	return loc; 
    }//O(1) when it doesnt start the while loop 
    //O(N^2) when makeBigger is called

    public void makeBigger(){
	_sideLen = _sideLen * 2; 
	Object[][] temp = new Object[_sideLen][_sideLen]; 
	for(int i = 0; i < _sideLen; i++){ 
	    for(int j = 0; j < _sideLen; j++){
		temp[i][j] = board[i][j]; 
	    }
	}
	board = temp; 
    }
	

    public void remove(Location loc){
        if (loc == null)
            throw new NullPointerException("loc == null");
	if(loc.getRow() >= _sideLen || loc.getCol() >= _sideLen)
	    throw new IndexOutOfBoundsException();   
	board[loc.getRod()] [loc.getCol()] = null; 
    }
	
    
}
