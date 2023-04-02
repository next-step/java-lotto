package rankingtwolotto.view;

import rankingtwolotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final int LOTTO_PRICE = 1000;
    private static final String RESULT_TITLE = "당첨 통계\n" + "---------";
    private static final String[] LOTTO_RESULT_SAME = {"3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000원) - ", "5개 일치, 보너스 볼 일치(30000000원) - ", "6개 일치 (2000000000원) - "};
    private static final String TOTAL_REWARD = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임))";

    public static int purchaseLottoNum(int purchaseAmount) {
        int purchaseLottoNum = purchaseAmount / LOTTO_PRICE;
        System.out.println(purchaseLottoNum + "개를 구매했습니다.");
        return purchaseLottoNum;
    }

    public static void showPurchaseLottos(Lotto purchaseLotto) {
        System.out.println(purchaseLotto.toString(purchaseLotto));
    }

    public static void announcementWiningResult(int purchaseAmount, List<Integer> matchedLottoCnt) {
        System.out.println(RESULT_TITLE);
        Collections.swap(matchedLottoCnt, 6, 7);
        for (int i = 0; i < LOTTO_RESULT_SAME.length; i++) {
            System.out.println(LOTTO_RESULT_SAME[i] + matchedLottoCnt.get(i + 3) + "개");
        }
        getRevenue(purchaseAmount, matchedLottoCnt.get(8));
    }

    private static void getRevenue(int purchaseAmount, int totalAmount) {
        String revenueRate = String.format("%.2f", (double)totalAmount / purchaseAmount);
        System.out.printf(TOTAL_REWARD, revenueRate, revenueRate.compareTo("1") < 0 ? "손해" : "이익");
    }
}
