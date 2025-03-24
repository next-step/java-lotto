package lotto;

import java.util.Objects;

public class MatchCount {
    public static final String INVALID_COUNT_EXCEPTION_MESSAGE = "당첨 번호는 0 이상 6 이하만 가능합니다.";
    private final int count;

    public MatchCount(int count) {
        this.validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < 0 || count > 6) {
            throw new IllegalArgumentException(INVALID_COUNT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MatchCount that = (MatchCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
