package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final static long LOTTO_PRICE = 1000;
    private final static double BENEFIT_POINT = 1.0;
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    //FIXME: 함수별 출력이 아닌 통계 도메인 생성 :)
    public long numberOfFirstRank(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Rank.FIRST == lotto.checkRank(winners))
            .count();
    }

    public long numberOfSecondRank(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Rank.SECOND == lotto.checkRank(winners))
            .count();
    }

    public long numberOfThirdRank(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Rank.THIRD == lotto.checkRank(winners))
            .count();
    }

    public long numberOfFourthRank(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Rank.FOURTH == lotto.checkRank(winners))
            .count();
    }

    public double calculateProfitRate(List<Number> winners) {
        BigDecimal profitRate = calculateTotalProfit(winners).divide(calculatePrincipal(), 2, RoundingMode.DOWN);
        return profitRate.doubleValue();
    }

    private BigDecimal calculateTotalProfit(List<Number> winners) {
        return Rank.sumPrize(getRanks(winners));
    }

    private List<Rank> getRanks(List<Number> winners) {
        return lottos.stream()
            .map(lotto -> lotto.checkRank(winners))
            .collect(Collectors.toUnmodifiableList());
    }

    private BigDecimal calculatePrincipal() {
        return BigDecimal.valueOf(lottos.size() * LOTTO_PRICE);
    }

    //FIXME: 리스트 채로 반환하면 가면 리스트를 전달한다. 수정 필요 :)
    public List<Lotto> getLottos() {
        return lottos;
    }

    public boolean hasBenefit(List<Number> winnerNumbers) {
        return calculateProfitRate(winnerNumbers) >= BENEFIT_POINT;
    }
}
