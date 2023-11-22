package lotto.domain.summary;

import lotto.constants.Winning;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningSummary {

    private final Map<Winning, Long> winnings;

    private WinningSummary(List<Winning> winnings) {
        this.winnings = initializeWinnings();

        for (Winning winning : winnings) {
            addWinning(winning);
        }
    }

    public static WinningSummary of(List<Winning> winnings) {
        return new WinningSummary(winnings);
    }

    private Map<Winning, Long> initializeWinnings() {
        return Winning.prizeWinning()
                .stream()
                .collect(Collectors.toMap(
                        winning -> winning,
                        winning -> 0L
                ));
    }

    private void addWinning(Winning winning) {
        winnings.merge(winning, 1L, Long::sum);
    }

    public Map<Winning, Long> winnings() {
        return Collections.unmodifiableMap(winnings);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningSummary that = (WinningSummary) o;
        return Objects.equals(winnings, that.winnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnings);
    }
}
