package lotto.view;

import lotto.Lotto;
import lotto.LottoResults;
import lotto.MatchedNumbers;

public class ResultView {

    private static final String QUANTITY_RESULT_MESSAGE = "개를 구입했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계\n----------";
    private static final String MATCHED_NUMBERS_MESSAGE = "개 일치 (";
    private static final String PRICE_MESSAGE = "원) - ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";

    public static void printQuantity(int quantity) {
        System.out.println(quantity + QUANTITY_RESULT_MESSAGE);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.lottoNumbers());
    }

    public static void printResult(LottoResults lottoResults, float profit) {
        System.out.println(LOTTO_RESULT_MESSAGE);

        for (MatchedNumbers matchedNumbers : lottoResults.values().keySet()) {
            System.out.println(matchedNumbers.value() + MATCHED_NUMBERS_MESSAGE
                    + matchedNumbers.price()  + PRICE_MESSAGE
                    + lottoResults.values().get(matchedNumbers) + COUNT_MESSAGE);
        }

        System.out.printf(PROFIT_MESSAGE, profit);
    }
}
