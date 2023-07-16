package lotto.domain;

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

    public Rank resolveRank(final Lotto target) {
        final long matchLottoNumber = target.countMatchLottoNumber(lotto);
        final boolean containsBonus = target.containsLottoNumber(bonus);

        return Rank.from(matchLottoNumber, containsBonus);
    }
}
