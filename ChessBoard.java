public class ChessBoard {
//     ChessBoard Class:
// - check if the chess piece
//  (posXis between columns a and h)and (posY is between 1 and 8)
//  - CONSTANT MAX_ROW = 8
//  - and MIN_ROW = 1

    private static final int MAX_ROW = 8;
    private static final int MIN_ROW = 1;
    private static final char MIN_COLUMN = 'a';
    private static final char MAX_COLUMN = 'h';
 

// Verify w/in bounds: 
//     Given column, row
//     - If h <= column >= a- && 8 <= row >= 1
//         Return T
//     - Else return F

// called by each piece -> public access
    public boolean withinChessboard(char column, int row) {
        return column >= MIN_COLUMN && column <= MAX_COLUMN
                && row >= MIN_ROW && row <= MAX_ROW;
    }
 


}