package lottery_bonus.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Lottery {
    private List<Integer> quickPicks;

    public Lottery(final List<Integer> quickPicks) {
        this.quickPicks = quickPicks;
    }

    public double compareWinningNumber(final List<Integer> winningNumbers) {
        return Math.toIntExact(quickPicks.stream()
                .filter(quickpick -> winningNumbers.contains(quickpick))
                .count());
    }
    public boolean compareBonusNumber(final int bonusNumber) {
        return quickPicks.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return quickPicks.stream()
                .map(Objects::toString)
                .collect(Collectors.toList())
                .toString();
    }
}
