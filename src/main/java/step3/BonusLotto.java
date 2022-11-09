package step3;

public class BonusLotto {
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;
    private final int bonus;
    private final Lotto lotto;

    public BonusLotto(Lotto lotto, int bonus) {
        if (lotto.checkBonus(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 지난 주 당첨 번호와 중복될 수 없습니다.");
        }
        if (bonus < LOTTO_START || bonus > LOTTO_END) {
            throw new IllegalArgumentException("보너스 번호는 지난 주 당첨 번호와 중복되지 않는 1 ~ 45 인 수를 입력해주세요.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public boolean checkBonus(Lotto lotto) {
        return lotto.checkBonus(bonus);
    }
}
