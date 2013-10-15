package othello;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;

import static othello.PlayerType.*;

/**
 * @author Shawn "Todd" Ervin
 */
public class Othello {

    static final int MyPieceINDEX = 1;  //index in pieces array
    static final int OppPieceINDEX = 3;  //index in pieces array
    static PieceColor[] pieces = {
            PieceColor.BORDER, PieceColor.WHITE, PieceColor.EMPTY, PieceColor.BLACK};
    //0 --> border, 1-->opponent, 2 --> empty, 3 --> me
    PlayerType currentPlayer;   //Limits player types to the values OPPONENT and ME
    Board board;
    /**
     * static final int ME = 1;
     * static final int Opponent = -1;
     * initialized by Othello.ME
     * or
     * public enum MYCOLRS(BLACK,WHIT,RED,BLUE);
     */
    private BufferedReader keyboard;

    /* Initializes game variables (including board) based in the initialization string
     * @param initStr -- Initial string with values "I B" or "I W"
     *                   "I B" -- Initialize game with agent playing as Black
     *                   "I W" -- Initialize game with agent playing as White
     */
    Othello(String initStr) {
        if (initStr.charAt(2) == 'B') {
            board = new Board(PieceColor.BLACK);
            currentPlayer = PlayerType.ME;
        } else {
            board = new Board(PieceColor.WHITE);
            currentPlayer = PlayerType.OPPONENT;
            pieces[OppPieceINDEX] = PieceColor.BLACK;
            pieces[MyPieceINDEX] = PieceColor.WHITE;
        }

    }

    public Othello(PushbackReader reader) {

        this.keyboard = keyboard;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        OthelloOut.printComment("Please enter I B or I W:");
        String initializeStr = keyboard.readLine();
        //Todd - input error message if not IW or IB. String not correct
        //also check for legal moves
        Othello game = new Othello(initializeStr); //Initialize game
        game.printBoard();
        OthelloOut.printReady(pieces[MyPieceINDEX]);  //let referee know that I'm ready to play
        Move move;
        while (!game.over()) {
            if (game.myTurn()) {
                move = game.getMyMove();
            } else {
                move = game.getOpponentMove(keyboard);
            }
            game.applyMove(move);
            game.printBoard();
            OthelloOut.printMove(pieces[MyPieceINDEX], move);
            game.switchPlayers();
        }//while game is not over
        //game.announceScore();
    }//main

    boolean over() {
        if (board.isEndGame()){
        return true;
        }

        return false;
    }

    boolean myTurn() {
        if (ME.getValue() == -1) {
            return false;
        }
        return true;
    }

    Move getMyMove() {

        ArrayList<Move> moveList = board.generateMoves(PlayerType.ME);
        if (moveList.isEmpty())
            return new Move(0, 0);  //return pass move
        else
            return moveList.get(0);
    }

    Move getOpponentMove(BufferedReader keyboard) throws IOException {
        ArrayList<Move> moveList = board.generateMoves(PlayerType.OPPONENT);
        int r = 0;
        int c = 0;
        //input from BufferedReader  uugghhhhh!!!
        return moveList.get(0);
    }

    void applyMove(Move move) {
      //board.applyMove(PlayerType.ME, move);//not working. This is my attempt to understand
    }

    void printBoard() {

        board.printBoard(pieces);
    }

    void switchPlayers() {
    }


    void announceScore() {

    }
        /*
        int oppScore = 0;
        int meScore = 0;
        int score[] = new int[2];
        for (int r = 0; r < Board.board.length; r++) {
            for (int c = 0; c < Board.board.length; c++) {
                if (Board.board[r][c] == OPPONENT.getValue()) {
                    oppScore++;
                }
                if (Board.board[r][c] == ME.getValue()) {
                    meScore++;
                }
            }//end for loop
        }//end for loop

        if (board.isEndGame() == true) {
            score[0] = oppScore;
            score[1] = meScore;
            System.out.print("The Score for the player is " + score[0] + "\n");
            System.out.print("The Score for the me is " + score[1]);
        }//end if
    }      */
}//Othello


