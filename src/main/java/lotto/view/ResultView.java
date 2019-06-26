package lotto.view;

import lotto.model.LottoAggregator;
import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.Order;

import java.util.Arrays;

public class ResultView {

    static final String COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    static final String RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    static final String RESULT_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %f 입니다.";

    public static void printPickedLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printBuyLottoCount(Order order) {
        System.out.println(String.format(COUNT_MESSAGE, order.getHandPickCount(), order.getAutoPickCount()));
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

    private static String checkBonusMessage(boolean isBonus) {
        if (isBonus) {
            return RESULT_BONUS_MESSAGE;
        }
        return RESULT_MESSAGE;
    }
}
