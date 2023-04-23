package calculator.domain;

import java.util.Arrays;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String character;

    OperatorType(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    static OperatorType of(String character) {
        return Arrays.stream(values())
                .filter(v -> character.equals(v.character))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", character)));
    }
}
