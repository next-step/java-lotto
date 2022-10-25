package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotteries {

    private final List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries, List<Lotto> manualLotteries) {
        this.lotteries = Stream.concat(lotteries.stream(), manualLotteries.stream())
                .collect(Collectors.toList());
    }

    public List<Lotto> getLotteries() {
        return this.lotteries;
    }

    public Map<Rank, Long> getLotteriesRank(WinningLotto winningLotto) {
        return lotteries.stream()
                .map(winningLotto::match)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}