package lottery;

import lottery.domain.Prize;

public class LottoResult {

    private static final String ILLEGAL_MATCHED_COUNT = "당첨 번호와 최대 6개의 숫자까지만 일치할 수 있습니다.";
    private final Prize prize;

    public LottoResult(int matchedCount, boolean isBonusMatched ) {
        this.prize = Prize.getPrize(checkInput(matchedCount), isBonusMatched);
    }

    private int checkInput(int matchedCount) {
        if (matchedCount > 6) {
            throw new IllegalArgumentException(ILLEGAL_MATCHED_COUNT);
        }
        return matchedCount;
    }

    boolean isPrize(Prize queryPrize) {
        return queryPrize.equals(prize);
    }
}
