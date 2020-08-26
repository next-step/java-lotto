package com.lotto.view;

import com.lotto.domain.Lottery;
import com.lotto.domain.LotteryCommission;
import com.lotto.domain.Statistic;

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
        List<Statistic> statistics = LOTTERY_COMMISSION.calculateWinningStatistics(lotteries, winningLottery);
        statistics.stream()
                .map(Statistic::toString)
                .forEach(System.out::println);
        float yield = LOTTERY_COMMISSION.calculateYield(lotteries, winningLottery);
        System.out.printf("총 수익률은 %10.5f 입니다.%n", yield);
    }
}
