package lottery_auto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lottery {
    private List<Integer> quickPicks;

    public Lottery(final List<Integer> quickPicks) {
        this.quickPicks = quickPicks;
    }

    public int compare(final List<Integer> number) {
        return Math.toIntExact(quickPicks.stream()
                .filter(quickpick -> number.contains(quickpick))
                .count());
    }

    @Override
    public String toString() {
        return quickPicks.stream()
                .map(Objects::toString)
                .collect(Collectors.toList())
                .toString();
    }
}
