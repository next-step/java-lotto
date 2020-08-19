package cc.oakk.lotto;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResult {
    private final Lotto lotto;
    private final Lotto comparedLotto;
    private final Rank rank;

    private LottoResult(Lotto lotto, Lotto comparedLotto, Rank rank) {
        this.lotto = lotto;
        this.comparedLotto = comparedLotto;
        this.rank = rank;
    }

    public static LottoResult of(Lotto lotto, Lotto comparingLotto) {
        throwIfNull(lotto);
        throwIfNull(comparingLotto);
        return new LottoResult(lotto, comparingLotto, lotto.compare(comparingLotto));
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Lotto getComparedLotto() {
        return comparedLotto;
    }

    public Rank getRank() {
        return rank;
    }
}
