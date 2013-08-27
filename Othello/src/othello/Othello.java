package othello;
import java.io.*;
/**
 *
 * @author Marietta E. Cameron
 */
public class Othello {
   
    static final int MyPieceINDEX= 1;  //index in pieces array
    static final int OppPieceINDEX = 3;  //index in pieces array
    static PieceColor[] pieces = {
                       PieceColor.BORDER, PieceColor.WHITE, PieceColor.EMPTY,PieceColor.BLACK};  
                       //0 --> border, 1-->opponent, 2 --> empty, 3 --> me
   
    PlayerType currentPlayer;   //Limits player types to the values OPPONENT and ME
    
    Board board;
    
    /* Initializes game variables (including board) based in the initialization string
     * @param initStr -- Initial string with values "I B" or "I W"
     *                   "I B" -- Initialize game with agent playing as Black
     *                   "I W" -- Initialize game with agent playeing as White
     */
    Othello(String initStr){
        if (initStr.charAt(2) == 'B') {       
            board = new Board(PieceColor.BLACK);
            currentPlayer = PlayerType.ME;
        }
        else {
            board = new Board(PieceColor.WHITE);
            currentPlayer = PlayerType.OPPONENT;
            pieces[OppPieceINDEX] = PieceColor.BLACK;
            pieces[MyPieceINDEX] = PieceColor.WHITE;
        }    
        
    }
    boolean over(){
      //returns true if the game is over false otherwise      
        return true;
    }
    boolean myTurn(){
      //return true if currently my turn false otherwise
        return true;
    }
    Move getMyMove() {
        return null;
    }
    Move getOpponentMove(BufferedReader keyboard) {
        return null;
    }
    void applyMove(Move move){
        
    }
    void printBoard(){
        
    }
    
    void switchPlayers(){
        
    }
    
    void announceScore(){
       
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
        OthelloOut.printReady(pieces[MyPieceINDEX]);  //let referee know that I'm readly to play
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
        }//while game is not over
        game.announceScore();
    }//main
}//Othello
