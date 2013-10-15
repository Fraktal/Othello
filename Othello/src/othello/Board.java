package othello;

import sun.org.mozilla.javascript.ast.WhileLoop;

import java.util.ArrayList;

import static othello.PlayerType.*;

/**
 * @author Shawn "Todd" Ervin
 */
public class Board {

    public static final int board[][] = new int[10][10];
    public static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1},
            //Left    Right   Down     Up     DownLeft
            {1, -1}, {1, 1}, {-1, -1}};
    //DownRight  UpRight  UpLeft
    int r;
    int c;

    /**
     * Initializes board using myColor
     *
     * @param myColor -- color of agent
     */
    Board(PieceColor myColor) {

        for (int i = 0; i < 10; i++) {
            board[i][0] = BORDER.getValue();
            board[i][9] = BORDER.getValue();
            board[0][i] = BORDER.getValue();
            board[9][i] = BORDER.getValue();
        }//end for loop 

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = EMPTY.getValue();
            }
        }

        //init board
        if (myColor == PieceColor.BLACK) {
            board[5][4] = ME.getValue();
            board[4][5] = ME.getValue();
            // whiteMove();

        } else {
            board[4][4] = OPPONENT.getValue();
            board[5][5] = OPPONENT.getValue();
            //blackMove();

        }//end if else statement

        if (myColor == PieceColor.WHITE) {
            board[5][4] = ME.getValue();
            board[4][5] = ME.getValue();
            // blackMove();

        } else {
            board[4][4] = OPPONENT.getValue();
            board[5][5] = OPPONENT.getValue();
            //whiteMove();

        }//end if else statement

    }

    Board(Board oldBoard) {

        for (int i = 0; i < 10; i++) {
            System.arraycopy(oldBoard.board[i], 0, board[i], 0,
                    oldBoard.board[i].length);
        }//end for loop
    }//end oldBoard

    public ArrayList<Move> generateMoves(PlayerType player) {

        ArrayList<Move> possible;
        possible = new ArrayList<Move>();
        PlayerType oppPlayer;
        boolean potential = false;
        int pos = 0;


        if (player == ME) {
            oppPlayer = OPPONENT;
        } else {
            oppPlayer = ME;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == EMPTY.getValue()) {
                    boolean isMove = false;
                    int[] flips = new int[8];
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int row = r + DIR[d][0];
                        int col = c + DIR[d][1];
                        while (board[row][col] == oppPlayer.getValue()) {
                            row += DIR[d][0];
                            col += DIR[d][1];
                            count++;
                        }//end while

                        if (board[row][col] == player.getValue()) {
                            isMove = true;
                            flips[d] = count;
                        }
                    }//end DIR for loop

                    if (isMove) {
                        possible.add(new Move(r, c, flips));
                    }//end if

                } //end if empty
            }//end second for loop
        }//end first for loop

        return possible;

    } //generateMoves

    /**
     * // Create the sorted set
     * SortedSet set = new TreeSet();
     * <p/>
     * // Add elements to the set
     * set.add("b");
     * set.add("c");
     * set.add("a");
     * <p/>
     * // Iterating over the elements in the set
     * Iterator it = set.iterator();
     * while (it.hasNext()) {
     * // Get element
     * Object element = it.next();
     * }
     * // The elements are iterated in order: a, b, c
     * <p/>
     * // Create an array containing the elements in a set (in this case a String array).
     * // The elements in the array are in order.
     * String[] array = (String[])set.toArray(new String[set.size()]);
     * <p/>
     * <p/>
     * returns a list of all legal moves. use sorted set. Must return
     * a list of moves like Cameron's game. pass player as a parameter. return ONLY
     * LEGAL moves.
     *
     * @param player -- player for whom to apply move
     * @param amove  -- move to apply to board
     */

    public void applyMove(PlayerType player, Move amove) {
        PlayerType oppPlayer;
        if (player == PlayerType.ME) {
            oppPlayer = PlayerType.OPPONENT;
        } else {
            oppPlayer = PlayerType.ME;
        }
        if (!amove.isAPass()) {
            board[amove.row][amove.col] = player.getValue();
            for (int d = 0; d < 8; d++) {
                int row = amove.row + DIR[d][0];
                int col = amove.col + DIR[d][1];
                while (board[row][col] == oppPlayer.getValue()) {
                    board[row][col] = player.getValue();
                    row += DIR[d][0];
                    col += DIR[d][1];
                }
            }
        }
    }//applyMove

    /**
     * amove has been passed to it. Take the board and apply move
     *
     * @return true if game is over (ie: no moves for either player)
     *         false otherwise
     */
    public boolean isEndGame() {
        //if both generate moves lists are empty then end game. if
        //statements for both. Boolean
        if (generateMoves(ME) == null && generateMoves(OPPONENT) == null) {
            return true;
        }

        return false;
    }

    public void printBoard(PieceColor[] pieces) {


        OthelloOut.printComment("    a b c d e f g h");


        for (int i = 0; i < board.length; i++) {
            String rowStr = i + " ";
            for (int j = 0; j < board.length; j++) {
                rowStr += pieces[board[i][j] + 2].toString() + " ";
            }

            OthelloOut.printComment(rowStr);
        }

    }
}//Board
//other methods: implmenting utility methods to help. Feel free to add other
//methods
