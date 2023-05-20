package step2.view.outputView;

import step2.LottoGame;
import step2.LottoMatch;
import step2.Ticket;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printResult(Map<Double, Integer> winnerMap, double rate){
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoMatch lottoMatch : LottoMatch.values()){
            String resultText = (int)lottoMatch.getMatchCount() + "개 일치";
            resultText += addBonusText(lottoMatch.getMatchCount());
            resultText += " (" + lottoMatch.getReward() + ")- " + winnerMap.get(lottoMatch.getMatchCount()) + "개";
            System.out.println(resultText);
        }
        System.out.println("총 수익률은 " + rate + "입니다.");
    }

    private static String addBonusText(double matchCount) {
        String text = "";
        if(matchCount == 5.5){
            text = ", 보너스 볼 일치";
        }
        return text;
    }

    public static void printTickets(List<Ticket> tickets){
        printTicketCount(tickets.size());
        for (Ticket ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printTicketCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }
}
