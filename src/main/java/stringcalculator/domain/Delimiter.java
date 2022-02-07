package stringcalculator.domain;

import java.util.Objects;

public class Delimiter {

    private final String STARTSWITH_ENDSWITH_IS_NUMBER_EXCEPTION_MESSAGE = "구분자의 시작과 끝은 숫자일 수 없습니다.";

    private final String value;

    public Delimiter(String value) {
        validateIsNumber(value);
        this.value = value;
    }

    private void validateIsNumber(String delimiter) {
        if (validateFirstIsNumber(delimiter) || validateLastIsNumber(delimiter)) {
            throw new IllegalArgumentException(STARTSWITH_ENDSWITH_IS_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    private boolean validateFirstIsNumber(String delimiter) {
        return Character.isDigit(delimiter.charAt(0));
    }

    private boolean validateLastIsNumber(String delimiter) {
        return Character.isDigit(delimiter.charAt(delimiter.length() - 1));
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Delimiter delimiter1 = (Delimiter) o;
        return Objects.equals(value, delimiter1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
