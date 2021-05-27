package step2.model;

public class LottoPrize {

    private final LottoRank rank;
    private final long count;

    private LottoPrize(LottoRank rank, long count) {
        this.rank = rank;
        this.count = count;
    }

    public static LottoPrize of(LottoRank rank, long count) {
        return new LottoPrize(rank, count);
    }

    public long getTotalPrize() {
        return rank.getPrice() * count;
    }

    public LottoRank getRank() {
        return rank;
    }

    public long getCount() {
        return count;
    }
}
