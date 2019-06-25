package lotto.view;

import lotto.model.LottoResult;
import lotto.model.LottoLevels;
import lotto.model.Lottos;

import java.util.Arrays;

public class ResultView {

    static final String RESULT_MESSAGE = "%d개 일치 (%d원) - %d개";
    static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %f 입니다.";

    public static void printPickedLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------------");

        Arrays.asList(LottoLevels.values()).stream()
                .forEach(level -> printEachMessage(level, lottoResult));
        System.out.println(String.format(RATE_OF_RETURN_MESSAGE, lottoResult.getRateOfReturn()));
    }

    private static void printEachMessage(LottoLevels level, LottoResult lottoResult) {
        String message = String.format(RESULT_MESSAGE,
                level.getMatchCount(),
                level.getPrizeMoney(),
                lottoResult.get(level)
        );
        System.out.println(message);
    }
}
