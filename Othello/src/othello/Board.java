package othello;

import java.util.SortedSet;
import java.util.TreeSet;

import static othello.PlayerType.*;

/**
 * @author Shawn "Todd" Ervin
 */
public class Board {

    public int board[][] = new int[10][10];
    public static final int[][] DIR = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1},
            {1, -1}, {1, 1}, {-1, -1}};

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
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                board[i][j] = EMPTY.getValue();
            }
        }

        //init board
        if (myColor == PieceColor.BLACK) {
            board[5][4] = ME.getValue();
            board[4][5] = ME.getValue();
        } else {
            board[4][4] = OPPONENT.getValue();
            board[5][5] = OPPONENT.getValue();
        }

        if (myColor == PieceColor.WHITE) {
            board[5][4] = ME.getValue();
            board[4][5] = ME.getValue();
        } else {
            board[4][4] = OPPONENT.getValue();
            board[5][5] = OPPONENT.getValue();
        }

    }

    Board(Board oldBoard) {
        int board[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(oldBoard.board[i], 0, board[i], 0,
                    board[i].length);
        }
    }

    public SortedSet<Move> generateMoves(PlayerType player) {
        SortedSet<Move> possible;
        possible = new TreeSet<Move>();
        PlayerType oppPlayer;

        if (player == ME) oppPlayer = OPPONENT;
        else oppPlayer = ME;
        for (int r = 1; r < board.length-1; r++) {
            for (int c = 1; c < board[r].length-1; c++) {
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
                        }
                        if (board[row][col] == player.getValue() && count > 0) {
                            isMove = true;
                            flips[d] = count;
                        }
                    }
                    if (isMove) possible.add(new Move(r, c, flips));
                }
            }
        }

        return possible;

    } //generateMoves


    public int evaluate(int player, int ply) {
        //check for endgame
        SortedSet<Move> myMoves = this.generateMoves(PlayerType.ME);
        SortedSet<Move> oppMoves = this.generateMoves(PlayerType.OPPONENT);
        int pieceCount = 0;

        for (int r = 1; r <= 8; r++) {
            for (int c = 1; c <= 8; c++) {
                if (board[r][c] != BORDER.getValue()) pieceCount += board[r][c];
            }
            if (myMoves.isEmpty() && oppMoves.isEmpty()) return pieceCount * 100000;
        }
        return pieceCount;
    }


    public SortedSet<Move> bestMove(int move_number, SortedSet<Move> treeMoves) {
        return treeMoves;
    }


    public SortedSet<Move> alphabeta(Board plyboard, int ply, int player,
                                     int alpha, int beta, int last_depth) {

        SortedSet<Move> returnMoves = new TreeSet<Move>();
        if (ply >= last_depth) {
            Move move = new Move(0, 0);
            move.value = plyboard.evaluate(player, ply);
            returnMoves.add(move);
        } else {
            PlayerType currentplayer = null;
            if (player >= 1) currentplayer = PlayerType.ME;
            else currentplayer = PlayerType.OPPONENT;
            SortedSet<Move> moveList = plyboard.generateMoves(currentplayer);
            if (moveList.isEmpty()) moveList.add(new Move(0, 0)); //add a pass move to list

            for (Move move : moveList) {
                //if (Othello.timeUP) return returnMoves;//add more checking timeout flag logic
                Board newBoard = new Board(plyboard);
                newBoard.applyMove(currentplayer, move);
                SortedSet<Move> tempList = newBoard.alphabeta(newBoard, ply + 1, -player, -beta, -alpha, last_depth);
                move.value = -tempList.first().value;
                returnMoves.add(move);
                if (move.value > alpha) alpha = move.value;
                if (alpha > beta) return returnMoves; //will not return all possible moves on ply zero level
            }
        }
        return returnMoves;
    }


    public void applyMove(PlayerType player, Move amove) {
        PlayerType oppPlayer;
        if (player == PlayerType.ME) oppPlayer = PlayerType.OPPONENT;
        else oppPlayer = PlayerType.ME;
        if (!amove.isAPass()) {
            board[amove.row][amove.col] = player.getValue();
            for (int d = 0; d < 8; d++) {
                int row = amove.row + DIR[d][0];
                int col = amove.col + DIR[d][1];
                int count = 0;
                while (count < amove.flip[d]) {
                    board[row][col] = player.getValue();
                    row += DIR[d][0];
                    col += DIR[d][1];
                    count ++;
                }
            }
        }
    }


    public boolean isEndGame() {
        return generateMoves(ME).isEmpty() && generateMoves(OPPONENT).isEmpty();
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

