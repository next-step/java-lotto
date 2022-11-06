package step3;

public class BonusLotto {
    private final int bonus;
    private final Lotto lotto;

    public BonusLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        if (lotto.checkBonus(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 지난 주 당첨 번호와 중복될 수 없습니다.");
        }
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return bonus;
    }
}
