package step2.domain.lottoResult;

public class LottoResult {
    private final WinNumber winNumber;
    private final WinCount winCount;

    private LottoResult(WinNumber winNumber, WinCount winCount) {
        this.winNumber = winNumber;
        this.winCount = winCount;
    }

    public static LottoResult of(WinNumber winNumber) {
        return new LottoResult(winNumber, new WinCount(0));
    }

    public static LottoResult of(WinNumber winNumber, int winCount) {
        return new LottoResult(winNumber, new WinCount(winCount));
    }

    public int winningProfit() {
        return winCount.moneyCount(winNumber.getMoney());
    }

    public void win(int hitNumber) {
        if (winNumber.getHit() != hitNumber) {
            return;
        }
        winCount.plus();
    }

    public int getWinCount() {
        return winCount.getNumberOfWin();
    }

    public int getHitNumber() {
        return winNumber.getHit();
    }

    public int getMoney() {
        return winNumber.getMoney();
    }
}
