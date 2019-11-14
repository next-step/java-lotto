package lotto.domain;

@FunctionalInterface
public interface WinningStratedy {
    public boolean isWinning(long matchCount, boolean matchBonusNumber);
}
