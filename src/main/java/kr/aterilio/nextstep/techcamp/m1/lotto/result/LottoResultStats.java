package kr.aterilio.nextstep.techcamp.m1.lotto.result;

public class LottoResultStats {

    private final PrizeMoney prizeMoney;
    private final EarningsRate earningsRate;

    public LottoResultStats(LottoResultDetail resultDetail, int paid) {
        prizeMoney = new PrizeMoney(resultDetail);
        earningsRate = new EarningsRate(prizeMoney.value(), paid);
    }

    public int prizeMoney() {
        return prizeMoney.value();
    }

    public float earningsRate() {
        return earningsRate.value();
    }
}
