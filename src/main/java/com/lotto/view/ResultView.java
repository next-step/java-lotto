package com.lotto.view;

import com.lotto.domain.Lottery;
import com.lotto.domain.LotteryCommission;
import com.lotto.domain.Statistic;
import com.lotto.domain.WinningLottery;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

public class ResultView {

    private static final int SCALE = 2;
    private static final LotteryCommission LOTTERY_COMMISSION = new LotteryCommission();
    private static final NumberFormat YIELD_FORMAT = NumberFormat.getInstance();

    static {
        YIELD_FORMAT.setMaximumFractionDigits(SCALE);
        YIELD_FORMAT.setRoundingMode(RoundingMode.HALF_EVEN);
    }

    public void showPurchaseHistory(List<Lottery> lotteries) {
        System.out.printf("%d 개를 구매 했어요.%n", lotteries.size());
        lotteries.stream()
                .map(Lottery::toString)
                .forEach(System.out::println);
    }

    public void showWinningStatistics(List<Lottery> lotteries, WinningLottery winningLottery) {
        System.out.println("당첨 통계\n---------------------------------");
        List<Statistic> statistics = LOTTERY_COMMISSION.calculateWinningStatistics(lotteries, winningLottery);
        statistics.stream()
                .map(statistic -> statistic.toString("%2d 개 일치 (%10s 원)", " - %2d 개"))
                .forEach(System.out::println);
        BigDecimal yield = LOTTERY_COMMISSION.calculateYield(lotteries.size(), statistics);
        System.out.printf("총 수익률은 %s 입니다.%n", YIELD_FORMAT.format(yield));
    }
}
