package lotto.view;

import lotto.domain.LottoRule;
import lotto.domain.MyLotto;
import lotto.domain.MyLottoResult;
import lotto.domain.WinLotto;

import java.util.List;

public class ResultView {
    public static void showMyLottos(List<MyLotto> myLottos) {
        for (MyLotto myLotto : myLottos) {
            System.out.println(myLotto);
        }
        System.out.println();
    }

    public static void showWinLotto(WinLotto winLotto) {
        System.out.printf("지난 주 당첨 번호 : %s\n\n", winLotto);
    }

    public static void showLottoResult(MyLottoResult myLottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d원) - %d개\n", LottoRule.MATCHED_3_NUMBERS_PRIZE, myLottoResult.getResult3matched());
        System.out.printf("4개 일치 (%d원) - %d개\n", LottoRule.MATCHED_4_NUMBERS_PRIZE, myLottoResult.getResult4matched());
        System.out.printf("5개 일치 (%d원) - %d개\n", LottoRule.MATCHED_5_NUMBERS_PRIZE, myLottoResult.getResult5matched());
        System.out.printf("6개 일치 (%d원) - %d개\n", LottoRule.MATCHED_6_NUMBERS_PRIZE, myLottoResult.getResult6matched());
    }

    public static void showProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.",profit);
    }
}
