package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lotteries {
    private final List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public Map<Integer, Integer> getStaticResult(Lottery winningNumbers1) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            map.put(i, 0);
        }

        for (Lottery lottery : this.lotteries) {
            int count = lottery.correctCount(winningNumbers1);
            map.put(count, map.getOrDefault(count, 0) + 1);
        }

        return map;
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
