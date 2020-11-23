package view;

import domain.LottoPrize;
import domain.Lottos;

import java.util.Map;
import java.util.stream.IntStream;

import static domain.LottoStandard.*;

public class ResultView {
    private final String DISPLAY_QUANTITY = "%s개를 구매했습니다.";
    private final String RESULT_STATISTIC = "당첨 통계";
    private final String HORIZONTAL = "---------";
    private final String STATISTIC_MENTION = "%d개 일치 (%d원)- %d개";
    private final String STATISTIC_MENTION_SECOND = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private final String PROFIT_MENTION = "총 수익률은 %.2f입니다.";
    private final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

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
        int matchBeginning = MATCH_BEGINNING.getStandardNumber();
        int matchEnding = MATCH_ENDING.getStandardNumber();

        IntStream.range(matchBeginning, matchEnding)
                .map(i -> matchEnding - i + matchBeginning - 1)
                .forEach(key -> {
                    if (key == LottoPrize.SECOND.getPrize()) {
                        System.out.println(
                                String.format(STATISTIC_MENTION_SECOND,
                                        LottoPrize.valueOf(key).get(0),
                                        LottoPrize.valueOf(key).get(1),
                                        lottoStatistics.get(key)
                                ));
                    } else {
                        System.out.println(
                                String.format(STATISTIC_MENTION,
                                        LottoPrize.valueOf(key).get(0),
                                        LottoPrize.valueOf(key).get(1),
                                        lottoStatistics.get(key)
                                ));
                    }
                });
    }

    public void displayProfit(double profit) {
        System.out.print(String.format(PROFIT_MENTION, profit));
        if(profit < PROFIT_STANDARD.getStandardNumber()) {
            System.out.println(LOSS);
        }
    }
}
