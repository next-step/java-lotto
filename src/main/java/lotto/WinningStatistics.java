package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final Map<WinningType, Integer> winningLogs;

    public WinningStatistics(Lotto winningNumber, List<Lotto> lottoList) {
        this(analyze(winningNumber, lottoList));
    }

    public WinningStatistics(Map<WinningType, Integer> winningLogs) {
        this.winningLogs = winningLogs;
    }

    private static Map<WinningType, Integer> analyze(Lotto winningNumber, List<Lotto> lottoList) {
        return lottoList.stream()
                .map(lotto -> lotto.matchedCount(winningNumber))
                .filter(WinningType::isWinningTypeNumber)
                .collect(Collectors.toMap(WinningType::valueOf, count -> 1, Integer::sum));
    }

    public Map<WinningType, Integer> winningLogs() {
        return Collections.unmodifiableMap(winningLogs);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatistics that = (WinningStatistics) o;
        for (WinningType type : WinningType.values()) {
            if (!winningLogs.getOrDefault(type, 0)
                    .equals(that.winningLogs
                            .getOrDefault(type, 0))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLogs);
    }
}
