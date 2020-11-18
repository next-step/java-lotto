package step02.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningCounterCollections {
    private final List<WinningCounter> numbersCount;

    private WinningCounterCollections(List<WinningCounter> winningCounters) {
        this.numbersCount = winningCounters;
    }

    public static WinningCounterCollections of(List<WinningCounter> winningCounters) {
        return new WinningCounterCollections(winningCounters);
    }

    public List<WinningCounter> filter(int from, int to) {
        return numbersCount.stream()
                .filter(numberCount -> numberCount.filter(from, to))
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCounterCollections that = (WinningCounterCollections) o;
        return Objects.equals(numbersCount, that.numbersCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersCount);
    }
}
