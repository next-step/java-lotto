package lotto.domain.result;

public class MatchCount {

    private final int MAX_MATCHING_COUNT = 6;
    private final int MIN_MATCHING_COUNT = 0;
    private final int count;

    public MatchCount(int count) {
        countValid(count);
        this.count = count;
    }

    public int value() {
        return count;
    }

    private void countValid(int count) {
        if (count > MAX_MATCHING_COUNT || count < MIN_MATCHING_COUNT) {
            throw new IllegalArgumentException("유효하지 않은 당첨번호 갯수입니다.");
        }
    }
}
