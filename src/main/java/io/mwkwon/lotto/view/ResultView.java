package io.mwkwon.lotto.view;

import io.mwkwon.lotto.domain.*;
import io.mwkwon.lotto.enums.Rank;

import java.util.*;

public class ResultView {
    public static final String BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String TITLE = "당첨 통계";
    public static final String DELIMITER = "---------";
    public static final String STATISTICS_MESSAGE = "%s개 일치(%s원)- %s개";

    public void printBuyLottoCount(LottoPayment lottoPayment) {
        int buyQuantity = lottoPayment.calcLottoBuyQuantity();
        System.out.println(buyQuantity + BUY_COUNT_MESSAGE);
    }

    public void printBuyLottos(BuyLottos buyLottos) {
        for (Lotto lotto : buyLottos.lottos()) {
            List<LottoNumber> lottoNumbers = new ArrayList<>(lotto.lottoNumbers());
            Collections.sort(lottoNumbers);
            System.out.println(lottoNumbers);
        }
    }

    public void printWinningStatistics(WinningRanks winningRanks) {
        System.out.println(TITLE);
        System.out.println(DELIMITER);
        Map<Rank, Integer> rankStatisticsMap = winningRanks.aggregateRank();
        for (Rank rank : Rank.createPrintTargetRank()) {
            int count = rankStatisticsMap.getOrDefault(rank, 0);
            System.out.println(String.format(STATISTICS_MESSAGE, rank.getMatchCount(), rank.getReward(), count));
        }
    }

    public void printProfitRate(WinningRanks winningRanks, LottoPayment lottoPayment) {
        double profitRate = winningRanks.calcProfitRate(lottoPayment);
        System.out.println("총 수익률은" + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

}
