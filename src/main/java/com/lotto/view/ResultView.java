package com.lotto.view;

import com.lotto.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class ResultView {

    private static final int SCALE = 2;
    private static final NumberFormat YIELD_FORMAT = NumberFormat.getInstance();

    static {
        YIELD_FORMAT.setMaximumFractionDigits(SCALE);
        YIELD_FORMAT.setRoundingMode(RoundingMode.HALF_EVEN);
    }

    public void showPurchaseHistory(Lotteries lotteries, Deposit deposit) {
        System.out.printf(
                "수동으로 %d 장, 자동으로 %d 장을 구매 했어요.%n%s%n",
                deposit.getManualLotteryCount(),
                deposit.getAutomaticLotteryCount(),
                lotteries
        );
    }

    public void showWinningStatistics(Statistics statistics) {
        System.out.println("당첨 통계\n---------------------------------");
        System.out.println(statistics.toStringFormatExceptLoser(
                "%2d 개 일치 (%10s 원)",
                "%2d 개 일치, 보너스 볼 일치 (%10s 원)",
                " - %2d 개"
        ));
        BigDecimal yield = statistics.calculateYield();
        System.out.printf("총 수익률은 %s 입니다.%n", YIELD_FORMAT.format(yield));
    }
}
