package lotto.domain;

import lotto.utils.MessageUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private static final int LOTTO_PRICE = 1_000;
    private static final int PROFIT_RATE_SCALE = 2;

    private final List<Lotto> lottos;
    private Map<LottoRank, Long> statistics;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void setStatistics() {
        this.statistics = lottos.stream()
                .collect(Collectors.groupingBy(Lotto::getLottoRank, Collectors.counting()));
    }

    public Map<LottoRank, Long> getStatistics() {
        return this.statistics;
    }

    public long calculateProfit() {
        validateStatistics();

        return statistics.entrySet().stream()
                .mapToLong(v -> (v.getKey().getReward() * v.getValue()))
                .sum();
    }

    public BigDecimal calculateProfitRate() {
        validateStatistics();

        int amount = lottos.size() * LOTTO_PRICE;
        return BigDecimal.valueOf(calculateProfit())
                .divide(BigDecimal.valueOf(amount), PROFIT_RATE_SCALE, RoundingMode.DOWN);
    }

    private void validateStatistics() {
        if (Objects.isNull(this.statistics)) {
            throw new IllegalArgumentException(MessageUtils.LOTTO_BEFORE_PRESENT_WINNING);
        }
    }

}
