package domain;


public class WinningInfo {
    private final LottoWinningType winningType;
    private int winningNumber;

    public static WinningInfo of(LottoWinningType winningType) {
        return new WinningInfo(winningType, 0);
    }

    private WinningInfo(LottoWinningType winningType, int winningNumber) {
        this.winningType = winningType;
        this.winningNumber = winningNumber;
    }

    public LottoWinningType getWinningType() {
        return winningType;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public void increaseHitNumber() {
        winningNumber++;
    }

    @Override
    public String toString() {
        return "WinningInfo{" +
                "winningType=" + winningType +
                ", winningNumber=" + winningNumber +
                '}';
    }
}
