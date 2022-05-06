package calculator.model;

import java.util.regex.Pattern;

public class Number {
    private static final String NUMBER_REGEX = "^\\+d+$";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);
    private static final String INVALID_NUMBER_CHARACTER = "잘못된 숫자입니다. 입력받은 숫자 : %s";
    private static final String NULL_OR_EMPTY_NUMBER_CHARACTER = "숫자가 비어있습니다.";

    private final int number;

    public Number(String numberCharacter) {
        validate(numberCharacter);
        this.number = toNumber(numberCharacter);
    }

    public Number(int number) {
        this.number = number;
    }

    private void validate(String numberCharacter) {
        if (isNullOrEmpty(numberCharacter)) {
            throw new IllegalStateException(NULL_OR_EMPTY_NUMBER_CHARACTER);
        }

        if (isNotNumber(numberCharacter)) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_CHARACTER, numberCharacter));
        }
    }

    private boolean isNullOrEmpty(String numberCharacter) {
        return numberCharacter == null || numberCharacter.isEmpty();
    }

    private boolean isNotNumber(String numberCharacter) {
        return NUMBER_PATTERN.matcher(numberCharacter).matches();
    }

    private int toNumber(String numberCharacter) {
        return Integer.parseInt(numberCharacter);
    }

    public int getNumber() {
        return number;
    }
}
