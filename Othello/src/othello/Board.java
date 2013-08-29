
package othello;

import java.util.ArrayList;

/**
 *
 * @author Shawn "Todd" Ervin
 */
public class Board {
    /**
     * Initializes board using myColor
     * 
     * @param myColor -- color of agent 
     */
    Board(PieceColor myColor){

    }//constructor

    /**
     * color will passed to me then initialize the board
     * initialize the board by color in the center at start positions
     * using 1 and -1
     * will be only called during the game
     * @param oldBoard -- board to be copied
     */

    Board(Board oldBoard){

    }//Board

    /**
     * Takes an old board and clones it. basically, every move will generate a
     * new board after each move. Make a copy of the board and create a new one
     * with new moves
     * @param player -- player for whom to generate moves
     * @return List of all valid moves for player 
     */
    public ArrayList<Move> generateMoves(PlayerType player) {
        return null;
    }//generateMoves

    /**
     * returns a list of all legal moves. She uses sorted set. Must return
     * a list of moves like her game. pass player as a parameter. return ONLY 
     * LEGAL moves. 
     * @param player  -- player for whom to apply move
     * @param amove   -- move to apply to board
     */
    public void applyMove(PlayerType player, Move amove) {
    }//applyMove

    /**
     * amove has been passed to it. Take the board and apply move
     * @return true if game is over (ie: no moves for either player) 
     *         false otherwise
     */
    public boolean isEndGame() {
        //if both generate moves lists are empty then end game. if 
        //statements for both. Boolean
        return true;
    }
}//Board
//other methods: implmenting utility methods to help. Feel free to add other
//methods

