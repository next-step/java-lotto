package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPlace;
import lotto.model.LottoStatistics;
import lotto.model.Lottos;

public class OutputView {
    public static void printLottos(Lottos lottos, int manualLottosSize) {
        System.out.println("수동으로 " + manualLottosSize + "장, 자동으로 " + (lottos.size() - manualLottosSize) + "개를 구매했습니다.");
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
        for (LottoPlace result : LottoPlace.values()) {
            if (result == LottoPlace.LOSE) continue;
            System.out.println(buildResultString(statistics, result));
        }
        System.out.printf("총 수익률은 %.2f 입니다.%n", statistics.calculateProfitRate());
    }

    private static String buildResultString(LottoStatistics statistics, LottoPlace result) {
        return result.getFirstCorrectCount() + "개 일치" + (result.getBonusState().isHit() ? ", 보너스 볼 일치 " : "") + "(" + result.getWinningPrice().getAmount() + "원) - " + statistics.count(result) + "개";
    }
}
