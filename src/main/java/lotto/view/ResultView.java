package lotto.view;

import lotto.dto.result.PurchasedLottos;
import lotto.dto.result.WinningStats;
import lotto.exception.NotSupportInstanceException;

public class ResultView {

    private static final String MESSAGE_PURCHASED_LOTTO = "개를 구매했습니다.";
    private static final String MESSAGE_WIN_RESULT = "당첨 통계";
    private static final String MESSAGE_SEPARATOR_LINE = "-----------";

    private ResultView() {
        throw new NotSupportInstanceException();
    }

    public static void purchasedLottosView(PurchasedLottos purchasedLottos) {
        System.out.println(purchasedLottos.lottos().count() + MESSAGE_PURCHASED_LOTTO);
        System.out.println(ResultBuilder.buildLottosInfo(purchasedLottos.lottos().toList()));
    }

    public static void lottosResultView(WinningStats winningStats) {
        System.out.println(MESSAGE_WIN_RESULT);
        System.out.println(MESSAGE_SEPARATOR_LINE);
        System.out.println(ResultBuilder.buildLottosResult(winningStats.matchStatsList()));
        System.out.println(ResultBuilder.buildLottosProfitRate(winningStats.profitRate()));
    }
}
