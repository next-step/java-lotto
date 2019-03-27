package lotto.domain;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException("BONUS NUMBER MUST NOT BE INCLUDED");
        }

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

    public Rank determineRank(Lotto anyLotto) {
        int count = this.countMatches(anyLotto);
        boolean matchBonus = this.matchBonus(anyLotto);

        return Rank.valueOf(count, matchBonus);
    }
}
