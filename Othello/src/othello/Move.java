package othello;

/**
 *
 * @author Shawn "Todd" Ervin
 */
public class Move implements Comparable<Move>{
    /**
     * static final int PASS_VALUE = 0;
     * Default constructor that initializes a pass move
     */
    Move(){

    }//Move default contructor
    /**
     * just spit out your color
     * @param moveValue -- parameter for initial value for Move's instance variables
     * 1 d array padded index 11 up to 88 
     * int position; 
     */
    Move(int moveValue){

    }//Move constructor

    /**
     * taking some initial value 
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
     * this needs to print out not the 1D array values, but the
     * board location i.e A 1 or B 1. Return a string. Use a hash table??
     * @param otherMove -- move to be compared 
     * @return 
     *      -1 if this move precedes otherMove
     *       0 if this move equals otherMove
     *       1 if this move succeeds otherMove
     */
    @Override
    public int compareTo(Move otherMove){
        /**
         * leave at 0 for the moment. If this move is supposed to come before 
         * the other move, then return negative -1, the same 0, 
         * if greater then 1
         */
        return 0;
    }//compareTo
}//Move

