package lotto.view;

import lotto.domain.Jackpot;
import lotto.domain.Money;
import lotto.domain.Result;

class ResultMessage {
    private ResultMessage() {}

    static String getJackpotStatistics(Result result, Money purchaseMoney) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---------\n");
        for (Jackpot jackpot : Jackpot.values()) {
            sb.append(getJackpotMsg(jackpot, result.getNumOfLotto(jackpot)));
        }
        double rateOfReturn = result.getRateOfReturn(purchaseMoney);
        sb.append(getRateOfReturnMsg(rateOfReturn));
        return sb.toString();
    }

    static String getNumOfLottosMsg(int numOfLottos) {
        return numOfLottos + "개를 구매했습니다.";
    }

    private static String getJackpotMsg(Jackpot jackpot, int numOfCorrected) {
        return jackpot.getNumOfCorrected()
                + "개 일치 ("
                + jackpot.getPrizeMoney()
                + "원)- "
                + numOfCorrected
                + "개\n";
    }

    private static String getRateOfReturnMsg(double rateOfReturn) {
        return "총 수익률은 " + rateOfReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
