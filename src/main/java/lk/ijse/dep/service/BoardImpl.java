package lk.ijse.dep.service;

public class BoardImpl  implements Board{

   static Piece[][] pieces =new Piece[NUM_OF_ROWS][NUM_OF_COLS]; // main form ------------>>>

   static  {
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }
    BoardUI boardUI;

    public BoardImpl(BoardUI boardUI) {

        this.boardUI = boardUI;
    }
    public BoardUI getBoardUI(){
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

        for (int i = 0; i < getPieces().length; i++) {
            if (getPieces()[i][col].equals(Piece.EMPTY)) return i;
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        if(findNextAvailableSpot(col) !=-1)return true;
        return false;
    }

    @Override
    public boolean existLegalMove() {
        for (int i = 0; i < getPieces().length; i++) {
            for (int j = 0; j < getPieces()[i].length; j++) {
                if (getPieces()[i][j].equals(Piece.EMPTY)) return true;
            }
        }
            return false;
    }


    public Winner findWinner() {
        int col1=0;
        int col2=0;
        int row1=0;
        int row2=0;
        for (int i = 0; i < getPieces().length; i++) {
            int count=0;
            for (int j = 0; j < getPieces()[i].length; j++) { // horizontal GREEN
                if(getPieces()[i][j].equals(Piece.GREEN)){
                    count++;
                    if(count==4){
                        col1=j-3;
                        row1=i;
                        col2=j;
                        row2=i;

                        return new Winner(col1,col2,row1,row2,Piece.GREEN);
                    }
                }else{
                    count=0;
                }
            }
        }
        for (int i = 0; i < getPieces().length; i++) {
            int count=0;
            for (int j = 0; j < getPieces()[i].length; j++) { // horizontal BLUE
                if(getPieces()[i][j].equals(Piece.BLUE)){
                    count++;
                    if(count==4){
                        col1=j-3;
                        row1=i;
                        col2=j;
                        row2=i;
                        return new Winner(col1,col2,row1,row2,Piece.BLUE);
                    }
                }else{
                    count=0;
                }
            }
        }
        for (int i = 0; i < getPieces()[0].length; i++) {  // vertical GREEN
            int count=0;
            for (int j = 0; j < getPieces().length; j++) {
                if(getPieces()[j][i].equals(Piece.GREEN)){
                    count++;
                    if(count==1){
                        col1=i;
                        col2=i;
                        row1=j;
                    }
                    if(count==4){
                        row2=j;
                        return new Winner(col1,col2,row1,row2,Piece.GREEN);
                    }
                }else{
                    count=0;
                }
            }
        }
        for (int i = 0; i < getPieces()[0].length; i++) { // vertical BLUE
            int count=0;
            for (int j = 0; j < getPieces().length; j++) {
                if(getPieces()[j][i].equals(Piece.BLUE)){
                    count++;
                    if(count==1){
                        col1=i;
                        col2=i;
                        row1=j;
                    }
                    if(count==4){
                        row2=j;

                        return new Winner(col1,col2,row1,row2,Piece.BLUE);

                    }
                }else{
                    count=0;
                }
            }
        }
     /*   for (int i = 0; i < getPieces()[0].length-2; i++) { // vertical BLUE
            int count=0;
            int index=i;

            for (int j = 0; j < getPieces().length; j++) {
                if(i+index > getPieces().length)break;
                if(getPieces()[j][i+index].equals(Piece.BLUE)){
                    index++;
                    count++;
                    if(count==1){
                        col1=i;
                        col2=i;
                        row1=j;
                    }
                    if(count==4){
                        row2=j;

                        return new Winner(col1,col2,row1,row2,Piece.BLUE);

                    }
                }else{
                    count=0;
                }

            }
        }
*/

        return new Winner(null);

    }

    @Override
    public void updateMove(int col, Piece move) {
       getPieces()[findNextAvailableSpot(col)][col]=move;

    }

    @Override
    public void updateMove(int row, int col, Piece move) {
         getPieces()[row][col]=move;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    } public static void pieceEmpty(){
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                pieces[i][j]=Piece.EMPTY;
            }
        }
    }
}

