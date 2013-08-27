package othello;

/**
 *
 * @author cameron
 */
public class Move implements Comparable<Move>{
    /**
     * Default constructor that initializes a pass move
     */
    Move(){
        
    }//Move default contructor
    /**
     * 
     * @param moveValue -- parameter for initial value for Move's instance variables 
     */
    Move(int moveValue){
        
    }//Move constructor
    
    /**
     * 
     * @param oldMove -- Move to be copied 
     */
    Move(Move oldMove){
        
    }//Move clone constructor
    
    /**
     * 
     * @return string value of Move 
     */
    @Override
    public String toString(){
        return null;
    }//toString
    /**
     * 
     * @param otherMove -- move to be compared 
     * @return 
     *      -1 if this move precedes otherMove
     *       0 if this move equals otherMove
     *       1 if this move succeeds otherMove
     */
    @Override
    public int compareTo(Move otherMove){
        return 0;
    }//compareTo
}//Move
