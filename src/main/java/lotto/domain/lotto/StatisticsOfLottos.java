package lotto.domain.lotto;

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

    public int numberOfMatchCount(int matchCount) {
        return resultOfLottos.numberOfMatchCount(matchCount);
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }
}
