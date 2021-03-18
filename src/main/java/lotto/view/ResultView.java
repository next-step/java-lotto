package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;
import lotto.domain.LottoYield;

import java.util.List;

public class ResultView {
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";

    public void printLottoTicketInfos(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.lottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.lottoNumber().toString()));
    }

    public void printLottoRanksInfos(List<LottoRank> readOnlyLottoLottoRanks, LottoYield lottoYield) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        readOnlyLottoLottoRanks.stream()
                .forEach(this::printLottoRank);

        printLottoYield(lottoYield);
    }

    public void printLottoYield(LottoYield lottoYield) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoYield.yield()) + "입니다.(기준이 1이기 때문에 결과적으로 " + lottoYield.stringYield() + "라는 의미임)");
    }
    public void printLottoRank(LottoRank lottoRank) {
        System.out.println(lottoRank.rankCount() + "개 일치 (" + lottoRank.prize() + ") - " + lottoRank.winnerCount() + "개");
    }

}
