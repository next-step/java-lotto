package lotto.domain;

public class WinningLottoDto {
    private final int matchCount;
    private final int prize;
    private final int winningCount;

    public WinningLottoDto(int matchCount, int prize, int winningCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.winningCount = winningCount;
    }

    public static WinningLottoDto of(WinningType winningType, int winningCount) {
        return new WinningLottoDto(winningType.getMatchCount(),
                                   winningType.getPrize(),
                                   winningCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
