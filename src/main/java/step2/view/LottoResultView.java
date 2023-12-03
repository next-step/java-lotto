package step2.view;

import java.util.Arrays;
import java.util.stream.Collectors;
import step2.model.Lotto;
import step2.model.LottoNumber;
import step2.model.LottoResult;
import step2.model.Lottos;
import step2.model.Money;

public class LottoResultView {

    public static void printLottosCount(Integer manualCount, Money money) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                manualCount, money.determineLottoPurchaseCount());
    }

    public static void printPurchaseLotto(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLottoNumbers()
                    .stream()
                    .map(LottoNumber::getNumber)
                    .sorted()
                    .toArray()));
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
