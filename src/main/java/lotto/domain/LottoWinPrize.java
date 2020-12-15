package lotto.domain;

import java.util.Arrays;

public enum LottoWinPrize {

    MATCH_3(3, 5000)
    , MATCH_4(4, 50000)
    , MATCH_5(5, 1500000)
    , MATCH_6(6, 2000000000)
    ;

    private final int matchedCount;
    private final long prize;
    private int count = 0;

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

    public int getCount() {
        return count;
    }

    private void addCount() {
        this.count++;
    }

    public static void addCount(int inputMatchedCount) {
        Arrays.stream(LottoWinPrize.values())
                .filter(lottoWinPrize -> lottoWinPrize.getMatchedCount() == inputMatchedCount)
                .forEach(LottoWinPrize::addCount);
    }
}
