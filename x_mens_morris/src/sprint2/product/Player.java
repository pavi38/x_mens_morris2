package sprint2.product;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Player {
    private char color;
    private Deque<GamePiece> gamePieces = new ArrayDeque<>();
    private List<GamePiece> boradPieces = new ArrayList<>();

    public Player(char color, int pieces) {
        this.color = color;
        for (int i = 1; i <= pieces; i++) {
            this.gamePieces.push(new GamePiece(i, color));
        }
    }

    public int numberOfGamePieces() {
        return gamePieces.size();
    }

    public int totalNumberOfPieces() {
        return boradPieces.size()+gamePieces.size();
    }

    public void getGamePiece(int row, int col) {
        GamePiece gamePiece;
        if (gamePieces.peek()!=null){
            gamePiece = gamePieces.poll();
            gamePiece.setLocation(row, col);
            boradPieces.add(gamePiece);
        }
    }

    public char getColor() {
        return color;
    }

    public Deque<GamePiece> getGamePieces() {
        return gamePieces;
    }

    public List<GamePiece> getBoradPieces() {
        return boradPieces;
    }

    public void setBoradPieces(List<GamePiece> boradPieces) {
        this.boradPieces = boradPieces;
    }

    public int numberOfBoradPieces() {return boradPieces.size();}

    public void setGamePiecesForFlying(){
        while(this.numberOfGamePieces()>3){
            gamePieces.pop();
        }
    }

    public void removeBoradPiece(int row, int col) {
        for (GamePiece gamePiece : boradPieces) {
            if(gamePiece.getPieceByLocation(row, col)){
                boradPieces.remove(gamePiece);
            }
        }
    }

}
