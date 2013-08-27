
package othello;

import java.util.ArrayList;

/**
 *
 * @author Marietta E. Cameron
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
     * 
     * @param oldBoard -- board to be copied
     */
    
    Board(Board oldBoard){
        
    }//Board
    
    /**
     * 
     * @param player -- player for whom to generate moves
     * @return List of all valid moves for player 
     */
    public ArrayList<Move> generateMoves(PlayerType player){
        return null;
    }//generateMoves
    
    /**
     * 
     * @param player  -- player for whom to apply move
     * @param amove   -- move to apply to board
     */
    public void applyMove(PlayerType player, Move amove){
        
    }//applyMove
    
    /**
     * 
     * @return true if game is over (ie: no moves for either player) 
     *         false otherwise
     */
    public boolean isEndGame(){
        return true;
    }
}//Board
