package study.step3.view;

import study.step3.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매하셨습니다.";
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";
    private static final String STRING_BONUS = ", 보너스 볼 일치";
    private static final String STRING_EMPTY = "";

    private final LottoTickets lottoTickets;

    public ResultView(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void printLottoTicketInfos() {
        List<LottoTicket> tickets = lottoTickets.readOnlyLottoTicket();
        System.out.println(lottoTickets.lottoQuantity() + BUY_QUANTITY_MESSAGE);
        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.readOnlyLottoNumber().toString()));
    }

    public void printLottoRanksInfos(LottoWinners lottoWinners) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        Arrays.asList(LottoRank.values())
                .stream()
                .forEach(lottoRank -> printLottoRank(lottoRank, lottoWinners));
    }

    public void printLottoYield(LottoTickets lottoTickets, LottoWinners lottoWinners) {
        double yield = LottoYield.operationYield(lottoTickets, lottoWinners);
        System.out.println("총 수익률을 " + String.format("%.2f", yield) + "입니다. (기준이 1이기 때문에 결과적으로 " + LottoYield.stringYield(yield) + "라는 의미임)");
    }

    private void printLottoRank(LottoRank lottoRank, LottoWinners lottoWinners) {
        if (lottoRank.countOfMatch != 0) {
            System.out.println(lottoRank.countOfMatch + "개 일치 " + bonusOfString(lottoRank) + "(" + lottoRank.winningMoney + ") - " + lottoRank.winnerCount(lottoTickets.readOnlyLottoTicket(), lottoWinners) + "개");
        }
    }

    private String bonusOfString(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return STRING_BONUS;
        }
        return STRING_EMPTY;
    }
}
