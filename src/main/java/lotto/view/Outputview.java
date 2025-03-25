package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;

public class Outputview {
    public static void printPurchasedAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult);

        double returnRate = lottoResult.getReturnRate();
        String isLose = (returnRate < 1) ? "손해" : "이득이";

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", returnRate, isLose);
    }
}
