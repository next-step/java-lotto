package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public int countMatches(Lotto anyLotto) {
        int count = 0;

        count += lotto.countMatches(anyLotto);

        return count;
    }

    public boolean matchBonus(Lotto anyLotto) {
        return anyLotto.contains(bonus);
    }

    public Prize calculatePrize(Lotto anyLotto) {
        int count = this.countMatches(anyLotto);
        boolean matchBonus = this.matchBonus(anyLotto);

        return Prize.valueOf(count, matchBonus);
    }
}
