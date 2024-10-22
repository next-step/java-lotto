package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class Report {

    private final WinningRules winningRules;

    public Report(WinningRules winningRules) {
        this.winningRules = winningRules;
    }

    public String reportTotalOrders(Orders orders) {
        StringBuilder builder = new StringBuilder();
        builder.append(orders.getTotalOrders()).append("개를 구매했습니다.\n");
        for(Lotto lotto: orders.getOrders()) {
            builder.append(ofLotto(lotto));
            builder.append("\n");
        }
        String result = builder.toString();
        System.out.println(result);
        return result;
    }

    /**
     * 당첨 통계
     * ---------
     * 3개 일치 (5000원)- 1개
     * 4개 일치 (50000원)- 0개
     * 5개 일치 (1500000원)- 0개
     * 6개 일치 (2000000000원)- 0개
     */
    public String reportWinners(Statistics statistics) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계\n");
        builder.append("---------\n");

        for (WinningRule winningRule : winningRules.getAllRules()) {
            builder.append(String.format("%d개 일치 (%d원)- %d개\n",
                    winningRule.getMatch(),
                    winningRule.getReward(),
                    statistics.get(winningRule.getMatch()))
            );
        }

        String result = builder.toString();
        System.out.println(result);
        return result;
    }

    public String reportRateOfReturn(Money input, Statistics statistics) {
        return reportRateOfReturn(input.get(), statistics);
    }

    public String reportRateOfReturn(int input, Statistics statistics) {
        int totalReward = 0;

        for (WinningRule winningRule : winningRules.getAllRules()) {
            totalReward += statistics.get(winningRule.getMatch()) * winningRule.getReward();
        }

        String result = String.format("총 수익률은 %.2f입니다.", BigDecimal.valueOf(totalReward).divide(BigDecimal.valueOf(input), 2, RoundingMode.FLOOR));
        System.out.println(result);
        return result;
    }

    private String ofLotto(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(lotto.getNumbers().stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
        builder.append("]");
        return builder.toString();
    }
}
