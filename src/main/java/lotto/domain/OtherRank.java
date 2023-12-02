package lotto.domain;

public class OtherRank implements RankCondition {
    @Override
    public boolean condition(int matchCount, boolean bonusNumber) {
        return matchCount != 5;
    }

    @Override
    public Rank matchRank(int matchCount) {
        return Rank.returnRank(matchCount);
    }
}
