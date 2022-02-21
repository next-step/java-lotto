package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.result.LottoResult;
import lotto.domain.result.WinningStatistics;

public class ResultView {

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            final StringBuilder sb = new StringBuilder("[");
            lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .forEach(number -> sb.append(number).append(", "));

            sb.append("]").deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString().trim());
        }
    }

    public static void printResult(WinningStatistics winningStatistics) {
        printStatistics(winningStatistics.getNumberOfResults().getRawNumberOfResults());
        printProfitRate(winningStatistics.getProfitRate());
    }

    private static void printStatistics(HashMap<LottoResult, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        results.keySet()
            .forEach(result -> System.out.println(
                result.getDescription() + results.get(result) + "개"));
    }

    private static void printProfitRate(String profitRate) {
        System.out.println(
            "총 수익률은 " + profitRate + "입니다.");
    }


}
