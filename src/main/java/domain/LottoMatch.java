package domain;

public class LottoMatch {
    private long matchCount;
    private boolean withBonusYn;

    public LottoMatch(Lotto lotto, Lotto firstLotto) {
        this.matchCount = checkMatchCount(lotto, firstLotto);
        this.withBonusYn = checkWithBonusYn(lotto, firstLotto);
    }

    private boolean checkWithBonusYn(Lotto lotto, Lotto firstLotto) {
        return false;
    }

    long checkMatchCount(Lotto lotto, Lotto firstLotto) {
        return lotto.getLottoNumber().stream()
                .filter(it -> firstLotto.getLottoNumber().contains(it))
                .count();
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean isWithBonusYn() {
        return withBonusYn;
    }

}
