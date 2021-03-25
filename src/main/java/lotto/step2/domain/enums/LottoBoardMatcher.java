package lotto.step2.domain.enums;

public enum LottoBoardMatcher {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int matchCount;
    private final int winningBonus;

    LottoBoardMatcher(int matchCount, int winningBonus) {
        this.matchCount = matchCount;
        this.winningBonus = winningBonus;
    }
}
