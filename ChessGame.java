import java.util.Scanner;

public class ChessGame {

// Emma (Danny) Boushka 

// Clarissa Esparza 

// Alfredo Herrera 

//This program verifies whether a given chess piece at a location 
//specified by the user can move to another location specified by the user. 

//The user should be allowed to select a piece and set its initial position, 
//then set the target position. 

//The system lets the user know if the target position is valid or invalid. 
//The user shall be prompted to verify another target position using the same 
//original position. The user shall also be prompted to select a different piece (start again).

    // no superclass for pieces, so the piece-type happens case by case, ie swithc case
    // branch has to happen here, so each type is able to call verify target
    private static boolean verifyPieceMove(String userPiece, String pieceColor, char currCol, int currRow, char targetCol, int targetRow){
        PieceType type = PieceType.valueOf(userPiece.trim().toUpperCase());
        switch(type){
            case PAWN:
                Pawn pawn = new Pawn(pieceColor, currCol, currRow);
                return pawn.verifyTarget(targetCol, targetRow);
            case ROOK:
                Rook rook = new Rook(pieceColor, currCol, currRow);
                return rook.verifyTarget(targetCol, targetRow);
            case KNIGHT:
                Knight knight = new Knight(pieceColor, currCol, currRow);
                return knight.verifyTarget(targetCol, targetRow);
            case BISHOP:
                Bishop bishop = new Bishop(pieceColor, currCol, currRow);
                return bishop.verifyTarget(targetCol, targetRow);
            case QUEEN:
                Queen queen = new Queen(pieceColor, currCol, currRow);
                return queen.verifyTarget(targetCol, targetRow);
            case KING:
                King king = new King(pieceColor, currCol, currRow);
                return king.verifyTarget(targetCol, targetRow);
            default:
                return false;
        }
    }

