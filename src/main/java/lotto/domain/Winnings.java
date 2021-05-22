package lotto.domain;

import java.util.function.Function;

public enum Winnings {
    FIRST(6, 2000000000, lottoReport -> lottoReport.sixMatched()),
    THIRD(5, 1500000, lottoReport -> lottoReport.fiveMatched()),
    FOURTH(4, 50000, lottoReport -> lottoReport.fourMatched()),
    FIFTH(3, 5000, lottoReport -> lottoReport.threeMatched()),
    ;
    public int matched;
    public int winnings;
    Function<LottoReport, Integer> lottoReportMatchedNumGetter;

    Winnings(int matched, int winnings, Function<LottoReport, Integer> lottoReportMatchedNumGetter) {
        this.matched = matched;
        this.winnings = winnings;
        this.lottoReportMatchedNumGetter = lottoReportMatchedNumGetter;
    }

    public void ifMatchedThan(int matched, Runnable runnable) {
        if(this.matched == matched){
            runnable.run();
        }
    }

}
