package lotto.domain;

import lotto.domain.enums.LottoPrize;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private static final BigDecimal UNIT_PRICE = BigDecimal.valueOf(1000L);

    private final List<Lotto> lottos;

    public Lottos(RandomGenerator randomGenerator, Integer amount) {
        int count = BigDecimal.valueOf(amount)
                .divide(UNIT_PRICE, 0, RoundingMode.FLOOR)
                .intValue();
        this.lottos = IntStream.range(0, count)
                .mapToObj(i -> new Lotto(randomGenerator))
                .collect(toList());
    }

    Lottos(List<Lotto> lottos) {
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

    public void forEach(Consumer<Lotto> action) {
        lottos.forEach(action);
    }

    public Integer count() {
        return lottos.size();
    }

    public Integer winningCount(Lotto winningLotto, LottoPrize lottoPrize) {
        return Math.toIntExact(lottos.stream()
                .filter(lotto -> Objects.equals(lotto.matchedCount(winningLotto), lottoPrize.matchedCount()))
                .count());
    }

    public BigDecimal totalProfitRate(Lotto winningLotto) {
        BigDecimal totalSum = Arrays.stream(LottoPrize.values())
                .reduce(BigDecimal.ZERO, (total, lottoPrize) -> {
                    Integer winningCount = winningCount(winningLotto, lottoPrize);
                    BigDecimal winningPrize = lottoPrize.money().multiply(BigDecimal.valueOf(winningCount));
                    return total.add(winningPrize);
                }, BigDecimal::add);

        BigDecimal purchaseAmount = BigDecimal.valueOf(count()).multiply(UNIT_PRICE);

        return totalSum.divide(purchaseAmount, 2, RoundingMode.FLOOR);
    }
}
