package cc.oakk.lotto.model.prizeprovider;

import cc.oakk.lotto.model.LottoPrize;
import cc.oakk.lotto.model.Rank;

public interface LottoPrizeProvider<T> {
    LottoPrize<T> getPrizeByRank(Rank rank);
}
