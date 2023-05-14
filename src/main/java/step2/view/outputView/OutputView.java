package step2.view.outputView;

import step2.LottoGame;
import step2.LottoMatch;
import step2.Ticket;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResult(Map<Integer, Integer> winnerMap, double rate){
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoMatch lottoMatch : LottoMatch.values()){
            System.out.println(lottoMatch.getMatchCount() + "개 일치 (" + lottoMatch.getReward() + ")- "
                    + winnerMap.get(lottoMatch.getMatchCount()) + "개");
        }
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
    public static void printTickets(List<Ticket> tickets){
        printTicketCount(tickets.size());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getTicket());
        }
    }

    public static void printTicketCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }
}
