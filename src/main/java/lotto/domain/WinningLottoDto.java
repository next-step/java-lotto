package lotto.domain;

public class WinningLottoDto {

    private final WinningType winningType;
    private final int winningCount;

    public WinningLottoDto(WinningType winningType, int winningCount) {
        this.winningType = winningType;
        this.winningCount = winningCount;
    }

    public static WinningLottoDto of(WinningType winningType, int winningCount) {
        return new WinningLottoDto(winningType, winningCount);
    }

    public int getMatchCount() {
        return winningType.getMatchCount();
    }

    public int getPrize() {
        return winningType.getPrize();
    }

    public boolean isSecond() {
        return winningType.isSecond();
    }

    public int getWinningCount() {
        return winningCount;
    }
}
