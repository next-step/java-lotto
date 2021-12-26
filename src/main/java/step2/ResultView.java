package step2;

import java.util.List;

public class ResultView {

    public static void showLottoUnitCount(int unitCount) {
        System.out.println(unitCount + "개를 구매했습니다.");
    }

    public static void showLottoUnitDetail(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void showWinningStats(List<Lotto> lottos, Lotto lastWeekWinningLotto, LottoPrice lottoPrice) {
        System.out.println("당첨 통계\n" + "---------");

        for (Lotto lotto : lottos) {
            LottoReward.calcMatchCount(lotto, lastWeekWinningLotto);
        }
        LottoReward.printResult();
        System.out.printf("총 수익률은 %.2f입니다.", LottoReward.calcYield(lottoPrice.price));
    }

}
