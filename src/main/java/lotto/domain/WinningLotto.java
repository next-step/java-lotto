package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize getMatchResult(Lotto lotto) {
        return LottoPrize.from(
                getMatchingNumberCount(lotto),
                lotto.hasNumber(bonusNumber)
        );
    }

    private int getMatchingNumberCount(Lotto lotto) {
        return (int) lotto.getLottoNumberSet()
                .stream()
                .filter(winningLotto::hasNumber)
                .count();
    }
}
