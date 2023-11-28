package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto winningLotto, LottoNumber bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public LottoResult getLottoResult(Lotto lotto) {
        return LottoResult.findResult(getMatchCount(lotto), isMatchBonus(lotto));
    }

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.numbers().contains(bonus);
    }

    private int getMatchCount(Lotto lotto) {
        return (int) winningLotto.numbers()
                .stream()
                .filter(value -> lotto.numbers().contains(value))
                .count();
    }
}
