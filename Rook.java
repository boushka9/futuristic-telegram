public class Rook {

    // Fields: private ->> only this class's own methods touch them directly
    // Everything else must go through the getters/setters
    private PieceType pieceName;
    private String color;
    private char column;
    private int row;

    // Empty constructor. Public so ChessGame can call new Rook().
    // Never static - a constructor's whole job is building "this".
    public Rook() {
        this.pieceName = PieceType.ROOK;
    }

    // Full constructor. pieceName is not a parameter on purpose: a Rook
    // object can only ever be a ROOK, so it's set internally instead of
    // trusting the caller to pass the right enum value.
    public Rook(String color, char column, int row) {
        this.pieceName = PieceType.ROOK;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    // Getters: public values, read this.field, so never static.
    public String getColor() {
        return color;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    // Setters: public ->> called to set new rook obj each time
    // (writes this.field, so never static, but returns nothing)
    public void setColumn(char column) {
        this.column = column;
    }

    // sets data != static 
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * this is the reason ChessGame holds a Rook object in the first place. 
     * it reads this.column/this.row to know where the piece currently is, so it can't be static.
     */
    public boolean verifyTarget(char targetColumn, int targetRow) {
        return isStraightLine(targetColumn, targetRow);
    }

    /**
     * Private support method for the actual movement check ->> Never called
     * from ChessGame directly! verifyTarget is the only door in
     */
    private boolean isStraightLine(char targetColumn, int targetRow) {
        return targetColumn == this.column || targetRow == this.row;
    }
}