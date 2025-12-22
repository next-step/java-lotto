package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;

public class ResultView {
    private static final String LOTTO_COUNT_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_MESSSAGE = "당첨 통계\n-------";
    private static final String LOTTO_COUNT_RESULT = "수동으로 %s장, 자동으로 %s장을 구매했습니다.\n";

    private static void printLottoCount(String lottoCount) {
        System.out.printf(LOTTO_COUNT_MESSAGE, lottoCount);
    }

    private static void printLottoNumbersList(String lottoList) {
        System.out.println(lottoList);
    }

    public static void printLotto(LottoCount manualCount, LottoCount autoCount, Lotto lotto) {
        printLottoCount(String.format(LOTTO_COUNT_RESULT, manualCount, autoCount));
        printLottoNumbersList(lotto.toString());
    }

    public static void printLottoResult(String lottoResult) {
        System.out.println(LOTTO_RESULT_MESSSAGE);
        System.out.println(lottoResult);
    }

    public static void printProfit(String profit) {
        System.out.printf("총 수익률은 %s입니다.", profit);
    }

    public static void printError(String errorMessage) {
        System.out.printf(String.format("Error :  " + errorMessage));
    }
}
