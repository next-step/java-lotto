package lottogame.view;

import lottogame.domain.LottoTicket;
import lottogame.domain.LottoNumberPackage;
import lottogame.domain.LottoResult;
import lottogame.domain.PurchaseCount;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ConsoleResultView {
    private static final String WINNING_RESULT_TITLE = "\n당첨 통계\n----------";
    public static final String BONUS_BALL_MATCHED = "보너스 볼 일치";

    public static void showPurchaseResult(LottoTicket lottoTicket) {
        showPurchaseResultTitle(lottoTicket.getPurchaseCount());
        showPurchasedLottoNumbers(lottoTicket.getGameNumbers());
    }

    private static void showPurchaseResultTitle(PurchaseCount purchaseCount) {
        System.out.println(
            String.format("\n수동으로 %d장, 자동으로 %d장을 구매했습니다.",
                purchaseCount.getManualCount(), purchaseCount.getAutomaticCount()
            )
        );
    }

    private static void showPurchasedLottoNumbers(List<LottoNumberPackage> purchasedNumbers) {
        Optional.ofNullable(purchasedNumbers)
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
        for(String curResult : result.getWinningResultStrings()) {
            System.out.println(curResult);
        }
        System.out.println(result.getProfitRateString());
    }
}