package lotto.domain;

public class LottoWinningResult {
    private final LottoWinningStatus lottoWinningStatus;
    private int count = 0;

    public LottoWinningResult(LottoWinningStatus lottoWinningStatus) {
        this.lottoWinningStatus = lottoWinningStatus;
    }

    public LottoWinningStatus getLottoWinningStatus() {
        return lottoWinningStatus;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public int getWinningAmount() {
        return lottoWinningStatus.getAmount() * count;
    }

    public boolean isWinningCountEqual(final int number) {
        return lottoWinningStatus.isWinningCountEqual(number);
    }
}
