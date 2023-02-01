package constants;

import java.util.List;

public class LetterMap {

    private static final List<String> LETTERS = List.of(
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h"
    );

    public static String getForInt(int n) {
        return LETTERS.get(n).toUpperCase();
    }

    public static int getByString(String letter) {
        return LETTERS.indexOf(letter.toLowerCase());
    }
}
