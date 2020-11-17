package lotto.dto;

import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.Result;

public class StatisticsDto {
    private final Result result;
    private final Money purchaseMoney;

    public StatisticsDto(Result result, Money purchaseMoney) {
        this.result = result;
        this.purchaseMoney = purchaseMoney;
    }

    public String toStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n---------\n");
        for (Rank rank : Rank.values()) {
            sb.append(getJackpotMsg(rank, result.getNumOfLotto(rank)));
        }
        sb.append("총 수익률은 " + result.getRateOfReturn(purchaseMoney) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        return sb.toString();
    }

    private String getJackpotMsg(Rank rank, int numOfCorrected) {
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
}
