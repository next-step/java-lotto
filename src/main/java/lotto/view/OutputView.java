package lotto.view;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoResult;

import java.util.List;

public class OutputView {
    public static void printPurchasedAmount(int amount) {
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.generateStatistics());

        double returnRate = lottoResult.calculateReturnRate();
        String isLose = (returnRate < 1) ? "손해" : "이득이";

        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", returnRate, isLose);
    }
}
