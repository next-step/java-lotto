package lotto;

import java.util.List;

public class ResultView {
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String HYPHENS = "---------";
    private static final String CORRECT = "개 일치";
    private static final String TOTAL_YIELD = "총 수익률은";
    private static final String COUNT = "개";

    public void printLottoNumbers(List<LottoTicket> tickets) {
        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).getLottoTicket());
        }
    }

    public void printStatisticsIntroduction() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(HYPHENS);
    }
    public void printStatisticsResult(int winningPoint, int money, int count) {
        System.out.printf("%d" + CORRECT + "(%d)- %d" + COUNT +"%n",winningPoint, money, count);
    }

    public void printTotalYield(double yield) {
        System.out.printf(TOTAL_YIELD + " %.2f 입니다.", Math.floor(yield*100)/100.0);
    }
}
