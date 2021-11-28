package lotto.domain.dto;

import lotto.domain.Ranks;
import lotto.domain.enums.Rank;

public class RanksDto {

    private final int matchCountOfFirst = Rank.FIRST.getMatchCount();
    private final int matchCountOfSecond = Rank.SECOND.getMatchCount();
    private final int matchCountOfThird = Rank.THIRD.getMatchCount();
    private final int matchCountOfFourth = Rank.FOURTH.getMatchCount();
    private final int matchCountOfFifth = Rank.FIFTH.getMatchCount();
    private final int prizeOfFirst = Rank.FIRST.getPrize();
    private final int prizeOfSecond = Rank.SECOND.getPrize();
    private final int prizeOfThird = Rank.THIRD.getPrize();
    private final int prizeOfFourth = Rank.FOURTH.getPrize();
    private final int prizeOfFifth = Rank.FIFTH.getPrize();
    private final int countOfFirst;
    private final int countOfSecond;
    private final int countOfThird;
    private final int countOfFourth;
    private final int countOfFifth;
    private final double rateOfProfit;

    public RanksDto(Ranks ranks) {
        countOfFirst = ranks.countRankOf(Rank.FIRST);
        countOfSecond = ranks.countRankOf(Rank.SECOND);
        countOfThird = ranks.countRankOf(Rank.THIRD);
        countOfFourth = ranks.countRankOf(Rank.FOURTH);
        countOfFifth = ranks.countRankOf(Rank.FIFTH);
        rateOfProfit = ranks.calculateRateOfProfit();
    }

    public int getMatchCountOfFirst() {
        return matchCountOfFirst;
    }

    public int getMatchCountOfSecond() {
        return matchCountOfSecond;
    }

    public int getMatchCountOfThird() {
        return matchCountOfThird;
    }

    public int getMatchCountOfFourth() {
        return matchCountOfFourth;
    }

    public int getMatchCountOfFifth() {
        return matchCountOfFifth;
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

    public int getPrizeOfFifth() {
        return prizeOfFifth;
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

    public int getCountOfFifth() {
        return countOfFifth;
    }

    public double getRateOfProfit() {
        return rateOfProfit;
    }

}
