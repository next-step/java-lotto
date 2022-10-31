package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinnerStat {
    private final Map<LottoWinnerClass, Long> map;

    public LottoWinnerStat(List<LottoWinner> winners) {
        this.map = winners.stream()
                .collect(Collectors.groupingBy(
                        LottoWinner::getWinnerClass,
                        Collectors.counting()));
    }

    public Long getWinnerCount(LottoWinnerClass winnerClass) {
        return map.getOrDefault(winnerClass, 0L);
    }
}
