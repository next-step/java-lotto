package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum LottoResult {

    FOURTH(3, 5_000),
    THIRD(4, 50_000),
    SECOND(5, 1_500_000),
    FIRST(6, 2_000_000_000);



    private final int matchCount;
    private final int winningPrice;


    LottoResult(int matchCount, int winningPrice) {
        this.matchCount = matchCount;
        this.winningPrice = winningPrice;
    }

    public static Optional<LottoResult> findByMatchCount(int matchCount) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> matchCount == lottoResult.matchCount)
                .findAny();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningPrice() {
        return winningPrice;
    }
}
