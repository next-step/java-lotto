package step2.view;

import step2.LottoTicket;
import step2.Statistics;
import step2.WinningStatistics;
import step2.Yield;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private List<LottoTicket> lottoTicketList = new ArrayList<>();

    private ResultView() {
    }

    public ResultView(List<LottoTicket> lottoTicketList){
        this.lottoTicketList = lottoTicketList;
        printMessage(lottoTicketList.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketList) {
            printMessage(lottoTicket.getNumbers().toString());
        }
    }

    public void printResult(Statistics result) {
        printMessage("당첨 통계");
        printMessage("----------");

        printStatistics(result);

        double yield = Yield.calculate(result.getTotalPrice(), lottoTicketList.size() * 1000);
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
            winning.print(value);
        });
    }
}
