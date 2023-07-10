package domain;

public class LottoResult {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public LottoResult(final Lotto lotto, final LottoNumber bonus) {
        if (lotto.containsLottoNumber(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 로또와 중복될 수 없습니다.");
        }

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }
}
