package pieces;

import board.ChessBoard;
import board.Field;
import java.util.List;

public interface Moveable {

    List<Field> getAvailableMoves(ChessBoard board);
}
