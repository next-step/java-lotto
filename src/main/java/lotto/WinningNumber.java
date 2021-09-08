package lotto;

public class WinningNumber {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkWinning(Lotto lotto) {
        int equalNumberCount = equalNumberCount(lotto);
        return LottoRank.valueOf(equalNumberCount);
    }

    private int equalNumberCount(Lotto lotto) {
        return (int) lotto.values().stream()
                .filter(winningLotto.values()::contains)
                .count();
    }
}
