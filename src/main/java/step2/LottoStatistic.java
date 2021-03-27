package step2;

public class LottoStatistic {

    private HitCount hitCount;
    private LottoPrize lottoPrize;

    public LottoStatistic(HitCount hitCount){
        //lottoPrize = LottoPrize.getPrizeInfo(hitCount);
    }

    public LottoPrize lottoPrize() {
        return lottoPrize;
    }
}
