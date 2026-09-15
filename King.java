public class King {

   
    private PieceType pieceName;
    private String color;
    private char column;
    private int row;

    // Empty constructor
    public King() {
        this.pieceName = PieceType.KING;
    }

    // Constructor with parameters
    public King(String color, char column, int row) {
        this.pieceName = PieceType.KING;
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

    // Verifies if the king can move to the target position
    public boolean verifyTarget(char targetColumn, int targetRow) {
        return isOneSquareMove(targetColumn, targetRow);
    }

    // Private support method for the movement check
    private boolean isOneSquareMove(char targetColumn, int targetRow) {
        int columnDifference = Math.abs(targetColumn - this.column);
        int rowDifference = Math.abs(targetRow - this.row);

        return columnDifference <= 1 && rowDifference <= 1;
    }
}
