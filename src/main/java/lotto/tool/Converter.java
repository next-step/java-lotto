package lotto.tool;

import lotto.exceptions.InvalidNumberException;

public final class Converter {

    private Converter() {
    }

    public static int toInteger(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

}
