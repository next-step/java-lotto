package step2.view;

import java.util.Arrays;
import step2.model.Lotto;
import step2.model.LottoResult;
import step2.model.Lottos;
import step2.model.Money;

public class LottoResultView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getPurchaseLottoSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.printLotto().toArray()));
        }
    }

    public static void printFinalLottoResult(LottoResult lottoResult, Money money) {
        printLottoStatistics(lottoResult);
        printProfitRate(lottoResult, money);
    }

    public static void printLottoStatistics(LottoResult lottoResult) {
        System.out.print(lottoResult.toString());
    }

    public static void printProfitRate(LottoResult lottoResult, Money money) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)",
                lottoResult.calculateProfitRate(money.determineLottoPurchaseCount()));
    }
}
