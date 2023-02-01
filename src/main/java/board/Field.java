package board;

import constants.Color;
import lombok.Getter;
import lombok.Setter;
import pieces.Piece;

@Getter
public class Field {

    private final String name;
    private final int posX;
    private final int posY;
    private final Color backgroundColor;

    public Field(String name, int posX, int posY, Color backgroundColor) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.backgroundColor = backgroundColor;
    }

    @Setter private Piece piece;
}
