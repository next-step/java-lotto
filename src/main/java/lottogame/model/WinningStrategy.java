package lottogame.model;

@FunctionalInterface
public interface WinningStrategy {
    boolean winning(int money, boolean bonusMatch);
}
