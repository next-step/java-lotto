package lotto.view;

import lotto.domain.*;

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

    public void printLottoQuantity(LottoQuantity lottoQuantity) {
        System.out.println("수동으로 " + lottoQuantity.manualQuantity() + "장, 자동으로 "  + lottoQuantity.autoQuantity() + "개를 구매했습니다.");
    }

    public void printLottoTicketInfos() {
        List<LottoTicket> tickets = lottoTickets.readOnlyLottoTicket();

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
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.(기준이 1이기 때문에 결과적으로 " + LottoYield.stringYield(yield) + "라는 의미임)");
    }

    public void printLottoRank(LottoRank lottoRank, LottoWinners lottoWinners) {
        System.out.println(lottoRank.countOfMatch + "개 일치 " + bonusOfString(lottoRank) + "(" + lottoRank.winningMoney + ") - " + lottoRank.winnerCount(lottoTickets.readOnlyLottoTicket(), lottoWinners) + "개");
    }

    private String bonusOfString(LottoRank lottoRank) {
        if (LottoRank.SECOND == lottoRank) {
            return STRING_BONUS;
        }

        return STRING_EMPTY;
    }
}
