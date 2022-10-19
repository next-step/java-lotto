package lotto.domain;

import lotto.domain.exception.NotNumberStringException;

import java.util.Objects;

public class PlayLottoCount {

    private final int value;

    public PlayLottoCount(int value) {
        validateSize(value);
        this.value = value;
    }

    public PlayLottoCount(String value) {
        this(parseInt(value));
    }

    private static void validateSize(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1보다 작은 수로 생성할 수 없습니다.");
        }
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayLottoCount that = (PlayLottoCount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "PlayLottoCount{" +
                "value=" + value +
                '}';
    }

    public boolean isLessThan(int value) {
        return this.value < value;
    }
}
