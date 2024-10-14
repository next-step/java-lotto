package lotto.domain;

public class LottoStatistics {
    public int getPrizeMoney(int matchCount) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount);
        return rank.getPrizeMoney();
    }

    public void incrementMatchCount(int matchCount) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount);
        validateRank(rank);
        rank.incrementCount();
    }

    public int getCountByMatchCount(int matchCount) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount);
        return rank.getCount();
    }

    public int getEarningsByMatchCount(int matchCount) {
        return getPrizeMoney(matchCount) * getCountByMatchCount(matchCount);
    }

    private void validateRank(LottoRank rank) {
        if (rank == LottoRank.NO_MATCH) {
            throw new IllegalArgumentException("유효하지 않은 매치 수: " + rank.getMatchCount());
        }
    }
}
