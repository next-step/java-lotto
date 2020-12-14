package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoPrize;
import com.nextstep.lotto.domain.LottoTickets;
import com.nextstep.lotto.domain.Money;

public class OutputView {
    private static final String MONEY_INPUT_COMMENT = "구입금액을 입력해 주세요.";
    private static final String WINNING_TICKET_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String STATISTICS_HEADER = "당첨 통계\n" + "---------";
    private static final String BONUS_NUMBER_INPUT_COMMENT = "보너스 볼을 입력해 주세요.";
    private static final String STATIC_LOTTO_COUNT_INPUT_COMMENT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String STATIC_LOTTO_NUMBER_INPUT_COMMENT = "수동으로 구매할 번호를 입력해 주세요.";

    public static void printStaticLottoCountInput() {
        System.out.println(STATIC_LOTTO_COUNT_INPUT_COMMENT);
    }

    public static void printStaticLottoNumberInput() {
        System.out.println(STATIC_LOTTO_NUMBER_INPUT_COMMENT);
    }

    public static void printMoneyInput() {
        System.out.println(MONEY_INPUT_COMMENT);
    }

    public static void printHowManyLottoTickets(final int numberOfStaticLottoTickets, final Money remainMoney) {
        System.out.println(BoughtHistoryOutputView.getHowManyLottoTickets(numberOfStaticLottoTickets, remainMoney));
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

    public static void printBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT_COMMENT);
    }
}
