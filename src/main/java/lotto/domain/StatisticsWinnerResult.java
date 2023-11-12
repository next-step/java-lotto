package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsWinnerResult {

    private final Map<RankLotto, Integer> result;

    public StatisticsWinnerResult(Map<RankLotto, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

    private int totalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().winningMoney() * entry.getValue())
                .sum();
    }

    public double rateOfReturn(int money) {
        return (double) totalPrize() / money;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        sb.append(ranksString());
        return sb.toString();
    }

    private String ranksString() {
        return result.entrySet().stream().filter(entry -> entry.getKey() != RankLotto.MISS)
                .map(entry -> String.format("%s - %d개", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
