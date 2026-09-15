

public class Pawn {
// Fields (all private): color, column, row
    private PieceType pieceName;
    private String color;
    private char column;
    private int row;

    public Pawn() {
        this.pieceName = PieceType.PAWN;
    }

    public Pawn(String color, char column, int row) {
        this.pieceName = PieceType.PAWN;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    public String getColor() {
        return color;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    //public verify accessed by game, but utilizes private methods
    public boolean verifyTarget(char targetColumn, int targetRow) {
        return isForwardMove(targetColumn, targetRow);
    }

    private boolean isForwardMove(char targetColumn, int targetRow) {
        // pawn can only move 'forward' (relative to it's color), in it's own row
        if (targetColumn != this.column) {
            return false;
        }
        
        int direction;
        // white pieces start on row 2, increment on +1 ->> Black pieces start on row 7, decrement on -1
        if (this.color.equalsIgnoreCase("White")) {
            direction = 1;
        } else {
            direction = -1;
        }

        int rowDifference = targetRow - this.row;
        //can only move one space 'forward' relatively 
        if (rowDifference == direction) {
            return true;
        }
        return false;
    }
}

/*Danny notes:

- A class can be fully public while every single one of its fields is private and its only exposed surface is a handful 
of getters, setters, and verifyTarget(). That's what good encapsulation looks like. 
The class type is visible so other classes can create and reference it, 
but what's happening inside an instance of that type is hidden.

- lit. the man behind the curtain. Like in that scene from singing in the rain, where one woman is on stage, 
she looks the part, she's dazzling the audience, shes mouthing along to the words of the song, but that other woman
is behind the curtain, doing the actual singing. 


- Ask myself: Does ChessGame (or any other class) need to call this directly to get its job done?
? If yes -> public. 
If it only exists so another method in the same class has something to call -> private. 
- Ask it from the caller's side: "does code outside this class have a legitimate reason to reach in here?" 

- Is this any of your business to know what's going on behind the curtain? 

*/