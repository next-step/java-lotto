package lotto.domain.dto;

import lotto.domain.Ranks;
import lotto.domain.enums.Rank;

public class RanksDto {

    private final int prizeOfFirst = Rank.FIRST.getPrize();
    private final int prizeOfSecond = Rank.SECOND.getPrize();
    private final int prizeOfThird = Rank.THIRD.getPrize();
    private final int prizeOfFourth = Rank.FOURTH.getPrize();
    private final int countOfFirst;
    private final int countOfSecond;
    private final int countOfThird;
    private final int countOfFourth;
    private final double rateOfProfit;

    public RanksDto(Ranks ranks) {
        countOfFirst = ranks.countRankOf(Rank.FIRST);
        countOfSecond = ranks.countRankOf(Rank.SECOND);
        countOfThird = ranks.countRankOf(Rank.THIRD);
        countOfFourth = ranks.countRankOf(Rank.FOURTH);
        rateOfProfit = ranks.calculateRateOfProfit();
    }

    public int getPrizeOfFirst() {
        return prizeOfFirst;
    }

    public int getPrizeOfSecond() {
        return prizeOfSecond;
    }

    public int getPrizeOfThird() {
        return prizeOfThird;
    }

    public int getPrizeOfFourth() {
        return prizeOfFourth;
    }

    public int getCountOfFirst() {
        return countOfFirst;
    }

    public int getCountOfSecond() {
        return countOfSecond;
    }

    public int getCountOfThird() {
        return countOfThird;
    }

    public int getCountOfFourth() {
        return countOfFourth;
    }

    public double getRateOfProfit() {
        return rateOfProfit;
    }

}
