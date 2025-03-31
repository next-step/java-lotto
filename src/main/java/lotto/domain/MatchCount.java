package lotto.domain;

/**
 * 로또 번호 일치 개수를 나타내는 객체
 */
public class MatchCount {
    private long value;

    public MatchCount(long value) {
        validate(value);
        this.value = value;
    }

    private void validate(long value) {
        if (value > 6 || value < 0) {
            throw new IllegalArgumentException("로또 번호 일치 개수는 0 이상 6 이하만 가능합니다.");
        }
    }

    public long value() {
        return value;
    }
}
