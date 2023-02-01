package pieces.specific;

import board.ChessBoard;
import board.Field;
import constants.Color;
import constants.LetterMap;
import java.util.List;
import lombok.NoArgsConstructor;
import pieces.Piece;

@NoArgsConstructor
public class Pawn extends Piece {

    public Pawn(Color color, String field) {
        this.setName("Pawn");
        this.setColor(color);
        String[] fieldSplit = field.split("");
        this.setPosX(LetterMap.getByString(fieldSplit[0]));
        this.setPosY(Integer.parseInt(fieldSplit[1]) - 1);
    }

    @Override
    public List<Field> getAvailableMoves(ChessBoard board) {
        return null;
    }
}
