package lotto.view;

import lotto.domain.*;

import java.util.List;

public class ResultView {
    public static void showMyLottos(MyLottos myLottos) {
        for (int i = 0; i < myLottos.count(); i++) {
            System.out.println(myLottos.find(i));
        }
        System.out.println();
    }

    public static void showWinLotto(WinLotto winLotto) {
        System.out.printf("지난 주 당첨 번호 : %s\n\n", winLotto);
    }

    public static void showLottoResult(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d원) - %d개\n", LottoRule.MATCHED_3_NUMBERS_PRIZE, result.getResult3matched());
        System.out.printf("4개 일치 (%d원) - %d개\n", LottoRule.MATCHED_4_NUMBERS_PRIZE, result.getResult4matched());
        System.out.printf("5개 일치 (%d원) - %d개\n", LottoRule.MATCHED_5_NUMBERS_PRIZE, result.getResult5matched());
        System.out.printf("6개 일치 (%d원) - %d개\n", LottoRule.MATCHED_6_NUMBERS_PRIZE, result.getResult6matched());
    }

    public static void showProfit(double profit) {
        System.out.printf("총 수익률은 %.2f입니다.",profit);
    }
}
