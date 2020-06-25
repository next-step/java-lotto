package lotto.view;

import java.math.BigDecimal;
import java.util.List;

public final class LottoResultView {

    private LottoResultView() {}

    public static void printRankResult(final List<String> rankResults) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------------------");

        for (String rankResult : rankResults) {
            System.out.println(rankResult);
        }

    }

    public static void printTotalEarningRate(final BigDecimal totalEarningRate) {
        System.out.println(String.format("총 수익률은 %.2f입니다.", totalEarningRate));
    }

}
