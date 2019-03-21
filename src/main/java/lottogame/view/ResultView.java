package lottogame.view;

import lottogame.domain.LottoTicket;
import lottogame.domain.LottoNumberPackage;
import lottogame.domain.LottoResult;
import lottogame.domain.PurchaseCount;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ResultView {
    static final String PURCHASE_RESULT_TITLE = "개를 구매했습니다.";
    static final String WINNING_RESULT_TITLE = "\n당첨 통계\n----------";

    public static void showPurchasedResult(LottoTicket lottoGame) {
        showPurchaseResultTitle(lottoGame.getPurchaseCount());
        showPurchasedLottoNumbers(lottoGame.getAutomaticNumbers());
    }

    static void showPurchaseResultTitle(PurchaseCount purchaseCount) {
        System.out.println("\n" + purchaseCount.getValue() + PURCHASE_RESULT_TITLE);
    }

    private static void showPurchasedLottoNumbers(List<LottoNumberPackage> purchasedLottoNumbers) {
        Optional.ofNullable(purchasedLottoNumbers)
                .orElse(Collections.emptyList())
                .forEach(System.out::println);
    }

    public static void showWinningResult(LottoResult result) {
        showWinningResultTitle();
        showWinningStatistics(result);
    }

    private static void showWinningResultTitle() {
        System.out.println(WINNING_RESULT_TITLE);
    }

    private static void showWinningStatistics(LottoResult result) {
        System.out.println(result.getWinningResultString());
        System.out.println(result.getProfitRateString());
    }
}