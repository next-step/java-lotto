package lotto.domain;

@FunctionalInterface
public interface WinningStrategy {
    boolean winnable(long howManyMatches, boolean bonusContains);
}
