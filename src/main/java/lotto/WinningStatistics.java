package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final Map<WinningType, Integer> winningLogs;
    private final float returnOnInvestment;

    public WinningStatistics(Lotto winningNumber, List<Lotto> lottoList) {
        this(analyze(winningNumber, lottoList), lottoList.size() * LottoStore.LOTTO_PRICE);
    }

    public WinningStatistics(Map<WinningType, Integer> winningLogs, int purchasedAmount) {
        this.winningLogs = winningLogs;
        long winnings = winningLogs.keySet()
                .stream()
                .map(type -> winnings(type, winningLogs.getOrDefault(type, 0)))
                .reduce(0L, Long::sum);
        returnOnInvestment = computeReturnOnInvestment(winnings, purchasedAmount);
    }

    private long winnings(WinningType type, int count) {
        return (long) type.winnings() * count;
    }

    private static Map<WinningType, Integer> analyze(Lotto winningNumber, List<Lotto> lottoList) {
        return lottoList.stream()
                .map(lotto -> lotto.matchedCount(winningNumber))
                .filter(WinningType::isWinningTypeNumber)
                .collect(Collectors.toMap(WinningType::valueOf, count -> 1, Integer::sum));
    }

    private static float computeReturnOnInvestment(long winnings, int purchasedAmount) {
        return (float) ((winnings * 100) / purchasedAmount) / 100;
    }

    public Map<WinningType, Integer> winningLogs() {
        return Collections.unmodifiableMap(winningLogs);
    }

    public float returnOnInvestment() {
        return returnOnInvestment;
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
