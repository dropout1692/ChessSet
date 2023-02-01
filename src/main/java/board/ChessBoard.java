package board;

import constants.Color;
import constants.LetterMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import pieces.Piece;
import pieces.specific.Bishop;
import pieces.specific.King;
import pieces.specific.Knight;
import pieces.specific.Pawn;
import pieces.specific.Queen;
import pieces.specific.Rook;

public class ChessBoard {

    private Map<String, Field> fieldMap;
    private List<Piece> whiteCaptures;
    private List<Piece> blackCaptures;

    public ChessBoard() {
        this.whiteCaptures = new ArrayList<>();
        this.blackCaptures = new ArrayList<>();
        this.fieldMap = initializeFields();
    }

    public Field getField(String fieldName) {
        return fieldMap.get(fieldName);
    }

    public Field getField(final int posX, final int posY) {
        return fieldMap.values().stream()
            .filter(f -> f.getPosX() == posX && f.getPosY() == posY)
            .findFirst()
            .orElse(null);
    }

    public void setField(String fieldName, Piece piece) {
        fieldMap.get(fieldName).setPiece(piece);
    }

    public void removePiece(String fieldName) {
        Field field = fieldMap.get(fieldName);
        Piece piece = field.getPiece();
        if (piece != null) {
            if (piece.getColor().equals(Color.WHITE)) {
                blackCaptures.add(piece);
            } else {
                whiteCaptures.add(piece);
            }
            field.setPiece(null);
        }
    }

    public void defaultPieceSetup() {

        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(new Rook(Color.WHITE, "A1"));
        whitePieces.add(new Knight(Color.WHITE, "B1"));
        whitePieces.add(new Bishop(Color.WHITE, "C1"));
        whitePieces.add(new Queen(Color.WHITE, "D1"));
        whitePieces.add(new King(Color.WHITE, "E1"));
        whitePieces.add(new Bishop(Color.WHITE, "F1"));
        whitePieces.add(new Knight(Color.WHITE, "G1"));
        whitePieces.add(new Rook(Color.WHITE, "H1"));
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(Color.WHITE, String.format("%s2",
                LetterMap.getForInt(i)
            )));
        }
        whitePieces.forEach(p -> {
            p.moveTo(this, p.getCurrentFieldName());
        });

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(new Rook(Color.BLACK, "A8"));
        blackPieces.add(new Knight(Color.BLACK, "B8"));
        blackPieces.add(new Bishop(Color.BLACK, "C8"));
        blackPieces.add(new Queen(Color.BLACK, "D8"));
        blackPieces.add(new King(Color.BLACK, "E8"));
        blackPieces.add(new Bishop(Color.BLACK, "F8"));
        blackPieces.add(new Knight(Color.BLACK, "G8"));
        blackPieces.add(new Rook(Color.BLACK, "H8"));
        for (int i = 0; i < 8; i++) {
            blackPieces.add(new Pawn(Color.BLACK, String.format("%s7",
                LetterMap.getForInt(i)
            )));
        }
        blackPieces.forEach(p -> {
            p.moveTo(this, p.getCurrentFieldName());
        });
    }

    private Map<String, Field> initializeFields() {

        Map<String, Field> fieldMap = new LinkedHashMap<>();
        IntStream.rangeClosed(0, 63)
            .forEach(i -> {
                int posY = i / 8;
                int posX = (i % 8);
                Color color = (i % 2 == 0) ? Color.BLACK : Color.WHITE;
                String name = String.format("%s%s",
                    LetterMap.getForInt(posX).toUpperCase(),
                    posY + 1
                );
                Field field = new Field(
                    name,
                    posX,
                    posY,
                    color
                );
                fieldMap.put(name, field);
            });

        return fieldMap;
    }
}
