package domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(final Lotto lotto, final LottoNumber bonus) {
        if (lotto.containsLottoNumber(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 로또와 중복될 수 없습니다.");
        }

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank checkLottoResult(final Lotto target) {
        long matchLottoNumber = this.lotto.countMatchLottoNumber(target);
        boolean containsBonus = target.containsLottoNumber(bonus);

        return Rank.resolveRank(matchLottoNumber, containsBonus);
    }

    public Lotto getLotto() {
        return this.lotto;
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }
}
