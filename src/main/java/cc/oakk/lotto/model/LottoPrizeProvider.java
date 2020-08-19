package cc.oakk.lotto.model;

public interface LottoPrizeProvider<T> {
    T getPrizeByRank(Rank rank);
}
