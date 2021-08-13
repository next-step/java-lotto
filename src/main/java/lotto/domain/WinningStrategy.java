package lotto.domain;

@FunctionalInterface
public interface WinningStrategy {
    boolean winnable(MatchingCount matchingCount, boolean isBonus);
}
