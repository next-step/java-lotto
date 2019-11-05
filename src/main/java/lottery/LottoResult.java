package lottery;

public class LottoResult {

    private static final String ILLEGAL_MATCHED_COUNT = "당첨 번호와 최대 6개의 숫자까지만 일치할 수 있습니다.";
    private final int matchedCount;

    public LottoResult(int matchedCount) {
        this.matchedCount = checkInput(matchedCount);
    }

    private int checkInput(int matchedCount) {
        if (matchedCount > 6) {
            throw new IllegalArgumentException(ILLEGAL_MATCHED_COUNT);
        }
        return matchedCount;
    }

    public boolean isMatchedNNumbers(int numberOfMatched) {
        return matchedCount == numberOfMatched;
    }
}
