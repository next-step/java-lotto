package lotto.domain;

public class WinLotto {

    private final Lotto winLotto;
    private final LottoNumber bonus;

    public WinLotto(Lotto winLotto, LottoNumber bonus) {
        validate(winLotto, bonus);
        this.winLotto = winLotto;
        this.bonus = bonus;
    }

    private void validate(Lotto winLotto, LottoNumber bonus) {
        if (winLotto.contains(bonus)) {
            throw new IllegalArgumentException("당첨 번호와 보너스는 중복될 수 없습니다.");
        }
    }

}
