package lk.ijse.dep.service;

public class HumanPlayer extends Player{
   public HumanPlayer(Board board){
        super(board);
    }

    @Override
    public void movePiece(int col) {
        if(board.isLegalMove(col)){
            board.updateMove(col,Piece.BLUE);
            board.getBoardUI().update(col,true);

            if(board.findWinner().getWinningPiece()==null){
               if(board.existLegalMove()){

               }else{
                      board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                      BoardImpl.pieceEmpty();
               }

            }else {
                board.getBoardUI().notifyWinner(board.findWinner());
                BoardImpl.pieceEmpty();
            }

        }
    }
}
