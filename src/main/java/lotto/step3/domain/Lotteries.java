package lotto.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Lotteries {

    private final List<Lotto> lotteries = new ArrayList<>();

    public Lotteries(int orderCount) {
        this(new ArrayList<>(), orderCount);
    }

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries.addAll(lotteries);
    }

    public Lotteries(List<List<Integer>> autoLotteries, int orderCount) {
        for (List<Integer> numbers : autoLotteries) {
            lotteries.add(new Lotto(numbers));
        }
        this.lotteries.addAll(range(0, orderCount)
                .mapToObj(i -> new Lotto())
                .collect(toList()));
    }

    public List<Lotto> getLotteries() {
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

    @Override
    public String toString() {
        return "Lotteries{" +
                "lotteries=" + lotteries +
                '}';
    }

}
