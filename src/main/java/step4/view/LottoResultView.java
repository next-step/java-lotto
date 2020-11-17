package step4.view;

import step4.domain.lotto.firstcollection.LottoTickets;
import step4.domain.lotto.firstcollection.WinningResults;
import step4.type.LottoType;
import step4.type.WinningType;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static step4.domain.lotto.firstcollection.WinningResults.DECIMAL_POINT_TWO_FIXED;
import static step4.domain.lotto.firstcollection.WinningResults.REVENUE_ANCHOR_POINT;

public class LottoResultView implements ResultView {
    private static final String PURCHASED_COUNT = "%s을 구매했습니다.";
    private static final String PURCHASED_MANUAL_COUNT = "수동으로 %d장";
    private static final String PURCHASED_AUTO_COUNT = "자동으로 %d장";

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
    public static final String DELIMITER = ", ";
    public static final int TICKET_MINIMUM_LIMIT = 0;

    @Override
    public void drawTicket(LottoTickets tickets) {
        clearStringBuilder();

        String purchasedCount = makePurchasedAlertMessage(tickets);

        append(purchasedCount, tickets.toString());
        System.out.println(sb.toString());
    }

    private String makePurchasedAlertMessage(LottoTickets tickets) {
        List<String> countStrings = new ArrayList<>();
        long manualSize = tickets.countTicketByLottoType(LottoType.MANUAL);
        long autoSize = tickets.countTicketByLottoType(LottoType.AUTO);
        if (manualSize > TICKET_MINIMUM_LIMIT) {
            countStrings.add(format(PURCHASED_MANUAL_COUNT, manualSize));
        }
        if (autoSize > TICKET_MINIMUM_LIMIT) {
            countStrings.add(format(PURCHASED_AUTO_COUNT, autoSize));
        }

        return format(PURCHASED_COUNT, String.join(DELIMITER, countStrings));
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
        append(format(MATCHED_WINNING_FORMAT,
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
            return format(MATCHED_WINNING_COUNT_BONUS, WinningType.getWinningAmount(type));
        }
        return format(MATCHED_WINNING_COUNT, WinningType.getWinningAmount(type));
    }

    @Override
    public void drawRevenueRate(LottoTickets tickets, WinningResults winningResults) {
        clearStringBuilder();

        Long winningAmount = winningResults.getWinningAmount();
        double expenses = tickets.getExpenses();
        double revenueRate = Math.round((winningAmount / expenses) * DECIMAL_POINT_TWO_FIXED / DECIMAL_POINT_TWO_FIXED);

        append(format(ALERT_REVENUE_RATE, revenueRate, revenueRate > REVENUE_ANCHOR_POINT ? REVENUE : DAMAGES));

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
