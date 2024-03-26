package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningStatic;

import java.util.List;

public class OutputView {
    public static void printBuyLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    public static void printWinningStatic(WinningStatic winningStatic) {
        System.out.println(winningStatic);
    }

    public static void printReturnRate(double returnRate){
        System.out.println("총 수익율은" + returnRate + " 입니다.");
        if(returnRate < 1){
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}
