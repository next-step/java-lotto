package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus ;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        validateDuplicate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonus) {
        if (lotto.getLotto().contains(bonus.getNumber())) {
            throw new IllegalArgumentException("당첨 번호와 중복되는 보너스 번호는 사용할 수 없습니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
