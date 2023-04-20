package domain;

import java.util.Arrays;

public enum Operand {

    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String separator;

    Operand(String separator) {
        this.separator = separator;
    }

    public static Operand lookUp(String separator) {

        return Arrays.stream(Operand.values())
                .filter(operand -> operand.separator.equals(separator))
                .findFirst()
                .get();
    }


    public String getSeparator() {
        return separator;
    }
}
