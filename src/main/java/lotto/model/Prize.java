package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prize {

    private final Map<Number, Number> countByRank;

    private Prize() {
        this.countByRank = IntStream
                .range(0, 7)
                .boxed()
                .collect(Collectors.toMap(Number::new, i -> new Number(), (b, n) -> b, LinkedHashMap::new));
    }

    public static Prize counting(Lotto beforeLotto, List<Lotto> lottoList) {
        Prize prize = new Prize();

        lottoList.stream()
                .map(lotto -> lotto.contains(beforeLotto))
                .forEach(count -> prize.countByRank.computeIfPresent(count, (rank, beforeCount) -> beforeCount.incrementAndGet()));

        return prize;
    }

    public static Number prizeByRank(Number rank) {
        if (rank.equals(new Number(4))) {
            return new Number(50000);
        }

        if (rank.equals(new Number(5))) {
            return new Number(1500000);
        }

        if (rank.equals(new Number(6))) {
            return new Number(2000000000);
        }

        return new Number(5000);
    }

    public double getWinningRate() {
        long price = this.countByRank
                .values()
                .stream()
                .reduce(Number::add)
                .orElse(new Number())
                .getValue() * 1000;

        long prize = this.countByRank
                .entrySet()
                .stream()
                .filter(result -> result.getKey().getValue() > 2)
                .mapToLong(countByRank -> prizeByRank(countByRank.getKey())
                        .multiple(countByRank.getValue())
                        .getValue())
                .sum();

        return new BigDecimal(prize)
                .divide(new BigDecimal(price), 2, RoundingMode.HALF_EVEN)
                .doubleValue();
    }

    public Map<Number, Number> getCountByRank() {
        return this.countByRank;
    }
}
