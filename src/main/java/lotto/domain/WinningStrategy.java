package lotto.domain;

@FunctionalInterface
public interface WinningStrategy {
    boolean winning(int money, boolean bonusMatch);
}
