package step2;

public class LottoStatistic {

    private long hitCount;
    private LottoPrize lottoPrize;

    public LottoStatistic(long hitCount){
        lottoPrize = LottoPrize.getPrizeInfo(hitCount);
    }

    public LottoPrize lottoPrize() {
        return lottoPrize;
    }
}
