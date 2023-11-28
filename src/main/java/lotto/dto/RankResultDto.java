package lotto.dto;

import java.util.Map.Entry;
import lotto.domain.Rank;

public class RankResultDto {

    private final boolean isSecond;
    private final int countOfMatch;
    private final long prizeMoney;
    private final long rankCount;

    public RankResultDto(boolean isSecond, int countOfMatch, long prizeMoney, long rankCount) {
        this.isSecond = isSecond;
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.rankCount = rankCount;
    }

    public static RankResultDto valueOf(Entry<Rank, Long> rankResult) {
        Rank rank = rankResult.getKey();
        int countOfMatch = rank.getCountOfMatch();
        long prizeMoney = rank.getPrizeMoney();
        long rankCount = rankResult.getValue();
        return new RankResultDto(rank.isSecond(), countOfMatch, prizeMoney, rankCount);
    }

    public boolean isSecond() {
        return isSecond;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public long getRankCount() {
        return rankCount;
    }
}
