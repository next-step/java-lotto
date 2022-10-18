package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private final static long LOTTO_PRICE = 1000;
    private final static double BENEFIT_POINT = 1.0;

    private final List<Lotto> lottos;
    private final Set<Number> winners;

    public LottoResult(List<Lotto> lottos, Set<Number> winners) {
        this.lottos = lottos;
        this.winners = winners;
    }

    public long numberOfFirstRank() {
        return lottos.stream().filter(lotto -> Rank.FIRST == lotto.checkRank(winners)).count();
    }

    public long numberOfSecondRank() {
        return lottos.stream().filter(lotto -> Rank.SECOND == lotto.checkRank(winners)).count();
    }

    public long numberOfThirdRank() {
        return lottos.stream().filter(lotto -> Rank.THIRD == lotto.checkRank(winners)).count();
    }

    public long numberOfFourthRank() {
        return lottos.stream().filter(lotto -> Rank.FOURTH == lotto.checkRank(winners)).count();
    }

    public double calculateProfitRate() {
        BigDecimal profitRate = calculateTotalProfit().divide(calculatePrincipal(), 2, RoundingMode.DOWN);
        return profitRate.doubleValue();
    }

    private BigDecimal calculateTotalProfit() {
        return Rank.sumPrize(getRanks());
    }

    private List<Rank> getRanks() {
        return lottos.stream().map(lotto -> lotto.checkRank(winners)).collect(Collectors.toUnmodifiableList());
    }

    private BigDecimal calculatePrincipal() {
        return BigDecimal.valueOf(lottos.size() * LOTTO_PRICE);
    }

    public boolean hasBenefit() {
        return calculateProfitRate() >= BENEFIT_POINT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(lottos, that.lottos) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, winners);
    }
}
