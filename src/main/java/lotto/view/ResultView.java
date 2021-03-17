package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.List;

public class ResultView {
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";

    public void printLottoTicketInfos(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.getLottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.getLottoNumber().toString()));
    }

    public void printLottoRanksInfos(List<LottoRank> readOnlyLottoRanks, int buyAmount) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        readOnlyLottoRanks.stream()
                .forEach(this::printLottoRank);

        printLottoYield(lottoYield(readOnlyLottoRanks, buyAmount));
    }

    public void printLottoYield(double lottoYield) {
        System.out.println("총 수익률은 " + lottoYield + "입니다.(기준이 1이기 때문에 결과적으로 " + printStringYield(lottoYield) + "라는 의미임)");
    }

    private String printStringYield(double lottoYield) {
        if (lottoYield >= 1) {
            return "이익";
        }

        return "손해";
    }

    public double lottoYield(List<LottoRank> readOnlyLottoRanks, int buyAmount) {
        int sumPrize = readOnlyLottoRanks.stream()
                .mapToInt(r -> r.getRank().rankPrizeSum(r.getWinnerCount()))
                .sum();

        return sumPrize / buyAmount;
    }

    public void printLottoRank(LottoRank lottoRank) {
        Rank rank = lottoRank.getRank();
        System.out.println(rank.getRankCount() + "개 일치 (" + rank.getPrize() + ") - " + lottoRank.getWinnerCount() + "개");
    }

}
