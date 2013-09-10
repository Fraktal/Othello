
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
     *final int EMPTY = 0;
     *final static int board[][] = new int[10][10];
     * 
     *for (int i=0; i<10; i++)      
     *   {
     *      board[i][0] = PieceColor.BORDER;
     *      board[i][9] = PieceColor.BORDER;
     *      board[0][i] = PieceColor.BORDER;
     *      board[9][i] = PieceColor.BORDER;
     *   } 
     * 
     *for (int i=1; i<9; i++)       
     *   for (int j=1; j<9; j++)
     *      board[i][j] = PieceColor.EMPTY;
     * 
     * //init board
     * if (PieceColor.value == 'B') {
     *      board[5][4] = PieceColor.BLACK;
     *      board[4][5] = PieceColor.BLACK;
     *      whiteMove();
     *     
     *  } else {
     *      board[4][4] = PieceColor.WHITE;          
     *      board[5][5] = PieceColor.WHITE;
     *      blackMove();
     *  }
     * 
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
     * // Create the sorted set
     * SortedSet set = new TreeSet();
     *
     * // Add elements to the set
     * set.add("b");
     * set.add("c");
     * set.add("a");
     *
     * // Iterating over the elements in the set
     * Iterator it = set.iterator();
     * while (it.hasNext()) {
     * // Get element
     * Object element = it.next();
     * }
     * // The elements are iterated in order: a, b, c
     *
     * // Create an array containing the elements in a set (in this case a String array).
     * // The elements in the array are in order.
     * String[] array = (String[])set.toArray(new String[set.size()]);
     * 
     *  
     * returns a list of all legal moves. use sorted set. Must return
     * a list of moves like Cameron's game. pass player as a parameter. return ONLY 
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

