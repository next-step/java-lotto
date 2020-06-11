package step2.view;

import step2.LottoTicket;
import step2.Statistics;
import step2.WinningStatistics;
import step2.util.MathUtils;

import java.util.List;

public class ResultView {
    private static final int LOTTO_PRICE = 1000;
    private int lottoTicketCount;
    private ResultView() {
    }

    public ResultView(List<LottoTicket> lottoTicketList){
        this.lottoTicketCount = lottoTicketList.size();
        printMessage(lottoTicketCount + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketList) {
            printMessage(lottoTicket.getNumbers().toString());
        }
    }

    public void printResult(Statistics statistics) {
        printMessage("당첨 통계");
        printMessage("----------");

        printStatistics(statistics);

        double yield = MathUtils.calculateYield(statistics.getTotalPrice(), lottoTicketCount * LOTTO_PRICE);
        yield = MathUtils.floorDecimal(yield, 2);
        String message = "총 수익률은 " + yield + "입니다.";
        if (yield < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        printMessage(message);

    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private void printStatistics(Statistics result) {
        result.getStatistics().forEach((key, value) -> {
            WinningStatistics winning = WinningStatistics.valueOfWinningCount(key);
            String message = winning.getMatchedNumberCount() + "개 일치 (" + winning.getWinningPrice() + "원)- " + value +"개";
            printMessage(message);
        });
    }
}
