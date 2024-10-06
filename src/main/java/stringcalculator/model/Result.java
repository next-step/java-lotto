package stringcalculator.model;

import java.util.Objects;

public class Result {
    public static final String ONLY_ALLOWED_NUMBER = "결과에 숫자 이외에 다른 문자가 올 수 없습니다.";
    private final int value;

    public Result(String number) {
        this.value = parseInt(number);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_ALLOWED_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return value == result.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
