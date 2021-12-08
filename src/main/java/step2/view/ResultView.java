package step2.view;

import step2.domain.*;
import step2.domain.WinningCondition;
import step2.dto.WinningInfo;
import step2.dto.WinningRate;
import step2.exception.NotInstanceException;

import java.util.Map;

public class ResultView {
    private static final String ANS_BUY_COUNT = "%d개를 구매했습니다.\n\n";
    private static final String AVG_WINNING = "당첨 통계";
    private static final String DASHES = "---------";
    private static final String SAME_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String TOTAL_RATE = "총 수익률은 %.2f 입니다.\n";

    private ResultView() {
        throw new NotInstanceException();
    }

    public static void renderLottoStatus(LottoTickets lottoTickets) {
        lottoTickets.lottoTickets().forEach(lottoTicket -> {
            System.out.println(lottoTicket.lottoTicket());
        });

        System.out.printf(ANS_BUY_COUNT, lottoTickets.lottoTicketsCount());
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
