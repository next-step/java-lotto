package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final static long LOTTO_PRICE = 1000;
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
    public long numberOfFirstDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.FIRST == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfSecondDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.SECOND == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfThirdDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.THIRD == lotto.checkDivision(winners))
            .count();
    }

    public long numberOfFourthDivision(List<Number> winners) {
        return lottos.stream()
            .filter(lotto -> Division.FOURTH == lotto.checkDivision(winners))
            .count();
    }

    public double calculateProfitRate(List<Number> winners) {
        BigDecimal profitRate = calculateTotalProfit(winners).divide(calculatePrincipal(), 2, RoundingMode.DOWN);
        return profitRate.doubleValue();
    }

    private BigDecimal calculateTotalProfit(List<Number> winners) {
        return Division.sumPrize(getDivisions(winners));
    }

    private List<Division> getDivisions(List<Number> winners) {
        return lottos.stream()
            .map(lotto -> lotto.checkDivision(winners))
            .collect(Collectors.toUnmodifiableList());
    }

    private BigDecimal calculatePrincipal() {
        return BigDecimal.valueOf(lottos.size() * LOTTO_PRICE);
    }

    //FIXME: 리스트 채로 반환하면 가면 리스트를 전달한다. 수정 필요 :)
    public List<Lotto> getLottos() {
        return lottos;
    }
}
