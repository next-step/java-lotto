package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000),
    ;
    public int countOfMatch;
    public int winnings;
    Function<LottoReport, Integer> lottoReportMatchedNumGetter;

    Rank(int countOfMatch, int winnings, Function<LottoReport, Integer> lottoReportMatchedNumGetter) {
        this.countOfMatch = countOfMatch;
        this.winnings = winnings;
        this.lottoReportMatchedNumGetter = lottoReportMatchedNumGetter;
    }

    public void ifMatchedThan(int matched, Runnable runnable) {
        if(this.countOfMatch == matched){
            runnable.run();
        }
    }
    public static Optional<Rank> valueOf(int matchedCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatched(matchedCount))
                .findFirst();
    }

    private boolean isMatched(int matchedCount) {
        return this.countOfMatch == matchedCount;
    }

}
