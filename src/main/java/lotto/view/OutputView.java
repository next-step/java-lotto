package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoWinning;
import lotto.domain.Lottos;

import java.util.Map;

public class OutputView {
    private static final String COUNT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_TITME_MESSAGE = "\n당첨 통계\n---------";
    private static final String LOTTO_LOSE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_WIN_MESSAGE = "(다시 로또 사러 고고)";

    public static void printPurchase(Lottos lottos) {
        printCountOfLotto(lottos);
        printLottos(lottos);
    }

    private static void printCountOfLotto(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + COUNT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottosResult(Lottos lottos) {
        System.out.println(RESULT_TITME_MESSAGE);
        Map<LottoWinning, Integer> winningStats = lottos.getLottosWinningStatus();

        for (LottoWinning status : LottoWinning.values()) {
            printWinningStatus(winningStats, status);
        }
        printLottosYield(lottos);
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    private static void printWinningStatus(Map<LottoWinning, Integer> winningStats, LottoWinning status) {
        if (status != LottoWinning.FAIL) {
            System.out.print(status.getWinningStatusStr());
            System.out.println(winningStats.getOrDefault(status, 0) + "개");
        }
    }

    private static void printLottosYield(Lottos lottos) {
        double yield = lottos.getMoney().getYield();
        String resultMessage = yield >= 1 ? LOTTO_WIN_MESSAGE : LOTTO_LOSE_MESSAGE;

        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다." + resultMessage);

    }
}
