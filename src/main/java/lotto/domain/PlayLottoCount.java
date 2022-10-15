package lotto.domain;

import java.util.Objects;

public class PlayLottoCount {

    private final int value;

    public PlayLottoCount(int value) {
        validateSize(value);
        this.value = value;
    }

    private static void validateSize(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1보다 작은 수로 생성할 수 없습니다.");
        }
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

    public int getValue() {
        return value;
    }
}
