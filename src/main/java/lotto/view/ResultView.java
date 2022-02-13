package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.UserLotto;
import lotto.domain.WinningStatistics;
import lotto.dto.UserLottoInfo;

public class ResultView {

    public static void printUserLottoInfo(UserLottoInfo userLottoInfo) {
        System.out.println(userLottoInfo.getQuantity() + "개를 구매했습니다.");

        for(UserLotto lotto : userLottoInfo.getUserLottos().getRawUserLottos()) {
            final StringBuilder sb = new StringBuilder("[");
            lotto.getNumbers().stream()
                .map(LottoNumber::getRaw)
                .forEach(number -> sb.append(number).append(", "));

            sb.append("]").deleteCharAt(sb.lastIndexOf(","));
            System.out.println(sb.toString().trim());
        }
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
        return lottoResult != LottoResult.NO_REWARD;
    }
}
