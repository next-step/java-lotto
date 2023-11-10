package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnerResult {

    private final Map<RankLotto, Integer> result;

    public WinnerResult(Map<RankLotto, Integer> result) {
        this.result = Collections.unmodifiableMap(result);
    }

    public WinnerResult(Lotto winLotto, List<Lotto> lottos) {
        this.result = Collections.unmodifiableMap(resultCount(winLotto, lottos));
    }

    public Map<RankLotto, Integer> result() {
        return result;
    }

    public int totalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().winningMoney() * entry.getValue())
                .sum();
    }

    private Map<RankLotto, Integer> resultCount(Lotto winLotto, List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> RankLotto.findRank(lotto.match(winLotto)))
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum));
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
