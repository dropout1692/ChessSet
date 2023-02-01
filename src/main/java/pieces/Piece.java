package pieces;

import board.ChessBoard;
import constants.Color;
import constants.LetterMap;
import lombok.Data;

@Data
public abstract class Piece implements Moveable {

    private String name;
    private int posX;
    private int posY;
    private Color color;

    public String getCurrentFieldName() {
        return String.format("%s%s",
            LetterMap.getForInt(posX),
            posY + 1
        );
    }

    public void moveTo(ChessBoard board, String fieldName) {

        String[] fieldSplit = fieldName.split("");
        int x = LetterMap.getByString(fieldSplit[0]);
        int y = Integer.parseInt(fieldSplit[1]) - 1;

        moveTo(board, x, y);
    }

    public void moveTo(ChessBoard board, int x, int y) {

        board.setField(this.getCurrentFieldName(), null);
        this.setPosX(x);
        this.setPosY(y);

        if (board.getField(this.getCurrentFieldName()).getPiece() != null) {
            board.removePiece(this.getCurrentFieldName());
        }

        board.setField(this.getCurrentFieldName(), this);
    }
}
