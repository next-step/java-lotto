package lotto.vo;

import lotto.domain.LottoMachine;
import lotto.enums.LottoRank;

import java.util.Arrays;

public class LottoResult {
    private final LottoWinResult lottoWinResult;
    private final long cost;

    public LottoResult(long[] matchCounts) {
        this.lottoWinResult = new LottoWinResult(matchCounts);
        this.cost = extractCost(matchCounts);
    }

    private long extractCost(long[] matchCounts) {
        return LottoMachine.PRICE_OF_LOTTO * extractNumberOfLottos(matchCounts);
    }

    private long extractNumberOfLottos(long[] matchCounts) {
        return Arrays.stream(matchCounts).sum();
    }

    public long getFirst() {
        return lottoWinResult.getFirst();
    }

    public long getSecond() {
        return lottoWinResult.getSecond();
    }

    public long getThird() {
        return lottoWinResult.getThird();
    }

    public long getFourth() {
        return lottoWinResult.getFourth();
    }

    long getCost() {
        return this.cost;
    }

    public long getTotalPrizeMoney() {
        long totalPrizeMoney = 0;

        totalPrizeMoney += (LottoRank.FIRST.getPrizeMoney() * getFirst());
        totalPrizeMoney += (LottoRank.SECOND.getPrizeMoney() * getSecond());
        totalPrizeMoney += (LottoRank.THIRD.getPrizeMoney() * getThird());
        totalPrizeMoney += (LottoRank.FOURTH.getPrizeMoney() * getFourth());

        return totalPrizeMoney;

    }

    public double getTotalProfitRate() {
        return (double) getTotalPrizeMoney() / this.cost;
    }
}
