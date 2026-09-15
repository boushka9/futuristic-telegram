public class ChessBoard {
    //     ChessBoard boarders
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

    // specific case of 'gh' type entry, char is single character = cannot compare those
    public boolean isValidColumn(char column) {
        return column >= MIN_COLUMN && column <= MAX_COLUMN;
    }

    // used w inputs that are not int/1-8
    public boolean isValidRow(int row) {
        return row >= MIN_ROW && row <= MAX_ROW;
    }
}