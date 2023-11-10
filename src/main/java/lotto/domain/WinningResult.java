package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {

    private final Map<RankLotto, Integer> result;

    public WinningResult(Map<RankLotto, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

    public int totalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().winningMoney() * entry.getValue())
                .sum();
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
        return result.entrySet().stream()
                .map(entry -> String.format("%s - %d개", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
