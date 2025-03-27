package lotto.domain;

public interface PrizeRankRule {
    boolean matches(MatchCount matchCount, boolean bonus);

    int getMatchCount();
}
