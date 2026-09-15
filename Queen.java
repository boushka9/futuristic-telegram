public class Queen {

 
    private PieceType pieceName;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public Queen() {
        this.pieceName = PieceType.QUEEN;
    }

    // Constructor with parameters
    public Queen(String color, char column, int row) {
        this.pieceName = PieceType.QUEEN;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    // Getters
    public String getColor() {
        return color;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // Setters
    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // Verifies if the queen can move to the target position
    public boolean verifyTarget(char targetColumn, int targetRow) {
        return isStraightOrDiagonalMove(targetColumn, targetRow);
    }

    // Private support method for the movement check
    private boolean isStraightOrDiagonalMove(char targetColumn, int targetRow) {
        int columnDifference = Math.abs(targetColumn - this.column);
        int rowDifference = Math.abs(targetRow - this.row);

        return targetColumn == this.column
                || targetRow == this.row
                || columnDifference == rowDifference;
    }
}
