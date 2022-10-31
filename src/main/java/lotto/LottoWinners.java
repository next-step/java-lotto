package lotto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoWinners {
    private final Map<LottoWinnerClass, Long> map;

    public LottoWinners(List<LottoWinner> winners) {
        this.map = winners.stream()
                .collect(Collectors.groupingBy(
                        LottoWinner::getWinnerClass,
                        Collectors.counting()));
    }

    public Long getWinnerCount(LottoWinnerClass winnerClass) {
        return map.getOrDefault(winnerClass, 0L);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinners that = (LottoWinners) o;
        return Objects.equals(map, that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}
