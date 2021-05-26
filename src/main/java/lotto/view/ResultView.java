package lotto.view;

import lotto.LottoRecord;
import lotto.Lottos;

public class ResultView {

    public static void buyLottoInfo(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printResult(LottoRecord lottoRecord) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        lottoRecord.printResult();
    }
}
