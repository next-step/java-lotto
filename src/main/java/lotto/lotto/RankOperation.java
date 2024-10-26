package lotto.lotto;

@FunctionalInterface
public interface RankOperation {
    boolean isRank(int matchingCnt, boolean bonusMatch);
}
