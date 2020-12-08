package lotto.view;

import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public class OutputView {
    private static final String MONEY_INPUT_COMMENT = "구입금액을 입력해 주세요.";
    private static final String WINNING_TICKET_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "당첨 통계\n" + "---------";

    public static void printMoneyInput() {
        System.out.println(MONEY_INPUT_COMMENT);
    }

    public static void printHowManyLottoTickets(final Money money) {
        System.out.println(BoughtHistoryOutputView.getHowManyLottoTickets(money));
    }

    public static void printBoughtLottoTickets(final LottoTickets lottoTickets) {
        System.out.println(BoughtHistoryOutputView.parseLottoTickets(lottoTickets));
    }

    public static void printWinningTicketInput() {
        System.out.println(WINNING_TICKET_COMMENT);
    }

    public static void printStatistics(final Money money, final LottoPrize lottoPrize) {
        System.out.println(STATISTICS_HEADER);
        String prizeResult = StatisticsOutputView.parseLottoPrize(lottoPrize);
        System.out.println(prizeResult);
        String profitRate = StatisticsOutputView.parseProfit(money, lottoPrize);
        System.out.println(profitRate);
    }
}
