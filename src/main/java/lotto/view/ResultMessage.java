package lotto.view;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;

class ResultMessage {
    private ResultMessage() {}

    static String getJackpotStatistics(Result result, Money purchaseMoney) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---------\n");
        for (Rank rank : Rank.values()) {
            sb.append(getJackpotMsg(rank, result.getNumOfLotto(rank)));
        }
        double rateOfReturn = result.getRateOfReturn(purchaseMoney);
        sb.append(getRateOfReturnMsg(rateOfReturn));
        return sb.toString();
    }

    static String getNumOfLottosMsg(int numOfLottos) {
        return numOfLottos + "개를 구매했습니다.";
    }

    private static String getJackpotMsg(Rank rank, int numOfCorrected) {
        if (rank == Rank.MISS) {
            return "";
        }
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch()
                    + "개 일치, 보너스 볼 일치("
                    + rank.getWinningMoney()
                    + "원)- "
                    + numOfCorrected
                    + "개\n";
        }
        return rank.getCountOfMatch()
                + "개 일치 ("
                + rank.getWinningMoney()
                + "원)- "
                + numOfCorrected
                + "개\n";
    }

    private static String getRateOfReturnMsg(double rateOfReturn) {
        return "총 수익률은 " + rateOfReturn + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
