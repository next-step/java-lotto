package step3.view;

import step3.LottoTicket;
import step3.Statistics;
import step3.WinningStatistics;
import step3.util.MathUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {
    private static final int LOTTO_PRICE = 1000;
    List<LottoTicket> lottoTicketList;

    public ResultView(List<LottoTicket> lottoTicketList){
        this.lottoTicketList = lottoTicketList;
        printMessage(lottoTicketList.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketList) {
            printMessage(lottoTicket.getNumbers().toString());
        }
    }

    public void printResult(Statistics statistics) {
        printMessage("당첨 통계");
        printMessage("----------");

        printStatistics(statistics);

        double yield = statistics.calculateYield(lottoTicketList.size());

        String message = "총 수익률은 " + MathUtils.floorDecimal(yield, 2) + "입니다.";
        if (yield < 1) {
            message += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }
        printMessage(message);

    }

    private void printStatistics(Statistics result) {
        Map<WinningStatistics, Integer> resultMap = result.getStatistics();
        Arrays.stream(WinningStatistics.values()).
                filter(e -> e.getMatchedNumberCount() > 0).
                sorted(Comparator.comparingInt(WinningStatistics::getMatchedNumberCount)).
                forEach(key -> {
                    String message = key.getMatchedNumberCount() + "개 일치 (" + key.getWinningMoney() + "원)- " + resultMap.get(key) + "개";
                    printMessage(message);
                });
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
