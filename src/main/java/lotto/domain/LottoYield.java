package lotto.domain;

import java.util.List;

public class LottoYield {
    private static final String STRING_PROFIT = "이익";
    private static final String STRING_LOSS = "손해";
    private static final int DEFAULT_LOTTO_YIELD = 1;

    private final double yield;

    public LottoYield(double yield) {
        this.yield = yield;
    }

    public LottoYield(List<LottoRank> lottoRanks, int buyAmount) {
        this.yield = operationYield(lottoRanks, buyAmount);
    }

    public double yield() {
        return yield;
    }

    public String stringYield() {
        if (yield >= DEFAULT_LOTTO_YIELD) {
            return STRING_PROFIT;
        }

        return STRING_LOSS;
    }

    private double operationYield(List<LottoRank> readOnlyLottoLottoRanks, int buyAmount) {
        double sumPrize = operationPrizeSum(readOnlyLottoLottoRanks);

        return sumPrize / buyAmount;
    }

    private double operationPrizeSum(List<LottoRank> readOnlyLottoLottoRanks) {
        return readOnlyLottoLottoRanks.stream()
                .mapToInt(lottoRank -> lottoRank.rankPrizeSum())
                .sum();
    }

    public boolean checkYield(double yield) {
        return this.yield == yield;
    }

}
