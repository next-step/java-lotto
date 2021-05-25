package lotto.view;

import lotto.common.WinningType;

import java.util.Arrays;
import java.util.Map;

public class ResultView {
    private static final String LOTTO_TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String STATISTICS_TITLE_MESSAGE = "\n당첨 통계\n---------";
    private static final String SECOND_STATISTICS_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String MINUS_PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final int PROFIT_STANDARD = 1;
    private static final int MIN_PROFIT_MATCHING_COUNT = 3;

    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.println(lottoTicketCount + LOTTO_TICKET_COUNT_MESSAGE);
    }

    public void printLottoTickets(String lottoTicketsText) {
        System.out.println(lottoTicketsText);
    }

    public void printResultStatistics(Map<WinningType, Integer> gameResult) {
        System.out.println(STATISTICS_TITLE_MESSAGE);

        for(WinningType winningType : gameResult.keySet()) {
            printResultStatistics(winningType, gameResult.get(winningType));
        }
    }

    private void printResultStatistics(WinningType winningType, int value) {
        if(winningType == WinningType.SECOND) {
            System.out.printf(SECOND_STATISTICS_MESSAGE, winningType.getMatchCount(), winningType.getPrize(), value);
        }

        if((winningType != WinningType.SECOND) && (winningType.getMatchCount() >= MIN_PROFIT_MATCHING_COUNT)) {
            System.out.printf(STATISTICS_MESSAGE, winningType.getMatchCount(), winningType.getPrize(), value);
        }
    }

    public void printResultProfit(double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
        if(profit < PROFIT_STANDARD) {
            System.out.print(MINUS_PROFIT_MESSAGE);
        }
    }
}
