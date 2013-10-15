package othello;

import java.util.ArrayList;

/**
 * @author Shawn "Todd" Ervin
 */


public class Move implements Comparable<Move> {
     static final int PASS_VALUE = 0;
    /*
     * Default constructor that initializes a pass move
     */
    int row;
    int col;
    int[] flip = new int[8];

    Move() {
        row = 0;
        col = 0;
    }//Move default contructor

    /**
     * just spit out your color
     *
     * @param -- parameter for initial value for Move's instance variables
     *           int position;
     */
    Move(int r, int c) {
        row = r;
        col = c;

    }//Move constructor

    Move(int r, int c, int[] flips) {
        row = r;
        col = c;
        System.arraycopy(flips, 0, flip, 0, 8);
    }//Move constructor

    /**
     * @param oldMove -- Move to be copied
     */
    Move(Move oldMove) {


    }//end oldMove

    /**
     * @return string value of Move
     */

    @Override
    public String toString() {
        if (row == 0)
            return "";
        else
            return (char) (col - 1 + (int) 'a') + " " + row;
    }//toString

    /**
     * this needs to print out not the 2D array values, but the
     * board location i.e. a 1 or b 1. Return a string. Use a hash table??
     *
     * @param otherMove -- move to be compared
     * @return -1 if this move precedes otherMove
     *         0 if this move equals otherMove
     *         1 if this move succeeds otherMove
     */
    @Override
    public int compareTo(Move otherMove) {
        /**
         * leave at 0 for the moment. If this move is supposed to come before 
         * the other move, then return negative -1, the same 0, 
         * if greater then 1
         */
        return 0;
    }//compareTo


boolean isAPass() {
        return row == PASS_VALUE;
    }

}//end move

