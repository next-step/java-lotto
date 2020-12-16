package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoWinPrize {

    MATCH_3(3, 5000)
    , MATCH_4(4, 50000)
    , MATCH_5(5, 1500000)
    , MATCH_6(6, 2000000000)
    ;

    private final int matchedCount;
    private final long prize;

    LottoWinPrize(int matchedCount, long prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Optional<LottoWinPrize> getLottoWinPrize(int matchedCount) {
        return Arrays.stream(LottoWinPrize.values())
                .filter(lottoWinPrize -> lottoWinPrize.getMatchedCount() == matchedCount)
                .findFirst();
    }
}
