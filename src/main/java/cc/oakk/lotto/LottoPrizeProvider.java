package cc.oakk.lotto;

public interface LottoPrizeProvider<T> {
    T getPrizeByRank(Rank rank);
}
