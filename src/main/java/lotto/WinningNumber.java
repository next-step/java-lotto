package lotto;

public class WinningNumber {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.values().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 일반 당첨 번호가 중복됩니다.");
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank checkWinning(Lotto lotto) {
        int equalNumberCount = equalNumberCount(lotto);
        boolean hasBonusNumber = lotto.values().contains(bonusNumber);

        return LottoRank.valueOf(equalNumberCount, hasBonusNumber);
    }

    private int equalNumberCount(Lotto lotto) {
        return (int) lotto.values().stream()
                .filter(winningLotto.values()::contains)
                .count();
    }
}
