package lottoAuto.model;

public class LottoResult {
    private int countMatchWinningNumbers;
    private boolean hasBonusBall;

    public LottoResult(int countMatchWinningNumbers, boolean hasBonusBall) {
        this.countMatchWinningNumbers = countMatchWinningNumbers;
        this.hasBonusBall = hasBonusBall;
    }

    public int getCountMatchWinningNumbers() {
        return countMatchWinningNumbers;
    }

    public boolean getHasBonusBall() {
        return hasBonusBall;
    }
}
