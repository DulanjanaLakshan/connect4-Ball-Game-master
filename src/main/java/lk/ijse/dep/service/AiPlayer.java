package lk.ijse.dep.service;



import java.util.Random;

public class AiPlayer extends Player{


    public AiPlayer(Board board){
        super(board);
    }

    @Override
    public void movePiece(int col) {
        col=getBestValue()[1];

    if (board.isLegalMove(col)) {

       board.updateMove(getBestValue()[0],col, Piece.GREEN);
        board.getBoardUI().update(col, false);
        if (board.findWinner().getWinningPiece()==null) {
            if (board.existLegalMove()) {
            } else {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                BoardImpl.pieceEmpty();
            }
        } else {
            board.getBoardUI().notifyWinner(board.findWinner());
            BoardImpl.pieceEmpty();
        }

    }


    }public  int minimax(int depth,boolean isMaxPlayer){
            int boardVal=evaluateBoard(depth);
            if( boardVal!=0 || depth==2){
                return boardVal;
            }

            if(isMaxPlayer){
                int min=Integer.MIN_VALUE;
                int field=0;

                for (int i = 0; i < board.getPieces().length; i++) {
                    for (int j = 0; j < BoardImpl.pieces[i].length; j++) {
                    if(BoardImpl.pieces[i][j].equals(Piece.EMPTY)){
                            BoardImpl.pieces[i][j]=Piece.GREEN;
                        field=minimax(depth + 1,false);
                            BoardImpl.pieces[i][j]=Piece.EMPTY;
                        min=Math.max(field,min);
                        }
                    }

                }
                return min;

            }else {
                int max=Integer.MAX_VALUE;
                int field=0;
                for (int i = 0; i < BoardImpl.pieces.length; i++) {
                    for (int j = 0; j <BoardImpl.pieces[i].length; j++) {
                        if(BoardImpl.pieces[i][j].equals(Piece.EMPTY)){
                            BoardImpl.pieces[i][j]=Piece.BLUE;
                            System.out.println("\t\t\t\tBLUE COL :"+j);
                            field=minimax(depth + 1,true);
                            BoardImpl.pieces[i][j]=Piece.EMPTY;
                            max=Math.min(field,max);
                        }
                    }
                }
                return max;

            }


    }public int evaluateBoard(int depth){
        if(board.findWinner().getWinningPiece()==null){
            return 0;
        } else if (board.findWinner().getWinningPiece().equals(Piece.BLUE)) {
            System.out.println("\t\tBlue -10 win");
            return -10;

        }else if (board.findWinner().getWinningPiece().equals(Piece.GREEN)){
            return 10;
        }

        return 0;
    }public int [] getBestValue(){
        int min=Integer.MIN_VALUE;
        int field=0;
        int ar[]={0,0};
        for (int i = 0; i < board.getPieces().length; i++) {
            for (int j = 0; j < BoardImpl.pieces[i].length; j++) {
                if(BoardImpl.pieces[i][j].equals(Piece.EMPTY)){
               BoardImpl.pieces[i][j]=Piece.GREEN;
                    field=minimax( 0,false);
               BoardImpl.pieces[i][j]=Piece.EMPTY;
                   if(field>min){
                       ar[0]=i;
                       ar[1]=j;
                       min=field;
                   }
                }
                }


            }

return ar;
    }

}
















