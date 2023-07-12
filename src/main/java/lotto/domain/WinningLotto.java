package lotto.domain;

public class WinningLotto {

    private static final String DUPLICATE_BONUS_WITH_LOTTO_BALLS_EXCEPTION_MESSAGE
            = "보너스 볼은 지난주 당첨 로또 번호와 중복될 수 없습니다.";
    private final Lotto lotto;
    private final Ball bonus;

    public WinningLotto(final Lotto lotto, final Ball bonus) {
        validate(lotto, bonus);
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private void validate(final Lotto lotto, final Ball bonus) {
        if (lotto.isContains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_WITH_LOTTO_BALLS_EXCEPTION_MESSAGE);
        }
    }
}
