package lotto.ui;

import lotto.domain.LottoWinPercentage;
import lotto.domain.LottoWinResult;
import lotto.domain.Lottos;

import java.util.List;

public class OutputView {

    public void printLottos(int lottoCount, Lottos lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
        System.out.println();
    }

    public void printLottoResultInfo() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printLottoResult(List<LottoWinResult> lottoWinResults) {
        for (LottoWinResult lottoWinResult : lottoWinResults) {
            System.out.println(lottoWinResult);
        }
    }

    public void printLottoRate(LottoWinPercentage lottoWinPercentage) {
        System.out.print("총 수익률은 " + lottoWinPercentage.getRate() + "입니다.");
        if (lottoWinPercentage.isLowerStandard()) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
