package lotto;

import java.util.List;

public class LottoReport {
    public final int METRIC_COUNT_THREE = 3;
    public final int METRIC_COUNT_FOUR = 4;
    public final int METRIC_COUNT_FIVE = 5;
    public final int METRIC_COUNT_SIX = 6;
    private int threeMatched;
    private int fourMatched;
    private int fiveMatched;
    private int sixMatched;

    public LottoReport(Lotto winners, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            updateMatchedNumberMetrics(winners, lotto);
        }
    }

    private void updateMatchedNumberMetrics(Lotto winners, Lotto test) {
        int matched = test.matchCountWith(winners);
        if (matched == METRIC_COUNT_THREE) {
            threeMatched++;
        }
        if (matched == METRIC_COUNT_FOUR) {
            fourMatched++;
        }
        if (matched == METRIC_COUNT_FIVE) {
            fiveMatched++;
        }
        if (matched == METRIC_COUNT_SIX) {
            sixMatched++;
        }
    }
    public int threeMatched(){
        return threeMatched;
    }
    public int fourMatched(){
        return fourMatched;
    }
    public int fiveMatched(){
        return fiveMatched;
    }
    public int sixMatched(){
        return sixMatched;
    }

}
