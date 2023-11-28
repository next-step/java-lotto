package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto winningLotto, LottoNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
        validate();
    }

    private void validate() {
        this.winningLotto.numbers().stream()
                .filter(winningLottoNumber -> winningLottoNumber.equals(this.bonus))
                .findAny()
                .ifPresent(a -> {
                    throw new IllegalArgumentException();
                });
    }

    public LottoResult getLottoResult(Lotto lotto) {
        return LottoResult.findResult(lotto.matchCount(winningLotto), lotto.hasNumber(bonus));
    }

}
