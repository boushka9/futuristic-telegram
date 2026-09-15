import java.util.Scanner;

public class ChessGame {

//This program verifies whether a given chess piece at a location 
//specified by the user can move to another location specified by the user. 

//The user should be allowed to select a piece and set its initial position, 
//then set the target position. 

//The system lets the user know if the target position is valid or invalid. 
//The user shall be prompted to verify another target position using the same 
//original position. The user shall also be prompted to select a different piece (start again).

    public static void ChessGame(){
        //SCANNER AND INTRO OUTSIDE GAME LOOP
        Scanner userIn = new Scanner(System.in);
        System.out.println("Welcome Player 1!");
        //WHILE LOOP TO KEEP GAME RUNNING UNTIL USER PROMPTS TO STOP
        while(true){
            System.out.println("Please select a chess peice: \n PAWN \n ROOK \n KNIGHT \n BISHOP \n QUEEN \n KING");
            String userPiece = userIn.nextLine();
            System.out.println("Please select a color: \n WHITE \n BLACK");
            String pieceColor = userIn.nextLine();
            System.out.println("You have chosen the " + pieceColor + " " + userPiece + " as your peice. \n Please input the initial position of your peice. \n CURRENT COLUMN: \n \t a \n \t b \n \t c \n \t d \n \t e \n \t f \n \t g \n \t h");
            // 4 ERRORS FOUND WHEN COMPILING FOR THESE CHAR AND INT DATATYPES THAT I TRIED TO MATCH FROM THE CLASSES
            char currCol = userIn.nextLine(); //some kind of type error, i think add userIn.nextChar();
            System.out.println("CURRENT ROW: \n \t 1 \n \t 2 \n \t 3 \n \t 4 \n \t 5 \n \t 6 \n \t 7 \n \t 8");
            int currRow = userIn.nextLine(); // userIn.nextInt()
            //INSTANT OF CHESSBOARDD CLASS CALLED 'NEW GAME' IS INITIALIZED TO VALIDATE INITIAL POSITION
            ChessBoard newGame = new ChessBoard();
            boolean checkInit = newGame.withinChessboard(currCol, currRow);
            //IF INITIAL POSITION IS VALID, PROCEED FOR FINAL POSITION VALIDATION
            if(checkInit){
                //THIS WHILE LOOP IS TO CONTINUE TO VALIDATE NEW FINAL POSITIONS WITHOUT CHANGING INITIAL
                while(checkInit){
                    System.out.println("Your " + pieceColor + " " + userPiece + "is at position " + currCol + " " + currRow + ". \n Please input the target position of your peice. \n FINAL COLUMN :  \n \t a \n \t b \n \t c \n \t d \n \t e \n \t f \n \t g \n \t h ");
                    char finCol = userIn.nextLine();
                    System.out.println("FINAL ROW: \n \t 1 \n \t 2 \n \t 3 \n \t 4 \n \t 5 \n \t 6 \n \t 7 \n \t 8");
                    int finRow = userIn.nextLine();
                    boolean checkFinal = newGame.withinChessboard(finCol, finRow);
                        System.out.println("This target position is valid! \n Would you like to try another final position? \n \t YES \n \t NO");
                        String finTry = userIn.nextLine();
                        //IF USER WOULD NOT LIKE TO TRY ANOTHER TARGET POSITION , ASK IF THEY WOULD LIKE TO CHANGE PIECE AND EXIT LOOP BY CHANGING INITIAL POSITION VALIDATION TO FALSE
                        if(finTry != "YES"){
                            System.out.println("Would you like to try another peice? \n \t YES \n \t NO");
                            String pieTry = userIn.nextLine();
                            if(pieTry != "YES"){
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
                if (inTry != "YES"){
                    System.out.println("Thank you for playing");
                    System.exit(0);
                }
            }
        }


    }
    public static void main(String[] args) {

        ChessGame();

        
    }
    
}
