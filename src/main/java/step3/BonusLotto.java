package step3;

public class BonusLotto {
    private final int bonus;
    private final Lotto lotto;

    public BonusLotto(Lotto lotto, int bonus) {
        if (lotto.checkBonus(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 지난 주 당첨 번호와 중복될 수 없습니다.");
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
