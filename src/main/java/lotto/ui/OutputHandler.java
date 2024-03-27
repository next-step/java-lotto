package lotto.ui;

import lotto.domian.LottoRank;
import lotto.domian.LottoResult;
import lotto.domian.LottoTickets;
import lotto.domian.PurchaseAmount;

import java.util.stream.Collectors;

public class OutputHandler {

    public OutputHandler() {}

    public void printWinnerNumber(String number){
        System.out.println(number);
    };

    public void printResultHeader(){
        System.out.println("당첨 통계");
        System.out.println("------------------");
    }

    public void printResult(LottoResult result){
        for(LottoRank rank: LottoRank.values()){
            int count = result.getResultCount(rank);
            if (rank.getMatchCount() > 0) {
                System.out.printf("%d개 일치 (%d원) - %d개\n",
                        rank.getMatchCount(), rank.getPrizeMoney(), count);
            }
        }
    }

    public void printEarningsRate(PurchaseAmount amount, long money){
        float rate = amount.calculateTotalProfitRate(money) ;
        if (rate % 1.0 == 0) {
            System.out.printf("총 수익률은 %.0f%% 입니다.\n", rate);
        } else {
            System.out.printf("총 수익률은 %.2f%% 입니다.\n", rate);
        }
    }

    public void printTickets(LottoTickets tickets){
        tickets.getLottoTickets()
                .forEach(ticket -> System.out.println(ticket.toString()));
    }
}
