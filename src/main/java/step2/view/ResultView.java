package step2.view;

import step2.domain.*;
import step2.exception.SingletonConstructorException;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String AVG_WINNING = "당첨 통계";
    private static final String DASHES = "---------";
    private static final String SAME_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String TOTAL_RATE = "총 수익률은 %.2f 입니다.\n";

    private ResultView() {
        throw new SingletonConstructorException();
    }

    public static void renderLottoCount(Ticket ticket) {
        System.out.println(ticket.ticketCount());
    }

    public static void renderLottoStatus(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> {
            System.out.println(lottoTicket.lottoTicket());
        });
    }

    public static void renderWinningResult(WinningResultInfo resultInfo) {
        System.out.println(AVG_WINNING);
        System.out.println(DASHES);

        Map<WinningCondition, WinningInfo> winningResultInfo = resultInfo.getWinningResultInfo();

        for (WinningInfo info : winningResultInfo.values()) {
            System.out.printf(SAME_RESULT, info.getMatchedCondition(), info.getWinningPrize(), info.getWinningCount());
        }
    }

    public static void renderWinningRate(WinningRate calculateRate) {
        System.out.printf(TOTAL_RATE, calculateRate.getWinningRate());
    }
}
