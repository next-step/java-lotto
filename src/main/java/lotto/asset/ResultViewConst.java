package lotto.asset;

import lotto.domain.Jackpot;

public class ResultViewConst {
    public static final String NUM_OF_LOTTOS_MSG = "개를 구매했습니다.";
    public static final String JACKPOT_STATISTICS_MSG = "\n당첨 통계\n---------";

    public static final String JACKPOT_MSG(Jackpot jackpot, int numOfCorrected) {
        return jackpot.getNumOfCorrected()
                + "개 일치 ("
                + jackpot.getPrizeMoney()
                + "원)- "
                + numOfCorrected
                + "개";
    }

    public static final String RATE_OF_RETURN_MSG(double rateOfReturn) {
        return "총 수익률은 " + rateOfReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
