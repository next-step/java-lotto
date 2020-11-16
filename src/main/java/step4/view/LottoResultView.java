package step4.view;

import step4.lotto.firstcollection.LottoTickets;
import step4.lotto.firstcollection.WinningResults;
import step4.type.WinningType;

public class LottoResultView implements ResultView {
    private static final String PURCHASED_COUNT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String MATCHED_WINNING_FORMAT = "%d개 %s - %d개";
    private static final String MATCHED_WINNING_COUNT = "일치(%d원)";
    private static final String MATCHED_WINNING_COUNT_BONUS = "일치, 보너스 볼 일치(%d원)";
    private static final String ALERT_REVENUE_RATE = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String REVENUE = "이득";
    private static final String DAMAGES = "손해";
    private static final String HORIZONTAL_DELIMITER = "---------";
    private static final int LOTTO_BONUS_MATCH_NUMBER = 5;
    private static final StringBuilder sb = new StringBuilder();

    @Override
    public void drawTicket(LottoTickets tickets) {
        clearStringBuilder();
        append(String.format(PURCHASED_COUNT, tickets.countTicket()), tickets.toString());
        System.out.println(sb.toString());
    }

    @Override
    public void drawWinningStatistics(WinningResults winningResults) {
        clearStringBuilder();

        append(WINNING_STATISTICS, HORIZONTAL_DELIMITER);
        winningResults.forEach(this::appendWinningRow);

        System.out.println(sb.toString());
    }

    private void appendWinningRow(WinningType type, int count) {
        String matchMessage = getMatchMessage(type);
        append(String.format(MATCHED_WINNING_FORMAT,
                getMatchCountMessage(type),
                matchMessage,
                count));
    }

    private int getMatchCountMessage(WinningType type) {
        return type.equals(WinningType.RANK_TWO_BONUS)
                ? LOTTO_BONUS_MATCH_NUMBER
                : WinningType.getMatchCount(type);
    }

    private String getMatchMessage(WinningType type) {
        if (type.equals(WinningType.RANK_TWO_BONUS)) {
            return String.format(MATCHED_WINNING_COUNT_BONUS, WinningType.getWinningAmount(type));
        }
        return String.format(MATCHED_WINNING_COUNT, WinningType.getWinningAmount(type));
    }

    @Override
    public void drawRevenueRate(double revenueRate, boolean isRevenue) {
        clearStringBuilder();

        append(String.format(ALERT_REVENUE_RATE, revenueRate, isRevenue ? REVENUE : DAMAGES));

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
