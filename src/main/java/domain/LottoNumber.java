package domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private final int value;


    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public LottoNumber(String value) {
        this(parse(value));
    }

    private void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("1부터 45까지의 로또만 생성이 가능하다.");
        }
    }

    private static int parse(String value) {
        String trimmed = value.trim();
        if (trimmed.isEmpty() || !trimmed.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
        return Integer.parseInt(trimmed);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public int getValue() {
        return value;
    }
}
