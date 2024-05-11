public class WinningResult {
    private final Rank rank;

    public WinningResult(Lotto lotto, LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        this.rank = Rank.valueOf((int) lotto.countCommonLottoNumbers(winningLottoNumbers), lotto.isWinningBonus(bonusNumber));
    }

    public Rank rank() {
        return this.rank;
    }

    public long winningMoney() {
        return this.rank.getWinningMoney();
    }
}
