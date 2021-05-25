package lotto.view;

import lotto.LottoResult;
import lotto.Lottos;

public class ResultView {

    public static void buyLottoInfo(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoResult.printResult();
    }
}
