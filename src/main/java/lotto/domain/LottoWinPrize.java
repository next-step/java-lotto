package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinPrize {

    MATCH_3(3, 5000, "3개 일치")
    , MATCH_4(4, 50000, "4개 일치")
    , MATCH_5(5, 1500000, "5개 일치")
    , MATCH_5_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치")
    , MATCH_6(6, 2000000000, "6개 일치")
    ;

    private static final int MATCHED_COUNT_DUPLICATE_CASE_NUMBER = 5;
    private final int matchedCount;
    private final long prize;
    private final String description;

    LottoWinPrize(int matchedCount, long prize, String description) {
        this.matchedCount = matchedCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchedCount() {
        return this.matchedCount;
    }

    public long getPrize() {
        return this.prize;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * 주어진 당첨번호와 일치하는 수와 보너스점수 일치 여부로 알맞는 LottoWinPrize를 리턴합니다.
     * @param matchedCount
     * @param matchBonusNumber
     * @return
     */
    public static Optional<LottoWinPrize> getLottoWinPrize(int matchedCount, boolean matchBonusNumber) {
        return Arrays.stream(LottoWinPrize.values())
                .filter(lottoWinPrize -> lottoWinPrize.getMatchedCount() == matchedCount)
                .reduce((lottoWinPrize, lottoWinPrize2) -> {
                    return !matchBonusNumber ? lottoWinPrize : lottoWinPrize2;
                });
    }
}
