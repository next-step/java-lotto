package kr.aterilio.nextstep.techcamp.m1.lotto;

public class LottoResult {

    private static final int EMPTY_PAID = 0;
    private static final float NONE_RETURN_RATE = 0.f;

    private final int prizeMoney;
    private final float rateOfReturn;

    private final LottoResultDetail resultDetail;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        resultDetail = new LottoResultDetail(lottoBundles.matchCounts(luckyNumbers));
        prizeMoney = resultDetail.calculatePrizeMoney();
        rateOfReturn = calculateRateOfReturn(prizeMoney, lottoBundles.paid());
    }

    private float calculateRateOfReturn(int prizeMoney, int paid) {
        if (paid == EMPTY_PAID) {
            return NONE_RETURN_RATE;
        }
        return (float) prizeMoney / paid;
    }

    public int is(ResultRank rankMatch) {
        return resultDetail.is(rankMatch);
    }

    public int prizeMoney() {
        return prizeMoney;
    }

    public String detail() {
        return resultDetail.detail();
    }

    public float rateOfReturn() {
        return rateOfReturn;
    }
}
