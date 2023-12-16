package lotto.domain;

public interface RankCondition {
    boolean condition(int matchCount, boolean bonusNumber);
    Rank matchRank(int matchCount);
}
