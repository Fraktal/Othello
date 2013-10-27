package othello;


/**
 * @author Shawn "Todd" Ervin
 */


public class Move implements Comparable<Move> {
    static final int PASS_VALUE = 0;
    int row;
    int col;
    int[] flip = new int[8];
    public int value;
    boolean passMove = false;

    Move() {
        row = 0;
        col = 0;
    }//Move default contructor

    Move(int r, int c) {
        row = r;
        col = c;
    }//Move constructor

    Move(int r, int c, int[] flips) {
        row = r;
        col = c;
        System.arraycopy(flips, 0, flip, 0, 8);
    }//Move constructor

    Move(String moveString) {
        if (moveString.length() == 0) {
            row = 0;
            col = 0;
        } else {
            col = moveString.charAt(2) - 'a' + 1;
            row = moveString.charAt(4) - '0';
        }
    }

    @Override
    public String toString() {
        if (row == 0) return "";
        else return (char) (col - 1 + (int) 'a') + " " + row;
    }

    /**
     * @param otherMove -- move to be compared
     * @return -1 if this move precedes otherMove
     *         0 if this move equals otherMove
     *         1 if this move succeeds otherMove
     */
    @Override
    public int compareTo(Move otherMove) {
        //in the list of sorted moves
        if (value > otherMove.value) return -1;
        else if (value < otherMove.value) return 1;
        else if (row < otherMove.row) return -1;
        else if (row > otherMove.row) return 1;
        else if (col < otherMove.col) return -1;
        else if (col > otherMove.col) return 1;
        else return 0;
    }


    boolean isAPass() {
        return row == PASS_VALUE;
    }


    public boolean equals(Object other) {
        Move otherMove = (Move) other;
        return row == otherMove.row && col == otherMove.col;
    }
}

