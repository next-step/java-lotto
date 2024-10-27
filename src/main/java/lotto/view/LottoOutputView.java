package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoPrizeCalculator;

import java.util.List;

public class LottoOutputView {

    public static void printPurchaseInfo(List<Lotto> purchaseList) {
        System.out.println(purchaseList.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchaseList) {
            System.out.println("[" + getPurchaseInfoToString(lotto) + "]");
        }
        System.out.println();
    }

    private static String getPurchaseInfoToString(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(lotto.getNumberByIndex(0).toString());

        for (int i = 1; i < 6; i++) {
            sb.append(", " + lotto.getNumberByIndex(i).toString());
        }

        return sb.toString();
    }

    public static void printResultInfo(LottoChecker lottoChecker) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3; i < 7; i++) {
            System.out.println(i + "개 일치 (" + LottoPrizeCalculator.getPrizeByIndex(i) + "원)-" + lottoChecker.getWinnerCount(i) + "개");
        }
        System.out.println("총 수익률은 " + LottoPrizeCalculator.calculateRateOfReturn(lottoChecker) + "입니다.");
    }
}
