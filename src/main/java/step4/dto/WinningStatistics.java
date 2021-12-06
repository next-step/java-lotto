package step4.dto;


import step4.domain.WinningRank;

import java.util.Map;

public class WinningStatistics {

    private final Map<WinningRank, Long> stat;

    public WinningStatistics(Map<WinningRank, Long> stat) {
        this.stat = stat;
    }

    public long getCount(WinningRank winningRank) {
        return stat.getOrDefault(winningRank, 0l);
    }
}
