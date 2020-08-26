package com.lotto.view;

import com.lotto.domain.Lottery;
import com.lotto.domain.LotteryCommission;

import java.util.List;

public class ResultView {

    private static final LotteryCommission LOTTERY_COMMISSION = new LotteryCommission();

    public void showPurchaseHistory(List<Lottery> lotteries) {
        System.out.printf("%d 개를 구매 했어요.%n", lotteries.size());
        lotteries.stream()
                .map(Lottery::toString)
                .forEach(System.out::println);
    }

    public void showWinningStatistics(List<Lottery> lotteries, Lottery winningLottery) {
        List<int[]> statistics = LOTTERY_COMMISSION.calculateWinningStatistics(lotteries, winningLottery);
        statistics.forEach(statistic -> {
            System.out.printf("%2d 개 일치 (%10d 원) - %2d 개%n",
                    statistic[LotteryCommission.MATCHING_COUNT_INDEX],
                    statistic[LotteryCommission.WINNINGS_INDEX],
                    statistic[LotteryCommission.LOTTERY_COUNT_INDEX]
            );
        });
        float yield = LOTTERY_COMMISSION.calculateYield(lotteries, winningLottery);
        System.out.printf("총 수익률은 %10.5f 입니다.%n", yield);
    }
}
