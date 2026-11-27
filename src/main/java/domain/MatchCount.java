package domain;

import java.util.Objects;

public class MatchCount {

    public static final int MIN = 0;
    public static final int MAX = 6;
    private final int value;

    public MatchCount(int value) {
        validate(value);
        this.value = value;
    }


    public boolean isSame(int value) {
        return this.value == value;
    }

    private void validate(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("일치 개수는 0~6 사이여야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
