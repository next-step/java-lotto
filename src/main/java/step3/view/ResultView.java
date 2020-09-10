package step3.view;

import step3.domain.LottoTicket;
import step3.domain.WinningType;
import step3.utils.Constant;

import java.util.List;

public class ResultView {

    public static void showLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + Constant.BOUGHT_N_LOTTO_TICKETS);
        lottoTickets.forEach(ticket -> System.out.println(ticket.getLottoNumbers()));
        System.out.println("");
    }

    public static void showWinningResult(List<WinningType> winningTypes) {

        int firstTypeCount = (int) winningTypes.stream().filter(winningType -> winningType == WinningType.FIRST).count();
        int secondTypeCount = (int) winningTypes.stream().filter(winningType -> winningType == WinningType.SECOND).count();
        int thirdTypeCount = (int) winningTypes.stream().filter(winningType -> winningType == WinningType.THIRD).count();
        int fourthTypeCount = (int) winningTypes.stream().filter(winningType -> winningType == WinningType.FOURTH).count();
        int fifthTypeCount = (int) winningTypes.stream().filter(winningType -> winningType == WinningType.FIFTH).count();

        System.out.println(Constant.COUNT_THREE + Constant.WINNING_RESULT_MESSAGE + Constant.PRIZE_WRAPPER(Constant.LOTTO_PRIZE_FIFTH) + Constant.UNIT_PRIZE + Constant.DASH + fifthTypeCount + Constant.UNIT_COUNT);
        System.out.println(Constant.COUNT_FOUR + Constant.WINNING_RESULT_MESSAGE + Constant.PRIZE_WRAPPER(Constant.LOTTO_PRIZE_FOURTH) + Constant.UNIT_PRIZE + Constant.DASH + fourthTypeCount + Constant.UNIT_COUNT);
        System.out.println(Constant.COUNT_FIVE + Constant.WINNING_RESULT_MESSAGE + Constant.PRIZE_WRAPPER(Constant.LOTTO_PRIZE_THIRD) + Constant.UNIT_PRIZE + Constant.DASH + thirdTypeCount + Constant.UNIT_COUNT);
        System.out.println(Constant.COUNT_FIVE + Constant.WINNING_RESULT_MESSAGE + Constant.BONUS_NUMBER_MESSAGE + Constant.PRIZE_WRAPPER(Constant.LOTTO_PRIZE_SECOND) + Constant.UNIT_PRIZE + Constant.DASH + secondTypeCount + Constant.UNIT_COUNT);
        System.out.println(Constant.COUNT_SIX + Constant.WINNING_RESULT_MESSAGE + Constant.PRIZE_WRAPPER(Constant.LOTTO_PRIZE_FIRST) + Constant.UNIT_PRIZE + Constant.DASH + firstTypeCount + Constant.UNIT_COUNT);

    }

    public static void showProfit(double profit) {
        System.out.println(Constant.PROFIT_RATIO + profit);
    }

    public static void startStatistics() {
        System.out.println("");
        System.out.println(Constant.WINNING_STATISTICS);
        System.out.println(Constant.WINNING_STATISTICS_DIVISION);
    }

}
