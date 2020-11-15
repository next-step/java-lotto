package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinningRankStatistics {
    private Map<WinningRank, Integer> counter = new LinkedHashMap<>();

    public WinningRankStatistics(WinningRanks winningRanks) {
        setDefaultCounter();
        count(winningRanks);
    }

    private void count(WinningRanks winningRanks) {
        winningRanks.getWinningRankList()
                .forEach(this::add);
    }

    private void add(WinningRank winningRank) {
        counter.compute(winningRank, (key, count) -> count + 1);
    }

    private void setDefaultCounter() {
        Arrays.stream(WinningRank.values()).forEach(winningRank -> counter.put(winningRank, 0));
    }

    public Map<WinningRank, Integer> getCounter() {
        return counter;
    }

    public int getWinningRankCount(WinningRank winningRank) {
        return counter.get(winningRank);
    }
}
