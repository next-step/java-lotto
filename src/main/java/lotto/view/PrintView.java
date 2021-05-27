package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.StringJoiner;

public class PrintView {

    private static final String MESSAGE_BUY_COUNT = "수동으로 %s장, 자동으로 %s개를 구매했습니다.\n";
    private static final String MESSAGE_MATCH = "%s개 일치 (%s원)- %s개\n";
    private static final String MESSAGE_MATCH_WITH_BONUS = "%s개 일치, 보너스 볼 일치(%s원)- %s개\n";
    private static final String MESSAGE_INCOME_RATE = "총 수익률은 %s입니다.";
    private static final String MESSAGE_LOSS_DESC = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final String MESSAGE_HEAD_LOTTO_STATISTICS = "당첨통계";
    private static final String MESSAGE_HEAD_LINE_SEPARATOR = "-----------";

    private static final String LOTTO_TICKET_DELIMITER = ",";
    private static final String LOTTO_TICKET_PREFIX = "[";
    private static final String LOTTO_TICKET_SUFFIX = "]";

    public void showStatusBuyTicket(LottoWallet lottoWallet) {
        List<LottoTicket> lottoTickets = lottoWallet.takeOutLottoTickets();
        System.out.printf(MESSAGE_BUY_COUNT, lottoWallet.getManualTicketCount(), lottoWallet.getAutoTicketCount());
        for (LottoTicket lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        StringJoiner lottoNumberJoiner = new StringJoiner(LOTTO_TICKET_DELIMITER, LOTTO_TICKET_PREFIX, LOTTO_TICKET_SUFFIX);

        for (LottoNumber lottoNumber : lottoTicket.getNumbers()) {
            int number = lottoNumber.value();
            lottoNumberJoiner.add(String.valueOf(number));
        }

        System.out.println(lottoNumberJoiner.toString());
    }

    public void showLottoResult(WinnerStatistics winnerStatistics) {
        showResultHeadLine();
        showResultBody(winnerStatistics);
    }

    private void showResultBody(WinnerStatistics winnerStatistics) {
        printBodyLine(LottoRank.FIFTH, winnerStatistics);
        printBodyLine(LottoRank.FOURTH, winnerStatistics);
        printBodyLine(LottoRank.THIRD, winnerStatistics);
        printBodyLine(LottoRank.SECOND, winnerStatistics);
        printBodyLine(LottoRank.FIRST, winnerStatistics);

        printRateLine(winnerStatistics);
    }

    private void printRateLine(WinnerStatistics winnerStatistics) {
        String incomeRateText = String.format(MESSAGE_INCOME_RATE, winnerStatistics.getIncomeRate());
        StringBuilder sb = new StringBuilder(incomeRateText);
        if (winnerStatistics.isLoss()) {
            sb.append(MESSAGE_LOSS_DESC);
        }

        System.out.println(sb.toString());
    }

    private void printBodyLine(LottoRank lottoRank, WinnerStatistics winnerStatistics) {
        String printMessage = MESSAGE_MATCH;

        if (lottoRank == LottoRank.SECOND) {
            printMessage = MESSAGE_MATCH_WITH_BONUS;
        }

        System.out.printf(printMessage, lottoRank.matchCount(), lottoRank.reward(), winnerStatistics.getNumberOfWinners(lottoRank));
    }

    private void showResultHeadLine() {
        System.out.println(MESSAGE_HEAD_LOTTO_STATISTICS);
        System.out.println(MESSAGE_HEAD_LINE_SEPARATOR);
    }

}
