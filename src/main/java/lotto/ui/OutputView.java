package lotto.ui;

import lotto.domain.LottoResult;
import lotto.domain.LottoWinPercentage;
import lotto.domain.Lottos;

public class OutputView {

    public void printLottos(int manualLottoCount, int autoLottoCount, Lottos lottos) {
        System.out.println();
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
        lottos.getLottos().forEach(lotto -> System.out.println(lotto));
    }

    public void printLottoResultInfo() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(lottoResult);
    }

    public void printLottoRate(LottoWinPercentage lottoWinPercentage) {
        System.out.print("총 수익률은 " + lottoWinPercentage.getRate() + "입니다.");
        if (lottoWinPercentage.isLowerStandard()) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

}
