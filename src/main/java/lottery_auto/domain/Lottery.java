package lottery_auto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lottery {
    private List<Integer> quickpicks;

    public Lottery(final List<Integer> quickpicks) {
        this.quickpicks = quickpicks;
    }

    public int compare(final List<Integer> number) {
        return Math.toIntExact(quickpicks.stream()
                .filter(quickpick -> number.contains(quickpick))
                .count());
    }

    @Override
    public String toString() {
        return quickpicks.stream()
                .map(Objects::toString)
                .collect(Collectors.toList())
                .toString();
    }
}
