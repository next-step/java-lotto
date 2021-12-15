package step2.view;

import step2.domain.*;
import step2.domain.WinningCondition;
import step2.domain.WinningInfo;
import step2.dto.WinningRate;
import step2.exception.NotInstanceException;

import java.util.Map;

public class ResultView {
    private static final String ANSWER_BUY_COUNT = "%d개를 구매했습니다.\n\n";
    private static final String AVERAGE_WINNING = "당첨 통계";
    private static final String DASHES = "---------";
    private static final String SAME_RESULT = "%d개 일치 (%d원)- %d개\n";
    private static final String TOTAL_RATE = "총 수익률은 %.2f 입니다. ";
    private static final String RATE_LOW_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
        throw new NotInstanceException();
    }

    public static void renderLottoStatus(LottoTickets lottoTickets) {
        lottoTickets.lottoTickets().forEach(lottoTicket -> {
            System.out.println(lottoTicket.lottoTicket());
        });

        System.out.printf(ANSWER_BUY_COUNT, lottoTickets.lottoTicketsCount());
    }

    public static void renderWinningResult(WinningResultInfo resultInfo) {
        System.out.println(AVERAGE_WINNING);
        System.out.println(DASHES);

        Map<WinningCondition, WinningInfo> winningResultInfo = resultInfo.getWinningResultInfo();

        winningResultInfo.keySet()
                .forEach(condition -> {
                    if(condition != WinningCondition.WIN_NONE) {
                        System.out.printf(SAME_RESULT, condition.getMatchedCondition(),
                                condition.getWinningPrize(),
                                resultInfo.getWinningResultInfo().get(condition).getWinningCount());
        }});
    }

    public static void renderWinningRate(WinningRate calculateRate, boolean lessThanBase) {
        System.out.printf(TOTAL_RATE, calculateRate.getWinningRate());

        if (lessThanBase) {
            System.out.println(RATE_LOW_MESSAGE);
        }
    }
}
