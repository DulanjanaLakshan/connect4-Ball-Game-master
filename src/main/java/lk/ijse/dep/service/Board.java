package lk.ijse.dep.service;

public interface Board  {
    static int NUM_OF_ROWS=5;
    static int NUM_OF_COLS=6;
    BoardUI getBoardUI();
    int findNextAvailableSpot(int col);
    boolean isLegalMove(int col);
    boolean existLegalMove();
   void updateMove(int col,Piece move);
   void updateMove(int row,int col,Piece move);
   Winner findWinner();
    Piece[][] getPieces();
   void setPieces(Piece[][] pieces);
}
