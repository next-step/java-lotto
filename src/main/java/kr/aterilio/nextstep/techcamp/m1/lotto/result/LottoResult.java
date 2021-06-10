package kr.aterilio.nextstep.techcamp.m1.lotto.result;

import kr.aterilio.nextstep.techcamp.m1.lotto.LottoBundle;
import kr.aterilio.nextstep.techcamp.m1.lotto.LuckyNumbers;

public class LottoResult {

    private final LottoResultDetail resultDetail;
    private final LottoResultStats resultStats;

    public LottoResult(LuckyNumbers luckyNumbers, LottoBundle lottoBundles) {
        resultDetail = new LottoResultDetail(lottoBundles.matchCounts(luckyNumbers));
        resultStats = new LottoResultStats(resultDetail, lottoBundles.paid());
    }

    public int prizeMoney() {
        return resultStats.prizeMoney();
    }

    public float earningsRate() {
        return resultStats.earningsRate();
    }

    public String detail() {
        return resultDetail.detail();
    }
}
