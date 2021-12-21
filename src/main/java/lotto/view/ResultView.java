package lotto.view;

import lotto.lotto.Lottos;
import lotto.result.LottoResults;
import lotto.result.MatchedNumbersCount;

public class ResultView {

    private static final String QUANTITY_RESULT_MESSAGE = "개를 구입했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n----------";
    private static final String MATCHED_NUMBERS_MESSAGE = "개 일치 (";
    private static final String PRICE_MESSAGE = "원) - ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.quantity() + QUANTITY_RESULT_MESSAGE);
        lottos.values().forEach(lotto -> System.out.println(lotto.lottoNumbers()));
    }

    public static void printResult(LottoResults lottoResults) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        StringBuilder stringBuilder = new StringBuilder();

        for (MatchedNumbersCount matchedNumbersCount : lottoResults.values().keySet()) {
            stringBuilder.append(matchedNumbersCount.value())
                    .append(MATCHED_NUMBERS_MESSAGE)
                    .append(matchedNumbersCount.price())
                    .append(PRICE_MESSAGE)
                    .append(lottoResults.values().get(matchedNumbersCount))
                    .append(COUNT_MESSAGE)
                    .append("\n");
        }

        System.out.println(stringBuilder);
        System.out.printf(PROFIT_MESSAGE, lottoResults.profit());
    }
}
