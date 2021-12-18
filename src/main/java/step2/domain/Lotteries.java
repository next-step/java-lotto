package step2.domain;

import step2.strategy.LotteryStrategy;

import java.util.*;
import java.util.stream.IntStream;

public class Lotteries {
    private final List<Lottery> lotteries;

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public static Lotteries createFromCount(LotteryStrategy strategy, int count) {
        List<Lottery> lotteries = new ArrayList<>();

        IntStream.range(0, count).forEach(i -> {
            lotteries.add(Lottery.createFromStrategy(strategy));
        });

        return new Lotteries(lotteries);
    }

    public static Lotteries createFromList(List<Lottery> lotteries) {
        return new Lotteries(lotteries);
    }

    public List<Lottery> getList() {
        return Collections.unmodifiableList(lotteries);
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
