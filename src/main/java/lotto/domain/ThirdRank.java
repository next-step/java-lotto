package lotto.domain;

public class ThirdRank implements RankCondition {
    @Override
    public boolean condition(int matchCount, boolean bonusNumber) {
        return matchCount == 5 && !bonusNumber;
    }

    @Override
    public Rank matchRank(int matchCount) {
        return Rank.THIRD;
    }
}
