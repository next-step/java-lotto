package lotto.domain.lotto;

import lotto.domain.Rank;

public class StatisticsOfLottos {
    private final ResultOfLottos resultOfLottos;
    private final double rateOfReturn;

    private StatisticsOfLottos(ResultOfLottos resultOfLottos, double rateOfReturn) {
        this.resultOfLottos = resultOfLottos;
        this.rateOfReturn = rateOfReturn;
    }

    public static StatisticsOfLottos newLottoResult(ResultOfLottos resultOfLottos, double rateOfReturn) {
        return new StatisticsOfLottos(resultOfLottos, rateOfReturn);
    }

    public int numberOfMatchCount(Rank rank) {
        return resultOfLottos.numberOfMatchCount(rank);
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }
}
