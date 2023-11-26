package lotto.dto;

import java.util.Map.Entry;
import lotto.domain.Rank;

public class RankResultDto {

    private final int countOfMatch;
    private final long prizeMoney;
    private final long rankCount;

    public RankResultDto(int countOfMatch, long prizeMoney, long rankCount) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.rankCount = rankCount;
    }

    public static RankResultDto valueOf(Entry<Rank, Long> rankResult) {
        Rank rank = rankResult.getKey();
        int countOfMatch = rank.getCountOfMatch();
        long prizeMoney = rank.getPrizeMoney();
        long rankCount = rankResult.getValue();
        return new RankResultDto(countOfMatch, prizeMoney, rankCount);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public long getRankCnt() {
        return rankCount;
    }
}
