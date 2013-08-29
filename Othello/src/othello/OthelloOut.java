package othello;

/**
 * Print utility methods for Othello Application.
 * For all output use these methods only!!!
 * @author Shawn "Todd" Ervin
 * 
 */
public class OthelloOut {

    static public void printMove(PieceColor color, Move amove) {
        System.out.printf("%s %s\n", color, amove);
    }//printMove

    static public void printComment(String str) {
        System.out.printf("C %s\n", str);
    }//printComment

    static public void printReady(PieceColor color) {
        System.out.printf("R %s\n", color);
    }//printReady    
}//OthelloOut

