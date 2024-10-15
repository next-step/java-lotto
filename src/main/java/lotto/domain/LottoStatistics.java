package lotto.domain;

public class LottoStatistics {
    public int getPrizeMoney(int matchCount, boolean bonusMatched) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount, bonusMatched);
        return rank.getPrizeMoney();
    }

    public void incrementMatchCount(int matchCount, boolean bonusMatched) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount, bonusMatched);
        rank.incrementCount();
    }

    public int getCountByMatchCount(int matchCount, boolean bonusMatched) {
        LottoRank rank = LottoRank.valueOfMatchCount(matchCount, bonusMatched);
        return rank.getCount();
    }

    public int getEarningsByMatchCount(int matchCount, boolean bonusMatched) {
        return getPrizeMoney(matchCount, bonusMatched) * getCountByMatchCount(matchCount, bonusMatched);
    }
}
