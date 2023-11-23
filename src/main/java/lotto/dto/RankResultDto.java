package lotto.dto;

import lotto.domain.Rank;
import lotto.domain.RankResult;

public class RankResultDto {

    private final int countOfMatch;
    private final long prizeMoney;
    private final long rankCnt;

    public RankResultDto(int countOfMatch, long prizeMoney, long rankCnt) {
        this.countOfMatch = countOfMatch;
        this.prizeMoney = prizeMoney;
        this.rankCnt = rankCnt;
    }

    public static RankResultDto valueOf(RankResult rankResult) {
        Rank rank = rankResult.getRank();
        int countOfMatch = rank.getCountOfMatch();
        long prizeMoney = rank.getPrizeMoney();
        long rankCnt = rankResult.getRankCnt();
        return new RankResultDto(countOfMatch, prizeMoney, rankCnt);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public long getRankCnt() {
        return rankCnt;
    }
}
