package othello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Shawn "Todd" Ervin
 */
public class Othello {

    Board board;
    Timer timer;
    PlayerType currentPlayer;
    int moveNumber = 0;
    public int timeRemaining;
    public static boolean timeUP;
    static final int MyPieceINDEX = 3;  //index in pieces array
    static final int OppPieceINDEX = 1;  //index in pieces array
    static double timeAllocation[] = {0.015, 0.015, 0.015, 0.015, 0.025, 0.025, 0.025, 0.025, 0.025, 0.025,
            0.048, 0.048, 0.048, 0.048, 0.048, 0.048, 0.050, 0.051, 0.052, 0.053,
            0.044, 0.045, 0.049, 0.049, 0.049, 0.051, 0.053, 0.055, 0.057, 0.059,
            0.060, 0.060, 0.061, 0.062, 0.063, 0.064, 0.065, 0.065, 0.065, 0.065,
            0.167, 0.168, 0.169, 0.169, 0.171, 0.172, 0.173, 0.175, 0.180, 0.180,
            0.181, 0.187, 0.196, 0.199, 0.220, 0.220, 0.220, 0.220, 0.220, 0.220,
            0.220, 0.250, 0.250, 0.250, 0.250, 0.250, 0.150, 0.010, 0.010, 0.010
    };

    static PieceColor[] pieces = {
            PieceColor.BORDER, PieceColor.WHITE, PieceColor.EMPTY, PieceColor.BLACK};


    class InterruptTask extends TimerTask {
        public void run() {
            OthelloOut.printComment("****>timeup");
            timeUP = true;
            timer.cancel();
        }
    }

    Othello(String initStr) {
        if (initStr.charAt(2) == 'B') {
            board = new Board(PieceColor.BLACK);
            currentPlayer = PlayerType.ME;
        } else {
            board = new Board(PieceColor.WHITE);
            currentPlayer = PlayerType.ME;
            pieces[OppPieceINDEX] = PieceColor.BLACK;
            pieces[MyPieceINDEX] = PieceColor.WHITE;
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        OthelloOut.printComment("Please enter I B or I W:");
        String initializeStr = keyboard.readLine();
        Othello game = new Othello(initializeStr); //Initialize game
        game.printBoard();
        OthelloOut.printReady(pieces[MyPieceINDEX]);  //let referee know that I'm ready to play
        Move move;
        while (!game.over()) {
            if (game.myTurn())
                move = game.getMyMove();
            else
                move = game.getOpponentMove(keyboard);
            game.applyMove(move);
            game.printBoard();
            OthelloOut.printMove(pieces[MyPieceINDEX], move);
            game.switchPlayers();
            game.moveNumber++;
        }//while game is not over
        game.announceScore();
    }//main

    boolean over() {
        return board.isEndGame();
    }

    boolean myTurn() {
        return currentPlayer == PlayerType.ME;
    }

    Move getMyMove() {
        int timeForMove = (int) (timeAllocation[moveNumber] * (double) timeRemaining);
        timer.schedule(new InterruptTask(), timeForMove * 1000);
        SortedSet<Move> moveList = board.alphabeta(board, 0, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, 2);
        if (!timeUP) timer.cancel();
        timeRemaining -= timeForMove;
        return moveList.first();
    }

    Move getOpponentMove(BufferedReader keyboard) throws IOException {
        OthelloOut.printComment("Enter Move ");
        Move noMove = new Move();//pass move
        SortedSet<Move> moveList = board.generateMoves(PlayerType.OPPONENT);
        String input = keyboard.readLine();
        String myTurn = input.substring(0, 1);
        if (myTurn.equals("W") || myTurn.equals("B")) { // in valid format
            Move oppMove = new Move(input);
            if (!moveList.contains(oppMove)) { // is legal move
                OthelloOut.printComment("Invalid move");
                return getOpponentMove(keyboard);
            } else {
                return oppMove;
            }
        } else {// not a valid format
            OthelloOut.printComment("You must pass");
            noMove.passMove = true;
            return noMove;
        }

    }

    void applyMove(Move move) {
        board.applyMove(currentPlayer, move);
    }

    void printBoard() {
        board.printBoard(pieces);
    }

    void switchPlayers() {
        if (currentPlayer == PlayerType.ME) {
            currentPlayer = PlayerType.OPPONENT;
        }
        else currentPlayer = PlayerType.ME;
    }


    void announceScore() {
       board.announceScore();
    }
}//Othello


