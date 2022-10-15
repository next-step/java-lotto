package step3.view;

import step3.domian.Lotto;
import step3.domian.LottoWallet;
import step3.domian.Prize;

import java.util.List;

public class ResultView {
    public static final String RESULT_TEXT = "\n당첨 통계\n---------";
    public static final String BUY_TEXT = "개를 구매했습니다.";
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

    public static void printDrawResult(List<Integer> results) {
        System.out.println(RESULT_TEXT);
        System.out.println(Prize.THREE_PRIZE.text + results.get(Prize.THREE_PRIZE.position) + COUNT_TEXT);
        System.out.println(Prize.FOUR_PRIZE.text + results.get(Prize.FOUR_PRIZE.position) + COUNT_TEXT);
        System.out.println(Prize.FIVE_PRIZE.text + results.get(Prize.FIVE_PRIZE.position) + COUNT_TEXT);
        System.out.println(Prize.FIVE_BONUS_PRIZE.text + results.get(Prize.FIVE_BONUS_PRIZE.position) + COUNT_TEXT);
        System.out.println(Prize.SIX_PRIZE.text + results.get(Prize.SIX_PRIZE.position) + COUNT_TEXT);
    }

    public static void printPercentage(float percentage) {
        System.out.print("총 수익률은" + String.format("%.2f", percentage) + "입니다.");
        if (percentage < 1) {
            System.out.print(LOSS_TEXT);
        }
    }
}
