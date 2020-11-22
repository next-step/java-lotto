package view;

import domain.LottoPrize;
import domain.Lottos;

import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private final String DISPLAY_QUANTITY = "%s개를 구매했습니다.";
    private final String RESULT_STATISTIC = "당첨 통계";
    private final String HORIZONTAL = "---------";
    private final String STATISTIC_MENTION = "%d개 일치 (%d원)- %d개";
    private final String PROFIT_MENTION = "총 수익률은 %.2f입니다.";
    private final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private final int PRIZE_BEGINNING = 3;
    private final int PRIZE_ENDING = 7;
    private final int PROFIT_STANDARD = 1;

    public void displayLottoQuantity(int quantity) {
        System.out.println(String.format(DISPLAY_QUANTITY, quantity));
    }

    public void displayLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(lotto -> System.out.println(lotto.getLottoNumbers().getNumbers()));
        System.out.println();
    }

    public void displayResultMention() {
        System.out.println();
        System.out.println(RESULT_STATISTIC);
        System.out.println(HORIZONTAL);
    }

    public void displayStatistic(Map<Integer, Integer> lottoStatistics) {
        IntStream.range(PRIZE_BEGINNING, PRIZE_ENDING)
                .forEach(key -> System.out.println(
                        String.format(STATISTIC_MENTION,
                                key,
                                LottoPrize.valueOf(key),
                                lottoStatistics.get(key)
                        )));
    }

    public void displayProfit(double profit) {
        System.out.print(String.format(PROFIT_MENTION, profit));
        if(profit < PROFIT_STANDARD) {
            System.out.println(LOSS);
        }
    }
}
