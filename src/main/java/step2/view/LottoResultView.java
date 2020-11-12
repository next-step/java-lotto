package step2.view;

import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumbers;
import step2.type.WinningType;

import java.util.Map;

public class LottoResultView implements ResultView {
    private static final String PURCHASED_COUNT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String MATCHED_WINNING_COUNT = "%d개 일치(%d원)- %d개";
    private static final String ALERT_REVENUE_RATE = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String REVENUE = "이득";
    private static final String DAMAGES = "손해";
    private static final String HORIZONTAL_DELIMITER = "---------";
    private static final StringBuilder sb = new StringBuilder();

    @Override
    public void drawTicket(LottoTickets tickets) {
        clearStringBuilder();
        append(String.format(PURCHASED_COUNT, tickets.countTicket()), tickets.toString());
        System.out.println(sb.toString());
    }

    @Override
    public void drawWinningStatistics(LottoTickets tickets, WinningNumbers winningNumbers) {
        clearStringBuilder();

        Map<WinningType, Integer> winningStatistics = winningNumbers.getWinningStatistics(tickets);

        append(WINNING_STATISTICS, HORIZONTAL_DELIMITER);
        winningStatistics.forEach(this::appendWinningRow);

        System.out.println(sb.toString());
    }

    private void appendWinningRow(WinningType type, int count) {
        append(String.format(MATCHED_WINNING_COUNT,
                WinningType.getMatchCount(type),
                WinningType.getWinningAmount(type),
                count));
    }

    @Override
    public void drawRevenueRate(LottoTickets tickets, WinningNumbers winningNumbers) {
        clearStringBuilder();
        double revenueRate = tickets.getRevenueRate(winningNumbers);
        append(String.format(ALERT_REVENUE_RATE, revenueRate, tickets.isRevenue(revenueRate) ? REVENUE : DAMAGES));
        System.out.println(sb.toString());
    }

    private void append(String... args) {
        for (String arg : args) {
            sb.append(arg)
                    .append(System.lineSeparator());
        }
    }

    private void clearStringBuilder() {
        sb.delete(0, sb.length());
    }
}
