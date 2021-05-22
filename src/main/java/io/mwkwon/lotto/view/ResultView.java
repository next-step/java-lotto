package io.mwkwon.lotto.view;

import io.mwkwon.lotto.domain.LottoPayment;
import io.mwkwon.lotto.domain.WinningRanks;
import io.mwkwon.lotto.enums.Rank;

import java.util.Map;

public class ResultView {

    public void printWinningStatistics(WinningRanks winningRanks) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Rank, Integer> rankIntegerMap = winningRanks.aggregateRank();
        for (Map.Entry<Rank, Integer> entry : rankIntegerMap.entrySet()) {
            Rank rank = entry.getKey();
            System.out.println(rank.getMatchCount() + "개 일치 (" + rank.getReward() + "원)- " + entry.getValue()+ "개");
        }
    }

    public void printProfitRate(WinningRanks winningRanks, LottoPayment lottoPayment) {
        double profitRate = winningRanks.calcProfitRate(lottoPayment);
        System.out.println("총 수익률은" + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

}
