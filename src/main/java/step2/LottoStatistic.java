package step2;

public class LottoStatistic {

    private LottoPrize lottoPrize;

    public LottoStatistic(HitCount hitCount){
        lottoPrize = LottoPrize.getPrizeInfoByHitCount(hitCount);
    }

    public LottoPrize lottoPrize() {
        return lottoPrize;
    }
}
