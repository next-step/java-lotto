package lotto.view;

import java.util.Arrays;
import java.util.Map;
import lotto.domain.Revenue;
import lotto.util.NumberUtils;

public class ResultOutputView {

    public static final String WINNING_STATISTICS = "\n당첨 통계\n";
    public static final String DIVISION_LINE = "---------\n";
    public static final String CORRECT_NUM_NO_BONUS = "%d개 일치 (%d원)- %d개\n";
    public static final String BONUS_NUM = "%d개 일치, 보너스 볼 일치 (%d원) - %d개\n";
    public static final String TOTAL_YIELD = "총 수익률은 %.2f 입니다.";
    public static final String TOTAL_YIELD_RESULT_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String TOTAL_YIELD_RESULT_INCOME = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public void printLottoStatics(Map<Revenue, Integer> revenueMap) {
        System.out.println(createLottoStaticsString(revenueMap));
    }

    public void printTotalRevenue(Double totalRevenue) {
        System.out.println(createTotalRevenueString(totalRevenue));
    }

    private StringBuilder createLottoStaticsString(Map<Revenue, Integer> revenueCluster) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(WINNING_STATISTICS)
            .append(DIVISION_LINE)
            .append(createLottoResultString(revenueCluster, stringBuilder));
    }

    private StringBuilder createLottoResultString(Map<Revenue, Integer> revenueCluster,
        StringBuilder stringBuilder) {
        Arrays.stream(Revenue.values()).filter(revenue -> revenue != Revenue.NOTHING)
            .forEach(revenue -> {
                stringBuilder.append(appendRevenue(revenue, revenueCluster));
            });
        return stringBuilder;
    }

    private StringBuilder createTotalRevenueString(Double totalRevenue) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(String.format(
            TOTAL_YIELD
            , totalRevenue
        ))
            .append(isIncome(totalRevenue));
    }

    private String isIncome(Double totalRevenue) {
        if (totalRevenue > 1) {
            return TOTAL_YIELD_RESULT_INCOME;
        }
        return TOTAL_YIELD_RESULT_LOSS;
    }

    private String appendRevenue(Revenue revenue, Map<Revenue, Integer> revenueCluster) {
        if (revenue.getBonus()) {
            return String.format(
                BONUS_NUM,
                revenue.getMatchNum(),
                revenue.getRevenue(),
                NumberUtils.convertNullToNumber(revenueCluster.get(revenue))
            );
        }
        return String.format(CORRECT_NUM_NO_BONUS,
            revenue.getMatchNum(),
            revenue.getRevenue(),
            NumberUtils.convertNullToNumber(revenueCluster.get(revenue))
            );
    }
}
