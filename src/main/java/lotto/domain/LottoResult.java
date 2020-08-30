package lotto.domain;

import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoGame.DEFAULT_LOTTO_PRICE;

public class LottoResult {
    private static final Integer INTEGER_ZERO = 0;
    private final List<Rank> matchRanks;

    public LottoResult(List<Rank> ranks) {
        this.matchRanks = ranks;
    }

    public static LottoResult of(List<Rank> ranks) {
        return new LottoResult(ranks);
    }

    public List<Rank> getMatchRanks() {
        return matchRanks;
    }

    public int countOfMathRanks(Rank rank) {
        return (int) matchRanks.stream()
                .filter(rank::equals)
                .count();
    }

    public int totalPrizeOfMathRanks(){
        return matchRanks.stream()
                .mapToInt(Rank::getWinningPrize)
                .reduce(INTEGER_ZERO,Integer::sum);
    }

    public double rateOfTotalPrize(int purchaseAmount) {
        return (double) totalPrizeOfMathRanks() / (purchaseAmount / DEFAULT_LOTTO_PRICE * DEFAULT_LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(matchRanks, that.matchRanks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchRanks);
    }
}
