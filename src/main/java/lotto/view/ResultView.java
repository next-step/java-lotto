package lotto.view;

import lotto.common.WinningType;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void printLottoTicketCount(int lottoTicketCount) {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    public void printLottoTickets(String lottoTicketsText) {
        System.out.println(lottoTicketsText);
    }

    public void printResultStatistics(int matchingCount, int matchingSum) {
        System.out.println(matchingCount + "개 일치 (" + WinningType.of(matchingCount).getPrize() + ")-"
                + matchingSum +"개");
    }

    public void printResultProfit(double profit) {
        System.out.print("총 수익률은 " + profit + "입니다.");
        if(profit < 1) {
            System.out.print("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
