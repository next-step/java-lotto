package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.Money;

public class OutputView {
    private static final String MONEY_INPUT_COMMENT = "구입금액을 입력해 주세요.";
    private static final String WINNING_TICKET_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "당첨 통계\n" + "---------";

    public static void printMoneyInput() {
        System.out.println(MONEY_INPUT_COMMENT);
    }

    public static void printWinningTicketInput() {
        System.out.println(WINNING_TICKET_COMMENT);
    }

    public static void printStatistics(Money money, LottoPrize lottoPrize) {
        System.out.println(STATISTICS_HEADER);
        StatisticsOutputView.parseLottoPrize(lottoPrize);
        StatisticsOutputView.parseProfit(money, lottoPrize);
    }
}
