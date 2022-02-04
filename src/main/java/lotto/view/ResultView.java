package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(final int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(Arrays.toString(lotto.getLotto().toArray()));
        }
        System.out.println();
    }

    public static void printLottoResults(List<LottoResult> lottoResults, double yield) {
        System.out.println("\n당첨 통계\n" + "---------");
        for(LottoResult lottoResult : lottoResults) {
            printLottoResult(lottoResult);
        }
        System.out.println("총 수익률은 " +  String.format("%.2f", yield) + "입니다.");
    }

    private static void printLottoResult(LottoResult lottoResult) {
        if(lottoResult.isBonusNumber()) {
            System.out.println(lottoResult.getMatchCount()+"개 일치, 보너스 볼 일치(" + lottoResult.getWinning()+")원- " + lottoResult.getCount()+"개");
            return;
        }
        System.out.println(lottoResult.getMatchCount() + "개 일치 (" + lottoResult.getWinning() + ")원- " + lottoResult.getCount()+"개");
    }
}
