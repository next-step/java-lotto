package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoResult;
import lotto.domain.WinningStatistics;

public class ResultView {

    private static int quantity;

    public static void printLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printTotalLottoNumbers(List<LottoTicket> lottoNumbers) {
        lottoNumbers.forEach(e -> System.out.println(e.getNumbers()));
    }

    public static void printResult(List<LottoResult> results, int purchasePrice) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        HashMap<LottoResult, Integer> result = WinningStatistics.getResult(results);
        result.keySet().stream()
            .filter(ResultView::hasReward)
            .forEach(lottoResult -> System.out.println(
                lottoResult.getDescription() + result.get(lottoResult) + "개"));

        System.out.println(
            "총 수익률은 " + WinningStatistics.getProfitRate(result, purchasePrice) + "입니다.");
    }

    private static boolean hasReward(LottoResult lottoResult) {
        return lottoResult != LottoResult.NO_PRIZE;
    }
}
