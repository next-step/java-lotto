package lottery.view;

import lottery.LottoResults;
import lottery.domain.LottoTickets;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        int numberOfTickers = lottoTickets.size();
        System.out.println(numberOfTickers + "개를 구매했습니다.");

        System.out.println(lottoTickets.toString() + "\n");
    }

    public static void printLottoResults(LottoResults results) {
        System.out.println(results.toString());
        System.out.printf("총 수익률은 %.2f 입니다.", results.getEarningRate());
    }
}
