package lotto.view;

import lotto.model.LottoAggregator;
import lotto.model.LottoRank;
import lotto.model.Lottos;

import java.util.Arrays;

public class ResultView {

    static final String RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    static final String RESULT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %f 입니다.";

    public static void printPickedLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResult(LottoAggregator lottoAggregator) {
        System.out.println("당첨 통계");
        System.out.println("---------------");

        Arrays.asList(LottoRank.values()).stream()
                .forEach(level -> printEachMessage(level, lottoAggregator));

        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, lottoAggregator.getRateOfReturn()));
    }

    private static void printEachMessage(LottoRank level, LottoAggregator lottoAggregator) {
        String message = String.format(checkBonusMessage(level.isBonus()),
                level.getMatchCount(),
                level.getPrizeMoney(),
                lottoAggregator.get(level)
        );
        System.out.println(message);
    }

    private static String checkBonusMessage(boolean isbonus) {
        if(isbonus) {
            return RESULT_BONUS_MESSAGE;
        }
        return RESULT_MESSAGE;
    }
}
