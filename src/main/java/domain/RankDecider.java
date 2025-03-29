package domain;

public class RankDecider {
    public static Rank decide(Lotto lotto, WinningNumber winningNumber) {
        return Rank.of(lotto.matchCount(winningNumber), lotto.matchBonusNumber(winningNumber));
    }
}
