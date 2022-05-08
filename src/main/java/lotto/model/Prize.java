package lotto.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Rank.NOT_WON;

public class Prize {

    private final Map<Number, Number> countByRank;

    private Prize() {
        this.countByRank = IntStream
                .range(0, 7)
                .boxed()
                .collect(Collectors.toMap(Number::of, i -> Number.of(), (b, n) -> b, LinkedHashMap::new));
    }

    public static Prize counting(Lotto beforeLotto, List<Lotto> lottoList) {
        Prize prize = new Prize();

        lottoList.stream()
                .map(lotto -> lotto.contains(beforeLotto))
                .forEach(count -> prize.countByRank.computeIfPresent(count, (rank, beforeCount) -> beforeCount.incrementAndGet()));

        return prize;
    }

    public static Rank prizeByRank(Number thisRank) {

        return Arrays
                .stream(Rank.values())
                .filter(rank -> thisRank.equals(rank.getCorrectCount()))
                .findFirst()
                .orElse(NOT_WON);
    }

    public Number getWinningRate() {
        Number price = this.countByRank
                .values()
                .stream()
                .reduce(Number::add)
                .orElse(Number.of())
                .multiple(Number.of(1000));

        Number prize = this.countByRank
                .entrySet()
                .stream()
                .filter(result -> result.getKey().getLongValue() > 2)
                .map(countByRank -> prizeByRank(countByRank.getKey())
                        .getPrize()
                        .multiple(countByRank.getValue()))
                .reduce(Number::add)
                .orElse(Number.of());

        return prize.divide(price);
    }

    public Map<Number, Number> getCountByRank() {
        return this.countByRank;
    }
}
