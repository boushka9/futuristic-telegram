public class ChessBoard {
//     ChessBoard Class:
// - check if the chess piece
//  (posXis between columns a and h)and (posY is between 1 and 8)
//  - CONSTANT MAX_ROW = 8
//  - and MIN_ROW = 1

    private static int MAX_ROW = 8;
    private static int MIN_ROW = 1;
    private static char MIN_COLUMN = 'a';
    private static char MAX_COLUMN = 'h';
 

// Verify w/in bounds of max/min values
// called by each piece -> public access
    public boolean withinChessboard(char column, int row) {
        return column >= MIN_COLUMN && column <= MAX_COLUMN
                && row >= MIN_ROW && row <= MAX_ROW;
    }
 


}