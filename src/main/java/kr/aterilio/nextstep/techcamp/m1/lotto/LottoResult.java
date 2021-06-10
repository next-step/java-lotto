package kr.aterilio.nextstep.techcamp.m1.lotto;

public class LottoResult {

    private final PrizeMoney prizeMoney;
    private final EarningsRate earningsRate;

    private final LottoResultDetail resultDetail;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        resultDetail = new LottoResultDetail(lottoBundles.matchCounts(luckyNumbers));
        prizeMoney = new PrizeMoney(resultDetail);
        earningsRate = new EarningsRate(prizeMoney.value(), lottoBundles.paid());
    }

    public int countOf(ResultRank rankMatch) {
        return resultDetail.of(rankMatch);
    }

    public int prizeMoney() {
        return prizeMoney.value();
    }

    public String detail() {
        return resultDetail.detail();
    }

    public float rateOfReturn() {
        return earningsRate.value();
    }
}
