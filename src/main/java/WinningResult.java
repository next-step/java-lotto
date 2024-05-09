public class WinningResult {
    private final Rank rank;

    public WinningResult(Lotto lotto, LottoNumbers winningLottoNumbers) {
        this.rank = Rank.valueOf((int) lotto.countCommonLottoNumbers(winningLottoNumbers));
    }

    public Rank rank() {
        return this.rank;
    }

    public long winningMoney() {
        return this.rank.getWinningMoney();
    }
}
