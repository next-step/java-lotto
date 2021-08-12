package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import java.util.Map;

public class OutputView {
    private static final String COUNT_PURCHASE_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String WINNING_STATUS_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String FINAL_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_YIELD_LOSE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String LOTTO_YIELD_WIN_MESSAGE = "(다시 로또 사러 고고)";

    public static void printPurchase(Lottos lottos) {
        printCountOfLotto(lottos);
        printLottos(lottos);
    }

    private static void printCountOfLotto(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + COUNT_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottosResult(Lottos lottos) {
        System.out.println(WINNING_RESULT_MESSAGE);
        Map<LottoResult, Integer> winningStats = lottos.getWinningStatus();

        for (LottoResult status : LottoResult.values()) {
            printWinningStatus(winningStats, status);
        }
        printLottosYield(lottos);
    }

    private static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

    private static void printWinningStatus(Map<LottoResult, Integer> winningStats, LottoResult status) {
        if (status != LottoResult.FAIL) {
            System.out.printf(WINNING_STATUS_MESSAGE, status.getMatchCount(), status.getReward(), winningStats.getOrDefault(status, 0));
        }
    }

    private static void printLottosYield(Lottos lottos) {
        double yield = LottoShop.getMoney().getYield();
        String resultMessage = yield >= 1 ? LOTTO_YIELD_WIN_MESSAGE : LOTTO_YIELD_LOSE_MESSAGE;
        System.out.printf(FINAL_YIELD_MESSAGE, yield);
        System.out.println(resultMessage);

    }
}
