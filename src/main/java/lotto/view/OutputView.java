package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoResult;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println("[" + getLottNumbersString(lotto) + "]");
        }
    }

    private static String getLottNumbersString(Lotto lotto) {
        return lotto.getNumbers().stream()
            .map(LottoNumber::getNumber)
            .sorted()
            .map(Object::toString)
            .reduce((accu, curr) -> accu + ", " + curr)
            .get();
    }

    public static void printStatistics(LottoStatistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoResult result : LottoResult.values()) {
            if (result == LottoResult.LOSE) continue;
            System.out.println(result.getFirstCorrectCount() + "개 일치(" + result.getWinningPrice().getAmount() + "원) - " + statistics.count(result) + "개");
        }
        System.out.println("총 수익률은 " + statistics.calculateProfitRate() + "입니다.");
    }
}
