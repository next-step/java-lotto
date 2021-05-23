package lotto.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

public enum Rank {
    FIFTH(3, 5000, lottoReport -> lottoReport.threeMatched()),
    FOURTH(4, 50000, lottoReport -> lottoReport.fourMatched()),
    THIRD(5, 1500000, lottoReport -> lottoReport.fiveMatched()),
    FIRST(6, 2000000000, lottoReport -> lottoReport.sixMatched()),
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