    public static void Play(){
        //SCANNER AND INTRO OUTSIDE GAME LOOP
        Scanner userIn = new Scanner(System.in);
        System.out.println("Welcome Player 1!");

        //INSTANT OF CHESSBOARDD CLASS CALLED 'NEW GAME' IS INITIALIZED TO VALIDATE INITIAL POSITION
        ChessBoard newGame = new ChessBoard();
        //WHILE LOOP TO KEEP GAME RUNNING UNTIL USER PROMPTS TO STOP
        while(true){
            System.out.println("Please select a chess piece: \n PAWN \n ROOK \n KNIGHT \n BISHOP \n QUEEN \n KING");
            String userPiece = userIn.nextLine();
            System.out.println("Please select a color: \n WHITE \n BLACK");

            // only proceed if/until the user enters valid color
            String pieceColor = "";
            boolean validColor = false;
            while(!validColor){
                pieceColor = userIn.nextLine().trim();
                if(pieceColor.equalsIgnoreCase("WHITE") || pieceColor.equalsIgnoreCase("BLACK")){
                    validColor = true;
                } else {
                    System.out.println("Invalid color. Please enter WHITE or BLACK.");
                }
            }
             //scanner kept getting stuck transitioning from string
            System.out.println("CURRENT COLUMN:");
              System.out.println("\ta");
              System.out.println("\tb");
              System.out.println("\tc");
              System.out.println("\td");
              System.out.println("\te");
              System.out.println("\tf");
              System.out.println("\tg");
              System.out.println("\th");

            char currCol = ' ';
            boolean validCol = false;

            while(!validCol){
                // don't ingore instances where user types "hg", reject and reprompt instead
                String rawCol = userIn.nextLine().trim().toLowerCase();
                // System.out.println("DEBUG: rawCol = [" + rawCol + "], length = " + rawCol.length());

                // single letter, .isValid that letter is w/in bounds
                if(rawCol.length() == 1 && newGame.isValidColumn(rawCol.charAt(0))){
                    currCol = rawCol.charAt(0);
                    validCol = true;
                } else {
                    System.out.println("Invalid column. Please enter a single letter a-h.");
                }
            }
           
            System.out.println("CURRENT ROW: \n \t 1 \n \t 2 \n \t 3 \n \t 4 \n \t 5 \n \t 6 \n \t 7 \n \t 8");
            int currRow = -1;
            boolean validRow = false;
            while(!validRow){
                String rawRow = userIn.nextLine().trim();
                try {
                    currRow = Integer.parseInt(rawRow);
                    validRow = true;
                } catch(NumberFormatException e){
                    System.out.println("Invalid row. Please enter a number.");
                }
            }

            boolean checkInit = newGame.withinChessboard(currCol, currRow);

            //IF INITIAL POSITION IS VALID, PROCEED FOR FINAL POSITION VALIDATION
            if(checkInit){
                //THIS WHILE LOOP IS TO CONTINUE TO VALIDATE NEW FINAL POSITIONS WITHOUT CHANGING INITIAL
                while(checkInit){
                    System.out.println("Your " + pieceColor + " " + userPiece + " is at position " + currCol + " " + currRow + ". \n Please input the target position of your piece. \n FINAL COLUMN :  \n \t a \n \t b \n \t c \n \t d \n \t e \n \t f \n \t g \n \t h ");
    
                    char finCol = ' ';
                    boolean validFinCol = false;
                    // don't ingore instances where user types "hg", reject and reprompt instead
                    while(!validFinCol){
                        String rawFinCol = userIn.nextLine().trim().toLowerCase();
                        if(rawFinCol.length() == 1 && newGame.isValidColumn(rawFinCol.charAt(0))){
                            finCol = rawFinCol.charAt(0);
                            validFinCol = true;
                        } else {
                            System.out.println("Invalid column. Please enter a single letter a-h.");
                        }
                    }

                    System.out.println("FINAL ROW: \n \t 1 \n \t 2 \n \t 3 \n \t 4 \n \t 5 \n \t 6 \n \t 7 \n \t 8");
                    int finRow = -1;
                    boolean validFinRow = false;

                    // scanner kept stalling string to int scan, scan as a string, then try to parse to an int. Plus of verifying input is actually an number
                    while(!validFinRow){
                        String rawFinRow = userIn.nextLine().trim();
                        try {
                            finRow = Integer.parseInt(rawFinRow);
                            validFinRow = true;
                        } catch(NumberFormatException e){
                            System.out.println("Invalid row. Please enter a number.");
                        }
                    } 

                    // target must differ from current position 
                    if(finCol == currCol && finRow == currRow){
                        System.out.println("Target must differ from current position.");
                    } else {
                        // checkFinal now checks board bounds AND the piece's own movement rules
                        boolean checkFinal = newGame.withinChessboard(finCol, finRow)
                                && verifyPieceMove(userPiece, pieceColor, currCol, currRow, finCol, finRow);
                        if(checkFinal){
                            System.out.println("Piece " + userPiece + " in position " + currCol + "" + currRow + " can move to target position " + finCol + "" + finRow);
                        } else {
                            System.out.println("Piece " + userPiece + " in position " + currCol + "" + currRow + " can not move to target position " + finCol + "" + finRow);
                        }
                    }

                    System.out.println("Would you like to try another final position for " + userPiece + "? \n \t YES \n \t NO");
                        String finTry = userIn.nextLine();
                        //IF USER WOULD NOT LIKE TO TRY ANOTHER TARGET POSITION , ASK IF THEY WOULD LIKE TO CHANGE PIECE AND EXIT LOOP BY CHANGING INITIAL POSITION VALIDATION TO FALSE
                        if(!finTry.equalsIgnoreCase("YES")){
                            System.out.println("Would you like to try another piece? \n \t YES \n \t NO");
                            String pieTry = userIn.nextLine();
                            if(!pieTry.equalsIgnoreCase("YES")){
                                System.out.println("Thank you for playing");
                                System.exit(0);
                            }else{
                                checkInit = false;
                            }
                        }
                }
            //IF INITIAL POSITION IS NOT VALID, USER WILL GET CHANCES TO TRY AGAIN
            }else{
                System.out.println("This initial position is invalid, would you like to try again? \n \t -YES \n \t-NO");
                String inTry = userIn.nextLine();
                if (!inTry.equalsIgnoreCase("YES")){
                    System.out.println("Thank you for playing");
                    System.exit(0);
                }
            }
        }


    }
    public static void main(String[] args) {

        Play();

        
    }
    
}