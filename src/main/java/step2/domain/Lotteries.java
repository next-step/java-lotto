package step2.domain;

import step2.domain.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(int count) {
        List<Lottery> lotteries = new ArrayList<>();

        for (int idx = 0; idx < count; idx++) {
            lotteries.add(Lottery.createFromList(RandomUtil.getRandomNumbers()
                    .stream()
                    .map(n -> Number.createFromInt(n))
                    .collect(Collectors.toList())));
        }

        this.lotteries = lotteries;
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getList() {
        return lotteries;
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
