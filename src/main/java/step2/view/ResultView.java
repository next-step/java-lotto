package step2.view;

import step2.domain.LottoTicket;
import step2.domain.Winner;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        List<Integer> lottoNums = lottoTicket.getLottoNums();

        System.out.println(String.join(",", String.valueOf(lottoNums)));
    }

    public void printWinnerStatistics(Winner winner) {
        System.out.println("\n당첨통계");
        System.out.println("---------");

        printStatistics(winner);
    }

    public void printStatistics(Winner winner) {
        Map<Integer, Integer> countOfRanks = winner.getCountOfRanks();

        System.out.println("3개 일치 (5000원)- " + countOfRanks.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50000원)- " + countOfRanks.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1500000원)- " + countOfRanks.getOrDefault(5, 0) + "개");
        System.out.println("6개 일치 (2000000000원)- " + countOfRanks.getOrDefault(6, 0) + "개");

        System.out.println("총 수익률은 " + winner.getProfit() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
