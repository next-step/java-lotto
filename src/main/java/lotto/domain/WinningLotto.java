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
                .filter(winningLottoNumber -> winningLotto.hasNumber(this.bonus))
                .findAny()
                .ifPresent(a -> {
                    throw new IllegalArgumentException("보너스번호가 당첨번호에 이미 포함된 번호입니다.");
                });
    }

    public LottoResult getLottoResult(Lotto lotto) {
        return LottoResult.findResult(lotto.matchCount(winningLotto), lotto.hasNumber(bonus));
    }

}
