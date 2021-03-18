package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoRank;

import java.util.List;

public class ResultView {
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";

    public void printLottoTicketInfos(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.lottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.lottoNumber().toString()));
    }

    public void printLottoRanksInfos(List<LottoRank> readOnlyLottoLottoRanks, int buyAmount) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        readOnlyLottoLottoRanks.stream()
                .forEach(this::printLottoRank);

        printLottoYield(lottoYield(readOnlyLottoLottoRanks, buyAmount));
    }

    public void printLottoYield(double lottoYield) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoYield) + "입니다.(기준이 1이기 때문에 결과적으로 " + printStringYield(lottoYield) + "라는 의미임)");
    }

    private String printStringYield(double lottoYield) {
        if (lottoYield >= 1) {
            return "이익";
        }

        return "손해";
    }

    public double lottoYield(List<LottoRank> readOnlyLottoLottoRanks, int buyAmount) {
        double sumPrize = readOnlyLottoLottoRanks.stream()
                .mapToInt(lottoRank -> lottoRank.rankPrizeSum())
                .sum();

        return sumPrize / buyAmount;
    }

    public void printLottoRank(LottoRank lottoRank) {
        System.out.println(lottoRank.rankCount() + "개 일치 (" + lottoRank.prize() + ") - " + lottoRank.winnerCount() + "개");
    }

}
