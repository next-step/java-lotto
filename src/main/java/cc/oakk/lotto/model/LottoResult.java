package cc.oakk.lotto.model;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResult {
    private final Lotto lotto;
    private final WinningLotto comparedLotto;
    private final Rank rank;

    private LottoResult(Lotto lotto, WinningLotto comparedLotto, Rank rank) {
        this.lotto = lotto;
        this.comparedLotto = comparedLotto;
        this.rank = rank;
    }

    public static LottoResult of(Lotto lotto, WinningLotto comparingLotto) {
        throwIfNull(lotto);
        throwIfNull(comparingLotto);
        return new LottoResult(lotto, comparingLotto, lotto.score(comparingLotto));
    }

    public Rank getRank() {
        return rank;
    }
}
