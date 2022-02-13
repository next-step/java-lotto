package lotto.view;

import java.util.HashMap;
import lotto.domain.number.LottoNumber;
import lotto.domain.result.LottoResult;
import lotto.domain.statistics.WinningStatistics;
import lotto.domain.user.UserLotto;
import lotto.domain.user.UserLottos;

public class ResultView {

    public static void printUserLottos(UserLottos userLottos) {
        System.out.println(userLottos.getQuantity() + "개를 구매했습니다.");

        for (UserLotto lotto : userLottos.getRawUserLottos()) {
            final StringBuilder sb = new StringBuilder("[");
            lotto.getNumbers().stream()
                .map(LottoNumber::getRaw)
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
