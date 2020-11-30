package lottery.domain;

import lottery.domain.strategy.Picker;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotteries {
    private final List<Lottery> lotteries;

    public static Lotteries repeat(int n, Picker picker) {
        return new Lotteries(IntStream.range(0, n)
                .mapToObj(i -> Lottery.from(picker))
                .collect(Collectors.toUnmodifiableList()));
    }

    private Lotteries(List<Lottery> lotteries) {
        this.lotteries = Collections.unmodifiableList(lotteries);
    }

    public Map<WinningType, Long> getMatches(WinningNumber winningNumber) {
        return lotteries.stream()
                .map(winningNumber::countMatched)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public int size() {
        return lotteries.size();
    }

    public void forEach(Consumer<? super Lottery> action) {
        lotteries.forEach(action);
    }
}
