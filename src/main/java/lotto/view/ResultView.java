package lotto.view;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.MatchType;

public class ResultView {

    public ResultView() {
    }

    public static void printLottoNumbers(LottoGame lottoGame) {
        printLottoCount(lottoGame.getLottoCount());
        lottoGame.getLottos().forEach(ResultView::printLottoNumber);
        System.out.println();
    }

    public static void printLottoGameResult(LottoResult lottoResult) {
        System.out.println("당첨 통계\n---------");
        Map<MatchType, Integer> matchResult = lottoResult.getResult();
        for (Map.Entry<MatchType, Integer> entry : matchResult.entrySet()) {
            printMatchNumber(entry);
        }
        printTotalYield(lottoResult.getYield());
    }

    private static void printLottoNumber(Lotto lotto) {
        System.out.println(lotto.getLottoNumber());
    }

    private static void printLottoCount(LottoCount lottoCount) {
        System.out.println("수동으로 " + lottoCount.getManualCount() + "장, 자동으로 "
            + lottoCount.getAutoCount() + "장을 구매했습니다.");
    }

    private static void printMatchNumber(Map.Entry<MatchType, Integer> entry) {
        if ((entry.getKey() == MatchType.FIVE_AND_BONUS_BALL)) {
            printBonusMatch(entry);
            return;
        }
        printMatch(entry);
    }

    private static void printMatch(Map.Entry<MatchType, Integer> entry) {
        System.out.println(
            entry.getKey().getCount() + "개 일치(" +
                entry.getKey().getMoney() + ")-" +
                entry.getValue() + "개");
    }

    private static void printBonusMatch(Map.Entry<MatchType, Integer> entry) {
        System.out.println(
            entry.getKey().getCount() + "개 일치, 보너스 볼 일치(" +
                entry.getKey().getMoney() + ")-" +
                entry.getValue() + "개");
    }

    private static void printTotalYield(float yield) {
        System.out.println("총 수익률은 " + yield + "입니다.");
    }


}
