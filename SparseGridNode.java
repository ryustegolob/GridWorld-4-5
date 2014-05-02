import java.io.*; 
import java.util.*; 

public class SparseGridNode{ 
    private Object occupant; 
    private int col;
    private SparseGridNode next;
    
    public SparseGridNode(Object o, int col, SparseGridNode n){
	occupant = o; 
	col = col; 
	next = n;
    }

    public Object getOccupant(){
	return occupant; 
    }
    public int getCol(){ 
	return col; 
    }
    public void setOccupant(Object o){ 
	occupant = o; 
    } 
    public void setNext(SparseGridNode x){
	next = x; 
    }
    public SparseGridNode getNext(){
	return next; 
    }

}
