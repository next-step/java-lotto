package lotto.domain;

import lotto.domain.exception.NotNumberStringException;

import java.util.Objects;

public class PlayLottoCount {

    private static final int MINIMUM = 0;
    private final int value;

    public PlayLottoCount(int value) {
        validateSize(value);
        this.value = value;
    }

    public PlayLottoCount(String value) {
        this(parseInt(value));
    }

    private static void validateSize(int value) {
        if (value < MINIMUM) {
            throw new IllegalArgumentException(String.format("%s보다 작은 수로 생성할 수 없습니다.", MINIMUM));
        }
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw NotNumberStringException.getInstance();
        }
    }

    public boolean isLessThan(int value) {
        return this.value < value;
    }

    public int subtract(PlayLottoCount playLottoCount) {
        return this.value - playLottoCount.value;
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
}
