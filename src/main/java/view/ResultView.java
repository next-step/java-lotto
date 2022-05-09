package view;

import domain.LottoTicket;
import domain.WinStatistic;

import java.util.List;

public class ResultView {

    public void printAllLottoNumbers(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public void printWinResult(List<WinStatistic> statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (WinStatistic statistic : statistics) {
            System.out.println(statistic.getMatchingNumber()
                    + "개 일치 (" + statistic.getAmount() + "원) - "
                    + statistic.getCount() + "개");
        }
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
