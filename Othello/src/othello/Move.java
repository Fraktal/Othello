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
    final char a = 1;
    final char b = 2;
    final char c = 3;
    final char d = 4;
    final char e = 5;
    final char f = 6;
    final char g = 7;
    final char h = 8;
    private boolean black_done = false; 
    private boolean white_done = false;
    
    /**public void blackMove() {
       
        // legal move constructor needs to be built
        black_done = true;
        for (int i=1; i<9; i++)
            for (int j=1; j<9; j++)
                if (game.legalMove(i,j,PieceColor.BLACK,false) ) 
                    black_done=false;

        game = black.strategy(game, black_done, PieceColor.BLACK);          
    }*/ 
    
    /**public void whiteMove() {
       
        // legal move constructor needs to be built
        white_done = true;
        for (int i=1; i<9; i++)
            for (int j=1; j<9; j++)
                if (game.legalMove(i,j,PieceColor.WHITE,false) ) 
                    white_done=false;

        game = white.strategy(game, white_done, PieceColor.WHITE);          
    }*/ 
    
    Move(){
    /**
     * moveInput = Board.board[Str.charAt(2)][r];
     * playerMoving = Str.charAt(1)
     * 
     * if (turn == PieceColor.BLACK) {
     *      blackMove();
     *      turn = PieceColor.WHITE;
     *  }
     * else {
     *      whiteMove();
     *      turn = PieceColor.BLACK;
     *  }
     * }
     *  
     */ 
    }//Move default contructor
    /**
     * just spit out your color
     * @param moveValue -- parameter for initial value for Move's instance variables
     * int position; 
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
     * this needs to print out not the 2D array values, but the
     * board location i.e. a 1 or b 1. Return a string. Use a hash table??
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

