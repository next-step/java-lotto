package lotto.view;

import lotto.model.Money;
import lotto.model.RankResult;
import lotto.model.RankResults;

public class OutputView {

    private static final String RESULT_STRATEGY_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개\n";

    private static final String PROFIT_RATIO_MESSAGE_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final String TICKET_COUNT_MESSAGE_FORMAT = "%d개를 구매하였습니다.\n";

    private static final String WINNING_STRATEGY_MESSAGE = "당첨 통계";

    private static final String WINNING_SEPERATE_MESSAGE = "---------";


    public void printTicketCount(int ticketCount) {
        System.out.printf(TICKET_COUNT_MESSAGE_FORMAT, ticketCount);
    }

    public void printLottoResults(RankResults rankResults, Money principal) {
        printWinningNotification();
        printWinningResults(rankResults);
        System.out.printf(PROFIT_RATIO_MESSAGE_FORMAT, rankResults.calculateProfitRatio(principal));
    }

    private void printWinningResults(RankResults rankResults) {
        for (RankResult rankResult : rankResults.getRankResults()) {
            System.out.printf(RESULT_STRATEGY_MESSAGE_FORMAT,
                    rankResult.getRank().getMatchCount(),
                    rankResult.getRank().getAmount(),
                    rankResult.getCount());
        }
    }

    private void printWinningNotification() {
        System.out.println(WINNING_STRATEGY_MESSAGE);
        System.out.println(WINNING_SEPERATE_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}
