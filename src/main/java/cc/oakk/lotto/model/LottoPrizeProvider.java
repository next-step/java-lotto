package cc.oakk.lotto.model;

public interface LottoPrizeProvider<T> {
    LottoPrize<T> getPrizeByRank(Rank rank);
}
