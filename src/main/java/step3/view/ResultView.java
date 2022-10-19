package step3.view;

import step3.domian.Lotto;
import step3.domian.LottoResult;
import step3.domian.LottoWallet;
import step3.domian.Prize;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static final String RESULT_TEXT = "\n당첨 통계\n---------";
    public static final String BUY_TEXT = "개를 구매했습니다.";
    public static final String THREE_TEXT = "3개 일치 (5000원)- ";
    public static final String FOUR_TEXT = "4개 일치 (50000원)- ";
    public static final String FIVE_TEXT = "5개 일치 (1500000원)- ";
    public static final String FIVE_BONUS_TEXT = "5개 일치, 보너스 볼 일치(30000000원)";
    public static final String SIX_TEXT = "6개 일치 (2000000000원)- ";
    public static final String COUNT_TEXT = "개";
    public static final String LOSS_TEXT = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoCount(int lottoNum) {
        System.out.println(lottoNum + BUY_TEXT);
    }

    public static void printLottoNum(LottoWallet lottoWallet) {
        for (Lotto lotto : lottoWallet.lottos) {
            System.out.println(lotto.toString());
        }

    }

    public static void printDrawResult(LottoResult results) {
        System.out.println(RESULT_TEXT);
        System.out.println(THREE_TEXT + results.getResultCount(Prize.THREE_PRIZE) + COUNT_TEXT);
        System.out.println(FOUR_TEXT + results.getResultCount(Prize.FOUR_PRIZE) + COUNT_TEXT);
        System.out.println(FIVE_TEXT + results.getResultCount(Prize.FIVE_PRIZE) + COUNT_TEXT);
        System.out.println(FIVE_BONUS_TEXT + results.getResultCount(Prize.FIVE_BONUS_PRIZE) + COUNT_TEXT);
        System.out.println(SIX_TEXT + results.getResultCount(Prize.SIX_PRIZE) + COUNT_TEXT);
    }

    public static void printPercentage(double percentage) {
        System.out.print("총 수익률은" + String.format("%.2f", percentage) + "입니다.");
        if (percentage < 1) {
            System.out.print(LOSS_TEXT);
        }
    }
}
