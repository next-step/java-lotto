package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = lotto.match(userLotto);
        boolean matchBonus = userLotto.contains(bonus);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
