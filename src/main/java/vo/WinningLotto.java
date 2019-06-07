package vo;

public class WinningLotto {
    private Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(Lotto lotto) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = lotto.match(userLotto);
        return Rank.valueOf(countOfMatch);
    }
}
